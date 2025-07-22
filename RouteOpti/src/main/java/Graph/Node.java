package Graph;

import java.util.Objects;

public class Node {

    private final String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Important to override the equals method to an Object comparison.
    @Override
    public boolean equals(Object objToSearch) {
        if (this == objToSearch) return true;
        if (!(objToSearch instanceof Node)) return false;
        Node node = (Node) objToSearch;
        return name.equals(node.name);
    }

    @Override
    public  int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString(){
        return name;
    }

}
