import java.lang.reflect.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotations().length > 0)
                .map(field -> field.getName())
                .toArray(String[]::new);

    }

}