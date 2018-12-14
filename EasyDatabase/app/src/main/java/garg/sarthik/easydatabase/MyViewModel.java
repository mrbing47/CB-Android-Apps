package garg.sarthik.easydatabase;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {

    private LiveData<List<Task>> tasklistLiveData;

    LiveData<List<Task>> getDataFromDatabase() {

        if (tasklistLiveData == null) {

            tasklistLiveData = TaskApplication.getDB().getTaskDao().getAllTask();

        }
        return tasklistLiveData;
    }


}
