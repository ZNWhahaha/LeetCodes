import java.io.IOException;
import java.io.InputStream;

public class hj_10 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int length = in.available();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; i++) {
            char a = (char) in.read();
            if (sb.indexOf(String.valueOf(a)) == -1){
                num += 1;
                sb.append(a);
            }
        }
        System.out.println(num);

    }
}
