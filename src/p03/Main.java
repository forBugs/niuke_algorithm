package p03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = scanner.next();
        String target = scanner.next();

        if (source.length() < target.length()) {
            System.out.println(-1);
        }

        for (int i = 0; i <= source.length() - target.length(); i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    continue;
                }
            }

            if (j == target.length()) {
                System.out.println(j);
                return ;
            }
        }
        System.out.println(-1);

    }
}
