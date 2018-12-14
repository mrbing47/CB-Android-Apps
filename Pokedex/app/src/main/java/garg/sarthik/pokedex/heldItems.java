package garg.sarthik.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

public class heldItems implements Parcelable {

    Item item;

    public Item getItem() {
        return item;
    }

    protected heldItems(Parcel in) {
    }

    public static final Creator<heldItems> CREATOR = new Creator<heldItems>() {
        @Override
        public heldItems createFromParcel(Parcel in) {
            return new heldItems(in);
        }

        @Override
        public heldItems[] newArray(int size) {
            return new heldItems[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
