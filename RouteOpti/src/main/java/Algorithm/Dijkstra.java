package Algorithm;

import Graph.*;

import java.util.*;
import java.util.List;

public class Dijkstra {

    // This method is only used for displaying purposes as of now!
    public static Map<Node, Double> calcShortestDistToNode(Graph graph, Node start){
        Map<Node, Double> allDistances = new HashMap<>();
        PriorityQueue<NodeDistancePair> queue =
                new PriorityQueue<>(Comparator.comparingDouble(NodeDistancePair::getDistance));

        for (Node node : graph.getAllNodes()) {
            allDistances.put(node, Double.POSITIVE_INFINITY);
        }

        allDistances.put(start, 0.0);
        queue.add(new NodeDistancePair(start, 0.0));

        while (!queue.isEmpty()) {
            NodeDistancePair current = queue.poll();
            Node currentNode = current.getNode();

            for (Edge edge : graph.getNeighbors(currentNode)) {
                Node neighbor = edge.getTarget();
                double newDistance = allDistances.get(currentNode) + edge.getDistance();
                if (newDistance < allDistances.get(neighbor)) {
                    allDistances.put(neighbor, newDistance);
                    queue.add(new NodeDistancePair(neighbor, newDistance));
                }
            }
        }
        return allDistances;
    }

    // Here is where is magic happens.
    public static List<Node> calcShortestPath(Graph graph, Node start, Node destination) {

        // 1. Initializing all distances as Infinity first.
        Map<Node, Double> allDistances = new HashMap<>();
        Map<Node, Node> predecessor = new HashMap<>();

        PriorityQueue<NodeDistancePair> queue =
                new PriorityQueue<>(Comparator.comparingDouble(NodeDistancePair::getDistance));

        for (Node node : graph.getAllNodes()) {
            allDistances.put(node, Double.POSITIVE_INFINITY);
        }

        // 2. Setting initial distance to 0 and starting the queue.
        allDistances.put(start, 0.0);
        queue.add(new NodeDistancePair(start, 0.0));


        // 3. Checking every node in the queue until we make it back to the start.
        //    (Does some switching around as usual)

        while (!queue.isEmpty()) {
            NodeDistancePair current = queue.poll();
            Node currentNode = current.getNode();
            System.out.println("\nCurrently checking: " + currentNode);

            if (currentNode.equals(destination)) { // This is where Overriding the equals() method is necessary.
                System.out.println("Path found and calculated!\n");
                break;
            }

            for (Edge edge : graph.getNeighbors(currentNode)) {

                Node neighbor = edge.getTarget();
                double newDistance = allDistances.get(currentNode) + edge.getDistance();
                System.out.printf("Distance to %s: %.2f\n", neighbor, edge.getDistance());

                if (newDistance < allDistances.get(neighbor)) {
                    allDistances.put(neighbor, newDistance);
                    predecessor.put(neighbor, currentNode);
                    queue.add(new NodeDistancePair(neighbor,newDistance));
                }

            }
        }

        // 4. Rebuilding path in order.

        List<Node> path = new LinkedList<>();
        Node step = destination;
        if (!predecessor.containsKey(destination)) {
            return path;
        }

        while (step != null) {
            path.add(0, step);
            step = predecessor.get(step);
        }
        return path;
    }


    // Helper class for the queue to store nodes temporarily.
    private record NodeDistancePair(Node node, double distance){
        public Node getNode() {
            return node;
        }

        public double getDistance(){
            return distance;
        }
    }
}
