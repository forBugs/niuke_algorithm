package com.datastructure.recursion;


/**
 * 汉诺塔问题
 * 古代有一个梵塔，塔内有三个座A、B、C，A座上有64个盘子，盘子大小不等，大的在下，小的在上。
 * 有一个和尚想把这64个盘子从A座移到C座，但每次只能允许移动一个盘子，并且在移动过程中，
 * 3个座上的盘子始终保持大盘在下，小盘在上。在移动过程中可以利用B座。
 * Created by Administrator on 2018/4/13.
 */
public class HanNota {
    private int i = 1;
    /**
     *
     * @param n 多少个盘子
     * @param from 起始柱子
     * @param depeneOn  中间柱子
     * @param to 最后一根柱子
     */
    public void hanNota(int n, char from, char depeneOn, char to) {
        if (n == 1) {
            move(n, from, to);
        } else {
            // 将n-1个盘子从A 借助C  挪到B
            hanNota(n-1,from,to,depeneOn);
            // 移动第n个盘子  从A 挪到C
            move(n,from,to);
            // 将n-1个盘子从 B 借助A  挪到C
            hanNota(n-1,depeneOn,from,to);
        }

    }

    private void move(int n, char from, char to) {
        System.out.println("第"+(i++)+"次从"+from+"---->"+to);
    }

    public static void main(String[] args) {
        HanNota hanNota = new HanNota();
        hanNota.hanNota(50,'A','B','C');
    }
}
