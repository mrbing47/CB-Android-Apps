package garg.sarthik.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.hardware.Sensor.TYPE_STEP_COUNTER;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView tvX, tvY, tvZ;
    LinearLayout linearLayout;
    SensorManager sensorManager;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        tvX = findViewById(R.id.gravityX);
        tvY = findViewById(R.id.gravityY);
        tvZ  = findViewById(R.id.gravityZ);
        linearLayout = findViewById(R.id.linearlayout);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

         List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        Sensor gravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        Sensor stepCounter = sensorManager.getDefaultSensor(TYPE_STEP_COUNTER);

        sensorManager.registerListener(this, stepCounter, SensorManager.SENSOR_DELAY_NORMAL);

        Log.e("TAG", "onCreate: " + sensors.size());
        for(Sensor s : sensors)
        {
            Log.e("TAG", "onCreate ------   ");
            Log.e("TAG", "onCreate: " + s.toString());
            Log.e("TAG", "onCreate ------   ");
        }
        tvY.setText(""+sensors.size());

        //registers the sensor for updates
        //sensorManager.registerListener(this,gravity,SensorManager.SENSOR_DELAY_UI);
    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//
//        float[] valuearray = event.values;
//
//        tvX.setText(""+valuearray[0]);
//        tvY.setText(""+valuearray[1]);
//        tvZ.setText(""+valuearray[2]);
//
//        //convert he values of the colors
//
//        int red = (int) (12.87 * (valuearray[0] + 9.8));
//        int green = (int) (12.87 * (valuearray[1] + 9.8));
//        int blue = (int) (12.87 * (valuearray[2] + 9.8));
//
//
//
//
////        int value = Color.parseColor("#" + red + green + blue);
//        int color =  Color.rgb(red,green,blue);
//
//     //   Log.e(TAG, "onSensorChanged: " + color );
//
//        linearLayout.setBackgroundColor(color);
//
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//        //This is called whenever the accuracy of the sensor changes
//    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        counter++;
        tvX.setText(""+counter);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
