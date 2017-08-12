package chapter3;

import bean.ListNode;

/**
 * 面试题16：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 思路：
 * 1. 设置一个新的头结点，每次先保存当前处理节点的下一个结点信息，
 * 然后让当前节点指向新的头结点，然后让新的头结点为当前节点，最后使得当前节点为保存的下一个结点。
 *
 * 注意：（关键之处，代码的鲁棒性）
 * 1. 链表为空和只有一个元素的情况
 * Created by 18710 on 2017/8/12.
 */
public class T16ReverseList {
    /**
     * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
     * @param head 链表的头结点
     * @return 反转后的链表的头结点
     */
    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = reverseHead;
            reverseHead = temp;
            temp = next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//		ListNode l5 = null;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode.printList(reverseList(l1));
    }
}
