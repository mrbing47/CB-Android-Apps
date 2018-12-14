package garg.sarthik.pokedex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StatsAdaptor extends RecyclerView.Adapter<StatsAdaptor.ViewHolder> {

    ArrayList<Stats> statsArrayList;
    Context ctx;

    public StatsAdaptor(ArrayList<Stats> statsArrayList, Context ctx) {
        this.statsArrayList = statsArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_stats,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Stats stats = statsArrayList.get(position);
        holder.tvName.setText(stats.stat.getName().replace("-"," "));
        holder.tvEffort.setText("" + stats.getEffort());
        holder.tvBaseStat.setText("" + stats.getBase_stat());
    }

    @Override
    public int getItemCount() {
        return statsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvEffort;
        TextView tvBaseStat;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvStatsName);
            tvEffort = itemView.findViewById(R.id.tvStatsEffort);
            tvBaseStat = itemView.findViewById(R.id.tvBaseStats);
        }
    }
}
