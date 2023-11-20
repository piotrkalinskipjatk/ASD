public class Main {
    public static void main(String[] args) {
        long n = 40;
        long startTimeWithoutRecursion = System.currentTimeMillis();
        long resultWithoutRecursion = FibonacciWithoutRecursion.calculate(n);
        long endTimeWithoutRecursion = System.currentTimeMillis();
        long durationWithoutRecursion = endTimeWithoutRecursion - startTimeWithoutRecursion;

        System.out.println("Wynik bez rekurencji: " + resultWithoutRecursion);
        System.out.println("Czas wykonania bez rekurencji: " + durationWithoutRecursion + " ms");

        long startTimeWithRecursion = System.currentTimeMillis();
        long resultWithRecursion = FibonacciWithRecursion.calculate(n);
        long endTimeWithRecursion = System.currentTimeMillis();
        long durationWithRecursion = endTimeWithRecursion - startTimeWithRecursion;

        System.out.println("Wynik z rekurencją: " + resultWithRecursion);
        System.out.println("Czas wykonania z rekurencją: " + durationWithRecursion + " ms");
    }
}

class FibonacciWithoutRecursion {
    public static long calculate(long n) {
        if (n == 1 || n == 0) {
            return n;
        }

        long previousFibunacci2 = 0;
        long previousFibunacci1 = 1;
        long currentFibunacci = 0;

        for (long i = 2; i <= n; i++) {
            currentFibunacci = previousFibunacci1 + previousFibunacci2;
            previousFibunacci2 = previousFibunacci1;
            previousFibunacci1 = currentFibunacci;
        }

        return currentFibunacci;
    }
}

class FibonacciWithRecursion {
    public static long calculate(long n) {
        if (n == 1 || n == 0) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }
}
