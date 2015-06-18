package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */
public class ProHD {

    private static int horasFabricante = 4;
    private static int minutosFabricante = 50;


    private static int horasUsuario = 6;
    private static int minutosUsuario = 5;


    public static String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

    public static String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }


    public static int getHorasFabricante() {
        return horasFabricante;
    }

    public static void setHorasFabricante(int horasFabricante) {
        ProHD.horasFabricante = horasFabricante;
    }

    public static int getMinutosFabricante() {
        return minutosFabricante;
    }

    public static void setMinutosFabricante(int minutosFabricante) {
        ProHD.minutosFabricante = minutosFabricante;
    }

    public static int getHorasUsuario() {
        return horasUsuario;
    }

    public static void setHorasUsuario(int horasUsuario) {
        ProHD.horasUsuario = horasUsuario;
    }

    public static int getMinutosUsuario() {
        return minutosUsuario;
    }

    public static void setMinutosUsuario(int minutosUsuario) {
        ProHD.minutosUsuario = minutosUsuario;
    }
}
