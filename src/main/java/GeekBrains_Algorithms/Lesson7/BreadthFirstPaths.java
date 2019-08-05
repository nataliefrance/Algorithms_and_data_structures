package GeekBrains_Algorithms.Lesson7;

import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean[] marked; //массив посещённости
    private int[] edgeTo; //массив откуда пришёл
    private int[] distanceTo; //расстояние (чтобы найти кратчайший путь)
    private int source; //номер вершины
    private final int INFINITY = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph graph, int source) {
        this.source = source;
        this.edgeTo = new int[graph.getVertexCount()];
        this.marked = new boolean[graph.getVertexCount()];
        this.distanceTo = new int[graph.getVertexCount()];
        for (int i = 0; i < distanceTo.length; i++) {
            distanceTo[i] = INFINITY;
        }
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distanceTo[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w :graph.getAdjacentList(vertex)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distanceTo[w] = distanceTo[vertex] + 1;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int vertex){
        return marked[vertex];
    }

    public LinkedList<Integer> pathTo(int v){
        if (!hasPathTo(v)){ //если дороги до вершины нет, возвращаем null
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distanceTo(int vertex){
        return distanceTo[vertex];
    }
}
