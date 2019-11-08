package utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;

public class JsonUtils {
    public static String createJson(final Object dto) {
        final Gson gson = new GsonBuilder().create();
        return gson.toJson(dto);
    }
}