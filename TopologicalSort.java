/**
 * Created by ousmane on 12/14/16.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    protected static class Graph {
        LinkedList<Integer>[] adj;
        private boolean[] visited;
        private int V;
        private int E;
        public Graph(int v){
            adj = new LinkedList[v+1];
            for(int i=0; i < adj.length; i++){
                adj[i] = new LinkedList<>();
            }
            V = v;
            visited = new boolean[V+1];
        }

        public void addEdge(int v, int w){
            adj[v].add(w);
            E++;
        }

        public LinkedList<Integer> adj(int v){
            return adj[v];
        }

        public int E(){
            return E;
        }

        public int V(){
            return V;
        }

        public void printGraph(){
            for(int i=1; i < V() +1; i++){
                System.out.print(i + " ");
                for(Integer elt : adj[i]){
                    System.out.print(elt +" ");
                }
                System.out.println();
            }
        }

        public void sort(Graph g){
            HashSet<Integer> set = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            for(int i=1; i < g.V()+1; i++){
                if(!set.contains(i)){
                    dfs(g, i, set, stack);
                }
            }

            for(Integer elt : stack){
                System.out.print(elt + " ");
            }
            System.out.println();
        }

        public Stack<Integer> dfs(Graph g, int v, HashSet<Integer> set, Stack<Integer> stack){
            visited[v] = true;
            set.add(v);
            for(Integer w : g.adj(v)){
                if(!visited[w] && !set.contains(w)){
                    dfs(g, w, set, stack);
                }
            }
            stack.push(v);
            return stack;
        }
    }

    public static void main(String[] args){
        TopologicalSort.Graph graph = new TopologicalSort.Graph(6);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(6, 1);
        graph.addEdge(6, 2);
        //graph.printGraph();
        graph.sort(graph);
    }
}
