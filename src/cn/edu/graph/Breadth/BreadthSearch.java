package cn.edu.graph.Breadth;

import cn.edu.graph.Vertex;

/**
 * Description:广度遍历图
 * Author: Hey
 * Date: 2015/12/12
 */
public class BreadthSearch {

    private Vertex[] vertexes;
    private int [][]adjMat;
    private Queue queue;
    private int nEles;

    public BreadthSearch(int maxSize){
        vertexes=new Vertex[maxSize];
        queue=new Queue(maxSize);
        nEles=0;
        adjMat=new int[maxSize][maxSize];
        for(int i=0;i<maxSize;i++){
            for(int j=0;j<maxSize;j++){
                adjMat[i][j]=0;
            }
        }
    }

    public void addVertex(String label){
        if(nEles==vertexes.length)
            return;
        vertexes[nEles++]=new Vertex(label);
    }

    private void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    public void breadthSearch(){
        vertexes[0].setVisited(true);
        queue.enQueue(0);
        while(!queue.isEmpty()){
            int v=getUnvisitedVertex(queue.peek());

            if(v==-1){
                System.out.print(vertexes[queue.deQueue()]);
            }else {
                vertexes[v].setVisited(true);
                queue.enQueue(v);
            }
        }
    }

    public int getUnvisitedVertex(int v){

        for(int i=0;i<vertexes.length;i++){
            if(adjMat[i][v]==1&&!vertexes[i].isVisited()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        BreadthSearch graph=new BreadthSearch(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge(0, 1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3, 4);

        graph.breadthSearch();

    }
}
