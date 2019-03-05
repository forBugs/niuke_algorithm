package p01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int k = scanner.nextInt();

            
        }


    }

    public static boolean isMulti(long l) {
        if (l % 3 == 0) {
            return true;
        }

        return false;
    }

    public static boolean isOverFlow(String s) {
        try {
            long l = Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
