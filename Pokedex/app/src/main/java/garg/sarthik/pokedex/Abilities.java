package garg.sarthik.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

class Abilities implements Parcelable{

    int slot;
    Ability ability;

    public int getSlot() {
        return slot;
    }

    public Ability getAbility() {
        return ability;
    }

    protected Abilities(Parcel in) {
        slot = in.readInt();
    }

    public static final Creator<Abilities> CREATOR = new Creator<Abilities>() {
        @Override
        public Abilities createFromParcel(Parcel in) {
            return new Abilities(in);
        }

        @Override
        public Abilities[] newArray(int size) {
            return new Abilities[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(slot);
    }
}
