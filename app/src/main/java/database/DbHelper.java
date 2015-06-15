package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ruben on 29/03/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "registro7.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public  DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManagerActualizaciones.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+ DB_NAME);
        onCreate(db);
    }
}
