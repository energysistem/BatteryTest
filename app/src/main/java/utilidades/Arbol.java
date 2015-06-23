package utilidades;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruben on 30/05/15.
 */
public class Arbol {


    public static List<String> Devuelverutas(){

        // Array TEXTO donde guardaremos los nombres de los ficheros
        List<String> item = new ArrayList<String>();

        //Defino la ruta donde busco los ficheros
        File f = new File(Environment.getExternalStorageDirectory() + "/Movies/");
        //Creo el array de tipo File con el contenido de la carpeta
        File[] files = f.listFiles();


        try {
            //Hacemos un Loop por cada fichero para extraer el nombre de cada uno
            for (int i = 0; i < files.length; i++)

            {
                //Sacamos del array files un fichero
                File file = files[i];

                //Si es directorio...
                if (file.isDirectory()) {


                    //    String cadenaRuta= Environment.getExternalStorageDirectory() + "/Movies/" + file.getName() + "((ESTE ES UN DIRECTORIO ERROR))";


                    String cadenaRuta = Environment.getExternalStoragePublicDirectory("MOVIES") + file.getName() + "((ESTE ES UN DIRECTORIO ERROR))";


                    item.add(cadenaRuta);

                    //Si es fichero...
                } else
                    item.add(Environment.getExternalStorageDirectory() + "/Movies/" + file.getName());

            }


        } catch (Exception e) {

            e.printStackTrace();
        }


        return item;
    }

}
