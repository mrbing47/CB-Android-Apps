package garg.sarthik.biodata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.ViewHolder> {

    private ArrayList<BioList> bioListArrayList;
    private Context ctx;

    public DataAdaptor(ArrayList<BioList> bioListArrayList, Context ctx) {
        this.bioListArrayList = bioListArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View view = li.inflate(R.layout.item_listview,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        BioList bioList = bioListArrayList.get(position);
        holder.tvName.setText(bioList.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity ma = (MainActivity)ctx;
                ma.addFragment(new FragmentB(bioListArrayList.get(position)));
             }
        });

    }

    @Override
    public int getItemCount() {
        return bioListArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNames);

        }
    }
}
