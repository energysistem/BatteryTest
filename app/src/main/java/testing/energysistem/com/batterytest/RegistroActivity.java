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

import database.DataBaseManagerActualizaciones;
import utilidades.Fechas;


public class RegistroActivity extends ActionBarActivity implements View.OnClickListener{


    

    DataBaseManagerActualizaciones objManagerActualizacion;
    private Button btnDuracion;
    private TextView tvDateInicial, tvDateFinal, tvDiferencia;
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



        btnDuracion=(Button) findViewById(R.id.btnBorrar);
        btnDuracion.setOnClickListener(this);


        tvDateInicial = (TextView) findViewById(R.id.registro_tvPrimeraFecha);
        tvDateFinal = (TextView) findViewById(R.id.registro_tvUltima_fecha);
        tvDiferencia = (TextView) findViewById(R.id.tvDuracion);




        String[] from = new String[]{ manager.CN_LEVEL_BATERY, manager.CN_FECHA};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};


        new LoadDataTask().execute();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, c, from, to, 0);
        listView.setAdapter(adapter);

        objManagerActualizacion= new DataBaseManagerActualizaciones(this);



    }




    @Override
    protected void onPostResume() {
        super.onPostResume();

        try{

            String primera = objManagerActualizacion.selectPrimeraActualizacion();
            String ultima = objManagerActualizacion.selectUltimaActualizacion();

            tvDateInicial.setText("PRIMERA FECHA: " + primera);
            tvDateFinal.setText("ULTIMA FECHA: " + ultima);
            tvDiferencia.setText("DIFERENCIA:<(" + Fechas.diferenciaTiempo(primera, ultima) + ")>");
        }catch (Exception e){

            tvDateInicial.setText("PRIMERA FECHA: " + " No hay suficentes datos");
            tvDateFinal.setText("ULTIMA FECHA: " + " No hay suficentes datos");
            tvDiferencia.setText("DIFERENCIA:<(" + 0 + ")>");


        }

    }

    @Override
    protected void onDestroy() {

        c.close();
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBorrar) {
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
            Toast.makeText(getApplicationContext(), "Cargando Datos", Toast.LENGTH_SHORT).show();
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



