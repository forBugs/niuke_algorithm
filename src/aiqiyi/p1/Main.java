package aiqiyi.p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String id = scanner.next();


        String firstPart = id.substring(0, 3);
        String secondPart = id.substring(3);

        int firstCount = getBitsSum(firstPart);
        int secondCount = getBitsSum(secondPart);
        if (firstCount== secondCount) {
            System.out.println(0);
            return ;
        }


        int minNum = Math.min(getBitsMin(firstPart), getBitsMin(secondPart));
        int minTwoNum = Math.min(getBitsSecondMin(firstPart), getBitsSecondMin(secondPart));
        if (Math.abs(firstCount - secondCount) <= 9 && Math.abs(firstCount - secondCount) <= (9-minNum)) {
            System.out.println(1);
        } else if ( Math.abs(firstCount - secondCount) <= 18 && Math.abs(firstCount - secondCount) <= (18 - minTwoNum)) {
            System.out.println(2);

        } else {
            System.out.println(3);
        }



    }

    public static int getBitsSum(String num) {

        int firstBit = Integer.valueOf(num.substring(0, 1));
        int secondBit = Integer.valueOf(num.substring(1, 2));
        int thirdBit = Integer.valueOf(num.substring(2, 3));

        return firstBit + secondBit + thirdBit;
    }

    public static int getBitsMin(String num) {

        int firstBit = Integer.valueOf(num.substring(0, 1));
        int secondBit = Integer.valueOf(num.substring(1, 2));
        int thirdBit = Integer.valueOf(num.substring(2, 3));

        return Math.min(Math.min(firstBit,secondBit),thirdBit);
    }


    public static int getBitsSecondMin(String num) {

        int firstBit = Integer.valueOf(num.substring(0, 1));
        int secondBit = Integer.valueOf(num.substring(1, 2));
        int thirdBit = Integer.valueOf(num.substring(2, 3));

        return (firstBit + secondBit + thirdBit) - Math.max(Math.max(firstBit, secondBit), thirdBit);
    }

}
