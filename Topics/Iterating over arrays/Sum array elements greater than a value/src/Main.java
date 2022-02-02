import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(new int[sc.nextInt()])    //creating and initializing array
                .map(a -> sc.nextInt())
                .toArray();

        int filterValue = sc.nextInt();                     //getting filter value

        System.out.println(Arrays.stream(arr)               //filtering and summing array and outputting result
                .filter(i -> i > filterValue)
                .sum());

    }
}