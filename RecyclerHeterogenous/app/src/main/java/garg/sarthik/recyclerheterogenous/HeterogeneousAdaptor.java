package garg.sarthik.recyclerheterogenous;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;

public class HeterogeneousAdaptor extends RecyclerView.Adapter<> {

    ArrayList<Objects> objectsArrayList = new ArrayList<>();
    Context ctx;

    class ImageHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
    }
}
