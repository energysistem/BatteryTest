package utilidades;

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


    public static String diferenciaTiempo(String dateInicial, String dateFinal) throws ParseException {


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


    public static String diferenciaHorasMin_Valoracion(String dateRef, String dateDuration) throws ParseException {


        String salida = "Sin Datos";


        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date dI = null;

        dI = format.parse(dateRef);

        Date dF = format.parse(dateDuration);


        Date diff = new Date(dF.getTime() - dI.getTime());

        //  Calendar calendar = Calendar.getInstance();
        calendar.setTime(diff);


        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);


        if (hours > 0 || minutes > 10) {

            salida = "(2) Mal";

        } else if (hours == 0 && minutes > 0 && minutes < 10) {

            salida = "(5) Regular";

        } else if (hours <= 0 && minutes <= 0) {

            salida = "(10) Bien";
        }

        return salida;
    }


}
