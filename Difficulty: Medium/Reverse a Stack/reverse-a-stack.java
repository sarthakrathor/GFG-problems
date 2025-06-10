// User function Template for Java

class Solution {
    static void insertAtBottom(Stack<Integer> st,int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        
        int top = st.pop();
        insertAtBottom(st,x);
        st.push(top);
    }
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        reverse(s);
        insertAtBottom(s,top);
    }
}