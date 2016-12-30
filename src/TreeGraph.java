import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ousmane on 12/21/16.
 */
public class TreeGraph {

    private LinkedList<Integer>[] adj;
    private LinkedList<Integer>[] parents;
    boolean[] visited;
    private int V=0;
    public TreeGraph(int V){
        this.V = V;
        adj = new LinkedList[V+1];
        parents = new LinkedList[V+1];
        visited = new boolean[V+1];
        for(int v=1; v < V+1; v++){
            adj[v] = new LinkedList<>();
            parents[v] = new LinkedList<>();
        }
    }

    protected static class Edge {
        private int s, d;
        public Edge(int u, int v){
            this.s = u;
            this.d = v;
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        parents[v].add(u);
    }

    public int V(){
        return V;
    }

    public void children(){
        for(int v=1; v < V+1; v++){
            System.out.print(v+": ");
            for(Integer w : adj[v]){
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }

    public void parens(){
        for(int v=1; v < V+1; v++){
            System.out.print(v+": ");
            for(Integer w : parents[v]){
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }

    public int minCutTree(TreeGraph tree, List<Edge> edgeList,
                          HashMap<Integer, Integer> weights){
        int minSum = Integer.MAX_VALUE;
        int sourceIndex = 0, destinationIndex = 0;
        for(Edge edge : edgeList){
            if(tree.parents[edge.d].contains(edge.s)) {
                sourceIndex = getIndex(tree.parents[edge.d], edge.s);
                tree.parents[edge.d].remove(sourceIndex);
            }
            if(tree.adj[edge.s].contains(edge.d)) {
                destinationIndex = getIndex(tree.adj[edge.s], edge.d);
                tree.adj[edge.s].remove(destinationIndex);
            }
            int source = edge.s, destination = edge.d;
            int leftSum = weightSum(tree, source, weights);
            int rightSum = weightSum(tree, destination, weights);
            int diff = Math.abs(leftSum - rightSum);
            if(diff < minSum){
                minSum = diff;
            }
            tree.adj[edge.s].add(destinationIndex, edge.d);
            tree.parents[edge.d].add(sourceIndex, edge.s);
            for(int i=1; i < tree.V()+1; i++){
                visited[i] = false;
            }
            destinationIndex = 0;
            sourceIndex = 0;
        }

        return minSum;
    }

    private int getIndex(LinkedList<Integer> list, int v){
        int index = 0;
        for(int i=0; i < list.size(); i++){
            if(list.get(i) == v){
                index = i;
                break;
            }
        }
        return index;
    }

    private int weightSum(TreeGraph g, int s, HashMap<Integer, Integer> mapWeight){
        int sum = 0;
        for(Integer q: g.parents[s]){
            if(!visited[q])
                sum+= weightSum(g, q, mapWeight);
        }
        if(!visited[s]) sum += mapWeight.get(s);
        visited[s] = true;
        for(Integer w: g.adj[s]){
            if(!visited[w])
                sum += weightSum(g, w, mapWeight);
        }
        return sum;
    }

    public static void main(String[] args){
        TreeGraph graph = new TreeGraph(6);
        List<Edge> edges = new ArrayList<>();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(2, 5));
        edges.add(new Edge(4, 5));
        edges.add(new Edge(5, 6));
        HashMap<Integer, Integer> mapWeight = new HashMap<>();
        mapWeight.put(1, 100);
        mapWeight.put(2, 200);
        mapWeight.put(3, 100);
        mapWeight.put(4, 500);
        mapWeight.put(5, 100);
        mapWeight.put(6, 600);
        graph.children();
        System.out.println("---------");
        graph.parens();
        System.out.println("The min sum is: " + graph.minCutTree(graph, edges, mapWeight));
    }
}
