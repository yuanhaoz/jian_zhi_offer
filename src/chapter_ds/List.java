package chapter_ds;

import bean.ListNode;

import java.util.Stack;

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
public class List {

    /**
     * 以 k 个节点为段，反转单链表。
     * Reverse Nodes in k_Group，Leetcode上的算法题，第6题的高级变种
     * @param head 链表头结点
     * @param k 每k个节点反转
     * @return 反转后的链表头
     */
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

    /**
     * 以 k 个节点为段，反转单链表。
     * Reverse Nodes in k_Group，Leetcode上的算法题，第6题的高级变种
     * @param head 链表头结点
     * @param k 每k个节点反转
     * @return 反转后的链表头
     */
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
     * @param head 链表头结点
     * @return 链表中节点的个数
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

    /**
     * 3、查找单链表中的倒数第k个结点（剑指offer，题15）
     * 这里需要声明两个指针：即两个结点型的变量first和second，首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，
     * 此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，
     * 此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
     *
     * 考虑k=0和k大于链表长度的情况
     * @param head 链表头结点
     * @param k 倒数第k
     * @return 倒数第k个节点
     */
    public static ListNode findLastNode(ListNode head, int k){
        if (head == null || k <= 0) { // 输入异常
            throw new RuntimeException("输入参数格式不对...");
        }
        ListNode first = head; // 两个指针
        ListNode second = head;
        for (int i = 0; i < k - 1; i++) {
            second = second.next;
            if (second == null) { // 说明k的值大于链表的长度
                throw new RuntimeException("k越界");
            }
        }
        // 两个指针同时移动，second到达尾节点时，first是倒数第k个节点
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    /**
     * 4、查找单链表中的中间结点：
     * 同样，面试官不允许你算出链表的长度，该怎么做呢？
     * 思路：和上面的第2节一样，也是设置两个指针first和second，只不过这里是，两个指针同时向前走，
     * second指针每次走两步，first指针每次走一步，直到second指针走到最后一个结点时，
     * 此时first指针所指的结点就是中间结点。
     * 注意链表为空，链表结点个数为1和2的情况。时间复杂度为O（n）。
     *
     * 上方代码中，当n为偶数时，得到的中间结点是第n/2个结点。比如链表有6个节点时，得到的是第3个节点。
     * @param head 链表头结点
     * @return 中间节点
     */
    public static ListNode findMidNode(ListNode head){
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    /**
     * 5、合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
     *  这道题经常被各公司考察。例如：链表1：1->2->3->4    链表2：2->3->4->5    合并后：1->2->2->3->3->4->4->5
     *  解题思路：挨着比较链表1和链表2。这个类似于归并排序。尤其要注意两个链表都为空、和其中一个为空的情况。
     *  只需要O(1)的空间。时间复杂度为O (max(len1,len2))
     * @param head1 链表1头结点
     * @param head2 链表2头结点
     * @return 合并后的链表头结点
     */
    public static ListNode mergeLinkList(ListNode head1, ListNode head2) {
        // 第一个链表为空
        if (head1 == null) {
            return head2;
        }
        // 第二个链表为空
        if (head2 == null) {
            return head1;
        }
        // 设置链表头结点
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) { // 链表1的元素小于链表2的元素
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        // 链表1没有遍历结束
        if (head1 != null) {
            temp.next = head1;
        }
        // 链表2没有遍历结束
        if (head2 != null) {
            temp.next = head2;
        }
        return head.next; // 返回空节点的下一个节点
    }

    /**
     * 6、单链表的反转：【出现频率最高】（不使用额外的空间）
     * 例如链表：1->2->3->4     反转之后：4->3->2->1
     * 思路：从头到尾遍历原链表，每遍历一个结点，将其摘下放在新链表的最前端。
     * 注意链表为空和只有一个结点的情况。时间复杂度为O（n）
     * @param head 链表头结点
     * @return 链表反转后的头结点
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null; // 保存链表新表头
        ListNode current = head; // 保存当前链表的遍历节点
        while (current != null) {
            ListNode next = current.next; // 保存当前节点的下一个节点
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    /**
     * 7、从尾到头打印单链表
     * 用递归实现，但有个问题：当链表很长的时候，就会导致方法调用的层级很深，有可能造成栈溢出。
     * 注意链表为空的情况。时间复杂度为O（n）
     * @param head 链表头结点
     */
    public static void reversePrint(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.print(head.val + "->");
    }

    /**
     * 7、从尾到头打印单链表
     * 对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。
     * 显式用栈，是基于循环实现的，代码的鲁棒性要更好一些。
     * 注意链表为空的情况。时间复杂度为O（n）
     * @param head 链表头结点
     */
    public static void reversePrintByStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) { // 将链表元素压入栈中
            stack.add(head);
            head = head.next;
        }
        while (!stack.isEmpty()) { // 将链表元素出栈打印
            System.out.print(stack.pop().val + "->");
        }
    }

