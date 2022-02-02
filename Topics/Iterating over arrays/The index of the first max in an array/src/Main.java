import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(new int[sc.nextInt()])
                .map(a -> a = sc.nextInt())
                .toArray();

        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                System.out.println(i);
                break;
            }
        }

    }
}