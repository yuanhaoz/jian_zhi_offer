package chapter6;

import bean.TreeNode;

/**
 * 面试题39：二叉树的深度
 * 题目1：输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路1：如果一棵树只有一个节点，它的深度为1.如果根节点只有左子树没有右子树，那么树的深度应该是其左子树的深度加1；同样如果根节点只有右子树
 * 没有左子树，那么树的深度就是右子树的深度加1.如果既有左子树又有右子树，那么该树的深度就是其左右子树深度的较大值再加1.
 *
 * 题目2：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
 * 思路2：
 * a.需要重复遍历结点多次的解法，简单但不足以打动面试官
 * 有了求二叉树的深度的经验之后再解决这个问题，我们很容易就能想到一个思路：在遍历树的每个结点的时候，调用函数TreeDepth得到它的左右子树的
 * 深度。如果每个结点的左右子树的深度相差都不超过1，按照定义它就是一棵平衡的二叉树。但是会导致某个结点被重复遍历多次，时间效率不高。
 * b.每个结点只遍历一次的解法，正是面试官喜欢的
 * 如果我们用后序遍历的方式遍历 二叉树的每一个结点，在遍历到一个节点之前我们就已经遍历了它的左右子树。只要在遍历每个结点的时候记录它的深度
 * （某一节点的深度等于它到叶节点的路径的长度），我们就可以一边遍历一边判断每个结点是不是平衡的。
 *
 * Created by 18710 on 2017/8/27.
 */
public class T39TreeDepth {

    /**
     * 二叉树的深度
     * @param root 根节点
     * @return 二叉树的深度
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) { // 叶子节点的子节点深度为0
            return 0;
        }
        int left = treeDepth(root.left); // 递归左子树深度
        int right = treeDepth(root.right); // 递归右子树深度
        return Math.max(left, right) + 1; // 左右子树中长度大的加1
    }

    /**
     * 题目2：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {  // 叶子节点的子节点是平衡的
            return true;
        }
        int diff = treeDepth(root.left) - treeDepth(root.right); // 左右子树高度差
        if (diff > 1 || diff < -1) { // 相差大于1就不是平衡二叉树
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right); // 递归判断左右子树
    }

    /**
     * 题目2：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public static boolean isBalanced2(TreeNode root) {
        int depth = 0;
        return isBalanced2(root, depth);
    }

    /**
     * 递归判断是否为平衡二叉树
     * 保存当前树节点的深度
     * 递归判断是否为平衡二叉树
     * @param root 树节点
     * @param depth 深度
     * @return 是否为平衡二叉树
     */
    public static boolean isBalanced2(TreeNode root, int depth) {
        if (root == null) { // 叶子节点的子节点深度为0
            depth = 0;
            return true;
        }
        int left = 0, right = 0; // 记录左右子节点的深度
        if (isBalanced2(root.left, left) && isBalanced2(root.right, right)) { // 如果左右子树都是平衡二叉树
            // 判断当前节点是否满足平衡二叉树的条件
            int diff = left - right; // 左右子树的深度
            if (diff <= 1 && diff >= -1) { // 左右子树高度差小于1，满足平衡二叉树的条件
                depth = 1 + Math.max(left, right); // 更新当前节点的树深度
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t7;
        System.out.println(treeDepth(root));
        System.out.println(isBalanced(root));
        System.out.println(isBalanced2(root));
    }


}
