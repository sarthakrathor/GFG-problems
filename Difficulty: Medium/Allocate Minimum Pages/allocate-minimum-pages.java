
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;

        if (k > n) return -1;

        int low = getMax(arr);
        int high = getSum(arr);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }

        return result;
    }

    static boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxPages) return false;

            if (pages + arr[i] > maxPages) {
                students++;
                pages = arr[i];

                if (students > k) return false;
            } else {
                pages += arr[i];
            }
        }

        return true;
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) max = Math.max(max, val);
        return max;
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }
}
