package utilidades;

import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

/**
 * Created by ruben on 30/05/15.
 */
public class ManagerBattery {

   private int bLevel;
    private int  icon_small;
    private boolean  presentBattery;
    private int  status;
    private String technology;
    private String temperature_S;
    private float  voltage;
    private int  levelBatery;
    private int  scale;
    private int  plugged;
    private int  health;
    private  boolean present;





    public ManagerBattery(Intent intent) {

         bLevel = intent.getIntExtra("level", 0); // gets the battery level
         Log.i("Levell", "" + bLevel);

         icon_small= intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,0);

         presentBattery= intent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);

        status= intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
         technology= intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
        float  temperature= ((float) intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0)) / 10;
         temperature_S= String.valueOf(temperature) + "*C";


        // voltage is reported in millivolts
          voltage= intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0)/1000;


          levelBatery= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
          scale= intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
          plugged= intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
          health= intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);



    }

    public int getbLevel() {
        return bLevel;
    }

    public void setbLevel(int bLevel) {
        this.bLevel = bLevel;
    }

    public int getIcon_small() {
        return icon_small;
    }

    public void setIcon_small(int icon_small) {
        this.icon_small = icon_small;
    }

    public boolean isPresentBattery() {
        return presentBattery;
    }

    public void setPresentBattery(boolean presentBattery) {
        this.presentBattery = presentBattery;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getTemperature_S() {
        return temperature_S;
    }

    public void setTemperature_S(String temperature_S) {
        this.temperature_S = temperature_S;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public int getLevelBatery() {
        return levelBatery;
    }

    public void setLevelBatery(int levelBatery) {
        this.levelBatery = levelBatery;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getPlugged() {
        return plugged;
    }

    public void setPlugged(int plugged) {
        this.plugged = plugged;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
