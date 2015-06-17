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


    public String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

    public String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }

}
