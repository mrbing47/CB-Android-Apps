package garg.sarthik.starbugs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;

import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Functions;
import garg.sarthik.starbugs.Statics.Variables;

import static android.view.View.GONE;

public class EventActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView tvEventLocation;
    TextView tvEventStatus;
    TextView tvEventStartTime;
    TextView tvEventEndTime;

    LinearLayout llEvent;
    LinearLayout eventLayoutButtons;
    Button btnAccept;
    Button btnReject;
    ProgressBar eventResponse;

    MapView eventMapView;

    LatLng latlng = null;
    GoogleMap gMap;
    private String TAG = "Event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        final Event event = getIntent().getParcelableExtra(Constants.EVENT_PARSE);
        final String callerFrag = getIntent().getStringExtra(Constants.FRAG_PARSE);

        latlng = Functions.getLatLng(event.getEventLatlng());

        llEvent = findViewById(R.id.llEvent);
        eventResponse = findViewById(R.id.eventResponseProgress);
        eventLayoutButtons = findViewById(R.id.eventLayoutButtons);
        tvEventStartTime = findViewById(R.id.tvEventStart);
        tvEventEndTime = findViewById(R.id.tvEventEnd);
        tvEventLocation = findViewById(R.id.tvEventLocation);
        tvEventStatus = findViewById(R.id.tvEventStatus);
        eventMapView = findViewById(R.id.eventMapView);
        btnAccept = findViewById(R.id.btnEventAccept);
        btnReject = findViewById(R.id.btnEventReject);

        enableButtons(true);

        if (callerFrag.equals(Constants.FRAG_HIST))
            eventLayoutButtons.setVisibility(GONE);

        tvEventStartTime.setText(Functions.formatDateTime(event.getEventStartTime()));

        if (!event.getEventEndTime().equals("0"))
            tvEventEndTime.setText(Functions.formatDateTime(event.getEventEndTime()));
        else
            tvEventEndTime.setText("Event has not ended yet");


        if (event.getEventStatus().equals(Constants.EVENT_STATUS_ACCEPT))
            tvEventStatus.setTextColor(getResources().getColor(R.color.colorGreen));
        else {
            if (event.getEventStatus().equals(Constants.EVENT_STATUS_REJECT))
                tvEventStatus.setTextColor(getResources().getColor(R.color.colorRed));
        }

        if (!event.getEventStatus().equals(""))
            tvEventStatus.setText(event.getEventStatus());
        else
            tvEventStatus.setText("Please RESPOND to this event");


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEvent(event, Constants.EVENT_STATUS_REJECT);
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEvent(event, Constants.EVENT_STATUS_ACCEPT);
            }
        });


        eventMapView.onCreate(null);
        eventMapView.getMapAsync(this);
        eventMapView.onResume();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        gMap = googleMap;

        Log.i(TAG, "onMapReady: \n\n\n\n");

        if (latlng != null) {

            gMap.getUiSettings().setAllGesturesEnabled(false);
            gMap.addMarker(new MarkerOptions().position(latlng));
            gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 12));

        }

    }

    public void updateEvent(final Event event, String status) {

        enableButtons(false);

        event.setEventStatus(status);

        final String[] args = event.getEventId().split("-");

        Variables.colUser.document(Variables.fireUser.getUid()).collection(Constants.COL_HISTORY).document(event.getEventId()).set(event).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Variables.colCamera.document(args[1]).collection(Constants.COL_HISTORY).document(args[0]).set(event).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Variables.colUser.document(Variables.fireUser.getUid()).collection(Constants.COL_NOTIFICATION).document(event.getEventId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                if (event.getEventStatus().equals(Constants.EVENT_STATUS_ACCEPT))
                                    tvEventStatus.setTextColor(getResources().getColor(R.color.colorGreen));
                                else {
                                    if (event.getEventStatus().equals(Constants.EVENT_STATUS_REJECT))
                                        tvEventStatus.setTextColor(getResources().getColor(R.color.colorRed));
                                }

                                tvEventStatus.setText(event.getEventStatus());

                                eventResponse.setVisibility(GONE);
                                Snackbar.make(llEvent, "Response has been Registered", Snackbar.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                enableButtons(true);
                                Snackbar.make(llEvent, "Error Occurred", Snackbar.LENGTH_LONG).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        enableButtons(true);
                        Snackbar.make(llEvent, "Error Occurred", Snackbar.LENGTH_LONG).show();
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                enableButtons(true);
                Snackbar.make(llEvent, "Error Occurred", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void enableButtons(boolean isEnable) {

        if (isEnable) {
            eventLayoutButtons.setVisibility(View.VISIBLE);
            eventResponse.setVisibility(GONE);
        } else {
            eventLayoutButtons.setVisibility(GONE);
            eventResponse.setVisibility(View.VISIBLE);
        }

    }
}
