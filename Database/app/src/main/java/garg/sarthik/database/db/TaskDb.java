package garg.sarthik.database.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import garg.sarthik.database.Task;
import garg.sarthik.database.models.Constants;

public class TaskDb extends SQLiteOpenHelper {

    public TaskDb(Context context) {
        super(context, Constants.DB_NAME, null, 1);
    }

    public long insertTask(Task task) {

//        String insertQuery = "INSERT INTO TASK VALUES ("
//                + task.getId()
//                + ", "
//                + task.getTitle()
//                + ");";
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.COLUMN_ID, task.getId());
        contentValues.put(Constants.COLUMN_TITLE, task.getTitle());

        return getWritableDatabase()
                .insert("Task",
                        null,
                        contentValues);

    }

    public ArrayList<Task> getAllTask() {
        //return the ArrayList of all the tasks stored in the db

        //String[] projection = new String[]{Constants.COLUMN_ID,Constants.COLUMN_TITLE};

        ArrayList<Task> taskArrayList = new ArrayList<>();

        Cursor cursor = getReadableDatabase().query(Constants.TABLE_NAME,
                null,   //enter projection here
                null,
                null,
                null,
                null,
                null);

        while(cursor.moveToNext())
        {
            long id = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_ID.trim()));
            String title = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_TITLE.trim()));

            taskArrayList.add(new Task(id,title));

        }

        cursor.close();
        return taskArrayList;
    }

    public Task getTaskWithId(Long id) {
        //return task with the given ID

        Task task;
        Cursor cursor = getReadableDatabase().query(Constants.TABLE_NAME,
                null,
                Constants.COLUMN_ID + " = ? ",
                new String[]{id.toString()},
                null,
                null,
                null);

        while(cursor.moveToNext())
        {
            Long fetchedID = cursor.getLong(0);
            String fetchedTitle = cursor.getString(1);
            task = new Task(fetchedID,fetchedTitle);
        }
        cursor.close();
        return task;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Called when the db is created for the first time, or its version was incremented
        //YOu can call it back to make changes to the table like adding some new columns

//        String query = "CREATE TABLE Task (" +
//                "Id INTEGER PRIMARY KEY," +
//                "TaskTitle TEXT NOT NULL" +
//                ");";

        String query = Constants.CREATE + Constants.TABLE_NAME + Constants.LEFT_BRACKET
                + Constants.COLUMN_ID + Constants.INTEGER + Constants.PRIMARY_KEY + Constants.COMMA
                + Constants.COLUMN_TITLE + Constants.TEXT + Constants.NOT_NULL
                + Constants.RIGHT_BRACKET + Constants.SEMICOLON;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //performs table alternation here or let th default implementation happens
    }
}
