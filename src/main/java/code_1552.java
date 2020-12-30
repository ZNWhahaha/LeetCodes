import java.util.Arrays;

public class code_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1,
                right = position[position.length-1] - position[0];
        if(m == 2)
            return right;
        while (left<right-1){
            int mid = (right+left)>>1;
            if (check(position,m,mid)){
                left = mid ;
            }
            else {
                right = mid-1;
            }
        }
        return check(position,m,right)?right:left;
    }

    public boolean check(int[] pos,int m,int mid){
        int num = m -1,
                last = pos[0];
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - last >= mid){
                num --;
                last = pos[i];
            }
        }
        return  num<1;
    }
}
