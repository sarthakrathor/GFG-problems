// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
    int[] ans = new int[2360];

    for (int i = 0; i < arr.length; i++) {
        ans[arr[i]]++;          
        if (dep[i] + 1 < 2360) {
            ans[dep[i] + 1]--; 
        }     
    }

    int sum = 0;
    int maxi = 0;

    for (int i = 0; i < 2360; i++) {
        sum += ans[i];
        maxi = Math.max(sum, maxi);
    }

    return maxi;
}
}

        
        
   