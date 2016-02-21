package ar.edu.unlp.info.hermescelascolus.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.edu.unlp.info.hermescelascolus.models.Model;

public class ManyToManyDao<A extends Model, B extends Model> extends GenericDao implements IManyToManyDao<A, B> {
    private String tableName;
    private String firstColumnName;
    private String secondColumnName;
    private String whereClause;
    private Dao<B> secondDao;
    private String selectQuery;

    public ManyToManyDao(Context context, String tableName,
                         String firstColumnName, String secondColumnName, Dao<B> secondDao) {
        super(context);
        this.tableName = tableName;
        this.firstColumnName = firstColumnName;
        this.secondColumnName = secondColumnName;
        this.whereClause = String.format("%s = ? AND %s = ?", firstColumnName, secondColumnName);
        this.secondDao = secondDao;
        this.selectQuery = String.format(
                "SELECT %s FROM %s WHERE %s = ?",
                secondColumnName,
                tableName,
                firstColumnName
        );
    }

    @Override
    public Collection<B> getRelated(A a) {
        List<B> list = new ArrayList<>();
        Cursor cursor = rawQuery(selectQuery);
        while (cursor.moveToNext()) {
            long id = (long) cursor.getInt(0);
            list.add(secondDao.getById(id));
        }
        cursor.close();
        return list;
    }

    @Override
    public void setRelated(A a, Collection<B> bs) {
        //TODO: transaction
        delete(tableName, firstColumnName + " = ?", String.valueOf(a.getId()));
        for (B b: bs){
            add(a, b);
        }
    }

    @Override
    public void add(A a, B b) {
        ContentValues cv = new ContentValues();
        cv.put(firstColumnName, a.getId());
        cv.put(secondColumnName, b.getId());
        db.insert(tableName, null, cv);
    }

    @Override
    public void remove(A a, B b) {
        delete(tableName,
                whereClause,
                String.valueOf(a.getId()),
                String.valueOf(b.getId()));
    }

}
