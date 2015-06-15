package testing.energysistem.com.batterytest;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;


import java.text.DecimalFormat;

import database.DataBaseManagerActualizaciones;


import utilidades.Fechas;
import utilidades.ManagerBattery;

public class CaracteristicasActivity extends ActionBarActivity {



    private TextView tvTemperatura, tvVoltage, tvTecnology, tvEstado, tvNivelbateriaActual, tvNivelBateriaMaximo, tvTomadeCorriente, tvSaludBateria, tvBatteryStatusIcon, tvPresentBatery;

    private Switch interruptorRegistro;


   private ManagerBattery objectManagerBattery;
    private DataBaseManagerActualizaciones managerActualizacion;
    private Fechas fecha_actual;

    int count_event =0;

    private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);

        inicializarVariables();

        interruptorRegistro.setChecked(false);
        managerActualizacion = new DataBaseManagerActualizaciones(this);

        res= getResources();

    }


public void inicializarVariables(){
    /////////////////////////////////////////////////////////////////// BATERIA
    tvTecnology = (TextView) findViewById(R.id.tvTecnolgy);
    tvTemperatura = (TextView) findViewById(R.id.tvTemperatura);
    tvVoltage = (TextView) findViewById(R.id.tvVoltage);
    tvEstado = (TextView) findViewById(R.id.tvEstado);
    tvNivelbateriaActual = (TextView) findViewById(R.id.tvNivelBateriaActual);
    tvNivelBateriaMaximo = (TextView) findViewById(R.id.tvNivelBateriaMaximo);
    tvTomadeCorriente = (TextView) findViewById(R.id.tvTomaDeCorriente);
    tvSaludBateria = (TextView) findViewById(R.id.tvSaludBateria);
    tvBatteryStatusIcon = (TextView) findViewById(R.id.tvbatteryStatusIcon);
    tvPresentBatery = (TextView) findViewById(R.id.tvpresentBattery);

/////////////////////////////////////////////////////////////////////////////////// DISPOSITIVO

    interruptorRegistro= (Switch) findViewById(R.id.tvSwitchRegistrp);
    //set the switch to ON


}


    @Override
    protected void onResume() {
        super.onResume();

        this.registerReceiver(this.myBatteryReceiver,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        Log.d("register", "register battery status receiver.");


    }

    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myBatteryReceiver);
        Log.d("unregister", "Unregister battery status receiver.");
        super.onDestroy();


    }



    private BroadcastReceiver myBatteryReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {



            objectManagerBattery = new ManagerBattery(intent);

            ActualizarInterfaz_llenarDatabase();


        }
    };




    public void ActualizarInterfaz_llenarDatabase(){



        tvTecnology.setText(res.getString(R.string.caracteristicas_Tecnologia) + objectManagerBattery.getTechnology());


        switch (objectManagerBattery.getStatus()) {

            case 1:
                tvEstado.setText(res.getString(R.string.caracteristicas_Estado) + objectManagerBattery.getStatus() + res.getString(R.string.caracteristicas_Estado_no_conocido));
                break;
            case 2:
                tvEstado.setText(res.getString(R.string.caracteristicas_Estado) + objectManagerBattery.getStatus() +res.getString(R.string.caracteristicas_Estado_cargando));
                break;
            case 3:
                tvEstado.setText(res.getString(R.string.caracteristicas_Estado) + objectManagerBattery.getStatus() +res.getString(R.string.caracteristicas_Estado_descargando));
                break;
            case 4:
                tvEstado.setText(res.getString(R.string.caracteristicas_Estado)+ objectManagerBattery.getStatus() + res.getString(R.string.caracteristicas_Estado_no_cargando));
                break;
            case 5:
                tvEstado.setText(res.getString(R.string.caracteristicas_Estado) + objectManagerBattery.getStatus() + res.getString(R.string.caracteristicas_Estado_carga_completa));
                break;
        }



        tvTemperatura.setText(res.getString(R.string.caracteristicas_Temperatura) + objectManagerBattery.getTemperature_S());

        DecimalFormat formatter = new DecimalFormat("#0.00");






        tvVoltage.setText(res.getString(R.string.caracteristicas_Voltaje)+new DecimalFormat("#0.0").format(objectManagerBattery.getVoltage())  + R.string.caracteristicas_Voltios);
        tvNivelbateriaActual.setText(res.getString(R.string.caracteristicas_PorcentajeBateria) + objectManagerBattery.getLevelBatery() + " %");
        tvNivelBateriaMaximo.setText(res.getString(R.string.caracteristicas_PorcentajeBateriaMaximo) + objectManagerBattery.getScale() + " %");


        if (objectManagerBattery.getPlugged() == BatteryManager.BATTERY_PLUGGED_AC) {
            tvTomadeCorriente.setText(res.getString(R.string.caracteristicas_CARGARDOR_CORRIENTE));
        } else if (objectManagerBattery.getPlugged() == BatteryManager.BATTERY_PLUGGED_USB) {
            tvTomadeCorriente.setText(res.getString(R.string.caracteristicas_USB_CORRIENTE)); // on USB power
        } else if (objectManagerBattery.getPlugged() == 0) {
            tvTomadeCorriente.setText(res.getString(R.string.caracteristicas_BATERIA_CORRIENTE)); // on battery power
        } else {
            tvTomadeCorriente.setText(res.getString(R.string.caracteristicas_SIN_CORRIENTE)); // on battery power
        }


        switch (objectManagerBattery.getHealth()) {
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_desconocida));
                break;
            case BatteryManager.BATTERY_HEALTH_GOOD:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_buena));
                break;
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_sobrecalentamiento));
                break;
            case BatteryManager.BATTERY_HEALTH_DEAD:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_muerta));
                break;
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_voltaje_por_encima_de_lo_normal));
                break;
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_fallo_inespecifico));
                break;

            case BatteryManager.BATTERY_HEALTH_COLD:
                tvSaludBateria.setText(res.getString(R.string.caracteristicas_salud_bateria_temperatura_baja));
                break;
        }


        tvBatteryStatusIcon.setCompoundDrawablesWithIntrinsicBounds(objectManagerBattery.getIcon_small(), 0, 0, 0);


        if (objectManagerBattery.isPresentBattery())
            tvPresentBatery.setText( res.getString(R.string.caracteristicas_salud_bateria_presente_si));
        else
            tvPresentBatery.setText(res.getString(R.string.caracteristicas_salud_bateria_presente_no));


/**
 * si esta activado el interruptor -->registramos el evento en la base de datos
 */
        if(count_event %3==0){

            if(interruptorRegistro.isChecked()){
                managerActualizacion.insertar_3parametros(null, "" + objectManagerBattery.getLevelBatery(), fecha_actual.getDateTime());
            }
        }


        count_event++;

        if(count_event >12){
            count_event =0;
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        Intent lanzador;
        switch (id) {

            case R.id.ItemRegistro:
                lanzador = new Intent(this, RegistroActivity.class);
                startActivity(lanzador);
                break;


            case R.id.ItemlistarVideo:
                lanzador = new Intent(this, ListaVideosActivity.class);
                startActivity(lanzador);
                break;


            case R.id.ItemDeviceInfo:
                lanzador = new Intent(this, DatosDispositivoActivity.class);
                startActivity(lanzador);
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
