package DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-22.
 */
public class HealperManger {
    private SQLiteHealper sp;
    private ArrayList<String> strings;

    public HealperManger(Context context) {
        sp = new SQLiteHealper(context);
    }
    public void insert(String cityname){
        SQLiteDatabase db = sp.getWritableDatabase();
        ContentValues valus=new ContentValues();
        valus.put("name",cityname);
        db.insert("qiongyou",null,valus);
    }
    public ArrayList<String> requer(String s){
        SQLiteDatabase db = sp.getReadableDatabase();
        Cursor query = db.query("qiongyou", new String[]{"name"}, "name like ?", new String[]{"%" + s + "%"}, null, null, null);
        if (query.getCount()>0){
            strings = new ArrayList<>();
            while (query.moveToNext()){
                String name = query.getString(query.getColumnIndex("name"));
                strings.add(name);
            }
            return strings;
        }
    return strings;
    }
    public boolean requername(String s){
        SQLiteDatabase db = sp.getReadableDatabase();
        Cursor query = db.query("qiongyou", new String[]{"name"}, "name=?", new String[]{s}, null, null, null);


        return !(query.getCount()>=1);
    }

}
