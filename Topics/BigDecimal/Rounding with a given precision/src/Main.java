import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        BigDecimal number = scanner.nextBigDecimal();
        int newScale = scanner.nextInt();
        number = number.setScale(newScale, RoundingMode.HALF_DOWN);

        System.out.println(number);
    }   
}