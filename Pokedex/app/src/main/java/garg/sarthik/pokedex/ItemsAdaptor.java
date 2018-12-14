package garg.sarthik.pokedex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemsAdaptor extends RecyclerView.Adapter<ItemsAdaptor.ViewHolder> {

    ArrayList<heldItems> heldItemsArrayList;
    Context ctx;

    public ItemsAdaptor(ArrayList<heldItems> heldItemsArrayList, Context ctx) {
        this.heldItemsArrayList = heldItemsArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        heldItems helditems = heldItemsArrayList.get(position);

        holder.tvName.setText(helditems.item.getName().replace("-"," "));
    }

    @Override
    public int getItemCount() {
        return heldItemsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvItemsName);
        }
    }
}
