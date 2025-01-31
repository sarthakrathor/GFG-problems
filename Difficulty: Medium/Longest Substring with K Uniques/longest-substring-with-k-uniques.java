//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int maxLen = -1;
        for(int j=0;j<n;j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            
            while(map.size() > k){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            
            if(map.size() == k){
                maxLen = Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
}