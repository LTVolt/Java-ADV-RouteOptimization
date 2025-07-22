package Graph;

public class Edge {

    private final Node target;
    private  final double distance;

    public Edge(Node target, double distance) {
        this.target = target;
        this.distance = distance;
    }

    public Node getTarget() {
        return this.target;
    }

    public double getDistance() {
        return this.distance;
    }
}