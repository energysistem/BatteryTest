package utilidades;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by RMS on 11/06/2015.
 */
public class Fechas {


    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static String diferenciaTiempo(String dateInicial, String dateFinal, String Formato) throws ParseException {

        String SalidaEnFormato = null;


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


        if (Formato.equals("registro")) {

            SalidaEnFormato = hours + " h " + minutes + " min " + seconds + " s ";

        } else if (Formato.equals("valoracion")) {

            SalidaEnFormato = hours + ":" + minutes;
        }


        return SalidaEnFormato;

    }


    public static String diferenciaMin_Valoracion(int HourRef, int minRef, int HourDuration, int minDuration) {


        String salida = "sin Salida";


        /**
         * pasamos el tiempo a la misma unidad (minutos)
         */
        int sumTotalRef = (HourRef * 60) + minRef;
        int sumTotalDuration = (HourDuration * 60) + minDuration;


        int diferenciaMinTotal = sumTotalRef - sumTotalDuration;


        Log.d("total_referencia", "(SUM REFERENCIA):" + sumTotalRef);
        Log.d("total_duracion", "(SUM DURACION):" + sumTotalDuration);
        Log.d("total_diff", "(((DIFERENCIA))):" + diferenciaMinTotal);

        /**
         * El tiempo de duracion positivo , es porque el tiempo de duracion es inferior o igual al tiempo estimado. (Mejora)
         */

        if (diferenciaMinTotal > 0)
            salida = "(10) Muy Bien Ha superado el tiempo estimado";
        else if (diferenciaMinTotal == 0)
            salida = "(7) Bien Ha llegado al tiempo estimado";
            //tiempo duracion negativo, porque el tiempo de duracion es superior al tiempo estimado (deficit)
        else if (diferenciaMinTotal < 0 && diferenciaMinTotal >= -10) //diferencia hasta 10 min
            salida = "(5) Regular , no ha llegado al tiempo estimado";
        else if (diferenciaMinTotal < -10 && diferenciaMinTotal > -30) // diferencia superior a 10 min
            salida = "(2) Mal, no ha llegado al tiempo por mas de 10 min";
        else if (diferenciaMinTotal < -30) // diferencia superior a 10 min
            salida = "(0) Muy Mal, no ha llegado al tiempo por mas de 30 min";


        return salida;


    }

}
