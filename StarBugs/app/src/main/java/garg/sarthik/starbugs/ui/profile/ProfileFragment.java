package garg.sarthik.starbugs.ui.profile;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import garg.sarthik.starbugs.POJO.User;
import garg.sarthik.starbugs.R;
import garg.sarthik.starbugs.Statics.Functions;
import garg.sarthik.starbugs.Statics.Variables;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private TextView tvName;
    private TextView tvEmail;
    private EditText etPhone;
    private EditText etAuthId;
    private EditText etBranch;
    private FloatingActionButton fabEdit;
    private Drawable originalDrawable;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        tvName = root.findViewById(R.id.tvProfileName);
        tvEmail = root.findViewById(R.id.tvProfileEmail);
        etPhone = root.findViewById(R.id.tvProfileNumber);
        etAuthId = root.findViewById(R.id.tvProfileAuthId);
        etBranch = root.findViewById(R.id.tvProfileBranch);
        fabEdit = root.findViewById(R.id.fabEdit);

        originalDrawable = etPhone.getBackground();

        changeEditState(false);

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPhone.isEnabled()) {
                    String branch = etBranch.getText().toString();
                    String phone = etPhone.getText().toString();
                    String authId = etAuthId.getText().toString();

                    if (branch.isEmpty() || phone.length() != 10 || authId.isEmpty()) {
                        Toast.makeText(getContext(), "Please enter proper data", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    profileViewModel.EditUserData(new User(Variables.user.getUserName(), Variables.user.getUserEmail(),phone, authId, branch, Variables.user.getUserToken()));
                    changeEditState(false);
                }else{
                    changeEditState(true);
                }
            }
        });

        profileViewModel.getUser().observe((LifecycleOwner) getContext(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                tvEmail.setText(user.getUserEmail());
                tvName.setText(Functions.toCapitalise(user.getUserName()));
                etAuthId.setText(user.getUserAuthId());
                etPhone.setText(user.getUserNumber());
                etBranch.setText(user.getUserBranch());
            }
        });
        return root;
    }
    
    private void changeEditState(boolean isEnable){
        
        if(isEnable){
            
            etBranch.setBackground(originalDrawable);
            etPhone.setBackground(originalDrawable);
            etAuthId.setBackground(originalDrawable);

            etAuthId.setEnabled(true);
            etPhone.setEnabled(true);
            etBranch.setEnabled(true);

            fabEdit.setImageResource(R.drawable.ic_check_white);

        }else{
            etBranch.setBackgroundColor(Color.TRANSPARENT);
            etPhone.setBackgroundColor(Color.TRANSPARENT);
            etAuthId.setBackgroundColor(Color.TRANSPARENT);

            etAuthId.setEnabled(false);
            etPhone.setEnabled(false);
            etBranch.setEnabled(false);

            fabEdit.setImageResource(R.drawable.ic_edit_white);

        }
    } 
}