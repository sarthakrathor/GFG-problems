class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        //to create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr:edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<int[]> q = new LinkedList<>(); //[node,parent]
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i] = true;
                q.add(new int[]{i,-1});
            }
            
            while(!q.isEmpty()){
                int[] curr = q.poll();
                int node = curr[0];
                int parent = curr[1];
                
                for(int n:adj.get(node)){
                    if(!visited[n]){
                        visited[n] = true;
                        q.add(new int[]{n,node});
                    }else if(n != parent){
                        return true;
                    }
                }
            }
        }
        
        return false;
        
        
    }
    
}