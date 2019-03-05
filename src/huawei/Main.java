package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int group = scanner.nextInt();
        int[][] arrs = new int[group][2];
        for (int i = 0; i < group; i++) {
            arrs[i][0] = scanner.nextInt();
            arrs[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < group; i++) {
            yuesefu(arrs[i][0], arrs[i][1]);
            System.out.println();
        }



    }

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() >0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.print(start.get(start.size()-1)+" ");
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.print(start.get(k)+" ");
                start.remove(k);
            }
        }
    }

}
