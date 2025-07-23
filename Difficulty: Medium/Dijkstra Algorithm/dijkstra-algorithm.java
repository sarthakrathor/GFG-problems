class Solution {
    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] i:edges){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int di = curr.dist;
            
            if(di> d[u]) continue;
            
            for(Pair n:adj.get(u)){
                int v = n.node;
                int w = n.dist;
                
                if(d[u] + w < d[v]){
                    d[v] = d[u]+w;
                    pq.offer(new Pair(v,d[v]));
                }
            }
        }
        
        return d;
    }
}