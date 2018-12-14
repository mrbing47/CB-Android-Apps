package garg.sarthik.pokedex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.app.progresviews.ProgressWheel;

import java.util.ArrayList;

public class Frag_stats extends Fragment {

    public Frag_stats newInstance(ArrayList<Stats> statsArrayList) {
        Frag_stats fragStats = new Frag_stats();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("stats", statsArrayList);
        fragStats.setArguments(bundle);

        return fragStats;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recyclerview,container,false);

        if(getArguments() != null)
        {
//            ProgressWheel progressWheel = view.findViewById(R.id.wheelprogress);
//            progressWheel.setPercentage(10);
//            progressWheel.setDefText("Stats");
//            progressWheel.setStepCountText("10");
            RecyclerView recyclerView = view.findViewById(R.id.rvCommon);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new StatsAdaptor(getArguments().<Stats>getParcelableArrayList("stats"),getContext()));
        }
        return view;
    }
}
