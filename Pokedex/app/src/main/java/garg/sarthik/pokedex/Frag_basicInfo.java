package garg.sarthik.pokedex;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Frag_basicInfo extends Fragment {

    int weight;
    int height;
    int id;
    int order;
    int base_exp;
    ArrayList<Poke_Types> pokeTypes;

    TextView tvWeight;
    TextView tvHeight;
    TextView tvID;
    TextView tvOrder;
    TextView tvBaseExp;
    RecyclerView rvTypes;

    public Frag_basicInfo(){}
    public Frag_basicInfo newInstance(int weight, int height, int id, int order, int base_exp, ArrayList<Poke_Types> pokeTypesArrayList)
    {
        Frag_basicInfo fragBasicInfo = new Frag_basicInfo();

        Bundle bundle = new Bundle();
        bundle.putInt("Weight",weight);
        bundle.putInt("Height",height);
        bundle.putInt("ID",id);
        bundle.putInt("order",order);
        bundle.putInt("baseexp",base_exp);
        bundle.putParcelableArrayList("types", pokeTypesArrayList);
        fragBasicInfo.setArguments(bundle);
        return  fragBasicInfo;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_basicinfo,container,false);

        if(getArguments()!=null) {

            weight = getArguments().getInt("Weight");
            height = getArguments().getInt("Height");
            id = getArguments().getInt("ID");
            order = getArguments().getInt("order");
            base_exp = getArguments().getInt("baseexp");
            pokeTypes = getArguments().getParcelableArrayList("types");

            tvWeight = view.findViewById(R.id.tvWeight);
            tvHeight = view.findViewById(R.id.tvHeight);
            tvID = view.findViewById(R.id.tvID);
            tvOrder = view.findViewById(R.id.tvOrder);
            tvBaseExp = view.findViewById(R.id.tvBaseExperince);
            RecyclerView rvList = view.findViewById(R.id.rvTypes);

            tvWeight.setText("" + weight);
            tvHeight.setText("" + height);
            tvID.setText("" + id);
            tvOrder.setText("" + order);
            tvBaseExp.setText("" + base_exp);


            rvList.setLayoutManager(new LinearLayoutManager(getContext()));
            rvList.setAdapter(new BasicInfoAdaptor(pokeTypes,getContext()));
        }
        return view;
    }
}
