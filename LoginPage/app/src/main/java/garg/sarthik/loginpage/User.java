package garg.sarthik.loginpage;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    String email;
    String password;

    protected User(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(){}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public User(String email, String password) {

        this.email = email;
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
    }
}
