package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ruben on 23/05/15.
 */
public class DataBaseManager {



    private DbHelper helper;
    private SQLiteDatabase db;

    /**
     * GET AND SET
     * @return
     */
    public DbHelper getHelper() {
        return helper;
    }

    public void setHelper(DbHelper helper) {
        this.helper = helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }



    public DataBaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }





    // Cierra la base de datos, cuando ésta ya no va a ser utilizada
    public void close() {
        /**
         * nos esta dando problemas si  lo cerramos
         * db.close();
         */
        db.close();

    }



    public void insertar_2parametros(String param1, String param2) {}
    public void insertar_3parametros(String param1, String param2, String param3) {}

    public void actualizar_3parametros(String param1, String param2, String param3) {}
    public void actualizar_2parametros(String param1, String param2) {}

    /**
     * ELIMINIAR REGISTRO
     * @param id
     */

    public void eliminar(String id) {

    }



    public void eliminarTodo() {

    }



    public Cursor cargarCursor() {

        return null;
    }


    public Boolean CompruebaRegistro(int id) {

    return false;
    }






}
