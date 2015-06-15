package testing.energysistem.com.batterytest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import database.DataBaseManagerActualizaciones;
import utilidades.Fechas;
import utilidades.ManagerBattery;


public class VerVideoActivity extends Activity implements MediaController.MediaPlayerControl {

    private VideoView mVideoView;

    /**
     * Intent
     */

    private String ruta;


    /**
     * registro bateria
     * @param savedInstanceState
     */
    private ManagerBattery objectManagerBattery;
    private DataBaseManagerActualizaciones managerActualizacion;
    int count_event =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_video);
        mVideoView =(VideoView)findViewById(R.id.surface_view);

        Intent intent = getIntent();

        if(intent.getExtras()!=null){

            ruta = intent.getStringExtra("ruta");
        }


        insertarRuta_ReproduccionBucle();

    }


public void insertarRuta_ReproduccionBucle(){

    managerActualizacion = new DataBaseManagerActualizaciones(this);


    mVideoView.setVideoPath(ruta);
    mVideoView.setMediaController(new MediaController(this));
    mVideoView.start();
    mVideoView.requestFocus();


    mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.setLooping(true);
        }
    });


}



    @Override
    protected void onResume() {
        super.onResume();

        this.registerReceiver(this.myBatteryReceiverVideo,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        Log.d("registerVideo", "register battery status receiver.");


    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(myBatteryReceiverVideo);
        Log.d("unregisterVideo", "Unregister battery status receiver.");
        super.onDestroy();


    }

    private BroadcastReceiver myBatteryReceiverVideo = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {


            objectManagerBattery = new ManagerBattery(intent);

            llenar_database();
        }
    };



public void llenar_database(){



/**
 * si esta activado el interruptor -->registramos el evento en la base de datos
 */
            if(count_event %3==0)
                managerActualizacion.insertar_3parametros(null, "" + objectManagerBattery.getLevelBatery(), Fechas.getDateTime());


                count_event++;

            if(count_event >12)
                count_event =0;

}

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int pos=mVideoView.getCurrentPosition();
        outState.putInt("posicion_video", pos);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);

        mVideoView.seekTo(savedState.getInt("posicion_video"));
    }



    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
