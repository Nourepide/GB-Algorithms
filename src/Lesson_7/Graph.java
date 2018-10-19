package Lesson_7;

public class Graph {
    private final int MAX_SIZE = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;

    private int size;
    private Stack stack;
    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_SIZE];
        adjMat = new int[MAX_SIZE][MAX_SIZE];
        size = 0;

        stack = new Stack(MAX_SIZE);
        queue = new Queue(MAX_SIZE);
    }

    public void addVortex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    private int getAdjUnvisitedVertex(int vertex) {
        for (int i = 0; i < size; i++) {
            if (adjMat[vertex][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }

        return -1;
    }

    void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);

        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
