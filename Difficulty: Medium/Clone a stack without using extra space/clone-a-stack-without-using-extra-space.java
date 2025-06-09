// User function Template for Java

class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        // code here
        Stack<Integer> copy = new Stack<>();
        while(!st.isEmpty()){
            copy.push(st.pop());
        }
        
        while(!copy.isEmpty()){
            cloned.push(copy.pop());
        }
    }
}