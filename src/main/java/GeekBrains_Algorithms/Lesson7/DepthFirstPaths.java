package GeekBrains_Algorithms.Lesson7;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;//массив посещённости
    private int[] edgeTo;//массив откуда пришёл
    private int source; //номер вершины

    public DepthFirstPaths(Graph graph, int source) {
        this.source = source;
        this.edgeTo = new int[graph.getVertexCount()];
        this.marked = new boolean[graph.getVertexCount()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int w : graph.getAdjacentList(vertex)) {
            if (!marked[w]) {
                edgeTo[w] = vertex;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int vertex){
        return marked[vertex];
    }

    public LinkedList<Integer> pathTo(int vertex){
        if (!hasPathTo(vertex)){ //если дороги до вершины нет, возвращаем null
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex1 = vertex;
        while (vertex1 != source){
            stack.push(vertex1);
            vertex1 = edgeTo[vertex];
        }
        return stack;
    }
}
