package testing.energysistem.com.batterytest;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import database.DataBaseManagerActualizaciones;


public class RegistroActivity extends ActionBarActivity implements View.OnClickListener{


    

    private Button btnDuracion;
    private TextView tv;

    DataBaseManagerActualizaciones objManagerActualizacion;


    private DataBaseManagerActualizaciones manager;
    private SimpleCursorAdapter adapter;
    private Cursor c;
    private ListView listView;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        manager = new DataBaseManagerActualizaciones(this);
        listView = (ListView) findViewById(R.id.listViewActualizaciones);


        // manager.insertar_3parametros(null, "1212", "1990-01-01 ");
        btnDuracion=(Button) findViewById(R.id.btnBorrar);
        btnDuracion.setOnClickListener(this);

        tv=(TextView) findViewById(R.id.tvDuracion);




        String[] from = new String[]{ manager.CN_LEVEL_BATERY, manager.CN_FECHA};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};


        new LoadDataTask().execute();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, c, from, to, 0);
        listView.setAdapter(adapter);

        objManagerActualizacion= new DataBaseManagerActualizaciones(this);



    }


    public String diferenciaTiempo(String dateInicial, String dateFinal) throws ParseException {


        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        Date dI = null;

        dI = format.parse(dateInicial);

        Date dF = format.parse(dateFinal);


        Date diff = new Date(dF.getTime() - dI.getTime());

        //  Calendar calendar = Calendar.getInstance();
        calendar.setTime(diff);


        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);


        return hours + " h " + minutes + " min " + seconds + " s ";
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();

        try{

            String primera = objManagerActualizacion.selectPrimeraActualizacion();
            String ultima = objManagerActualizacion.selectUltimaActualizacion();


            tv.setText("\nPRIMERA FECHA: " + primera + "\n ULTIMA FECHA:" + "\t" + ultima + "\n DIFERENCIA:<(" + diferenciaTiempo(primera, ultima) + ")>");
        }catch (Exception e){

            tv.setText( "PRIMERA FECHA: " + "No hay suficentes datos"+ "\n ULTIMA FECHA: " + "No hay suficentes datos" );

        }

    }

    @Override
    protected void onDestroy() {

        c.close();
        super.onDestroy();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnBorrar){
            objManagerActualizacion.eliminarTodo();

            String[] from = new String[]{ manager.CN_LEVEL_BATERY, manager.CN_FECHA};
            int[] to = new int[]{android.R.id.text1, android.R.id.text2};

            new LoadDataTask().execute();
            adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, c, from, to, 0);
            listView.setAdapter(adapter);
        }
    }


    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Loading data...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            c = manager.cargarCursor();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            adapter.changeCursor(c);
        }
    }


}



