import java.util.*;

// A class to represent a graph edge
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// A class to represent a subset for Union-Find
class Subset {
    int parent, rank;

    Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

public class KruskalAlgorithm {
    private List<Edge> edges = new ArrayList<>();

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Find the root of the subset in which element i belongs
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Union of two subsets
    private void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Kruskal's Algorithm to find MST
    public void kruskal(int V) {
        Collections.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int rootSrc = find(subsets, edge.src);
            int rootDest = find(subsets, edge.dest);

            if (rootSrc != rootDest) {
                mst.add(edge);
                union(subsets, rootSrc, rootDest);
            }
        }

        for (Edge e : mst) {
            System.out.println(e.src + " -- " + e.dest + ": " + e.weight);
        }
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm();
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        System.out.println("Minimum Spanning Tree:");
        graph.kruskal(4); // Number of vertices in the graph
    }
}
