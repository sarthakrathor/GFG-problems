//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution obj = new Solution();

            boolean a = obj.areIsomorphic(s1, s2);
            if (a)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s1, String s2) {
        // Your code here
        if(s1.length()!=s2.length()){
            return false;
        }
        
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char o = s1.charAt(i);
            char r = s2.charAt(i);
            
            if(!map.containsKey(o)){
                if(!map.containsValue(r)){
                    map.put(o,r);
                }
                else{
                    return false;
                }
            }
            else{
                char val = map.get(o);
                if(val!=r){
                    return false;
                }
            }
            }
            return true;
        }
}