package garg.sarthik.customadaptors;

public class Student {

    private String name, batch, location;

    public String getName() {
        return name;
    }

    public Student(String name, String batch, String location) {
        this.name = name;
        this.batch = batch;
        this.location = location;
    }

    public String getBatch() {

        return batch;
    }

    public String getLocation() {
        return location;
    }
};
