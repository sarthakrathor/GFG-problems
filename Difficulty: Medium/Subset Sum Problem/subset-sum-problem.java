class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum + 1];
        return helper(n - 1, sum, arr, dp);
    }

    static boolean helper(int index, int target, int[] nums, Boolean[][] dp) {
        // Base Cases
        if (target == 0) return true;      
        if (index == 0) return nums[0] == target;

        if (dp[index][target] != null) return dp[index][target];

        // Not pick 
        boolean notPick = helper(index - 1, target, nums, dp);

        // Pick 
        boolean pick = false;
        if (nums[index] <= target)
            pick = helper(index - 1, target - nums[index], nums, dp);

        return dp[index][target] = pick || notPick;
    }
}