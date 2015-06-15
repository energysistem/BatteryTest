package testing.energysistem.com.batterytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import utilidades.DatosDispositivo;


public class DatosDispositivoActivity extends Activity {


    private TextView tvDatos;
    private DatosDispositivo datosObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_dispositivo);

        tvDatos=(TextView) findViewById(R.id.tvDatosDevice);

        datosObject= new DatosDispositivo();

        tvDatos.setText(datosObject.toString());

    }


}
