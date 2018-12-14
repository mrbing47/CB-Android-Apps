package garg.sarthik.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TaskAdaptor extends RecyclerView.Adapter<TaskAdaptor.ViewHolder> {

    Context context;
    List<Task> taskList;

    public TaskAdaptor(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Task task = taskList.get(position);

        holder.tvComment.setText(task.getName());

        Picasso.get()
                .load("https://randomuser.me/api/portraits/men/41.jpg")
                .placeholder(R.drawable.ic_wallpaper)
                .into(holder.ivUser);

    }

    @Override
    public int getItemCount() {
    return taskList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvComment;
        ImageView ivUser;

        public ViewHolder(View itemView) {
            super(itemView);

            tvComment = itemView.findViewById(R.id.tvComment);
            ivUser = itemView.findViewById(R.id.ivUser);
        }
    }
}
