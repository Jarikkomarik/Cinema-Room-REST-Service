import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[]arr=new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int searchedValue = sc.nextInt();
        boolean b = false;
        for (int i:arr){
            if (i == searchedValue) {
                b = true;
            }
        }
        System.out.println(b);
    }
}