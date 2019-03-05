package tengxun;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();  // 节点数
        int m = scanner.nextInt();   // 变数

        UndirectedGraphNode[] nodes = new UndirectedGraphNode[n+1];
        nodes[0] = null;
        for (int i = 1; i <= n; i++) {
            nodes[i] = new UndirectedGraphNode(i);

        }

        for (int i = 0; i < m; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            nodes[first].neighbors.add(nodes[second]);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            int x = 0;
            int y = 0;
            for (int j = 1; j <= n && j!=i; j++) {

                boolean ret = check(nodes[i], nodes[j]);
                if (ret) {
                    x++;

                }

                boolean ret2 = check(nodes[j], nodes[i]);
                if (ret2) {
                    y++;
                }
            }

            if (x < y) {
                count++;
            }
        }
        System.out.println(count);

    }


   static class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return check(a,b)||check(b,a);
    }
    public static boolean check(UndirectedGraphNode a, UndirectedGraphNode b){
        if(a ==null||b ==null) return false;
        if(a ==b) return true;
        if(a.label ==-1) return false;
        a.label =-1;
        for(int i=0;i<a.neighbors.size();i++){
            if(check(a.neighbors.get(i),b))return true;
        }
        return false;
    }


}



