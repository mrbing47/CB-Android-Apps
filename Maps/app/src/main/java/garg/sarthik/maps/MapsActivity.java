package garg.sarthik.maps;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {


    LatLng codingBlocks = new LatLng(28.5856474, 77.3131665); //new LatLng(28,77);
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        googleMap.setMapStyle(MapStyleOptions
                .loadRawResourceStyle(this, R.raw.map_style));
        // Add a marker in Sydney and move the camera
        //final LatLng codingBlocks = new LatLng(28.5856474, 77.3131665); //First param is Latitude, Second param is the Longitude

        MarkerOptions markerOptions = new MarkerOptions()
                .draggable(true)
                .position(codingBlocks)
                .title("Coding Blocks");

        //  googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.addMarker(markerOptions);
        // googleMap.animateCamera(CameraUpdateFactory.newLatLng(codingBlocks));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(codingBlocks, 18));

        attachLocation();

        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

            MarkerOptions currentMarker;
            LatLng newPosition;

            @Override
            public void onMarkerDragStart(Marker marker) {


//                if (marker.getPosition() == null) {
//
//                    currentLocation = newPosition;
//
//                } else {
//
//                    currentLocation = marker.getPosition();
//                }
//
//
                currentMarker = new MarkerOptions()
                        .draggable(true)
                        .title(marker.getTitle())
                        .position(codingBlocks);

//                float lat = (float) cod.latitude;
//                float lng = (float) currentLocation.longitude;
//                googleMap.addMarker(currentMarker);
//                googleMap.moveCamera(CameraUpdateFactory.newLatLng(codingBlocks));


            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

                newPosition = marker.getPosition();
                googleMap.addMarker(currentMarker);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(newPosition));

                PolylineOptions polylineOptions = new PolylineOptions()
                        .add(codingBlocks, newPosition)
                        .color(getResources().getColor(R.color.White))
                        .width(1);

                googleMap.addPolyline(polylineOptions);

                codingBlocks = newPosition;


            }
        });

        googleMap.isTrafficEnabled();

//        LatLng latLng = new LatLng(40,151);
//
//        MarkerOptions markerOptions1 = new MarkerOptions().position(latLng).title("TEST LOCATION");
//
//        googleMap.addMarker(markerOptions1);
//       // googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @SuppressLint("MissingPermission")
    private void attachLocation() {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        try {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100, 0, this);
        } catch (Exception exception) {
            Log.e("Location", "attachLocation: Request Location Update Fail");
        }

    }

    @Override
    public void onLocationChanged(Location location) {

        LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions()
                .title("Current Location")
                .position(currentLocation);

        mMap.addMarker(markerOptions);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));

        PolylineOptions polylineOptions = new PolylineOptions()
                .add(codingBlocks, currentLocation)
                .color(getResources().getColor(R.color.White))
                .width(5);

        mMap.addPolyline(polylineOptions);

        codingBlocks = currentLocation;


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
