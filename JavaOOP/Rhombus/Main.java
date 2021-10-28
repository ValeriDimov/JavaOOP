package Rhombus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Rhombus rhombus = new Rhombus(n);

        rhombus.printRhombus(n);

//        System.out.println(rhombus.printTop(n));
//        System.out.println(rhombus.printMiddle(n));
//        System.out.println(rhombus.printBottom(n));

//        printTop(n);
//        printMiddle(n);
//        printBottom(n);
    }

//    private static void printTop(int n) {
//        for (int r = 1; r < n; r++) {
//            for (int c = 0; c < n - r; c++) {
//                System.out.print(" ");
//            }
//            for (int cS = n - r; cS < n; cS++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//
//        }
//    }

//    private static void printMiddle(int n) {
//        for (int i = 1; i <= n; i++) {
//            System.out.print("* ");
//        }
//        System.out.println();
//    }

//    private static void printBottom(int n) {
//        for (int r = n - 1; r >= 1; r--) {
//            for (int c = 0; c < n - r; c++) {
//                System.out.print(" ");
//            }
//            for (int cS = n - r; cS < n; cS++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }

}
