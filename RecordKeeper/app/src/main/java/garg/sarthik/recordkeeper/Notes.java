package garg.sarthik.recordkeeper;

import android.text.Editable;

public class Notes {
    private String notes;
    private String time;
    private String color;

    public Notes(String notes, String time, String color) {
        this.notes = notes;
        this.time = time;
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public String getTime() {
        return time;
    }

    public String getColor() {
        return color;
    }
}
