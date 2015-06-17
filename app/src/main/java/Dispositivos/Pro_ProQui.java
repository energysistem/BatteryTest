package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */

public class Pro_ProQui {

    private static int horasFabricante = 3;
    private static int minutosFabricante = 50;


    private static int horasUsuario = 5;
    private static int minutosUsuario = 34;


    public String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

    public String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }

}
