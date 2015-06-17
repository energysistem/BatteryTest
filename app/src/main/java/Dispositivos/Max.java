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


    public String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

    public String devuelveEnFormatoEspecificoUsuario() {

        return horasUsuario + ":" + minutosUsuario;

    }

}
