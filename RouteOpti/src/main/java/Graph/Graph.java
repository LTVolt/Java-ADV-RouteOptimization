package Graph;

import java.util.*;

public class Graph {

    private final Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node start, Node destination, double distance) {
        adjacencyList.get(start).add(new Edge(destination, distance));
    }

    public List<Edge> getNeighbors(Node node){
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }

    public Set<Node> getAllNodes() {
        return adjacencyList.keySet();
    }

    public boolean containsNode(Node node) {
        return adjacencyList.containsKey(node);
    }
}
