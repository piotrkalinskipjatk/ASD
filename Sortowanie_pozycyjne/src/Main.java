public class Main {
    public static void main(String[] args) {
        int[] A = {5432, 7654, 9321, 567};
        ArraySort.positionSort(A);
        ArraySort.arrayPrint(A);
    }
}

class ArraySort {

    public static void positionSort(int[] arr) {
        int max = findLongestElement(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp, max);
        }
    }

    private static int findLongestElement(int[] arr) {
        int longestElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > longestElement) {
                longestElement = arr[i];
            }
        }
        return longestElement;
    }

    private static void countingSort(int[] A, int exp, int max) {
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[max + 1];

        for (int i = 0; i < n; i++) {
            int value = (A[i] / exp) % 10;
            C[value]++;
        }

        for (int i = 1; i <= max; i++) {
            C[i] += C[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int value = (A[i] / exp) % 10;
            B[C[value] - 1] = A[i];
            C[value]--;
        }

        for (int i = 0; i < A.length; i++){
            A[i] = B[i];
        }
    }

    public static void arrayPrint(int[] A) {
        for(int i : A){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
