package cn.edu.twoforktree;

/**
 * Description:
 * Author: Hey
 * Date: 2015/12/8
 */
public class Node implements Comparable<Node>{
    private int value;
    protected Node leftChild;
    protected Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return (Integer) value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    public int compareTo(Node node) {

        return this.value-node.getValue();
    }
}
