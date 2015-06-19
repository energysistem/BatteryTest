package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */
public class Neo {

    private static int horasUsuario = 4;
    private static int minutosUsuario = 40;

    public static int getHorasUsuario() {
        return horasUsuario;
    }

    public static void setHorasUsuario(int horasUsuario) {
        Neo.horasUsuario = horasUsuario;
    }

    public static int getMinutosUsuario() {
        return minutosUsuario;
    }

    public static void setMinutosUsuario(int minutosUsuario) {
        Neo.minutosUsuario = minutosUsuario;
    }
}
