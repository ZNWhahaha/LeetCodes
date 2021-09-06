package helpOthers;

public class Wangcd_tengxun_02 {
    private class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode solve(ListNode[] a){
        ListNode result = new ListNode(-1);
        ListNode[] cur = new ListNode[a.length];
        for (int i = 0; i < a.length; i++)
            cur[i] = a[i];
        int len = checkMaxLen(a);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < a.length; j++) {
                if (cur[j] != null){
                    result.next = cur[j];
                    cur[j] = cur[j].next;
                }
            }
        }
        return result.next;
    }
    public int checkMaxLen(ListNode[] ls){
        int result = 0;
        for (int i = 0; i < ls.length; i++) {
            int tmp = 0;
            while (ls[i] != null){
                tmp ++;
                ls[i] = ls[i].next;
            }
            result = Math.max(result,tmp);
        }
        return result;
    }
}
