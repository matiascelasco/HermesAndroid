package ar.edu.unlp.info.hermescelascolus.models.helpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by laura on 23/02/16.
 */
public class DateSerializer implements JsonSerializer<Date> {
    private String format = "dd/MM/yyyy HH:mm:ss";

    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        Date bodyPartDate = date;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = format.format(bodyPartDate);
        return date == null ? null : new JsonPrimitive(formattedDate);
    }
}
