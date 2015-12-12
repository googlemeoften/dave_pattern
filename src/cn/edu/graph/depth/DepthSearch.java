package cn.edu.graph.depth;

import cn.edu.graph.Vertex;

/**
 * Description:��ȱ���ͼ
 * Author: Hey
 * Date: 2015/12/11
 */
public class DepthSearch {

    private Vertex[] vertexes;
    private int maxSize;
    private int adjMat[][];
    private Stack stack;
    private int nEles;

    public DepthSearch(int maxSize) {

        this.maxSize = maxSize;
        vertexes = new Vertex[maxSize];
        stack = new Stack(maxSize);
        nEles = 0;

        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public boolean addVertex(String label) {
        if (nEles == maxSize)
            return false;
        vertexes[nEles++] = new Vertex(label);
        return true;
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * 深度遍历
     */
    public void depthSearch() {

        vertexes[0].setVisited(true);
        stack.push(0);
        display(0);

        while (!stack.isEmpty()){
            int v=getUnvisitedVertex(stack.peek());
            if(v==-1){
                stack.pop();
            }else {
                vertexes[v].setVisited(true);
                display(v);
                stack.push(v);
            }
        }

    }

    private void display(int vertex){
        System.out.println(vertexes[vertex]);
    }

    /**
     * 查找没有访问过的节点
     * @return
     */
    public int getUnvisitedVertex(int vertex) {

        for (int i = 0; i < maxSize; i++)
            if (adjMat[vertex][i] == 1 && !vertexes[i].isVisited()) {
                return i;
            }
        return -1;
    }

    public static void main(String[]args){
        DepthSearch graph=new DepthSearch(5);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge(0, 1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3, 4);




    }

}
