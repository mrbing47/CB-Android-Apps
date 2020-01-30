package garg.sarthik.starbugs.POJO;

import android.os.Parcel;
import android.os.Parcelable;

import garg.sarthik.starbugs.Statics.Functions;

public class Event implements Parcelable {

    String eventId;
    String eventLatlng;
    String eventStartTime;
    String eventEndTime;

    public Event() {
    }


    public Event(long camId, String eventLatlng, String eventStartTime) {

        this.eventId = Functions.generateId(camId);
        this.eventLatlng = eventLatlng;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = "0";
    }

    protected Event(Parcel in) {
        eventId = in.readString();
        eventLatlng = in.readString();
        eventStartTime = in.readString();
        eventEndTime = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getEventId() {
        return eventId;
    }

    public String getEventLatlng() {
        return eventLatlng;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventId);
        dest.writeString(eventLatlng);
        dest.writeString(eventStartTime);
        dest.writeString(eventEndTime);
    }
}
