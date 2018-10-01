package Lesson_7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVortex('A');
        graph.addVortex('B');
        graph.addVortex('C');
        graph.addVortex('D');
        graph.addVortex('E');
        graph.addVortex('F');
        graph.addVortex('G');
        graph.addVortex('H');
        graph.addVortex('I');
        graph.addVortex('J');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(0, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        graph.bfs();
    }
}
