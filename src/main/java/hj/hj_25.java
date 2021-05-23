package hj;

//输入描述:
//        ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限
//        输出描述:
//        ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
//        I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
//        按R<i>从小到大的顺序:
//        (1)先输出R<i>；
//        (2)再输出满足条件的I的个数；
//        (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
//        (4)最后再输出I。
//        附加条件：
//        (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
//        (2)如果没有满足条件的I，对应的R<i>不用输出
//        (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)

import java.util.*;

public class hj_25 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int i_len = in.nextInt();
            String[] i_nums = new String[i_len];
            for (int i = 0; i < i_len; i++) {
                i_nums[i] = in.next();
            }
            int r_len = in.nextInt();
            int[] r_num = new int[r_len];
            for (int i = 0; i < r_len; i++) {
                r_num[i] = in.nextInt();
            }
            Arrays.sort(r_num);
            String[] r_nums = new String[r_len];
            for (int i = 0; i < r_len; i++) {
                r_nums[i] = String.valueOf(r_num[i]);
            }
            StringBuilder sumNums = new StringBuilder();
            int allLen = 0;
            for (int i = 0; i < r_len; i++) {
                StringBuilder sb = new StringBuilder();
                if (i > 0 && r_nums[i].equals(r_nums[i-1]))
                    continue;
                int sameRnums = 0;

                for (int j = 0; j < i_len; j++) {
                    if (i_nums[j].contains(r_nums[i])){
                        sameRnums += 1;
                        sb.append(String.valueOf(j) + ' ').append(i_nums[j] + ' ');
                    }
                }
                if (sameRnums != 0){
                    sumNums.append(r_nums[i] + ' ').append(String.valueOf(sameRnums) + ' ').append(sb);
                    allLen += sameRnums * 2 + 2;
                }

            }
            System.out.println(String.valueOf(allLen) + ' ' + sumNums.substring(0,sumNums.length()-1));
        }
    }

}
