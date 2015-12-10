package cn.edu.twoforktree;

/**
 * Description:
 * Author: Hey
 * Date: 2015/12/10
 */
public class BinaryNode implements Comparable<BinaryNode> {
    private Integer value;
    protected BinaryNode leftChild;
    protected BinaryNode rightChild;

    public BinaryNode(Integer value, BinaryNode leftChild, BinaryNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return (Integer) value;
    }

    public void setValue(Integer value) {this.value = value;}

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    public int compareTo(BinaryNode node) {

        return this.value - node.getValue();
    }
}
