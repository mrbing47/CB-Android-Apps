package garg.sarthik.recordkeeper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import garg.sarthik.recordkeeper.R;

public class NoteAdaptor extends RecyclerView.Adapter<NoteAdaptor.ViewHolder> {

    private Context ctx;
    private ArrayList<Notes> notelist;

    public NoteAdaptor(Context ctx, ArrayList<Notes> notelist) {
        this.ctx = ctx;
        this.notelist = notelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(inflatedView);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {        // position does not corresponds to position, but the id

        Notes notes = notelist.get(position);
        holder.tvNote.setText(notes.getNotes());
        holder.tvTime.setText(notes.getTime());

    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTime;
        TextView tvNote;
        Button btnRemove;

        public ViewHolder(View itemView) {              //use it always to use onClickListener to use and use getAdapterPosition to get the position
            super(itemView);
            tvNote = itemView.findViewById(R.id.tvNote);
            tvTime = itemView.findViewById(R.id.tvTime);
            btnRemove = itemView.findViewById(R.id.btnRemove);

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    notelist.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    Toast.makeText(ctx, "Deleted", Toast.LENGTH_SHORT);

                }
            });
        }
    }
}
