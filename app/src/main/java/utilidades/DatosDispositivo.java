package utilidades;


/**
 * Created by ruben_000 on 31/05/2015.
 */
public class DatosDispositivo {


    private String ANDROID = android.os.Build.VERSION.RELEASE;       //The current development codename, or the string "REL" if this is a release build.
    private String BOARD = android.os.Build.BOARD;                 //The name of the underlying board, like "goldfish".
    private String BOOTLOADER = android.os.Build.BOOTLOADER;            //  The system bootloader version number.
    private String BRAND = android.os.Build.BRAND;                 //The brand (e.g., carrier) the software is customized for, if any.

    private String DEVICE = android.os.Build.DEVICE;                //  The name of the industrial design.
    private String DISPLAY = android.os.Build.DISPLAY;               //A build ID string meant for displaying to the user
    private String FINGERPRINT = android.os.Build.FINGERPRINT;           //A string that uniquely identifies this build.
    private String HARDWARE = android.os.Build.HARDWARE;              //The name of the hardware (from the kernel command line or /proc).
    private String HOST = android.os.Build.HOST;
    private String ID = android.os.Build.ID;                    //Either a changelist number, or a label like "M4-rc20".
    private String MANUFACTURER = android.os.Build.MANUFACTURER;          //The manufacturer of the product/hardware.
    private String MODEL = android.os.Build.MODEL;                 //The end-user-visible name for the end product.
    private String PRODUCT = android.os.Build.PRODUCT;               //The name of the overall product.

    private String TAGS = android.os.Build.TAGS;                  //Comma-separated tags describing the build, like "unsigned,debug".
    private String TYPE = android.os.Build.TYPE;                  //The type of build, like "user" or "eng".
    private String USER = android.os.Build.USER;


    public String getANDROID() {
        return ANDROID;
    }

    public void setANDROID(String ANDROID) {
        this.ANDROID = ANDROID;
    }

    public String getBOARD() {
        return BOARD;
    }

    public void setBOARD(String BOARD) {
        this.BOARD = BOARD;
    }

    public String getBOOTLOADER() {
        return BOOTLOADER;
    }

    public void setBOOTLOADER(String BOOTLOADER) {
        this.BOOTLOADER = BOOTLOADER;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getDEVICE() {
        return DEVICE;
    }

    public void setDEVICE(String DEVICE) {
        this.DEVICE = DEVICE;
    }

    public String getDISPLAY() {
        return DISPLAY;
    }

    public void setDISPLAY(String DISPLAY) {
        this.DISPLAY = DISPLAY;
    }

    public String getFINGERPRINT() {
        return FINGERPRINT;
    }

    public void setFINGERPRINT(String FINGERPRINT) {
        this.FINGERPRINT = FINGERPRINT;
    }

    public String getHARDWARE() {
        return HARDWARE;
    }

    public void setHARDWARE(String HARDWARE) {
        this.HARDWARE = HARDWARE;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public void setMANUFACTURER(String MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getPRODUCT() {
        return PRODUCT;
    }

    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    public String getTAGS() {
        return TAGS;
    }

    public void setTAGS(String TAGS) {
        this.TAGS = TAGS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    @Override
    public String toString() {
        return " Datos Dispositivo :  \n" +

                "\n -ANDROID='" + ANDROID + '\n' +
                "-----------------------------------------------" +
                "\n -BOARD='" + BOARD + '\n' +
                "-----------------------------------------------" +
                "\n -BOOTLOADER='" + BOOTLOADER + '\n' +
                "-----------------------------------------------" +
                "\n -BRAND='" + BRAND + '\n' +
                "-----------------------------------------------" +
                "\n -DEVICE='" + DEVICE + '\n' +
                "-----------------------------------------------" +
                "\n DISPLAY='" + DISPLAY + '\n' +
                "-----------------------------------------------" +
                "\n -FINGERPRINT='" + FINGERPRINT + '\n' +
                "-----------------------------------------------" +
                "\n -HARDWARE='" + HARDWARE + '\n' +
                "-----------------------------------------------" +
                "\n -HOST='" + HOST + '\n' +
                "-----------------------------------------------" +
                "\n -ID='" + ID + '\n' +
                "-----------------------------------------------" +
                "\n -MANUFACTURER='" + MANUFACTURER + '\n' +
                "-----------------------------------------------" +
                "\n -MODEL='" + MODEL + '\n' +
                "-----------------------------------------------" +
                "\n -PRODUCT='" + PRODUCT + '\n' +
                "-----------------------------------------------" +
                "\n -TAGS='" + TAGS + '\n' +
                "-----------------------------------------------" +
                "\n -TYPE='" + TYPE + '\n' +
                "-----------------------------------------------" +
                "\n -USER='" + USER + '\n' +
                "-----------------------------------------------" +
                '.';
    }
}
