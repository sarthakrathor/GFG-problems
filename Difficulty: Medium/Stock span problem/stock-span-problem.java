
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1); //by default for the first element 
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans.add(i+1);
            }else{
                ans.add(i-st.peek());
            }
            
            st.push(i);
        }
        
        
        return ans;
    }
}