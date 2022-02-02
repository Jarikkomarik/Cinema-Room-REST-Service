import java.util.Arrays;

class AnnotationUtils {

    public static void printClassAnnotations(Class classObject) {
        Arrays.stream(classObject.getDeclaredAnnotations())
                .forEach(annotation -> System.out.println(annotation.annotationType().getSimpleName()));
    }
}
