import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean result = false;

        for (int i = 0; i < arr.length-1; i++) {
            if ((arr[i] == n && arr[i+1] == m) || (arr[i] == m && arr[i+1] == n)) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}