package com.datastructure.recursion;

/**
 * 求取最大公约数  和最小公倍数
 * <p>
 * 最大公约数：
 * 利用递归，辗转相除法
 * 最小公倍数：
 * 两个数的乘机==两个数的最小公倍数*最大公约数
 * Created by Administrator on 2018/4/13.
 */
public class GcdAndLcm {
    // 求最大公约数  递归版
    public int get_gcd(int a, int b) {
        // 找到a,b最大值和最小值
        int max = a > b ? a : b;
        int min = a < b ? a : b;

        if (max % min == 0) {
            return min;
        } else {
            return get_gcd(min,max%min);
        }
    }

    // 求最大公约数  循环版
    public int get_gcd2(int a, int b) {
        if(a<b){
            // 交换a b
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (a % b == 0) {
            return b;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;


    }

    // 求最小公倍数

    public int get_lcm(int a, int b) {
        return (a*b)/get_gcd(a,b);
    }

    public static void main(String[] args) {
        GcdAndLcm gcdAndLcm = new GcdAndLcm();

        System.out.println(gcdAndLcm.get_gcd2(10,15));
        System.out.println(gcdAndLcm.get_lcm(9,15));
    }

}
