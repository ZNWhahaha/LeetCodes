import java.util.Scanner;

public class hj_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long num = in.nextLong();
            for(int i=2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    System.out.print(i + " ");
                    num /= i;
                    i--;
                }
            }
            System.out.print(num + " ");
        }
    }
}
