//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int rsum = 0; 
        int lsum = 0; 


        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        int maxSum = lsum; 
        int n = cardPoints.length;
        
        for (int i = 0; i < k; i++) {
            lsum -= cardPoints[k - i - 1]; 
            rsum += cardPoints[n - i - 1]; 
            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int[] cardPoints = new int[inputArray.length];
            for (int j = 0; j < inputArray.length; j++) {
                cardPoints[j] = Integer.parseInt(inputArray[j]);
            }
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Solution solution = new Solution();
            System.out.println(solution.maxScore(cardPoints, k));
            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends