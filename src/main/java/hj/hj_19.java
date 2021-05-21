package hj;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class hj_19 {

//    开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> data = new LinkedHashMap<>();
        while (in.hasNextLine()) {
            String thing = in.nextLine();
            int index1 = thing.lastIndexOf(" ");
            int index2 = thing.lastIndexOf("\\");
            String key = (index1 - index2) > 16 ? thing.substring(index1-16): thing.substring(index2+1);
            data.put(key,data.getOrDefault(key,0)+1);
        }

        int count=0;
        for (String key_1:data.keySet()){
            count++;
            if(count>(data.size()-8)){
                System.out.println(key_1+" "+data.get(key_1));
            }
        }
        
    }
}
