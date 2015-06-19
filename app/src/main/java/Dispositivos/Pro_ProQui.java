package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */

public class Pro_ProQui {


    private static int horasFabricante = 5;
    private static int minutosFabricante = 34;

    private static int horasUsuario = 3;
    private static int minutosUsuario = 50;

    public static int getHorasFabricante() {
        return horasFabricante;
    }

    public static void setHorasFabricante(int horasFabricante) {
        Pro_ProQui.horasFabricante = horasFabricante;
    }

    public static int getMinutosFabricante() {
        return minutosFabricante;
    }

    public static void setMinutosFabricante(int minutosFabricante) {
        Pro_ProQui.minutosFabricante = minutosFabricante;
    }

    public static int getHorasUsuario() {
        return horasUsuario;
    }

    public static void setHorasUsuario(int horasUsuario) {
        Pro_ProQui.horasUsuario = horasUsuario;
    }

    public static int getMinutosUsuario() {
        return minutosUsuario;
    }

    public static void setMinutosUsuario(int minutosUsuario) {
        Pro_ProQui.minutosUsuario = minutosUsuario;
    }

    public String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

    public String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }
}
