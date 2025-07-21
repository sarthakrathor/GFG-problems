class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //using kahn's algorithm 
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr:edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
            q.add(i);
            }
        }
        
        int count = 0; // for keeping track of nodes that 
                       // are already processed
                       
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            
            for(int n:adj.get(curr)){
                indegree[n]--;
                if(indegree[n] == 0) q.add(n);
            }
        }
        
        return count != V; // checking if there are some nodes unprocessed
        // if exists mean cycle is present 
        
    }
}