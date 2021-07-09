package hj;

import java.util.Scanner;

public class hj_39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String mask = in.nextLine();
            Long subNet = ipToNumber(mask);
            String ipStr1 = in.nextLine();
            String ipStr2 = in.nextLine();
            if(subNet<=0 || subNet>=0XFFFFFFFFL || (((0XFFFFFFFFL ^ subNet )+1) | subNet) != subNet ) {
                System.out.println(1);
                continue;
            }
            long ip1 = ipToNumber(ipStr1);
            if(-1L == ip1){
                System.out.println(1);
                continue;
            }
            long ip2 = ipToNumber(ipStr2);
            if(-1L == ip2){
                System.out.println(1);
                continue;
            }
            System.out.println(( (ip1&subNet) == (ip2&subNet))?0:2);
        }
    }

    public static long ipToNumber(String ip){
        int tmp = 0,flag =1;
        long num = 0L;
        char[] arr = ip.toCharArray();
        for(char ch : arr){
            if(ch == '.'){
                num = num << 8 | tmp;
                flag=0;
                tmp = 0;
                continue;
            }
            if(flag >= 2){
                return -1L;
            }
            if(ch >= '0' && ch <= '9'){
                tmp = tmp * 10 + ch - '0';
                if(tmp>255){
                    flag = 3;
                    break;
                }else{
                    flag = 0;
                }
            }else{
                flag = 3;
                break;
            }
        }
        if(flag >= 2){
            return -1L;
        }
        num = num << 8 | tmp;
        return num ;
    }
}
