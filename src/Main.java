import java.util.Scanner;

//https://github.com/alfordz0405/-IdeaProjects.git

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers to be sorted: ");
        int input_size = scanner.nextInt();

        int[] input = new int[input_size];

        // Take input from the user here using a loop
        for (int i = 0; i < input.length; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            input[i] = scanner.nextInt();
        }

        int low = 0;
        int high = input.length - 1;

        MergeSort(input, low, high);

        System.out.println("Sorted array:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        scanner.close();
    }

    public static void MergeSort(int[] A, int low, int high) {
        if (low < high) {

            int mid = low + (high - low) / 2;

            MergeSort(A, low, mid);
            MergeSort(A, mid + 1, high);
            Merge(A, low, mid, high);
        }
    }

    public static void Merge(int[] A, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;


        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }
            k++;
        }


        while (i <= mid) {
            temp[k] = A[i];
            i++;
            k++;
        }


        while (j <= high) {
            temp[k] = A[j];
            j++;
            k++;
        }


        for (i = 0; i < temp.length; i++) {
            A[low + i] = temp[i];
        }
    }
}
