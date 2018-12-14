package garg.sarthik.mynotes;

public class Notes {

    private String notes;
    private String time;

    public Notes(String notes, String time) {
        this.notes = notes;
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public String getTime() {
        return time;
    }
}
