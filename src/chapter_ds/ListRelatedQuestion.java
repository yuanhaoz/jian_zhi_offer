package chapter_ds;

import bean.ListNode;

/**
 * 包含链表的以下内容：
 * 1、单链表的创建和遍历
 * 2、求单链表中节点的个数
 * 3、查找单链表中的倒数第k个结点（剑指offer，题15）
 * 4、查找单链表中的中间结点
 * 5、合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
 * 6、单链表的反转【出现频率最高】（剑指offer，题16）
 * 7、从尾到头打印单链表（剑指offer，题5）
 * 8、判断单链表是否有环
 * 9、取出有环链表中，环的长度
 * 10、单链表中，取出环的起始点（剑指offer，题56）。本题需利用上面的第8题和第9题。
 * 11、判断两个单链表相交的第一个交点（剑指offer，题37）
 * 12、以 k 个节点为段，反转单链表。Reverse Nodes in k_Group，Leetcode上的算法题，第6题的高级变种
 * Created by 18710 on 2017/8/24.
 */
public class ListRelatedQuestion {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode begin = head; // begin是当前段的开始
        ListNode end = begin; // end是下一段的开始
        ListNode newHead = begin; // 新的链表头
        ListNode prevNode = head; // 是上一段的最后一个节点
        int flag = 0; // 记录是第几段
        while (end != null) {
            int count = 1;
            while (end.next != null && count < k) {
                end = end.next;
                count++;
            }
            if (count == k) {
                if (flag == 0) {
                    newHead = end;
                }
                flag++;
                if (flag > 1) { // 不是第一段时就需要段与段之间的连接
                    prevNode.next = end; // 段和段之间进行连接
                    prevNode = begin;
                }
                end = end.next; // 下一段的开始
                ListNode prev = null;
                int i = 0;
                while (i < k) { // 链表反转
                    ListNode nextNode = begin.next;
                    begin.next = prev;
                    prev = begin;
                    begin = nextNode;
                    i++;
                }
                begin = end; // 下一段的开始
                prevNode.next = end; // 两个段之间连接，是为了避免下一段节点数不足k个，这不能使用44行代码来连接
            } else {
                break;
            }
        }
        return newHead;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = null;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    /**
     * 2、求单链表中节点的个数：
     * 注意检查链表是否为空。时间复杂度为O（n）。这个比较简单。
     * @return
     */
    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        ListNode current = head;
        while (current != null) { // 当前元素不为空
            length++;
            current = current.next;
        }
        return length;
    }
    
}
