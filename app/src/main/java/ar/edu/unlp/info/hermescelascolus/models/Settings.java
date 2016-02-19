package ar.edu.unlp.info.hermescelascolus.models;


public class Settings {

    private static final Settings instance = new Settings();
    static {
        instance.setMonitorIp("192.168.0.1");
        instance.setMonitorPort("8000");
    }
    public static Settings getInstance(){
        return instance;
    }

    private Settings(){

    }

    private String monitorIp;
    private String monitorPort;

    public String getMonitorPort() {
        return monitorPort;
    }

    public void setMonitorPort(String monitorPort) {
        this.monitorPort = monitorPort;
    }

    public String getMonitorIp() {
        return monitorIp;
    }

    public void setMonitorIp(String monitorIp) {
        this.monitorIp = monitorIp;
    }


}
