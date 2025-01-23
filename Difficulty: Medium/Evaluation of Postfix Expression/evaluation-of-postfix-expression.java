//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") 
                || arr[i].equals("/")){
                int b = st.pop();
                int a = st.pop();
                
                switch(arr[i]){
                    case "+":
                        st.push(a+b);
                        break;
                    case "-":
                        st.push(a-b);
                        break;
                    case "/":
                        st.push(a/b);
                        break;
                    case "*":
                        st.push(a*b);
                        break;
                }
            }
            else st.push(Integer.parseInt(arr[i]));
        }
        return st.peek();
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends