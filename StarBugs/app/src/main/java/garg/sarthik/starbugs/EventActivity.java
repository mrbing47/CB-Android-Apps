package garg.sarthik.starbugs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Functions;

public class EventActivity extends AppCompatActivity implements OnMapReadyCallback {

    private String TAG = "Event";

    TextView tvEventLocation;
    TextView tvEventStartTime;
    TextView tvEventEndTime;
    MapView eventMapView;

    LatLng latlng = null;
    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Event event = getIntent().getParcelableExtra(Constants.EVENT_PARSE);

        latlng = Functions.getLatLng(event.getEventLatlng());

        tvEventStartTime = findViewById(R.id.tvEventStart);
        tvEventEndTime = findViewById(R.id.tvEventEnd);
        tvEventLocation = findViewById(R.id.tvEventLocation);
        eventMapView = findViewById(R.id.eventMapView);


        tvEventEndTime.setText(Functions.formatDateTime(event.getEventEndTime()));
        tvEventStartTime.setText(Functions.formatDateTime(event.getEventStartTime()));

        eventMapView.onCreate(null);
        eventMapView.getMapAsync(this);
        eventMapView.onResume();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        gMap = googleMap;

        Log.i(TAG, "onMapReady: \n\n\n\n");

        if(latlng != null){

            gMap.getUiSettings().setAllGesturesEnabled(false);
            gMap.addMarker(new MarkerOptions().position(latlng));
            gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 12));

        }

    }
}
