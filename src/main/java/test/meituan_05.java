package test;

import LeetCode.code_543;

import java.util.Scanner;

public class meituan_05 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
            this.left = null;
            this.right = null;
        }
        TreeNode(int x,TreeNode left, TreeNode right){
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextLine();
        }
        int[] treerun = new int[m];
        for (int i = 0; i < m; i++) {
            treerun[i] = in.nextInt();
        }
    }

    private static void build(int[] nums){
        int n = nums.length;
        nums[n/2] = t;
        
    }
}
