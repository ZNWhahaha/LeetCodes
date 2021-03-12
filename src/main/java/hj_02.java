import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class hj_02 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        List<Character> list = new ArrayList();
        int count = 0;
        char a = (char)in.read();
        while(a != '\n'){
            list.add(a);
            a = (char)in.read();
        }
        char target = (char)in.read();
        for(char tmp :list){
            if(tmp == target || tmp == target+32 || tmp == target-32)
                count += 1;
        }
        System.out.println(count);
    }
}
