class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) 
            adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        
        int[] color = new int[V];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(color[i] == 0){
                dfs(i,adj,color,result);
            }
        }
        
        Collections.reverse(result);
        return result;
        
    }
    
    static void dfs(int node,List<List<Integer>> adj,int[] color,ArrayList<Integer> result){
        color[node] = 1;
            
        for(int n:adj.get(node)){
            if(color[n] == 0){
                dfs(n,adj,color,result);
            }
        }
            
        color[node] = 2;
        result.add(node);
    }
}