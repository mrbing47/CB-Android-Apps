package garg.sarthik.pokedex;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Frag_abilities extends Fragment {

    public Frag_abilities newInstance(ArrayList<Abilities> abilitiesArrayList) {

        Frag_abilities fragAbilities = new Frag_abilities();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Abilities", abilitiesArrayList);
        Log.e("TAG", "newInstance: " + abilitiesArrayList.get(0).ability.getName());
        fragAbilities.setArguments(bundle);
        return fragAbilities;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recyclerview, container, false);

        if (getArguments() != null) {
            Log.e("TAG", "onCreateView: ABILITIES");
             RecyclerView rvList = view.findViewById(R.id.rvCommon);
            rvList.setLayoutManager(new LinearLayoutManager(getContext()));
            rvList.setAdapter(new AbilitiesAdaptor(getArguments().<Abilities>getParcelableArrayList("Abilities"),getContext()));
        }
        return view;
    }
}
