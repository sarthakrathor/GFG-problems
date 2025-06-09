// User function Template for Java
class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> rt = new Stack<>();
        while(!st.isEmpty()){
            rt.push(st.pop());
        }
        st.push(x);
        while(!rt.isEmpty()){
            st.push(rt.pop());
        }
        return st;
    }
}