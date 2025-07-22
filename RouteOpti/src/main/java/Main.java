import Algorithm.Dijkstra;
import Graph.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        Node stationA = new Node("A");
        Node stationB = new Node("B");
        Node stationC = new Node("C");
        Node stationD = new Node("D");
        Node stationE = new Node("E");
        Node stationF = new Node("F");
        Node stationG = new Node("G");
        Node stationH = new Node("H");

        graph.addNode(stationA);
        graph.addNode(stationB);
        graph.addNode(stationC);
        graph.addNode(stationD);
        graph.addNode(stationE);
        graph.addNode(stationF);
        graph.addNode(stationG);
        graph.addNode(stationH);

        // Station A Connections
        graph.addEdge(stationA, stationB, 5);
        graph.addEdge(stationA, stationC, 7);

        // Station B Connections
        graph.addEdge(stationB, stationA, 5);
        graph.addEdge(stationB, stationC, 8);
        graph.addEdge(stationB, stationD, 11);
        graph.addEdge(stationB, stationE, 13);

        // Station C Connections
        graph.addEdge(stationC, stationA, 7);
        graph.addEdge(stationC, stationB, 8);
        graph.addEdge(stationC, stationE, 8);
        graph.addEdge(stationC, stationF, 10);
        graph.addEdge(stationC, stationH, 18);

        // Station D Connections
        graph.addEdge(stationD, stationB, 11);
        graph.addEdge(stationD, stationE, 6);
        graph.addEdge(stationD, stationG, 7);

        // Station E Connections
        graph.addEdge(stationE, stationB, 13);
        graph.addEdge(stationE, stationC, 8);
        graph.addEdge(stationE, stationD, 6);
        graph.addEdge(stationE, stationH, 9);

        // Station F Connections
        graph.addEdge(stationF, stationC, 10);
        graph.addEdge(stationF, stationH, 13);

        // Station G Connections
        graph.addEdge(stationG, stationD, 7);
        graph.addEdge(stationG, stationH, 4);

        // Station H Connections
        graph.addEdge(stationH, stationC, 18);
        graph.addEdge(stationH, stationE, 8);
        graph.addEdge(stationH, stationF, 13);
        graph.addEdge(stationH, stationG, 4);

        System.out.print("Enter your Starting Point (A-H): ");
        Node start = new Node(scanner.nextLine().toUpperCase());

        System.out.print("Enter your Destination Point (A-H): ");
        Node destination = new Node(scanner.nextLine().toUpperCase());

        long startTime = System.nanoTime();

        List<Node> path = Dijkstra.calcShortestPath(graph, start, destination);

        if (path.isEmpty()) {
            System.out.println("\nNo path found. Already there OR " + start + " does not connect to " +
                    destination + " OR invalid response.");
        } else {

            System.out.print("Shortest path: ");
            for (Node node : path) {
                System.out.print(node + " -> ");
            }
            System.out.print("Finish\n");
        }

        scanner.close();

        System.out.println("\nRuntime: " + ((System.nanoTime() - startTime) / 1000000) + "ms");
    }
}
