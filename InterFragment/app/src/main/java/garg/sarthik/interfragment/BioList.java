package garg.sarthik.interfragment;

public class BioList {

    private String name;
    private String gender;
    private String imageURL;
    private String dob;

    public BioList(String name, String gender, String imageURL, String dob) {
        this.name = name;
        this.gender = gender;
        this.imageURL = imageURL;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDob() {
        return dob;
    }
}
