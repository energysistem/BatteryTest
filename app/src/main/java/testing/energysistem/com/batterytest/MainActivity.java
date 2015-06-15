package testing.energysistem.com.batterytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import utilidades.Modo_Fabricante;
import utilidades.Modo_Usuario;


public class MainActivity extends Activity  {

private Button btnIniciarTest;
private RadioButton radioFabricante, radioUsuario, radioCaracteristicas;
private RadioGroup radioGroupOpciones;

    private AudioManager mAudioManager;



    Resources res;
    Context mainContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainContext=this;
        res= getResources();

        addListenerOnButton();


        mAudioManager= (AudioManager)getSystemService(Context.AUDIO_SERVICE);


    }



    public void addListenerOnButton() {
        radioGroupOpciones=(RadioGroup) findViewById(R.id.main_radioOpciones);
        radioFabricante=(RadioButton) findViewById(R.id.main_radioModoFabricante);
        radioUsuario=(RadioButton) findViewById(R.id.main_radioModoUsuario);
        radioCaracteristicas=(RadioButton) findViewById(R.id.main_radioVerCaracteristicas);
        btnIniciarTest= (Button) findViewById(R.id.main_btnIniciarTest);




        btnIniciarTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent lanzador;




                if (radioFabricante.isChecked()) {
                    Toast.makeText(getBaseContext(), res.getString(R.string.main_radio_modo_fabricante), Toast.LENGTH_SHORT).show();


                    try {

                        ConfiguracionPredeterminada(1);


                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    lanzador = new Intent(mainContext, ListaVideosActivity.class);

                    startActivity(lanzador);

                } else if (radioUsuario.isChecked()) {
                    Toast.makeText(getBaseContext(), res.getString(R.string.main_radio_modo_usuario), Toast.LENGTH_SHORT).show();

                    try {

                       ConfiguracionPredeterminada(2);

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    lanzador = new Intent(mainContext, ListaVideosActivity.class);

                    startActivity(lanzador);

                } else if (radioCaracteristicas.isChecked()) {
                    Toast.makeText(getBaseContext(), res.getString(R.string.main_radio_caracteristicas_bateria), Toast.LENGTH_SHORT).show();

                    lanzador = new Intent(mainContext, CaracteristicasActivity.class);
                    startActivity(lanzador);
                } else {

                    Toast.makeText(getBaseContext(), res.getString(R.string.main_elija_opcion), Toast.LENGTH_SHORT).show();
                }


            }

        });

    }



public void wifi(Boolean interruptor){

    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

    if(interruptor==true)
        wifi.setWifiEnabled(true);
    else
    wifi.setWifiEnabled(false);

}

    public  boolean Bluetooth(boolean enable) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = bluetoothAdapter.isEnabled();
        if (enable && !isEnabled) {
            return bluetoothAdapter.enable();
        }
        else if(!enable && isEnabled) {
            return bluetoothAdapter.disable();
        }
        // No need to change bluetooth state
        return true;
    }







    private void setMobileDataEnabled(Context context, boolean enabled) throws NoSuchMethodException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, InvocationTargetException {
        final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Class conmanClass = null;
        try {
            conmanClass = Class.forName(conman.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
        iConnectivityManagerField.setAccessible(true);
        final Object iConnectivityManager = iConnectivityManagerField.get(conman);
        final Class iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());
        final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
        setMobileDataEnabledMethod.setAccessible(true);

        setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
    }

public void regularVolumenBrillo(int caso){

    if(caso==1){

        Toast.makeText(this, "Reproduccion modo fabricante", Toast.LENGTH_SHORT).show();

        android.provider.Settings.System.putInt(this.getContentResolver(),
                android.provider.Settings.System.SCREEN_BRIGHTNESS, Modo_Fabricante.BRILLO_RECOMENDADO);


        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, Modo_Fabricante.VOLUMEN_RECOMENDADO, AudioManager.STREAM_MUSIC);

    }else if(caso==2){

        Toast.makeText(this, "Reproduccion modo usuario",Toast.LENGTH_SHORT).show();

        android.provider.Settings.System.putInt(this.getContentResolver(),
                android.provider.Settings.System.SCREEN_BRIGHTNESS, Modo_Usuario.BRILLO_RECOMENDADO);

        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, Modo_Usuario.VOLUMEN_RECOMENDADO, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);

    }


}

    public void ConfiguracionPredeterminada(int caso) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        wifi(false);
        Bluetooth(false);
        setMobileDataEnabled(this,false);

        switch (caso) {

            case 1:

                regularVolumenBrillo(caso);

                break;


            case 2:

                regularVolumenBrillo(caso);

                break;

            default:

                break;

        }



    }

    private void startActivity(MainActivity mainActivity, Intent intent) {


        startActivity(intent);

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
