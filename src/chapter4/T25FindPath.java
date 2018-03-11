package chapter4;

import bean.TreeNode;

import java.util.Stack;

/**
 * 面试题25：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 思路：
 * 1. 当用前序遍历的方式访问某一节点时，我们把该节点添加到路径上，并累加该结点的值。
 * 如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数，则当前的路径符合要求，我们把它打印出来。
 * 如果当前节点不是叶节点，则继续访问它的子节点。当前节点访问结束后，递归函数将自动回到它的父节点。
 * 因此我们在函数退出之前要在路径上删除当前节点并减去当前节点的值，以确保返回父节点时路径刚好是从根节点到父节点的路径。
 * 我们不难看出保存路径的数据结构实际上是一个栈，因为路径要与递归调用状态一致，而递归的本质就是一个压栈和出栈的过程。
 *
 * Created by 18710 on 2017/8/16.
 */
public class T25FindPath {

    public static void findPath(TreeNode root, int expectedSum){
        if (root == null) {
            return ;
        }
        int curSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        findPath(root, expectedSum, stack, curSum);
    }

    public static void findPath(TreeNode root, int expectedSum, Stack<TreeNode> stack, int curSum){
        // 将当前节点加到路径中并更新路径和
        stack.add(root);
        curSum += root.val;
        boolean isLeaf = (root.left == null && root.right == null) ? true : false; // 是否叶节点
        if (isLeaf && curSum == expectedSum) { // 找到打印路径
            for (TreeNode t : stack) {
                System.out.print(t.val + " ");
            }
            System.out.println();
        }
        if (root.left != null) { // 递归左子树
            findPath(root.left, expectedSum, stack, curSum);
        }
        if (root.right != null) { // 递归右子树
            findPath(root.right, expectedSum, stack, curSum);
        }
        // 是叶节点，但是路径不等于目标路径
        curSum -= root.val;
        stack.pop();
    }

    public static void main(String[] args) {
        // 一条路径
        //	    8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11

		TreeNode root = new TreeNode(8);
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(11);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		findPath(root, 19);

        // 两条路径
        //	    10
        //    /    \
        //   5     12
        //  / \
        // 4   7
        root = new TreeNode(10);
        n1 = new TreeNode(5);
        n2 = new TreeNode(12);
        n3 = new TreeNode(4);
        n4 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        findPath(root, 22);
    }

}
