import java.util.*;

public class Main {
    Scanner sc;

    int[] box1;
    int[] box2;

    Main(Scanner sc) {
        box1 = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        box2 = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
    }

    public String compareBoxes() {
        box1 = Arrays.stream(box1).sorted().toArray();
        box2 = Arrays.stream(box2).sorted().toArray();

        if (isSmaller(box1, box2)) {
            return "Box 1 < Box 2";
        } else if (isSmaller(box2, box1)) {
            return "Box 1 > Box 2";
        } else {
            return "Incompatible";
        }
    }

    private boolean isSmaller (int[] box1, int[] box2) {
        if (box1[0] < box2[0]
            && box1[1] < box2[1]
            && box1[2] < box2[2]) {
            return true;
        }

        else {
            return false;
            }

    }

    public static void main(String[] args) {
        Main m1 = new Main(new Scanner(System.in));

        System.out.println(m1.compareBoxes());
    }
}
