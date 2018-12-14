package garg.sarthik.okhttp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context ctx;
    //ArrayList<ReposDetail> reposDetailArrayListDetails;
    ReposDetail[] reposDetailArrayListDetails;

    public UserAdapter(Context ctx, ReposDetail[] reposDetails) {
        this.ctx = ctx;
        this.reposDetailArrayListDetails = reposDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_reposlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ReposDetail reposDetail = reposDetailArrayListDetails[position];

        holder.tvName.setText(reposDetail.getName());
        holder.tvFullName.setText(reposDetail.getFull_name());
    }

    @Override
    public int getItemCount() {
        return reposDetailArrayListDetails.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvFullName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvFullName = itemView.findViewById(R.id.tvFullName);
        }
    }
}
