package garg.sarthik.starbugs.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import garg.sarthik.starbugs.Adapters.NotificationAdapter;
import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.R;
import garg.sarthik.starbugs.ui.history.HistoryFragment;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private TextView tvNotification;
    private RecyclerView rvNotification;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        tvNotification = root.findViewById(R.id.tvNotification);
        rvNotification = root.findViewById(R.id.rvNotification);

        notificationsViewModel.getEvents().observe((LifecycleOwner) getContext(), new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {

                if (events.size() == 0) {
                    tvNotification.setVisibility(View.VISIBLE);
                    rvNotification.setVisibility(View.GONE);
                } else {

                    tvNotification.setVisibility(View.GONE);
                    rvNotification.setVisibility(View.VISIBLE);

                    Collections.reverse(events);

                    rvNotification.setLayoutManager(new LinearLayoutManager(getContext()));
                    rvNotification.setAdapter(new NotificationAdapter(events, getContext(), NotificationsFragment.this));
                }
            }

        });
        return root;
    }
}