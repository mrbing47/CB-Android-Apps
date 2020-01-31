package garg.sarthik.starbugs.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import garg.sarthik.starbugs.POJO.User;
import garg.sarthik.starbugs.Statics.Variables;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<User> mUser;

    public ProfileViewModel() {
        mUser = new MutableLiveData<>();
        mUser.setValue(Variables.user);
    }

    public LiveData<User> getUser() {
        return mUser;
    }

    public void EditUserData(User user){
        Variables.user = user;
        mUser.setValue(user);

        Variables.colUser.document(Variables.fireUser.getUid()).set(user);
    }
}