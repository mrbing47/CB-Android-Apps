package garg.sarthik.interfragment;

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

public class FragmentA extends Fragment {

    RecyclerView rvNotes;

    ArrayList<BioList> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_menu,container,false);

        arrayList.add(new BioList("Sarthik Garg","Male"," ","01.07.1999"));
        arrayList.add(new BioList("Joey Tribianni","Male"," ","05.12.1990"));
        arrayList.add(new BioList("Rachael Green","Female"," ","09.07.2000"));
        arrayList.add(new BioList("Alice White","Female"," ","20.04.1995"));
        arrayList.add(new BioList("Ross Geller","Male"," ","01.10.2001"));
        arrayList.add(new BioList("Jon Snow","Male"," ","31.11.1999"));
        arrayList.add(new BioList("Rose Leslie","Female"," ","16.02.1998"));
        arrayList.add(new BioList("Chandler Bing","Male"," ","10.09.1992"));
        arrayList.add(new BioList("Monica Geller","Female"," ","19.05.1994"));

        DataAdaptor dataAdaptor = new DataAdaptor(arrayList,view.getContext());

        rvNotes = view.findViewById(R.id.lvNames);
        rvNotes.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvNotes.setAdapter(dataAdaptor);

        return view;
    }
}
