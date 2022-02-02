import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            int product = a[i] * a[i + 1];
            if (product > max) {
                max = product;
            }
        }
        System.out.println(max);
    }
}