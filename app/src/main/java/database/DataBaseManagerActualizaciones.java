package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by ruben on 10/04/15.
 */
public class DataBaseManagerActualizaciones extends DataBaseManager {




    public static final String TABLE_NAME = "actualizacion";
    public static final String CN_ID = "_id";
    public static final String CN_LEVEL_BATERY = "bateria";
    public static final String CN_FECHA = "fecha";





    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_LEVEL_BATERY + " text ,"
            + CN_FECHA + " datetime );";






    public DataBaseManagerActualizaciones(Context context) {
        super(context);
    }



    // Cierra la base de datos, cuando ésta ya no va a ser utilizada
    @Override
    public void close() {
        /**
         * nos esta dando problemas si lo cerramos
         *   db.close();
         */
        super.getDb().close();
    }


    public String selectUltimaActualizacion() {



        Cursor resultSet = getDb().rawQuery("Select * from " + TABLE_NAME + " order by " + CN_FECHA + " DESC LIMIT 1", null);
        resultSet.moveToFirst();

        String ultima=resultSet.getString(2).toString();

        if(ultima==null)
            ultima="";

        return ultima;


    }

    public String selectPrimeraActualizacion() {



        Cursor resultSet = getDb().rawQuery("Select * from " + TABLE_NAME + " order by " + CN_FECHA + " ASC LIMIT 1", null);
        resultSet.moveToFirst();



        String ultima=resultSet.getString(2).toString();

        String rec1 = resultSet.getString(resultSet.getColumnIndex
                (CN_FECHA));

        if(ultima==null)
            ultima="";


        return ultima;


    }







    private ContentValues generarContentValues( String id,String cod, String fecha) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_LEVEL_BATERY, cod);
        valores.put(CN_FECHA, fecha);
        return valores;
    }

    @Override
    public void insertar_3parametros(String id, String level ,String date)
    {

        //getDb().execSQL("INSERT INTO " + TABLE_NAME + "(" + CN_ID + ", " + CN_LEVEL_BATERY + "," + CN_FECHA + ") VALUES(''," + level + " ,'datetime()'");
        getDb().insert(TABLE_NAME, null, generarContentValues(id, level, date));
    }




    /**
     * ELIMINIAR REGISTRO
     * @param id
     */
    @Override
    public void eliminar(String id) {
        //bd.delete (Tabla, Claúsula Where, Argumentos Where)
        getDb().delete(TABLE_NAME, CN_ID + "=?", new String[]{id});
    }


    @Override
    public void eliminarTodo() {
        //db.delete(TABLE_NAME, CN_ID + "IN (?,?)", new String[]{id1, id2});
        getDb().execSQL("DELETE FROM " + TABLE_NAME + ";");
    }





    @Override
    public Cursor cargarCursor() {

        String[] columnas = new String[]{CN_ID, CN_LEVEL_BATERY, CN_FECHA};

        return super.getDb().query(TABLE_NAME, columnas, null, null, null, null, null);
    }



    public Boolean algunRegistro(){


        boolean esta=true;

        Cursor resultSet = super.getDb().rawQuery("Select * from "+TABLE_NAME,null);



        //Returns the numbers of rows in the cursor.
        resultSet.getCount();


        if(resultSet.getCount()==0) {
            esta=false;
        }else {
            esta=true;
        }

        return esta;
    }

    @Override
    public Boolean CompruebaRegistro(int id) {

        boolean esta=true;

        Cursor resultSet = super.getDb().rawQuery("Select * from "+TABLE_NAME+" WHERE "+CN_ID+"="+id,null);

        //Returns the numbers of rows in the cursor.
        resultSet.getCount();


        if(resultSet.getCount()==0) {
            esta=false;
        }else {
            esta=true;
        }

        return esta;


    }



}
