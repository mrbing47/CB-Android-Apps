package garg.sarthik.kpit.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import garg.sarthik.kpit.POJO.Location;
import garg.sarthik.kpit.R;


public class SearchAdaptor extends RecyclerView.Adapter<SearchAdaptor.ViewHolder> {

    ArrayList<Location> locations;
    Context ctx;

    public SearchAdaptor (Context ctx, ArrayList<Location> locations){

        this.ctx = ctx;
        this.locations = locations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx).inflate( R.layout.location_item,parent));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Location location = locations.get(position);

        holder.tvLocation.setText(location.getName());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvLocation;
        ImageButton ibRemoveLocation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLocation = itemView.findViewById(R.id.tvLocation);
            ibRemoveLocation = itemView.findViewById(R.id.ibRemoveLocation);
        }
    }
}
