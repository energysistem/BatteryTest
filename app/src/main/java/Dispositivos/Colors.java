package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */
public class Colors {


    private static int horasUsuario = 5;
    private static int minutosUsuario = 20;

    public static int getHorasUsuario() {
        return horasUsuario;
    }

    public static void setHorasUsuario(int horasUsuario) {
        Colors.horasUsuario = horasUsuario;
    }

    public static int getMinutosUsuario() {
        return minutosUsuario;
    }

    public static void setMinutosUsuario(int minutosUsuario) {
        Colors.minutosUsuario = minutosUsuario;
    }

    public String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }
}
