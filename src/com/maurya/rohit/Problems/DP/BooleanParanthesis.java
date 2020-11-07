package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class BooleanParanthesis {


    public static int countParanthesis(String a){

        char[] expression = a.toCharArray();
        // Number of boolean symbols.
        final int N = a.length()/2 + 1;
        int[][] T = new int[N+1][N+1];       // count of true.
        int[][] F = new int[N+1][N+1];       //count of false

        // fill base cases.

        // one length expression.
        // ith symbol idx = (i-1)*2;
        for (int i=1; i<=N; i++) T[i][i] = expression[(i-1)*2] == 'T' ? 1 : 0;

        for (int i=1; i<=N; i++) F[i][i] = expression[(i-1)*2] == 'F' ? 1 : 0;


//
//        // two length expression.
//        // A ? B
//        for (int i=1; i<=N-1; i++) {
//            char A = expression[(i-1)*2];
//            char B = expression[(i-1)*2 + 2];
//            char op = expression[(i-1)*2 + 1];
//            if(A=='T' && B=='T'){
//                dp[i][i+1] =  (op== '^') ? 0 : 1;
//            }
//            else if(A=='F' && B=='F'){
//                dp[i][i+1] = 0;
//            } else {
//                dp[i][i+1] = (op=='&') ? 0:1;
//            }
//        }

        // fill for 3 or more length expression.
        for (int l =2; l<=N; l++){
            for (int i=1; i<=N-l+1; i++){
                int j = i+l-1;
                for (int k=i; k<j; k++){
                    char op = expression[(k-1)*2 + 1];
                    // total 1 to k -> sum of T & F.
                    int total1 = T[i][k] + F[i][k];

                    // total k+1 to j.
                    int total2 = T[k+1][j] + F[k+1][j];

                    if(op=='&'){
                        T[i][j] += T[i][k] * T[k+1][j];
                        F[i][j] += total1*total2 - T[i][k]*T[k+1][j];
                    }
                    else if(op=='|'){
                        F[i][j] += F[i][k]*F[k+1][j];
                        T[i][j] += total1*total2 - F[i][k]*F[k+1][j];
                    }
                    else {
                        // XOR case.
                        T[i][j] += T[i][k]*F[k+1][j] + F[i][k]*T[k+1][j];
                        F[i][j] += T[i][k]*T[k+1][j] + F[i][k]*F[k+1][j];
                    }
                }
            }
        }
        return T[1][N];

    }

    public static void main(String[] args) {
       // System.out.println(countParanthesis("T|T&F^T"));
        Scanner scanner= new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            scanner.nextInt();
            String s = scanner.next();
            System.out.println(countParanthesis(s));
        }
    }
}
