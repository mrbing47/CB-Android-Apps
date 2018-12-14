package garg.sarthik.database;

public class Task {

    Long id;
    String title;

    public Task(long id, String title) {

        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
