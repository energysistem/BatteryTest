package testing.energysistem.com.batterytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import utilidades.Arbol;

//test
public class ListaVideosActivity extends Activity {


    ListView listView ;

    private LocationManager locationManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_videos);




        locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);

        comprobarGps();

        devuelve_rutas();


    }


    public void comprobarGps(){

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            Toast.makeText(this, "GPS esta desabilitado", Toast.LENGTH_SHORT).show();
        else
            showGPSDisabledAlertToUser();

    }


    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS esta activado. Desactivelo porfavor")
                .setCancelable(false)
                .setPositiveButton("ir a menu gps",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }









    public void devuelve_rutas(){



        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);


        String[] ListaRutas = new String[Arbol.Devuelverutas().size()];


        List<String> listaNodo1 = Arbol.Devuelverutas();


        for(int i=0; i<listaNodo1.size(); i++){

            ListaRutas[i]=listaNodo1.get(i);

        }



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ListaRutas);


        // Assign adapter to ListView
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                int itemPosition = position;


                String itemValue = (String) listView.getItemAtPosition(position);


                Intent lanzarRuta = new Intent(getApplicationContext(), VerVideoActivity.class);
                lanzarRuta.putExtra("ruta", itemValue);
                startActivity(lanzarRuta);


                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });







    }





}

