package chapter7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题50：树中两个节点的最低公共祖先
 *
 * 1. 如果树是二叉树，并且是二叉搜索树。因为二叉搜索树是排序过的，位于左子树的节点都比父节点小，而位于右子树的节点都比父节点大，
 * 我们只需要从树的根节点开始和两个输入的结点进行比较。如果当前节点的值比两个节点的值都大，那么最低的共同父节点一定是在当前节点的左子树中，
 * 于是下一次遍历当前节点的左子节点。如果当前节点的值比两个节点的值都小，那么最低公共父节点一定在当前节点的右子树中，于是下一次遍历当前
 * 节点的右子节点。这样在树中从上到下找到的第一个在两个输入节点的值之间的节点，就是最低的公共祖先。
 *
 * 2. 不是二叉搜索树，甚至不是二叉树，而是普通的树。如果树中的节点有指向父节点的指针，那么这个问题可以转换求两个链表的第一个公共节点。
 *
 * 3. 如果是普通的树且没有指向父节点的指针。从根节点开始遍历一棵树，每遍历到一个节点时，判断两个输入节点是不是在它的子树中。
 * 如果在子树中，则分别遍历它的所有子节点，并判断两个输入节点是不是在它们的子树中。这样从上到下一直找到第一个节点，它自己的子树中同时包含
 * 两个输入的节点而它的知己诶单却没有，那么该节点就是最低的公共祖先。（每次循环都要遍历到需要的节点，时间复杂度较高）
 *
 * 4. 用两个链表保存从根节点分别到两个节点的路径信息，这个路径的最后公共节点就是最低公共祖先。（前序遍历）
 *
 * Created by 18710 on 2017/8/31.
 */
public class T50GetLastCommonParent {

    /**
     * 树节点的定义，普通树
     */
    private static class TreeNode {
        int val;
        List<TreeNode> children = new LinkedList<>();

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    /**
     * 得到从根节点到目标节点的路径信息
     *
     * @param root   根节点
     * @param target 目标节点
     * @param path   路径信息
     */
    public static void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root); // 添加当前节点
        for (TreeNode treeNode : root.children) {
            if (treeNode == target) { // 当前节点为目标节点，将该节点加到路径中
                path.add(treeNode);
                return;
            } else {
                getNodePath(treeNode, target, path); // 得到节点的路径
            }
        }
        path.remove(path.size() - 1); // 现场还原
    }

    /**
     * 找到两个路径中的最后一个共同的结点
     *
     * @param p1 路径1
     * @param p2 路径2
     * @return 共同的结点，没有返回null
     */
    public static TreeNode getLastCommonNode(List<TreeNode> p1, List<TreeNode> p2) {
        Iterator<TreeNode> ite1 = p1.iterator();
        Iterator<TreeNode> ite2 = p2.iterator();
        TreeNode last = null;
        while (ite1.hasNext() && ite2.hasNext()) { // 有下一个节点
            TreeNode tmp = ite1.next();
            if (tmp == ite2.next()) { // 路径1的下一个节点和路径2的下一个节点相等就更新last值。直到最后一个值不相等
                last = tmp;
            }
        }
        return last;
    }

    /**
     * 找树中两个结点的最低公共祖先
     *
     * 每一次遍历时间复杂度是O(n)。得到的两条路径长度在最差的情况是O(n)，
     * 通常情况下两条路径的长度是O(logn)。
     *
     * @param root 树的根节点
     * @param p1   结点1
     * @param p2   结点2
     * @return 公共结点，没有返回null
     */
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode p1, TreeNode p2) {
        if (root == null || p1 == null || p2 == null) {
            return null;
        }
        List<TreeNode> path1 = new LinkedList<>();
        getNodePath(root, p1, path1);
        List<TreeNode> path2 = new LinkedList<>();
        getNodePath(root, p2, path2);
        return getLastCommonNode(path1, path2);
    }

    public static void main(String[] args) {
        test01();
        System.out.println("==========");
        test02();
        System.out.println("==========");
        test03();
    }


    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n6);
        n4.children.add(n7);

        n3.children.add(n5);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(getLastCommonParent(n1, n6, n3));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(getLastCommonParent(n1, n4, n5));
    }

    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(getLastCommonParent(n1, n5, n6));
    }

}