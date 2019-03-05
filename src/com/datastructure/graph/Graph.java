package com.datastructure.graph;

import java.util.LinkedList;

/**
 * 图的基本数据结构  有向图
 * Created by Administrator on 2018/4/19.
 */
public class Graph {
    private int vertexSize;  // 顶点的个数
    private int[] vertexs;  // 顶点数组
    private int[][] matrix;  // 边数组
    private static final int MAX_WEIGHT = 1000;    // 代表邻接矩阵中的∞
    private boolean[] isVisited;

    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        this.vertexs = new int[vertexSize];
        this.matrix = new int[vertexSize][vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
        isVisited = new boolean[vertexSize];
    }

    /**
     * 获取某个顶点的出度
     * @param index
     * @return
     */
    public int getOutDegree(int index) {
        int count = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            if(matrix[index][i] > 0 && matrix[index][i] < MAX_WEIGHT) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 获取某个顶点的出度
     * @param index
     * @return
     */
    public int getInDegree(int index) {
        int count = 0;
        for (int i = 0; i < vertexSize; i++) {
            if(matrix[i][index] > 0 && matrix[index][i] < MAX_WEIGHT) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 获取某个顶点的第一个邻接顶点
     * @param i
     * @return
     */
    public int getFirstNeigh(int i) {
        for (int j = 0; j < vertexSize; j++) {
            if(matrix[i][j] > 0 && matrix[i][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 获取某个顶点相对于前一个邻接顶点的下一个邻接顶点
     * @param v
     * @param index
     * @return
     */
    public int getNextNeigh(int v, int index) {
        for (int i = index + 1; i < vertexSize; i++) {
            if(matrix[v][i] > 0 && matrix[v][i] < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先搜索遍历
     */
    public void depthFirstSearch(int i) {
        System.out.println("访问到顶点："+i);
        isVisited[i] = true;
        int neigh = getFirstNeigh(i);
        while (neigh != -1) {
            if(!isVisited[neigh]) {
                depthFirstSearch(neigh);
            }
            neigh = getNextNeigh(i,neigh);
        }
    }

    /**
     * 对外的深度优先搜索
     */
    public void depthFirstSearch() {
        isVisited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if(!isVisited[i]) {
                depthFirstSearch(i);
            }
        }
        isVisited = new boolean[vertexSize];
    }

    /**
     * 广度优先搜索遍历
     * @param i
     */
    public void broadFirstSearch(int i) {
        System.out.println("访问节点："+i);
        // 声明一个队列
        LinkedList<Integer> queue = new LinkedList<>();
        int neigh,temp;
        // 第一次把v0加入到队列中
        queue.add(i);
        isVisited[i] = true;
        while (!queue.isEmpty()) {
            // 出队列
            temp = queue.removeFirst().intValue();
            neigh = getFirstNeigh(temp);
            while (neigh!= -1) {
                if(!isVisited[neigh]) {
                    // 入队列
                    System.out.println("访问节点："+neigh);
                    isVisited[neigh] = true;
                    queue.add(neigh);
                }
                neigh = getNextNeigh(temp,neigh);
            }
        }
    }

    /**
     * 对外的广度优先搜索
     */
    public void broadFirstSearch(){
        isVisited = new boolean[vertexSize];
        for(int i =0;i<vertexSize;i++){
            if(!isVisited[i]){
                broadFirstSearch(i);
            }
        }
    }

    public void prim(){
        // 最小代价生成数组 保存相关顶点边的权值 为0代表此节点已经添加到最小生成树中
        int[] lowCost = new int[vertexSize];
        //存放最小权值数组的顶点下标
        int[] adjvex = new int[vertexSize];
        int min ;
        int minId;
        int sum = 0;
        //初始化
        for (int i = 1; i < vertexSize; i++) {
            lowCost[i] = matrix[0][i];
        }
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            minId = 0;
            // 找到当前lowCost数组中的最小值  并记录下标
            for (int j = 1; j < vertexSize; j++) {
                if(lowCost[j] < min && lowCost[j] > 0) {
                    min = lowCost[j];
                    minId = j;
                }
            }
            sum += min;
            lowCost[minId] = 0;
            System.out.println("顶点:"+adjvex[minId]+"权值："+min);
            // 更新lowCost的值
            for (int j = 1; j < vertexSize; j++) {
                if(matrix[minId][j] < lowCost[j] && lowCost[j] != 0) {
                    lowCost[j] = matrix[minId][j];
                    adjvex[j] = minId;
                }
            }

        }
        System.out.println("最小生成树权值和:"+sum);

    }


    /**
     * 获取两个顶点之间的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2];
        return weight == 0 ? 0 : weight == MAX_WEIGHT ? -1 : weight;
    }

    public int getVertexSize() {
        return vertexSize;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);

        int [] a1 = new int[]{0,10,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT};
        int [] a2 = new int[]{10,0,18,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,MAX_WEIGHT,12};
        int [] a3 = new int[]{MAX_WEIGHT,MAX_WEIGHT,0,22,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,8};
        int [] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,22,0,20,MAX_WEIGHT,MAX_WEIGHT,16,21};
        int [] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,20,0,26,MAX_WEIGHT,7,MAX_WEIGHT};
        int [] a6 = new int[]{11,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,26,0,17,MAX_WEIGHT,MAX_WEIGHT};
        int [] a7 = new int[]{MAX_WEIGHT,16,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,17,0,19,MAX_WEIGHT};
        int [] a8 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,16,7,MAX_WEIGHT,19,0,MAX_WEIGHT};
        int [] a9 = new int[]{MAX_WEIGHT,12,8,21,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};

        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;
        graph.matrix[5] = a6;
        graph.matrix[6] = a7;
        graph.matrix[7] = a8;
        graph.matrix[8] = a9;
//        graph.broadFirstSearch();
        graph.prim();
    }
}
