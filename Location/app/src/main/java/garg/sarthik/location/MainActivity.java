package garg.sarthik.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public static final int requestCodeForPermission = 12345;
    LocationManager locationManager;

    TextView tvLongitude;
    TextView tvLatitude;
    TextView tvTime;
    TextView tvProvider;
    TextView tvSpeed;
    TextView tvAccuracy;
    TextView tvAltitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAccuracy = findViewById(R.id.tvAccuracy);
        tvAltitude = findViewById(R.id.tvAltitude);
        tvLongitude = findViewById(R.id.tvLongitude);
        tvLatitude = findViewById(R.id.tvLatitude);
        tvProvider = findViewById(R.id.tvProvider);
        tvTime = findViewById(R.id.tvTime);
        tvSpeed = findViewById(R.id.tvSpeed);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Check to see the app has the permissions or not
        // checkSelfPermission return 0 if Permission Granted (PackageManager.PERMISSION_GRANTED)
        // and -1 if Permission Denied (PackageManager.PERMISSION_DENIED)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //This block runs if i don't have any of the permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, requestCodeForPermission);

            //This won't work as the dialog run Async
            //    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        } else {


            Toast.makeText(this, "Already have the Permission", Toast.LENGTH_SHORT).show();
//            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            Log.e("TAG", "onCreate: " + location.getLatitude());
//            Log.e("TAG", "onCreate: " + location.getLongitude());

            //Write to check to see if the location is OFF or ON

            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Toast.makeText(this, "Location is not enabled", Toast.LENGTH_SHORT).show();
            } else {

                locationSuccess();
            }

        }
//        locationManager.addProximityAlert();  It is used to know whether the user is in a specific geofence or not

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            //Do your processing here
            Toast.makeText(this, "Thank you for the permission", Toast.LENGTH_SHORT).show();
//            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            Log.e("TAG", "onCreate: " + location.getLatitude());
//            Log.e("TAG", "onCreate: " + location.getLongitude());

            //Write to check to see if the location is OFF or ON

            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Toast.makeText(this, "Location is not enabled", Toast.LENGTH_SHORT).show();
            } else {

                locationSuccess();
            }
        } else {
            //This will run when one of the permission is not granted
            //Here you can show Toast
            Toast.makeText(this, "Sorry, but the app needs the permission", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.e("TAG", "onLocationChanged: " + location.getLatitude());
        Log.e("TAG", "onLocationChanged: " + location.getLongitude());
        Log.e("TAG", "onLocationChanged: " + location.getProvider());
        Log.e("TAG", "onLocationChanged: " + location.getTime());

        //Only GPS provider will give the values below
        Log.e("TAG", "onLocationChanged: " + location.getAccuracy());
        Log.e("TAG", "onLocationChanged: " + location.getAltitude());
        Log.e("TAG", "onLocationChanged: " + location.getSpeed());

        tvSpeed.setText("" + location.getSpeed());
        tvTime.setText("" + location.getTime());
        tvLongitude.setText("" + location.getLongitude());
        tvLatitude.setText("" + location.getLatitude());
        tvProvider.setText("" + location.getProvider());0
        tvAltitude.setText("" + location.getAltitude());
        tvAccuracy.setText("" + location.getAccuracy());

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

    @SuppressLint("MissingPermission")
    public void locationSuccess() {

        // Only gives the update a single time
        // locationManager.requestSingleUpdate();

        //Gives locations multiple times
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Removes the listener for the location related events,
        //Ideally this should be done when the app no longer needs access to user's location
        locationManager.removeUpdates(this);
    }
}
