package garg.sarthik.pokedex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AbilitiesAdaptor extends RecyclerView.Adapter<AbilitiesAdaptor.ViewHolder>{

    ArrayList<Abilities> abilitiesArrayList;

    public AbilitiesAdaptor(ArrayList<Abilities> abilitiesArrayList, Context ctx) {
        this.abilitiesArrayList = abilitiesArrayList;
        this.ctx = ctx;
    }

    Context ctx;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_abilities_types,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Abilities abilities = abilitiesArrayList.get(position);
        holder.tvNameTag.setText("Ability:");
        holder.tvName.setText(abilities.ability.getName().replace("-"," "));
        holder.tvSlot.setText(""+abilities.getSlot());
    }

    @Override
    public int getItemCount() {
        return abilitiesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvNameTag;
        TextView tvSlot;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvATName);
            tvNameTag = itemView.findViewById(R.id.tvATNametxt);
            tvSlot = itemView.findViewById(R.id.tvATSlot);
        }
    }
}
