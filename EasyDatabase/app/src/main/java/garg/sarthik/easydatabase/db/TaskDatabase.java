package garg.sarthik.easydatabase.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import garg.sarthik.easydatabase.Task;

@Database(entities = {Task.class}, version = 2)
public abstract class TaskDatabase extends RoomDatabase {

    public abstract TaskDao getTaskDao();
}
