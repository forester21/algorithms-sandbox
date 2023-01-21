package euclid;

import java.util.Scanner;

public class Euclid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Integer first = scanner.nextInt();
            Integer second = scanner.nextInt();
            System.out.println(calculateGCD(first, second));
            System.out.println(second);
        }
    }

    private static Integer calculateGCD(Integer first, Integer second) {
        while (first != 0 && second != 0) {
            if (first > second) {
                first = first % second;
            } else {
                second = second % first;
            }
        }
        if (first == 0) {
            return second;
        } else {
            return first;
        }
    }
}
