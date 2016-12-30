/**
 * Created by ousmane on 12/22/16.
 */
public class JourneyToTheMoon {


    public int countPairs(Digraph g){
        int maxCount = 0;
        boolean[] visited = new boolean[g.V()];
        for(int v=0; v < g.V(); v++){
            maxCount += dfs(g, v, visited);
            reinitialize(visited);
        }
        System.out.println("maxCount: " + maxCount);
        return maxCount;
    }

    private void reinitialize(boolean[] visited){
        for(int v=0; v < visited.length; v++){
            visited[v] = false;
        }
    }

    private int dfs(Digraph g, int s, boolean[] visited){
        int count = 0;
        visited[s] = true;
        for(Integer w : g.adj(s)){
            if(!visited[w]){
                count += dfs(g, w, visited) + 1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 3);
        digraph.addEdge(2, 0);
        digraph.addEdge(4, 5);
        digraph.addEdge(4,2);
        digraph.printGraph();
        JourneyToTheMoon jtm = new JourneyToTheMoon();
        System.out.println("The total number of combination are: " + jtm.countPairs(digraph));
    }
}
