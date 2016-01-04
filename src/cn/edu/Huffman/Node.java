package cn.edu.Huffman;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/2
 */
public class Node implements Comparable {
    private Character ch;
    private Integer value;
    private boolean isLeftChild;
    protected Node parent;
    protected Node leftChild;
    protected Node rightChild;

    public Node() {
        super();
    }

    public Node(Character ch, int value) {
        this.ch = ch;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isLeftChild() {
        return isLeftChild;
    }

    public void setLeftChild(boolean leftChild) {
        isLeftChild = leftChild;
    }

    @Override
    public int compareTo(Object o) {
        Node node = null;
        if (o instanceof Node) {
            node = (Node) o;
        }
        return this.value - node.value;
    }


    @Override
    public String toString() {
        return "Node{" +
                "ch=" + ch +
                ", value=" + value +
                '}';
    }
}
