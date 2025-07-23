class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean[] path = new boolean[V];
        boolean[] visited = new boolean[V];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr:edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
        }
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,path,visited)) return true;
            }
        }
        
        return false;
    }
        
        boolean dfs(int node,List<List<Integer>> adj,boolean[] path,boolean[] visited){
            visited[node] = true;
            path[node] = true;
            
            for(int n:adj.get(node)){
                if(!visited[n]){
                    if(dfs(n,adj,path,visited)) return true;
                }else if(path[n]){
                    return true;
                }
            }
            
            path[node] = false;
            return false;
        }
        
        
}
