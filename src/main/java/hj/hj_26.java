package hj;

import java.util.Scanner;

public class hj_26 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        while (sca.hasNext())
        {
            String str = sca.nextLine();
            char [] cha = str.toCharArray();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i<26; i++)
            {
                char c = (char)(i + 'A');
                for (int j = 0; j<str.length(); j++)
                {
                    if (cha[j] == c || cha[j] == (char)(c + 32))
                        sb.append(cha[j]);
                }
            }

            for (int k = 0; k<str.length(); k++)
            {
                if (!(cha[k] >= 'A' && cha[k] <= 'Z' || cha[k] >= 'a' && cha[k] <= 'z'))
                    sb.insert(k, cha[k]);
            }
            System.out.println(sb.toString());
        }
    }
}
