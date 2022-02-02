import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public static String[] getPublicFields(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter( Field -> Modifier.isPublic(Field.getModifiers()))
                .map(Field -> Field.getName())
                .toArray(String[]::new);
    }

}