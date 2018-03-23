// Java program to count occurrences
// of an element

class Main
{
    /* if x is present in arr[] then returns
       the count of occurrences of x,
       otherwise returns -1. */
    static int count(int arr[], int x, int n)
    {
        // index of first occurrence of x in arr[0..n-1]
        int i;

        // index of last occurrence of x in arr[0..n-1]
        int j;

        /* get the index of first occurrence of x */
        i = first(arr, 0, n-1, x, n);

        /* If x doesn't exist in arr[] then return -1 */
        if(i == -1)
            return i;

      /* Else get the index of last occurrence of x.
         Note that we are only looking in the
         subarray after first occurrence */
        j = last(arr, i, n-1, x, n);

        /* return count */
        return j-i+1;
    }

    /* if x is present in arr[] then returns the
       index of FIRST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
    static int first(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid -1), x, n);
        }
        return -1;
    }

    /* if x is present in arr[] then returns the
       index of LAST occurrence of x in arr[0..n-1],
       otherwise returns -1 */
    static int last(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
                return mid;
            else if(x < arr[mid])
                return last(arr, low, (mid -1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};

        // Element to be counted in arr[]
        int x =  3;
        int n = arr.length;
        int c = count(arr, x, n);
        System.out.println(x+" occurs "+c+" times");
    }
}