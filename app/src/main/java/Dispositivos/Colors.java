package Dispositivos;

/**
 * Created by RMS on 17/06/2015.
 */


/**
 * Vol minimo, brillo maximo, modo avion
 */
public class Colors {


    private static int horasFabricante = 4;
    private static int minutosFabricante = 5;


    public String devuelveEnFormatoEspecificoFabricante() {

        return horasFabricante + ":" + minutosFabricante;

    }

}
