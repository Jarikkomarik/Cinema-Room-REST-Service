import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class ReflectionUtils {

    public static int countPublicMethods(Class targetClass) {
        AtomicInteger counterOfPublicModifiers = new AtomicInteger();
        Arrays.stream(targetClass.getDeclaredMethods())
                .forEach(Method -> {
                    if (Modifier.isPublic(Method.getModifiers())) {
                        counterOfPublicModifiers.getAndIncrement();
                    }
                });


        return counterOfPublicModifiers.get();
    }
}