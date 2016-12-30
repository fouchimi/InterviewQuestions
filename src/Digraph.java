import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ousmane on 12/22/16.
 */
public class Digraph {
    private LinkedList<Integer>[] adj;
    private int V, E;
    private List<Edge> list = new ArrayList<>();

    public Digraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int v=0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        Edge newEdge = new Edge(u, v);
        list.add(newEdge);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){ return E; }

    public List<Edge> getEdges(){
        return list;
    }

    public LinkedList<Integer> adj(int v){
        return adj[v];
    }

    public void printGraph(){
        for(int v=0; v <V; v++){
            System.out.print(v + ": ");
            for(Integer w : adj(v)){
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
