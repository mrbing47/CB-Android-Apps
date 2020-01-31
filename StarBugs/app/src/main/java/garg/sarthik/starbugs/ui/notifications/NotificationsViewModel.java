package garg.sarthik.starbugs.ui.notifications;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Variables;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<List<Event>> mEvents;

    public NotificationsViewModel() {
        mEvents = new MutableLiveData<>();
        Variables.colUser.document(Variables.fireUser.getUid()).collection(Constants.COL_NOTIFICATION).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                mEvents.setValue(queryDocumentSnapshots.toObjects(Event.class));
            }
        });

    }

    public LiveData<List<Event>> getEvents() {
        return mEvents;
    }
}