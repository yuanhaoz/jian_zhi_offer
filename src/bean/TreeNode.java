package bean;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 定义二叉树结构
 * Created by 18710 on 2017/8/9.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public void traversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.print(node.val + " ");
        }

    }
}
