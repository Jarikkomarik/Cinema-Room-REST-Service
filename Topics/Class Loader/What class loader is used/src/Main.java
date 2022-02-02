import java.util.Scanner;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner("dsfd sdf");
        ClassLoader classLoader = sc.getClass().getClassLoader();
        System.out.println(classLoader.getName());
    }
}
class A {

}