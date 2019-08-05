package GeekBrains_Algorithms.Lesson7;

import java.util.LinkedList;

public class Graph {
    private int vertexCount; //количество вершин
    private int edgeCount; //количество рёбер
    private LinkedList<Integer>[] adjacentList; //список смежности

    public Graph(int vertexCount) {
        if (vertexCount <= 0){
            throw new IllegalArgumentException("Количество вершин не может быть меньше нуля.");
        }
        this.vertexCount = vertexCount;
        this.adjacentList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public LinkedList<Integer> getAdjacentList(int vertex) {
        return (LinkedList<Integer>) adjacentList[vertex].clone();
    }

    public void addEdge(int v1, int v2){
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount){
            throw new IllegalArgumentException();
        }
        adjacentList[v1].add(v2);
        adjacentList[v2].add(v1);
    }


}
