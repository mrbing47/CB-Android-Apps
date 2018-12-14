package garg.sarthik.easydatabase.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import garg.sarthik.easydatabase.Task;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAllTask();

    @Query("SELECT * FROM task WHERE id = :id")
    Task taskWithId(int id);

    @Insert
    void inertTask(Task... task);

    @Insert
    void insertTaskList(List<Task> task);

    @Update
    void updateTask(Task task);

    @Delete
    void deleteTask(Task task);


}
