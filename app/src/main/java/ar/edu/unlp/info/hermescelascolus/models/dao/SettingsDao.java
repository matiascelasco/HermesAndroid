package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Settings;

public class SettingsDao extends GenericDao implements Dao<Settings>{

    public SettingsDao(Context context) {
        super(context);
    }

    private Settings loadFromCursor(Cursor cursor){
        Settings s = new Settings();
        s.setId(cursor.getInt(0));
        s.setMonitorIp(cursor.getString(1));
        s.setMonitorPort(cursor.getString(2));
        s.setShowNetworkErrors(cursor.getInt(3) == 1);
        return s;
    }

    @Override
    public List<Settings> all() {
        List<Settings> settingsList = new ArrayList<>();
        Cursor cursor = rawQuery(
                "SELECT _id, ip_address, port, show_network_errors FROM Settings"
        );
        while (cursor.moveToNext()) {
            settingsList.add(this.loadFromCursor(cursor));
        }
        cursor.close();
        return settingsList;
    }

    @Override
    public Settings getById(long id) {
        throw new RuntimeException("Settings can't be get by id");
    }

    @Override
    public void save(Settings settings) {
        ContentValues cv = new ContentValues();
        cv.put("ip_address", settings.getMonitorIp());
        cv.put("port", settings.getMonitorPort());
        cv.put("show_network_errors", settings.shouldShowNetworkErrors() ? 1 : 0);

        update("Settings", cv, "_id = ?", String.valueOf(settings.getId()));
    }

    @Override
    public void delete(Settings settings) {
        throw new RuntimeException("Settings can't be deleted");
    }
}
