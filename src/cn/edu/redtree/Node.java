package cn.edu.redtree;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/2
 */
public class Node {

    private Integer value;
    private boolean isBlack;
    protected Node parent;
    protected Node leftChild;
    protected Node rightChild;

    public Node(int value, Node parent, boolean isBlack) {
        this.value = value;
        this.parent = parent;
        this.isBlack = isBlack;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", isBlack=" + isBlack +
                ", parent=" + getParentValue()+
                '}';
    }
    public Integer getParentValue(){
        return parent==null?0:parent.getValue();
    }
}
