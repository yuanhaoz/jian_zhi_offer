package chapter3;

import bean.TreeNode;

/**
 * 面试题18：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 *
 * 思路：
 * 1. 分成两步：第一步在树A中找到和B的根节点的值一样的节点R，
 * 第二步再判断树A中以R为根节点的子树是不是包含和树B一样的结构。
 *
 * Created by 18710 on 2017/8/14.
 */
public class T18HasSubtree {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
     * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的结点都找完为止。
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     * @return true：树B是树A的子结构，false：树B是不树A的子结构
     */
    public static boolean hasSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) { // 如果两个节点值相等，判断是否含有相同子结构
                result = isSubTree(root1, root2);
            }
            if (!result) { // 不相等的时候遍历左节点并判断
                result = hasSubTree(root1.left, root2);
            }
            if (!result) { // 不相等的时候遍历右节点并判断
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * 判断是否子结构
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     * @return true：树B是树A的子结构，false：树B是不树A的子结构
     */
    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) { // 需要比较节点为空 （必须先判断root2是否为空，再判断root1是否为空）
            return true;
        }
        if (root1 == null) { // 左节点为空时不是子结构
            return false;
        }
        if (root1.val != root2.val) { // 节点值不同说明不是子结构
            return false;
        }
        // 递归比较左右子节点
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));
    }

}
