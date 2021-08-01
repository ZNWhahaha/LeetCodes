package test;

import java.util.*;

//你的省份有多个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，那么它就会装满水，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水

//给你一个整数数组 rains ，其中：
//
//rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
//
//rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水

//返回一个数组 ans ，满足：
//
//ans.length == rains.length
//
//如果 rains[i] > 0 ，那么ans[i] == -1 。
//
//如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
//
//如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组


public class aiqiyi_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        s:while (in.hasNextLine()){
            String tmp = in.nextLine();
            tmp = tmp.substring(1,tmp.length()-1);
            System.out.println(tmp);
            char[] rains = tmp.toCharArray();
            int[] result = new int[rains.length];
            int loads = 0;
            for (char c : rains){
                loads = Math.max(loads,c-'0');
            }
            int[] load = new int[loads];

            for (int i = 0; i < rains.length; i++) {
                if (rains[i]-'0' >0){
                    result[i] = -1;
                    load[rains[i]] += 1;
                }
            }

            int nu = 0;

            for (int i : result){
                if (i != -1)
                    nu += 1;
            }

            int[] tree = new int[nu];

            for (int i = 0; i < tree.length; i++) {
                    
            }


            for (int i = 0; i < load.length; i++) {
                if (load[i] > 1){
                    System.out.println("[]");
                    continue s;
                }
            }

            System.out.print('[');
            for (int i : result)
                System.out.print(i+',');
            for (int i = 0; i < result.length-1; i++) {
                System.out.print(result[i]+',');
            }
            System.out.println(result[result.length-1]+']');
        }
    }

    public static void travel(int[] result,int[] load, int index){
        if (index == load.length)
            return;

        for (int i = index; i < result.length; i++) {
            if (result[i] == -1)
                continue;


        }
    }

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;

        //存储可以 rains[i] == 0 的索引位置（这里使用 TreeSet 是为了方便查找 适合 排空湖泊 的索引天数）
        TreeSet<Integer> set = new TreeSet<>();

        //记录某个湖泊最后一次下雨的日期
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[len];

        for(int i = 0; i < len; i++){
            if(rains[i] == 0){
                set.add(i);
            }else{
                //如果之前下过雨
                if(map.containsKey(rains[i])){
                    //获取上一次下雨的时间
                    int preIdx = map.get(rains[i]);
                    //获取比 preIdx 大并且离 preIdx 最近的日期来抽空湖泊
                    Integer zeroIdx = set.higher(preIdx);
                    if(zeroIdx == null){
                        return new int[0];
                    }
                    res[zeroIdx] = rains[i];
                    set.remove(zeroIdx);
                }
                map.put(rains[i], i);
                res[i] = -1;
            }
        }
        for(int i = 0; i < len; i++){
            if(res[i] == 0){
                res[i] = 1;
            }
        }
        return res;
    }
}
