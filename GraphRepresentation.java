import java.util.LinkedList;
import java.util.List;

public class GraphRepresentation {

    // Adjacency Matrix Representation
    static class GraphAdjMatrix {
        private int[][] adjMatrix;
        private int numVertices;

        public GraphAdjMatrix(int numVertices) {
            this.numVertices = numVertices;
            adjMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int i, int j) {
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1; // For undirected graph
        }

        public void removeEdge(int i, int j) {
            adjMatrix[i][j] = 0;
            adjMatrix[j][i] = 0; // For undirected graph
        }

        public void printGraph() {
            System.out.println("Adjacency Matrix:");
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    // Adjacency List Representation
    static class GraphAdjList {
        private List<List<Integer>> adjList;
        private int numVertices;

        public GraphAdjList(int numVertices) {
            this.numVertices = numVertices;
            adjList = new LinkedList<>();
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new LinkedList<>());
            }
        }

        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
            adjList.get(dest).add(src); // For undirected graph
        }

        public void removeEdge(int src, int dest) {
            adjList.get(src).remove((Integer) dest);
            adjList.get(dest).remove((Integer) src); // For undirected graph
        }

        public void printGraph() {
            System.out.println("Adjacency List:");
            for (int i = 0; i < adjList.size(); i++) {
                System.out.print("Vertex " + i + ":");
                for (Integer vertex : adjList.get(i)) {
                    System.out.print(" -> " + vertex);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;

        // Adjacency Matrix Example
        GraphAdjMatrix graphMatrix = new GraphAdjMatrix(numVertices);
        graphMatrix.addEdge(0, 1);
        graphMatrix.addEdge(0, 2);
        graphMatrix.addEdge(1, 2);
        graphMatrix.addEdge(1, 3);
        System.out.println("Graph using Adjacency Matrix:");
        graphMatrix.printGraph();

        // Adjacency List Example
        GraphAdjList graphList = new GraphAdjList(numVertices);
        graphList.addEdge(0, 1);
        graphList.addEdge(0, 2);
        graphList.addEdge(1, 2);
        graphList.addEdge(1, 3);
        System.out.println("Graph using Adjacency List:");
        graphList.printGraph();
    }
}
