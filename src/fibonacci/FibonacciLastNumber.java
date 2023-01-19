package fibonacci;

import java.util.Scanner;

public class FibonacciLastNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Integer indexNum = scanner.nextInt();
            System.out.println(calculateFibonacciNumber(indexNum));
        }
    }

    private static Integer calculateFibonacciNumber(Integer indexNum) {
        if (indexNum <= 1) {
            return indexNum;
        }
        Integer[] buffer = {0, 1};
        for (int i = 2; i <= indexNum; i++) {
            buffer[i % 2] = (buffer[0] + buffer[1]) % 10;
        }
        return buffer[indexNum % 2];
    }
}
