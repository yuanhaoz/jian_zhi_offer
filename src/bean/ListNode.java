package bean;

/**
 * Created by 18710 on 2017/8/10.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

}
