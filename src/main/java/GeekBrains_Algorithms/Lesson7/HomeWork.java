package GeekBrains_Algorithms.Lesson7;

/*
Реализовать программу, в которой задается граф из 10 вершин.
Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */
public class HomeWork {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(1, 2);
        graph.addEdge(1, 9);
        graph.addEdge(2, 8);
        graph.addEdge(2, 3);
        graph.addEdge(3, 10);
        graph.addEdge(6, 10);
        graph.addEdge(4, 3);
        graph.addEdge(4, 9);
        graph.addEdge(4, 5);
        graph.addEdge(5, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(1, 0);

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 1);
        System.out.println("Кратчайший путь от вершины 1 до вершины 10: " + bfp.distanceTo(10));
        System.out.println(bfp.pathTo(10));
    }

}