    /**
     * 8、判断单链表是否有环：
     * 这里也是用到两个指针，如果一个链表有环，那么用一个指针去遍历，是永远走不到头的。
     * 因此，我们用两个指针去遍历：first指针每次走一步，second指针每次走两步，
     * 如果first指针和second指针相遇，说明有环。时间复杂度为O (n)。
     * @param head 链表头结点
     * @return 是否存在环
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head; // 每次移动一步
        ListNode second = head; // 每次移动两步
        while (second != null && second.next != null) { // 判断空指针
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    /**
     * 9、取出有环链表中，环的长度：从开始到相遇处first走的步数
     * @param head 链表头结点
     * @return 环的长度
     */
    public static int getCycleLength(ListNode head){
        if (head == null || head.next == null) {
            return 0;
        }
        int length = 0; // 环的长度
        ListNode first = head; // 每次移动一步
        ListNode second = head; // 每次移动两步
        while (second != null && second.next != null) { // 判断空指针
            first = first.next;
            second = second.next.next;
            length++;
            if (first == second) {
                return length;
            }
        }
        return 0;
    }

    /**
     * 10、单链表中，取出环的起始点：从相遇点开始，设置一个节点从头开始，然后最终相遇的节点就是环的起始点。
     * @param head 链表头结点
     * @return 链表中环的起始节点
     */
    public static ListNode getCycleStart(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head; // 每次移动一步
        ListNode second = head; // 每次移动两步
        while (second != null && second.next != null) { // 判断空指针
            first = first.next;
            second = second.next.next;
            if (first == second) {
                ListNode temp = head;
                while (temp != second) {
                    temp = temp.next;
                    second = second.next;
                }
                return second;
            }
        }
        return null;
    }

    /**
     * 11、判断两个单链表相交的第一个交点。 剑指offer，题37。
     * 先遍历两个链表得到长度差，让长的链表先走长度差步，然后再同时走相遇的第一个节点就是返回结果。
     * 时间复杂度为：O(m+n)
     * @param head1 链表1头结点
     * @param head2 链表2头结点
     * @return 相交的第一个节点
     */
    public static ListNode meetNode(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        int diff = Math.abs(len1 - len2);
        ListNode longHead = head1;
        ListNode shortHead = head2;
        if (len1 < len2) {
            longHead = head2;
            shortHead = head1;
        }
        for (int i = 0; i < diff; i++) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        head.next = a;
        a.next = b;
        b.next = c;
//		System.out.println(getLength(head));
//		System.out.println(findLastNode(head, 1).val);
//		System.out.println(findLastNode(head, 1).val);
//		System.out.println(findMidNode(head).val);
//		ListNode d = new ListNode(3);
//		c.next = d;
//		System.out.println(findMidNode(head).val);

//        ListNode head1 = new ListNode(2);
//        ListNode a1 = new ListNode(3);
//        ListNode b1 = new ListNode(4);
//        ListNode c1 = new ListNode(5);
//		head1.next = a1;
//		a1.next = b1;
//		b1.next = c1;
//        ListNode merge = mergeLinkList(head1, head);
//		System.out.println("-------------链表合并--------------");
//		while(merge != null){
//			System.out.print(merge.val + "->");
//			merge = merge.next;
//		}

//        ListNode reverse = reverseList(head);
//		System.out.println("-------------链表反转--------------");
//		while(reverse != null){
//			System.out.print(reverse.val + "->");
//			reverse = reverse.next;
//		}

//		System.out.println("------------链表反转：递归---------------");
//		reversePrint(head);
//		System.out.println("------------链表反转：栈---------------");
//		reversePrintByStack(head);

//        System.out.println("------------链表环---------------");
//		System.out.println(hasCycle(head));
//		c.next = head;
//		System.out.println("是否存在环：" + hasCycle(head));
//		System.out.println("环的长度是：" + getCycleLength(head));
//		System.out.println("环的起始节点是：" + getCycleStart(head).val);

        ListNode head4 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        head4.next = a4;
        a4.next = b;
        System.out.println(meetNode(head, head4).val);
    }

}
