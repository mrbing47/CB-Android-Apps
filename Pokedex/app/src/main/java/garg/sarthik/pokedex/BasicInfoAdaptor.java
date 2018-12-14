package garg.sarthik.pokedex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BasicInfoAdaptor extends RecyclerView.Adapter<BasicInfoAdaptor.ViewHolder> {

    ArrayList<Poke_Types> poke_typesArrayList;
    Context ctx;

    public BasicInfoAdaptor(ArrayList<Poke_Types> pokeTypes, Context ctx) {
        this.poke_typesArrayList = pokeTypes;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_abilities_types,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Poke_Types pokeTypes = poke_typesArrayList.get(position);
        holder.tvName.setText(pokeTypes.type.getName().replace("-"," "));
        holder.tvSlot.setText(""+pokeTypes.getSlot());
        holder.tvNameTag.setText("Type:");

    }

    @Override
    public int getItemCount() {
        return poke_typesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvNameTag;
        TextView tvSlot;
        public ViewHolder(View itemView) {
            super(itemView);

            tvNameTag = itemView.findViewById(R.id.tvATNametxt);
            tvName = itemView.findViewById(R.id.tvATName);
            tvSlot = itemView.findViewById(R.id.tvATSlot);
        }
    }
}
