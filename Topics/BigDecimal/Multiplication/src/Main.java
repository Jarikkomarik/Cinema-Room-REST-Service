import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal first = sc.nextBigDecimal();
        BigDecimal second = sc.nextBigDecimal();

        System.out.println(first.multiply(second));
    }
}