package DB;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aaa on 15-4-22.
 */
public class SQLiteHealper extends SQLiteOpenHelper {


    public SQLiteHealper(Context context) {
        super(context, "qiongyou.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String s="create table qiongyou (_id Integer primary key autoincrement,name text)";
        db.execSQL(s);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
