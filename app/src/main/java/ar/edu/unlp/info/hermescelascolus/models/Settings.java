package ar.edu.unlp.info.hermescelascolus.models;


public class Settings implements Model {

    private long id;
    private boolean showNetworkErrors;

    public Settings(){
        id = 0;
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


    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean shouldShowNetworkErrors() {
        return showNetworkErrors;
    }

    public void setShowNetworkErrors(boolean showNetworkErrors) {
        this.showNetworkErrors = showNetworkErrors;
    }
}
