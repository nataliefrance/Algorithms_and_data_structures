package GeekBrains_Algorithms.Lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(7, 8);

        System.out.println(graph.getAdjacentList(1));

        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2);
        System.out.println(dfp.hasPathTo(3));
        System.out.println(dfp.pathTo(3));
    }
}
