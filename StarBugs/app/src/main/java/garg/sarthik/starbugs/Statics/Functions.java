package garg.sarthik.starbugs.Statics;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.Calendar;

public class Functions {


    public static LatLng getLatLng(String str){

        String[] args = str.split(" , ");

        double lat = Double.parseDouble(args[0]);
        double lng = Double.parseDouble(args[1]);

        return new LatLng(lat,lng);
    }


    public static String getCurrentTime() {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        int time = (hour * 100) + min;

        Log.e("Time", "getCurrentTime: currentDate" + time);

        String res = "" + time;

        if(res.length() == 3)
            res = "0" + res;

        return res;
    }

    public static String getCurrentDate() {

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        int currentDate = (year * 10000) + (month * 100) + date;

        Log.e("Date", "getCurrentDate: currentDate: " + currentDate);
        return "" + currentDate;
    }

    public static String generateId(long serialNo) {

        String currTime = "" + getCurrentTime();
        if(currTime.length() == 3)
            currTime = "0" + currTime;

        return "" + getCurrentDate() + currTime + serialNo;
    }

    public static String toCapitalise(String txt) {
        String result = "";

        String[] words = txt.split(" ",0);

        for (String w : words) {

            String first = w.substring(0, 1).toUpperCase();
            String afterfirst = w.substring(1);
            result += first + afterfirst + " ";
            Log.e("FUNCTIONS", "toCapitalise: " + result );
        }
        return result;
    }

    public static String convertToTime(String _24hrTime){

        int nTime = Integer.parseInt(_24hrTime);
        int minute = nTime % 100;
        int hourOfDay = nTime / 100;

        String ampm;
        String minZero = "";
        String hrZero = "";

        if (hourOfDay >= 12) {
            ampm = "PM";
            hourOfDay -= 12;
        } else
            ampm = "AM";

        if (hourOfDay == 0)
            hourOfDay = 12;

        if (hourOfDay < 10)
            hrZero = "0";
        if (minute < 10)
            minZero = "0";

        String result = "" + hrZero + hourOfDay + ":" + minZero + minute + " " + ampm;

        return result;
    }

    public static String formatDateTime(String input){

        if(input.length() == 1)
            return "0";

        String yr = input.substring(0,4).substring(2);
        String month = input.substring(4,6);
        String day = input.substring(6,8);

        String hr = input.substring(8,10);
        String min = input.substring(10,12);

        return day + "/" + month + "/" + yr + ", " + convertToTime(hr+min);
    }

}
