package garg.sarthik.starbugs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.SetOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import garg.sarthik.starbugs.EventActivity;
import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.R;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Functions;
import garg.sarthik.starbugs.Statics.Variables;
import garg.sarthik.starbugs.ui.history.HistoryFragment;
import garg.sarthik.starbugs.ui.notifications.NotificationsFragment;

import static android.view.View.GONE;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {


    private String TAG = "NA";

    private List<Event> events;
    private Context ctx;
    private Object obj;
    private String callerFrag = "";

    public NotificationAdapter(List<Event> events, Context ctx, Object obj) {
        this.events = events;
        this.ctx = ctx;
        this.obj = obj;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.layout_event_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Event event = events.get(position);

        if(obj instanceof HistoryFragment) {

            holder.itemLayoutButtons.setVisibility(GONE);

            callerFrag = Constants.FRAG_HIST;
        }
        else {

            callerFrag = Constants.FRAG_NOT;

            holder.itemLayoutButtons.setVisibility(View.VISIBLE);

            holder.fabReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateEvent(event, Constants.EVENT_STATUS_REJECT);
                }
            });

            holder.fabAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateEvent(event, Constants.EVENT_STATUS_ACCEPT);
                }
            });
        }

        final LatLng latlng = Functions.getLatLng(event.getEventLatlng());


        holder.itemLayoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, EventActivity.class);
                intent.putExtra(Constants.EVENT_PARSE, event);
                intent.putExtra(Constants.FRAG_PARSE, callerFrag);
                ctx.startActivity(intent);
            }
        });

        String address = Functions.decodeAddress(ctx,latlng);
        holder.tvItemLocation.setText(address);
        holder.tvItemDate.setText(Functions.formatDateTime(event.getEventStartTime()));

        holder.mapView.onCreate(null);
        holder.mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.getUiSettings().setAllGesturesEnabled(false);

                Event event = events.get(position);
                LatLng latlng = Functions.getLatLng(event.getEventLatlng());

                googleMap.addMarker(new MarkerOptions().position(latlng).title(event.getEventLatlng()).draggable(false));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13));

                Log.i(TAG, "" + latlng.latitude + " " + latlng.longitude);
            }
        });
        holder.mapView.onResume();
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        MapView mapView;
        TextView tvItemDate;
        TextView tvItemLocation;
        FloatingActionButton fabAccept;
        FloatingActionButton fabReject;
        LinearLayout itemLayoutButtons;
        LinearLayout itemLayoutText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItemDate = itemView.findViewById(R.id.tvItemDate);
            tvItemLocation = itemView.findViewById(R.id.tvItemLocation);
            mapView = itemView.findViewById(R.id.itemMapView);
            itemLayoutText = itemView.findViewById(R.id.itemLayoutText);
            itemLayoutButtons = itemView.findViewById(R.id.itemLayoutButtons);
            fabAccept = itemView.findViewById(R.id.fabAccept);
            fabReject = itemView.findViewById(R.id.fabReject);

        }

    }

    private void updateEvent(Event event, String status){

        event.setEventStatus(status);

        String[] args = event.getEventId().split("-");

        Variables.colUser.document(Variables.fireUser.getUid()).collection(Constants.COL_HISTORY).document(event.getEventId()).set(event);
        Variables.colCamera.document(args[1]).collection(Constants.COL_HISTORY).document(args[0]).set(event);
        Variables.colUser.document(Variables.fireUser.getUid()).collection(Constants.COL_NOTIFICATION).document(event.getEventId()).delete();
    }

}
