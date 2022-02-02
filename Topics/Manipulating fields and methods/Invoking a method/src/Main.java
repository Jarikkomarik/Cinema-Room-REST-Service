import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class MethodsDemo {

    public static void main(String[] args) {
        Arrays.stream(SomeClass.class.getDeclaredMethods()).forEach(method -> {
            try {
                System.out.println(method.invoke(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}