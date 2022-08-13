/*
 * https://atcoder.jp/contests/dp/tasks/dp_g
 * In this question you are given a not rooted BT and you need to tell the width of the BT.
 * In this we used the concepts of dp on trees.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DiameterNonRooted {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static int[] dp;
    static int fun(int i,ArrayList<ArrayList<Integer>> graph){
        if(dp[i] != -1) return dp[i];
        int maxValue = 0;
        boolean leaf = true;
        for(int neighbour : graph.get(i)){
            leaf = false;
            maxValue = Math.max(maxValue, fun(neighbour,graph));
        }

        return dp[i] = (leaf) ? 0 : 1+maxValue;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)  graph.add(new ArrayList<Integer>());

        dp = new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<m;i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            graph.get(u).add(v);
        }
        int result = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            result = Math.max(result, fun(i,graph));
        }
        System.out.println("Longest path is "+result);
        scan.close();
    }
    

}

