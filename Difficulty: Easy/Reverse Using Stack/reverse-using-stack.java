class Solution {
    public String reverse(String S) {
        // code here
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<S.length()){
            st.push(S.charAt(i));
            i++;
        }
        
        String rs = "";
        while(!st.isEmpty()){
            rs+=st.pop();
        }
        
        return rs;
    }
}