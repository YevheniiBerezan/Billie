package utils;

import net.serenitybdd.core.Serenity;

import java.util.ArrayList;
import java.util.List;

public final class TestSessionController {

    private static final String CASTING_ERROR_MESSAGE = "Could not cast value stored in session with key [%s] to %s";

    @SuppressWarnings("unchecked")
    public static void storeObjectInSession(final String key, final Object obj) {
        Serenity.getCurrentSession().put(key, obj);
    }

    public static <T> T getObjectFromSession(final String key, final Class<T> returnType) {
        final Object obj = Serenity.getCurrentSession().get(key);
        T result = null;
        try {
            result = returnType.cast(obj);
        } catch (final ClassCastException e) {
            warnMessage(key, returnType, e);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getListOfObjectsFromSession(final String key, final Class<T> returnType) {
        final Object obj = Serenity.getCurrentSession().get(key);
        List<T> result = new ArrayList<T>();
        try {
            result = (List<T>) obj;
        } catch (final ClassCastException e) {
            warnMessage(key, returnType, e);
        }
        return result;
    }

    private static void warnMessage(final String key, final Class<?> returnType, final ClassCastException e) {
        String.format(CASTING_ERROR_MESSAGE, key, returnType.getName());
    }
}