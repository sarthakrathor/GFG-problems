//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            char ss = s.charAt(i);
            if((ss >= 'A' && ss <= 'Z') ||
               (ss >= 'a' && ss <= 'z') ||
               (ss >= '0' && ss <= '9')) 
               ans = ans+ss;
            
            else if(ss == '(') st.push(ss);
            else if(ss == ')'){
                while(st.peek() != '('){
                    ans = ans+st.pop();
                }
                st.pop(); //to remove the remaining '(' bracket
            }
            
            else{ //ss == operancd case
                while(!st.isEmpty() && priority(ss) <= priority(st.peek())){
                    ans = ans+st.pop();
                }
                st.push(ss); // to add the operator with lower priority  
            }
        }
        while(!st.isEmpty()){
            ans = ans+st.peek();
            st.pop();
        }
        
        return ans;
    }
    
    static int priority(char s){
        if(s == '^') return 3;
        else if(s == '*' || s == '/') return 2;
        else if(s == '+' || s == '-') return 1;
        else return -1;
    }
}