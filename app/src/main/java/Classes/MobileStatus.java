package Classes;

import java.io.Serializable;

public class MobileStatus implements Serializable {

    String networkavaiable;
    String batterylevel;
    String simavailable;
    String gpsavailable;

    public String getSimid() {
        return simid;
    }

    public void setSimid(String simid) {
        this.simid = simid;
    }

    String simid;

    public String getNetworkavaiable() {
        return networkavaiable;
    }

    public void setNetworkavaiable(String networkavaiable) {
        this.networkavaiable = networkavaiable;
    }

    public String getBatterylevel() {
        return batterylevel;
    }

    public void setBatterylevel(String batterylevel) {
        this.batterylevel = batterylevel;
    }

    public String getSimavailable() {
        return simavailable;
    }

    public void setSimavailable(String simavailable) {
        this.simavailable = simavailable;
    }

    public String getGpsavailable() {
        return gpsavailable;
    }

    public void setGpsavailable(String gpsavailable) {
        this.gpsavailable = gpsavailable;
    }
}
