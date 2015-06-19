package testing.energysistem.com.batterytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

import Dispositivos.Colors;
import Dispositivos.Max;
import Dispositivos.Neo;
import Dispositivos.ProHD;
import Dispositivos.Pro_ProQui;
import database.DataBaseManagerActualizaciones;
import utilidades.DatosDispositivo;
import utilidades.Fechas;


public class ValoracionActivity extends Activity {


    DataBaseManagerActualizaciones objManagerActualizacion;
    String Dateduracion;
    TextView tvDuracion, tvResultadoModoFabricante, tvResultadoModoUsuario, tvDevice;

    private DatosDispositivo datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion);

        objManagerActualizacion = new DataBaseManagerActualizaciones(this);

        tvDuracion = (TextView) findViewById(R.id.valoracion_duracion);
        tvResultadoModoFabricante = (TextView) findViewById(R.id.valoracion_ResultadoModoFabricante);
        tvResultadoModoUsuario = (TextView) findViewById(R.id.valoracion_ResultadoModoUsuario);
        tvDevice = (TextView) findViewById(R.id.valoracion_tv_nameDevice);

        datos = new DatosDispositivo();


        if (objManagerActualizacion.algunRegistro()) {


            try {

                Dateduracion = Fechas.diferenciaTiempo(objManagerActualizacion.selectPrimeraActualizacion(), objManagerActualizacion.selectUltimaActualizacion(), "valoracion");

            } catch (ParseException e) {
                e.printStackTrace();
            }


            String delimitadores = ":";
            String[] arrayDateDuracion = Dateduracion.split(delimitadores);

            int horas = Integer.parseInt(arrayDateDuracion[0]);
            int min = Integer.parseInt(arrayDateDuracion[1]);

            Log.d("time_array", "hour :" + horas + " min: " + min);

            try {

                Relaciona(horas, min);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Elije el Modo Usuario o Modo Fabricante para poder valorar el dispositivo", Toast.LENGTH_LONG).show();

        }



    }


    public void Relaciona(int horas_duracion, int min_duracion) throws ParseException {

        String resultadoFabricante;


        String resultadoUsuario;


        tvDevice.setText("[" + datos.getDEVICE() + "]");


        switch (datos.getDEVICE()) {

            case "Energy_Phone_Pro_HD":



                resultadoFabricante = Fechas.diferenciaMin_Valoracion(ProHD.getHorasFabricante(), ProHD.getMinutosFabricante(), horas_duracion, min_duracion);
                resultadoUsuario = Fechas.diferenciaMin_Valoracion(ProHD.getHorasUsuario(), ProHD.getMinutosUsuario(), horas_duracion, min_duracion);

                tvDuracion.append(" " + Dateduracion);
                tvResultadoModoFabricante.setText(resultadoFabricante);
                tvResultadoModoUsuario.setText(resultadoUsuario);
                break;


            case "Energy_Phone_Max":


                resultadoFabricante = Fechas.diferenciaMin_Valoracion(Max.getHorasFabricante(), Max.getMinutosFabricante(), horas_duracion, min_duracion);
                resultadoUsuario = Fechas.diferenciaMin_Valoracion(Max.getHorasUsuario(), Max.getMinutosUsuario(), horas_duracion, min_duracion);

                tvDuracion.append(" " + Dateduracion);
                tvResultadoModoFabricante.setText(resultadoFabricante);
                tvResultadoModoUsuario.setText(resultadoUsuario);
                break;


            case "Energy_Phone_Pro":

                resultadoFabricante = Fechas.diferenciaMin_Valoracion(Pro_ProQui.getHorasFabricante(), Pro_ProQui.getMinutosFabricante(), horas_duracion, min_duracion);
                resultadoUsuario = Fechas.diferenciaMin_Valoracion(Pro_ProQui.getHorasUsuario(), Pro_ProQui.getMinutosUsuario(), horas_duracion, min_duracion);

                tvDuracion.append(" " + Dateduracion);
                tvResultadoModoFabricante.setText(resultadoFabricante);
                tvResultadoModoUsuario.setText(resultadoUsuario);
                break;


            case "Energy Phone Colors":


                resultadoFabricante = "-No hay datos de referencia del fabricante";
                resultadoUsuario = Fechas.diferenciaMin_Valoracion(Colors.getHorasUsuario(), Colors.getMinutosUsuario(), horas_duracion, min_duracion);

                tvDuracion.append(" " + Dateduracion);
                tvResultadoModoFabricante.setText(resultadoFabricante);
                tvResultadoModoUsuario.setText(resultadoUsuario);
                break;


            case "Energy Phone Neo":


                resultadoFabricante = "-No hay datos de referencia del fabricante";
                resultadoUsuario = Fechas.diferenciaMin_Valoracion(Neo.getHorasUsuario(), Neo.getMinutosUsuario(), horas_duracion, min_duracion);

                tvDuracion.append(" " + Dateduracion);
                tvResultadoModoFabricante.setText(resultadoFabricante);
                tvResultadoModoUsuario.setText(resultadoUsuario);
                break;


          
            default:
                Toast.makeText(getApplicationContext(), "No reconozco a este dispositivo", Toast.LENGTH_LONG).show();
                break;

        }


    }

}
