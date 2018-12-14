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

import java.util.ArrayList;

public class Frag_items extends Fragment {

    public Frag_items newInstance(ArrayList<heldItems> heldItemsArrayList) {

        Frag_items fragItems = new Frag_items();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("items", heldItemsArrayList);
        fragItems.setArguments(bundle);
        return fragItems;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_recyclerview, container, false);

        if (getArguments() != null) {
            RecyclerView recyclerView = view.findViewById(R.id.rvCommon);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new ItemsAdaptor(getArguments().<heldItems>getParcelableArrayList("items"), getContext()));
        }

        return view;
    }
}
