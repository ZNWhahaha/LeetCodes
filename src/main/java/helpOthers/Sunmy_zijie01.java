package helpOthers;

import java.util.Scanner;

public class Sunmy_zijie01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        int len = Integer.parseInt(tmp);
        String[] tree = new String[len];
        for (int i = 0; i < len; i++) {
            String t = in.next();
            if (t.equals("B") || t.equals("Y"))
                tree[i] = t;
        }
        if (tree.length != len){
            System.out.println(0);
            return;
        }
        if (tree.length == 1 && tree[0].equals("Y")){
            System.out.println(1);
            return;
        }
        if (tree.length == 1 && tree[0].equals("B")){
            System.out.println(0);
            return;
        }
        if (tree.length == 2){
            if (tree[0].equals("Y") && tree[1].equals("Y")){
                System.out.println(1);
                return;
            }
        }

        System.out.println(Tree(tree));
    }

    public static int Tree(String[] ratings) {
        int result = 0;
        if (ratings.length > 2){
            if (ratings[0].equals("Y") && ratings[1].equals("Y")){
                result++;
                ratings[0] = "B";
            }

            if (ratings[ratings.length-1].equals("Y") && ratings[ratings.length-2].equals("Y")){
                result++;
                ratings[ratings.length-1] = "B";
            }
        }
        else if (ratings.length == 2){
            if (ratings[0].equals("Y") && ratings[1].equals("Y"))
                result++;
        }
        for (int i = 1; i < ratings.length-1; i++) {
            if (ratings[i-1].equals("Y") && ratings[i+1].equals("Y") && !ratings[i].equals("B")) {
                ratings[i] = "B";
                result++;
            }
        }

        for (int i = ratings.length - 2; i > 0; i--) {
            if (ratings[i-1].equals("Y") && ratings[i+1].equals("Y") && !ratings[i].equals("B")) {
                ratings[i] = "B";
                result++;
            }
        }
        return result;
    }
}
