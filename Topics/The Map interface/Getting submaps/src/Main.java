import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int from = sc.nextInt();
        int to = sc.nextInt();
        int items = sc.nextInt();

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < items; i++) {
            map.put(sc.nextInt(), sc.nextLine());
        }

        IntStream
                .rangeClosed(from, to)
                .forEach(i -> System.out.println(i + map.get(i)));

    }
}