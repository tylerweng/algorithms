class QuickSort {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5, -4, 123};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        System.out.println("array prior to");
        printArray(arr);
        ob.sort(arr, 0, n - 1);

        System.out.println("array post sort");
        printArray(arr);
    }
}

class Main {
    public static void main(String[] args) {
        QuickSort.main(null);
    }
}