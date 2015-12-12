package cn.edu.graph;

/**
 * Description:
 * Author: Hey
 * Date: 2015/12/11
 */
public class Vertex {

    private String label;
    private boolean isVisited;

    public Vertex(String label){
        this.label=label;
        this.isVisited=false;
    }

    public String getLabel(){
        return this.label;
    }

    public void setVisited(boolean isVisited){
        this.isVisited=isVisited;
    }

    public boolean isVisited(){
        return this.isVisited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
