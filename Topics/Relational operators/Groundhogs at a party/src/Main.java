import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int receesCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        System.out.println(isWeekend == true && receesCups < 26 && receesCups > 14 ?
                "true" : isWeekend == false && receesCups < 21 && receesCups > 9 ?
                "true" : "false");
    }
}