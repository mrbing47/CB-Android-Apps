package garg.sarthik.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Poke_Types implements Parcelable {

    int slot;
    Type type;

    protected Poke_Types(Parcel in) {
        slot = in.readInt();
    }

    public static final Creator<Poke_Types> CREATOR = new Creator<Poke_Types>() {
        @Override
        public Poke_Types createFromParcel(Parcel in) {
            return new Poke_Types(in);
        }

        @Override
        public Poke_Types[] newArray(int size) {
            return new Poke_Types[size];
        }
    };

    public Type getType() {
        return type;
    }

    public int getSlot() {

        return slot;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(slot);
    }
}
