package utilidades;


/**
 * Created by ruben_000 on 31/05/2015.
 */
public class DatosDispositivo {


    String ANDROID         =   android.os.Build.VERSION.RELEASE;       //The current development codename, or the string "REL" if this is a release build.
    String BOARD           =   android.os.Build.BOARD;                 //The name of the underlying board, like "goldfish".
    String BOOTLOADER      =   android.os.Build.BOOTLOADER;            //  The system bootloader version number.
    String BRAND           =   android.os.Build.BRAND;                 //The brand (e.g., carrier) the software is customized for, if any.

    String DEVICE          =   android.os.Build.DEVICE;                //  The name of the industrial design.
    String DISPLAY         =   android.os.Build.DISPLAY;               //A build ID string meant for displaying to the user
    String FINGERPRINT     =   android.os.Build.FINGERPRINT;           //A string that uniquely identifies this build.
    String HARDWARE        =   android.os.Build.HARDWARE;              //The name of the hardware (from the kernel command line or /proc).
    String HOST            =   android.os.Build.HOST;
    String ID              =   android.os.Build.ID;                    //Either a changelist number, or a label like "M4-rc20".
    String MANUFACTURER    =   android.os.Build.MANUFACTURER;          //The manufacturer of the product/hardware.
    String MODEL           =   android.os.Build.MODEL;                 //The end-user-visible name for the end product.
    String PRODUCT         =   android.os.Build.PRODUCT;               //The name of the overall product.

    String TAGS            =   android.os.Build.TAGS;                  //Comma-separated tags describing the build, like "unsigned,debug".
    String TYPE            =   android.os.Build.TYPE;                  //The type of build, like "user" or "eng".
    String USER            =   android.os.Build.USER;



    @Override
    public String toString() {
        return "DatosDispositivo{  \n" +

                "\n -ANDROID='" + ANDROID + '\'' +
                "\n -BOARD='" + BOARD + '\'' +
                "\n -BOOTLOADER='" + BOOTLOADER + '\'' +
                "\n -BRAND='" + BRAND + '\'' +
                "\n -DEVICE='" + DEVICE + '\'' +
                "\n\n -DISPLAY='" + DISPLAY + '\'' +
                "\n\n -FINGERPRINT='" + FINGERPRINT + '\'' +
                "\n\n -HARDWARE='" + HARDWARE + '\'' +
                "\n -HOST='" + HOST + '\'' +
                "\n -ID='" + ID + '\'' +
                "\n -MANUFACTURER='" + MANUFACTURER + '\'' +
                "\n -MODEL='" + MODEL + '\'' +
                "\n -PRODUCT='" + PRODUCT + '\'' +
                "\n -TAGS='" + TAGS + '\'' +
                "\n -TYPE='" + TYPE + '\'' +
                "\n -USER='" + USER + '\'' +
                '}';
    }
}
