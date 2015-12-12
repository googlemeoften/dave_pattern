package cn.edu.graph.depth;

/**
 * Description:ջ
 * Author: Hey
 * Date: 2015/12/11
 */
public class Stack {

    private int top;
    private int[]vertexes;

    public Stack(int maxSize){
        top=-1;
        this.vertexes=new int[maxSize];
    }

    public boolean push(int vertex){
        if(isFull())
            return false;
        vertexes[++top]=vertex;


        return true;
    }

    public int pop(){
        return vertexes[top--];
    }

    public int peek(){
        return vertexes[top];
    }

    public boolean isEmpty(){
       return top==-1;
    }

    public boolean isFull(){
        return top==vertexes.length;
    }
    private void print() {
        while (!isEmpty()) {
            System.out.print(pop());
        }
    }

}
