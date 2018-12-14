package garg.sarthik.likegmail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView tvName;
    TextView tvDOB;
    TextView tvGender;
    ImageView ivUser;
    private int position;
    BioList bioList;

    public FragmentB(BioList bioListArrayList) {
        this.bioList = bioListArrayList;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_bio,container,false);

        tvName = view.findViewById((R.id.nameUser));
        tvDOB = view.findViewById(R.id.tvDOB);
        tvGender = view.findViewById((R.id.tvGender));


        tvName.setText(bioList.getName());
        tvDOB.setText(bioList.getDob());
        tvGender.setText(bioList.getGender());


        return view;
    }
}


