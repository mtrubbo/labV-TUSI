package frgp.utn.edu.ar.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

public class JsonUtils {
    public static String convertToJson(List<?> object) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object);
    }
}
