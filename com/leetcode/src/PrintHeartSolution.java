package com.leetcode.src;

public class PrintHeartSolution {
    private int[][] matrix = {
            {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}

    };
    public static void main(String[] args){
        printHeart();
        printNSpace(5); printN(1); printNSpace(3); printN(1);System.out.println();
        printNSpace(4); printN(2); printNSpace(3); printN(2);System.out.println();
        printNSpace(3); printN(4); printNSpace(1); printN(4);System.out.println();
        printNSpace(2); printN(3); printNSpace(0); printN(9);System.out.println();
        printNSpace(2); printN(4); printNSpace(0); printN(8);System.out.println();
        printNSpace(3); printN(3); printNSpace(0); printN(7);System.out.println();
        printNSpace(4); printN(2); printNSpace(0); printN(6);System.out.println();
        printNSpace(5); printN(1); printNSpace(0); printN(5);System.out.println();
        printNSpace(5); printN(0); printNSpace(2); printN(3);System.out.println();
        printNSpace(8); printN(0); printNSpace(0); printN(1);System.out.println();

    }

    private static void printN(int n){
        for(int i = 0; i < n; i++){
            System.out.print("*");
        }
    }

    private static void printNSpace(int n){
        for(int i = 0 ; i < n; i++){
            System.out.print(" ");
        }
    }

    private static void printHeart(){
        int n = 10;
        for (int i = -3*n/2; i <= n; i++) {
            for (int j = -3*n/2; j <= 3*n/2; j++) {
                // inside either diamond or two circles
                if ((Math.abs(i) + Math.abs(j) < n)
                        || ((-n/2-i) * (-n/2-i) + ( n/2-j) * ( n/2-j) <= n*n/2)
                        || ((-n/2-i) * (-n/2-i) + (-n/2-j) * (-n/2-j) <= n*n/2)) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
