package testing.energysistem.com.batterytest;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import utilidades.Modo_Fabricante;
import utilidades.Modo_Usuario;


public class CartaAdapdater extends RecyclerView.Adapter<CartaAdapdater.CartaViewHolder> {
    public Context mainContext;
    AudioManager mAudioManager;
    private List<Ficha> items;

    public CartaAdapdater(List<Ficha> items, Context contexto) {
        this.items = items;
        this.mainContext = contexto;

        mAudioManager = (AudioManager) mainContext.getSystemService(contexto.AUDIO_SERVICE);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CartaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card, viewGroup, false);
        return new CartaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CartaViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.visitas.setText("Visitas:" + String.valueOf(items.get(i).getVisitas()));
    }

    public void wifi(Boolean interruptor) {

        WifiManager wifi = (WifiManager) mainContext.getSystemService(Context.WIFI_SERVICE);

        if (interruptor == true)
            wifi.setWifiEnabled(true);
        else
            wifi.setWifiEnabled(false);

    }

    public boolean Bluetooth(boolean enable) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = bluetoothAdapter.isEnabled();
        if (enable && !isEnabled) {
            return bluetoothAdapter.enable();
        } else if (!enable && isEnabled) {
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

    public void regularVolumenBrillo(int caso) {

        if (caso == 1) {

            Toast.makeText(mainContext, "Reproduccion modo fabricante", Toast.LENGTH_SHORT).show();

            android.provider.Settings.System.putInt(mainContext.getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS, Modo_Fabricante.BRILLO_RECOMENDADO);


            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, Modo_Fabricante.VOLUMEN_RECOMENDADO, AudioManager.STREAM_MUSIC);

        } else if (caso == 2) {

            Toast.makeText(mainContext, "Reproduccion modo usuario", Toast.LENGTH_SHORT).show();

            android.provider.Settings.System.putInt(mainContext.getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS, Modo_Usuario.BRILLO_RECOMENDADO);

            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, Modo_Usuario.VOLUMEN_RECOMENDADO, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);

        }


    }

    public void ConfiguracionPredeterminada(int caso) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        DisplayMetrics dm = new DisplayMetrics();
        //(WindowManager) mainContext.
        // getWindowManager().getDefaultDisplay().getMetrics(dm);
        mainContext.getResources().getDisplayMetrics();


        wifi(false);
        Bluetooth(false);
        setMobileDataEnabled(mainContext, false);

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

    public class CartaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;


        public CartaViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
        }


        @Override
        public void onClick(View v) {
            Log.d("TAG", "onClick " + getPosition() + " ");


            Resources res = Resources.getSystem();
            switch (getPosition()) {


                case 0:

                    // Toast.makeText(mainContext, res.getString(R.string.main_radio_modo_fabricante), Toast.LENGTH_SHORT).show();


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

                    v.getContext().startActivity(new Intent(mainContext, ListaVideosActivity.class));
                    break;

                case 1:


                    //      Toast.makeText(mainContext, res.getString(R.string.main_radio_modo_usuario), Toast.LENGTH_SHORT).show();

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


                    v.getContext().startActivity(new Intent(mainContext, ListaVideosActivity.class));
                    break;


                case 2:

                    v.getContext().startActivity(new Intent(mainContext, RegistroActivity.class));


                    break;

                case 3:

                    v.getContext().startActivity(new Intent(mainContext, CaracteristicasActivity.class));

                    break;


                case 4:

                    v.getContext().startActivity(new Intent(mainContext, DatosDispositivoActivity.class));
                    break;
            }


        }
    }

}
