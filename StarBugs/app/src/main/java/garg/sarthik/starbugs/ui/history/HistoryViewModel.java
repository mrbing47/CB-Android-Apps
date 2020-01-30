package garg.sarthik.starbugs.ui.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Variables;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<List<Event>> mEvents;

    public HistoryViewModel() {
        mEvents = new MutableLiveData<>();
        List<Event> events = new ArrayList<>();

        events.add(new Event(1,"77 , 80", "202001240821"));
        events.add(new Event(23,"25 , 33", "202001240821"));
        events.add(new Event(2,"28.6751628 , 77.2212948", "202001240821"));
        events.add(new Event(69,"71 , 25", "202001240821"));
        events.add(new Event(88,"69 , 55", "202001240821"));
        events.add(new Event(45,"7 , 8", "202001240821"));

        /*Variables.colUser.document(Variables.fireUser.getUid()).collection(Constants.COL_HISTORY).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                mEvents.setValue(queryDocumentSnapshots.toObjects(Event.class));
            }
        });*/
        mEvents.setValue(events);
    }

    public LiveData<List<Event>> getEvents() {
        return mEvents;
    }
}