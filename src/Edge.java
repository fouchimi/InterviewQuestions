/**
 * Created by ousmane on 12/25/16.
 */
public class Edge {
    private int u, v, weight;

    public Edge(int u, int v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public Edge(int u, int v){
        this.u = u;
        this.v = v;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
}
