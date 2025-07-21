class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int x = q.peek();
            ans.add(q.remove());
            for(int i:adj.get(x)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }    
        return ans;
    }
}