package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */
public class Max {

    private static int horasFabricante = 4;
    private static int minutosFabricante = 0;

    private static int horasUsuario = 5;
    private static int minutosUsuario = 20;

    public static int getHorasFabricante() {
        return horasFabricante;
    }

    public static void setHorasFabricante(int horasFabricante) {
        Max.horasFabricante = horasFabricante;
    }

    public static int getMinutosFabricante() {
        return minutosFabricante;
    }

    public static void setMinutosFabricante(int minutosFabricante) {
        Max.minutosFabricante = minutosFabricante;
    }

    public static int getHorasUsuario() {
        return horasUsuario;
    }

    public static void setHorasUsuario(int horasUsuario) {
        Max.horasUsuario = horasUsuario;
    }

    public static int getMinutosUsuario() {
        return minutosUsuario;
    }

    public static void setMinutosUsuario(int minutosUsuario) {
        Max.minutosUsuario = minutosUsuario;
    }

    public String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

    public String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }
}
