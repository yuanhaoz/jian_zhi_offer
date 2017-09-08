package chapter_ds;

import bean.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  轻松搞定面试中的二叉树题目
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  算法大全（3） 二叉树
 *
 * 一定要能熟练地写出所有问题的递归和非递归做法！
 *
 * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）
 * 2. 求二叉树的深度: getDepthRec（递归），getDepth
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！）
 * 5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL
 * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel
 * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf
 * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec
 * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec
 * 10.1 判断两个树是否互相镜像：isMirrorRec
 * 11. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec
 * 14. 判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
 *
 * Created by 18710 on 2017/9/6.
 */
public class BinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        root.left = t2;
        root.right = t3;
        t3.left = t4;
        t3.right = t5;

//        TreeNode t6 = new TreeNode(6);
//        t5.left = t6;

		System.out.println("（递归）树的节点数为：" + getNodeNumRec(root));
		System.out.println("（非递归）树的节点数为：" + getNodeNum(root));
        System.out.println("（递归）树的高度为：" + getDepthRec(root));
        System.out.println("（非递归）树的高度为：" + getDepth(root));
        System.out.println("（递归）树的前序遍历为：");
        preorderTraversalRec(root);
        System.out.println();
        System.out.println("（非递归）树的前序遍历为：");
        preorderTraversal(root);
        System.out.println();
        System.out.println("（非递归）树的前序遍历为：（方法2）");
        preorderTraversal2(root);
        System.out.println();
        System.out.println("（递归）树的中序遍历为：");
        inorderTraversalRec(root);
        System.out.println();
        System.out.println("（非递归）树的中序遍历为：");
        inorderTraversal(root);
        System.out.println();
        System.out.println("（递归）树的后序遍历为：");
        postorderTraversalRec(root);
        System.out.println();
        System.out.println("（非递归）树的后序遍历为：");
        postorderTraversal(root);
        System.out.println();
        System.out.println("树的层次遍历为：");
        levelTraversal(root);
        System.out.println();
        System.out.println("该树第3层节点数为：" + getNodeNumKthLevelRec(root, 3));
        System.out.println("（递归）该树叶子节点数为：" + getNodeNumLeafRec(root));
        System.out.println("（非递归）该树叶子节点数为：" + getNodeNumLeafRec(root));

        TreeNode root1 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t33 = new TreeNode(3);
        TreeNode t44 = new TreeNode(4);
        TreeNode t55 = new TreeNode(5);
        root1.left = t22;
        root1.right = t33;
        t33.left = t44;
        t33.right = t55;
        System.out.println("（递归）两棵树是否相同：" + isSameRec(root, root1));
        System.out.println("（非递归）两棵树是否相同：" + isSame(root, root1));
        System.out.println("（递归）树是否是AVL平衡二叉树：" + isAVLTree(root));

        System.out.println("（递归）二叉树的镜像是：");
        mirrorRec(root);
        levelTraversal(root);
        System.out.println("（非递归）二叉树的镜像是：");
        mirror(root);
    }

    /**
     * 求二叉树中的节点个数递归解法： O(n)
     * （1）如果二叉树为空，节点个数为0
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     * @param root 树根节点
     * @return 节点个数
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    /**
     * 求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal，
     *  即用一个Queue，在Java里面可以用LinkedList来模拟
     * @param root 树根节点
     * @return 节点个数
     */
    public static int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue =  new LinkedList<>(); // 用队列保存树节点，先进先出
        queue.add(root);
        int count = 1; // 节点数量
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll(); // 每次从对列中删除节点，并返回该节点信息
            if (temp.left != null) { // 添加左子孩子到对列
                queue.add(temp.left);
                count++;
            }
            if (temp.right != null) { // 添加右子孩子到对列
                queue.add(temp.right);
                count++;
            }
        }
        return count;
    }

    /**
     * 求二叉树的深度（高度） 递归解法： O(n)
     * （1）如果二叉树为空，二叉树的深度为0
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     * @param root 树根节点
     * @return 树的深度
     */
    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    /**
     * 求二叉树的深度（高度）迭代解法：O(n)
     * 基本思想同LevelOrderTraversal，还是用一个Queue
     * @param root 树根节点
     * @return 树的深度
     */
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentLevelCount = 1; // 当前层的节点数量
        int nextLevelCount = 0; // 下一层节点数量
        int depth = 0; // 树的深度

        Queue<TreeNode> queue = new LinkedList<>(); // 对列保存树节点
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(); // 移除节点
            currentLevelCount--; // 当前层节点数减1
            if (temp.left != null) { // 添加左节点并更新下一层节点个数
                queue.add(temp.left);
                nextLevelCount++;
            }
            if (temp.right != null) { // 添加右节点并更新下一层节点个数
                queue.add(temp.right);
                nextLevelCount++;
            }
            if (currentLevelCount == 0) { // 如果是该层的最后一个节点，树的深度加1
                depth++;
                currentLevelCount = nextLevelCount; // 更新当前层节点数量并且重置下一层节点数量
                nextLevelCount = 0;
            }
        }
        return depth;
    }

    /**
     * 前序遍历，中序遍历，后序遍历
     * 前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     * @param root 树根节点
     */
    public static void preorderTraversalRec(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    /**
     * 前序遍历迭代解法：用一个辅助stack，总是把右孩子放进栈
     * @param root 树根节点
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈保存树节点
        stack.add(root);
        while (!stack.isEmpty()) { // 栈不为空
            TreeNode temp = stack.pop();
            System.out.print(temp.val + "->"); // 先根节点，因为是前序遍历
            if (temp.right != null) { // 先添加右孩子，因为栈是先进后出
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
    }

    /**
     * 前序迭代解法：用一个辅助stack，先把左子节点遍历完
     * @param root 树根节点
     */
    public static void preorderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { // 不断将左子节点入栈，直到cur为空
                stack.push(cur);
                System.out.print(cur.val + "->"); // 前序遍历，先打印当前节点在打印左子节点，然后再把右子节点加到栈中
                cur = cur.left;
            }
            if (!stack.isEmpty()) { // 栈不为空，弹出栈元素
                cur = stack.pop(); // 此时弹出最左边的节点
                cur = cur.right; // 令当前节点为右子节点
            }
        }
    }

    /**
     * 中序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     * @param root 根节点
     */
    public static void inorderTraversalRec(TreeNode root){
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + "->");
        inorderTraversalRec(root.right);
    }

    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内，
     * 然后输出栈顶元素，再处理栈顶元素的右子树
     * http://www.youtube.com/watch?v=50v1sJkjxoc
     * 还有一种方法能不用递归和栈，基于线索二叉树的方法，较麻烦以后补上
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
     * @param root 树根节点
     */
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { // 不断将左子节点入栈，直到cur为空
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) { // 栈不为空，弹出栈元素
                cur = stack.pop(); // 此时弹出最左边的节点
                System.out.print(cur.val + "->"); // 中序遍历，先打印左子节点在打印当前节点，然后再把右子节点加到栈中
                cur = cur.right; // 令当前节点为右子节点
            }
        }
    }

    /**
     * 后序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     * @param root 根节点
     */
    public static void postorderTraversalRec(TreeNode root){
        if (root == null) {
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + "->");
    }

    /**
     * 后序遍历迭代解法：双栈法
     * @param root 根节点
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>(); // 保存树节点
        Stack<TreeNode> stack2 = new Stack<>(); // 保存后序遍历的结果
        stack1.add(root);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp); // 将弹出的元素加到stack2中
            if (temp.left != null) { // 左子节点先入栈
                stack1.push(temp.left);
            }
            if (temp.right != null) { // 右子节点后入栈
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + "->");
        }
    }

    /**
     * 分层遍历二叉树（按层次从上到下，从左到右）迭代
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：
     * 弹出一个节点，访问，若左子节点或右子节点不为空，将其压入队列
     * @param root 根节点
     */
    public static void levelTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 对列保存树节点
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + "->");
            if (temp.left != null) { // 添加左右子节点到对列
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    /**
     * 求二叉树第k层的节点个数         递归解法：
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     * 求以root为根的k层节点数目，等价于求以root左孩子为根的k-1层（因为少了root）节点数目  加上
     * 以root右孩子为根的k-1层（因为 少了root）节点数目
     * @param root 根节点
     * @param k 第k个节点
     * @return 第k层节点数
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getNodeNumKthLevelRec(root.left, k - 1) + getNodeNumKthLevelRec(root.right, k - 1);
    }

    /**
     * 求二叉树中叶子节点的个数（递归）
     * @param root 根节点
     * @return 叶子节点个数
     */
    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    /**
     * 求二叉树中叶子节点的个数（迭代）
     * 基于层次遍历 Level order traversal
     * @param root 根节点
     * @return 叶子节点个数
     */
    public static int getNodeNumLeaf(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leaf = 0; // 叶子节点个数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left == null && temp.right == null) { // 叶子节点
                leaf++;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return leaf;
    }

    /**
     * 判断两棵二叉树是否相同的树。
     * 递归解法：
     * （1）如果两棵二叉树都为空，返回真
     * （2）如果两棵二叉树一棵为空，另外一棵不为空，返回假
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
     * @param r1 二叉树1
     * @param r2 二叉树2
     * @return 是否相同
     */
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) { // 都是空
            return true;
        } else if (r1 == null || r2 == null) { // 有一个为空，一个不为空
            return false;
        }
        if (r1.val != r2.val) { // 两个不为空，但是值不相同
            return false;
        }
        return isSameRec(r1.left, r2.left) && isSameRec(r1.right, r2.right); // 递归遍历左右子节点
    }

    /**
     * 判断两棵二叉树是否相同的树（迭代）
     * @param r1 二叉树1
     * @param r2 二叉树2
     * @return 是否相同
     */
    public static boolean isSame(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null) { // 都是空
            return true;
        } else if (r1 == null || r2 == null) { // 有一个为空，一个不为空
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(r1);
        stack2.add(r2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode temp1 = stack1.pop();
            TreeNode temp2 = stack2.pop();
            if (temp1 == null && temp2 == null) { // 两个元素都为空，因为添加的时候没有对空节点做判断
                continue;
            } else if (temp1 != null && temp2 != null && temp1.val == temp2.val) {
                stack1.push(temp1.left); // 相等则添加左右子节点判断
                stack1.push(temp1.right);
                stack2.push(temp2.left);
                stack2.push(temp2.right);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断二叉树是不是平衡二叉树   递归解法：
     * （1）如果二叉树为空， 返回真
     * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
     * @param root 根节点
     * @return 是否二叉平衡树（AVL树）
     */
    public static boolean isAVLTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) { // 左右子树高度差大于1
            return false;
        }
        return isAVLTree(root.left) && isAVLTree(root.right); // 递归判断左右子树
    }

    /**
     * 求二叉树的镜像   递归解法：
     * （1）如果二叉树为空，返回空
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左右子树
     *
     * 1. 破坏原来的树，把原来的树改成其镜像
     *
     * @param root 根节点
     * @return 镜像二叉树的根节点
     */
    public static TreeNode mirrorRec(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = mirrorRec(root.right); // 递归镜像左右子树
        TreeNode right = mirrorRec(root.left);
        root.left = left; // 更新根节点的左右子树为镜像后的树
        root.right = right;
        return root;
    }

    /**
     * 求二叉树的镜像   递归解法：
     * （1）如果二叉树为空，返回空
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左右子树
     *
     * 2. 不能破坏原来的树，返回一个新的镜像树
     *
     * @param root 根节点
     * @return 镜像二叉树的根节点
     */
    public static TreeNode mirrorCopyRec(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val); // 创建新节点，然后界皇左右子树
        newRoot.left = mirrorCopyRec(root.right);
        newRoot.right = mirrorCopyRec(root.left);
        return newRoot;
    }

    /**
     * 3. 判断两个树是否互相镜像
     * @param r1 二叉树 1
     * @param r2 二叉树 2
     * @return 是否互相镜像
     */
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        // 递归比较r1的左子树的镜像是不是r2右子树
        // 和r1的右子树的镜像是不是r2的左子树
        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);
    }

    /**
     * 求二叉树的镜像   非递归解法：
     * （1）如果二叉树为空，返回空
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左右子树
     *
     * 1. 破坏原来的树，把原来的树改成其镜像
     *
     * @param root 树根节点
     */
    public static void mirror(TreeNode root) {
        if (root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            // 交换左右孩子
            TreeNode tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
    }

    /**
     * 求二叉树的镜像   非递归解法：
     * （1）如果二叉树为空，返回空
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左右子树
     *
     * 2. 不能破坏原来的树，返回一个新的镜像树
     *
     * @param root
     * @return
     */
    public static TreeNode mirrorCopy(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> newStack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode newRoot = new TreeNode(root.val);
        newStack.push(newRoot);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
                newCur.left = new TreeNode(cur.right.val);
                newStack.push(newCur.left);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                newCur.right = new TreeNode(cur.left.val);
                newStack.push(newCur.right);
            }
        }
        return newRoot;
    }
}
