package garg.sarthik.firebase;

public class Task {

    String name, title;
    Long id;
    boolean isDone;

    public Task () {}

    public Task(String name, String title, Long id, boolean isDone) {
        this.name = name;
        this.title = title;
        this.id = id;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }
}
