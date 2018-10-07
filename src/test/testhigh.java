package test;

import java.util.Scanner;
public class testhigh {
    public static void main(String[] args){
        /* code */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] count = new int[n];
        while(m > 0){
            int test = in.nextInt();
            for(int i = 1; i <= n; i++){
                if(test == i){
                    count[i-1]++;
                }
            }
            m--;
        }
        int score = count[0];
        for(int i = 1; i < n; i++){
            if(count[i] < score){
                score = count[i];
            }
        }
        System.out.println(score);
    }
}