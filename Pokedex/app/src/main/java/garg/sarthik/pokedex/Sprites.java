package garg.sarthik.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

class Sprites implements Parcelable{

    String back_female;
    String back_default;
    String front_female;
    String front_default;

    protected Sprites(Parcel in) {
        back_female = in.readString();
        back_default = in.readString();
        front_female = in.readString();
        front_default = in.readString();
    }

    public static final Creator<Sprites> CREATOR = new Creator<Sprites>() {
        @Override
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        @Override
        public Sprites[] newArray(int size) {
            return new Sprites[size];
        }
    };

    public String getBack_female() {
        return back_female;
    }

    public String getBack_default() {
        return back_default;
    }

    public String getFront_female() {
        return front_female;
    }

    public String getFront_default() {
        return front_default;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(back_female);
        dest.writeString(back_default);
        dest.writeString(front_female);
        dest.writeString(front_default);
    }
}
