package garg.sarthik.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Stats implements Parcelable {

    int base_stat;
    int effort;
    Stat stat;

    protected Stats(Parcel in) {
        base_stat = in.readInt();
        effort = in.readInt();
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public int getBase_stat() {
        return base_stat;
    }

    public int getEffort() {
        return effort;
    }

    public Stat getStat() {
        return stat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(base_stat);
        dest.writeInt(effort);
    }
}
