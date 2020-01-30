package garg.sarthik.starbugs.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import garg.sarthik.starbugs.Adapters.NotificationAdapter;
import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.R;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private RecyclerView rvHistory;
    private TextView tvHistory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                ViewModelProviders.of(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        rvHistory = root.findViewById(R.id.rvHistory);
        tvHistory = root.findViewById(R.id.tvHistory);

        historyViewModel.getEvents().observe((LifecycleOwner) getContext(), new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {

                if (events.size() == 0) {
                    tvHistory.setVisibility(View.VISIBLE);
                    rvHistory.setVisibility(View.GONE);
                } else {

                    tvHistory.setVisibility(View.GONE);
                    rvHistory.setVisibility(View.VISIBLE);

                    rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));
                    rvHistory.setAdapter(new NotificationAdapter(events, getContext(), HistoryFragment.this));
                }
            }
        });
        return root;
    }
}