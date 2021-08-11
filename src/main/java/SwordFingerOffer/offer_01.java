package SwordFingerOffer;

public class offer_01 {
    public int divide(int a, int b) {
         if (a == 0x80000000 && b == -1){
             return 0x7FFFFFFF;
         }

         int nag = 2;
         if (a > 0){
             nag --;
             a = -a;
         }
         if (b > 0){
             nag --;
             b = -b;
         }

         int result = 0;
         while (a <= b){
             int value = b;
             int quotient = 1;
             while (value > 0xc0000000 && value + value >= a){
                 quotient += quotient;
                 value += value;
             }
             result += quotient;
             a -= value;
         }
         return nag == 1 ? -result : result;
    }
}
