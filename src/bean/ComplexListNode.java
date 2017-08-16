package bean;

/**
 * 复杂链表：
 * 一个指针指向下一个元素的位置，另外一个指针指向链表随意的一个元素或者为空
 *
 * Created by 18710 on 2017/8/16.
 */
public class ComplexListNode {

    public int val;
    public ComplexListNode next;
    public ComplexListNode sibling;

    public ComplexListNode(int val){
        this.val = val;
        next = null;
        sibling = null;
    }

}
