# jian_zhi_offer
剑指虐我千百遍，我待剑指如初恋
第XXX次和剑指XXX，我真的是XXX了
## 题目列表

### 面试需要的基本知识
#### 编程语言 C++/C/Java
1. 赋值运算符函数
2. 实现Singleton模式（设计模式，参考）
#### 数据结构
3. 二维数组中的查找（数组）
4. 替换空格（不使用自带函数）（字符串）
5. 从尾到头打印链表（栈、递归）（链表）
6. 重建二叉树（前序、中序、后序遍历特点、递归）（树）<a href="src/chapter2/T6ReConstructBinaryTree.java"  target="_blank">前往</a>
7. 用两个栈实现对列（入队和出队）（栈和对列）<a href="src/chapter2/T7TwoStackToQueue.java"  target="_blank">前往</a>
#### 算法和数据操作
8. 旋转数组的最小数字（二分查找变种）（查找和排序）<a href="src/chapter2/T8MinNumberInRotateArray.java"  target="_blank">前往</a>
9. 斐波那契数列（递归和循环，递归解法的弊端）<a href="src/chapter2/T9Fibonacci.java"  target="_blank">前往</a>
10. 二进制中1的个数（位运算，减1求与的次数）<a href="src/chapter2/T10NumberOf1.java"  target="_blank">前往</a>

### 高质量的代码
#### 代码的完整性
11. 数值的整数次方（指数为负、数值为0等边界情况，递归解法）<a href="src/chapter3/T11Power.java"  target="_blank">前往</a>
12. 打印1到最大的n位数（数组模拟、全排列、递归）<a href="src/chapter3/T12PrintOneToNthDigits.java"  target="_blank">前往</a>
13. 在O(1)时间删除链表节点（链表空、删除节点为头节点、尾节点等）<a href="src/chapter3/T13DeleteNode.java"  target="_blank">前往</a>
14. 调整数组顺序使奇数位于偶数前面（两个指针）<a href="src/chapter3/T14ReorderOddEven.java"  target="_blank">前往</a>
#### 代码的鲁棒性
15. 链表中倒数第k个结点（链表空，k小于1，k大于链表长度，两个指针）<a href="src/chapter3/T15FindKthToTail.java"  target="_blank">前往</a>
16. 反转链表（链表空、只有一个节点）<a href="src/chapter3/T16ReverseList.java"  target="_blank">前往</a>
17. 合并两个排序的链表（某个链表为空）<a href="src/chapter3/T17MergeList.java"  target="_blank">前往</a>
18. 树的子结构（两步：根节点是否相等，是否是子结构）<a href="src/chapter3/T18HasSubtree.java"  target="_blank">前往</a>

### 解决面试题的思路
#### 面试官谈面试思路
19. 二叉树的镜像（递归，交换左右节点）<a href="src/chapter4/T19MirrorBinaryTree.java"  target="_blank">前往</a>
#### 画图让抽象问题形象化
20. 顺时针打印数组（循环条件，每圈打印数组的边界条件）<a href="src/chapter4/T20PrintMatrixClockWisely.java"  target="_blank">前往</a>
#### 举例让抽象问题具体化
21. 包含min函数的栈（利用辅助栈保存最小值）<a href="src/chapter4/T21MinStack.java"  target="_blank">前往</a>
22. 栈的压入、弹出序列（熟悉入栈和出栈的过程）<a href="src/chapter4/T22IsPopOrder.java"  target="_blank">前往</a>
23. 从上往下打印二叉树（对列，先进先出）<a href="src/chapter4/T23PrintFromTopToBottom.java"  target="_blank">前往</a>
24. 二叉搜索树的后序遍历序列（二叉搜索树：左子树比根节点小，右子树比根节点大。后序遍历数组的特点）<a href="src/chapter4/T24VerifySequenceOfBST.java"  target="_blank">前往</a>
25. 二叉树中和为某一值的路径（递归、栈、举例模拟计算过程）<a href="src/chapter4/T25FindPath.java"  target="_blank">前往</a>
#### 分解让复杂问题简单化（题目较为复杂，需要多加理解练习）
26. 复杂链表的复制（三步：复制节点的next，复制节点的sibling，拆分链表）<a href="src/chapter4/T26CloneNodes.java"  target="_blank">前往</a>
27. 二叉搜索树和双向链表（中序遍历、递归）<a href="src/chapter4/T27Convert.java"  target="_blank">前往</a>
28. 字符串的排列（全排列、递归、回溯）<a href="src/chapter4/T28Permutation.java"  target="_blank">前往</a>

### 优化时间和空间效率（题目较为复杂，需要多加理解练习）
#### 时间效率
29. 数组中出现次数超过一半的数字（快排能改变数组O(n)、快速解法O(n)）<a href="src/chapter5/T29MoreThanHalfNum.java"  target="_blank">前往</a>
30. 最小的k个数（快排能改变数组O(n)、最大堆和额外k空间O(nlogk)）<a href="src/chapter5/T30GetLeastNumbers.java"  target="_blank">前往</a>
31. 连续子数组的最大和（举例分析数组规律、动态规划）<a href="src/chapter5/T31FindGreatestSumOfSubArray.java"  target="_blank">前往</a>
32. 从1到n整数中1出现的次数（最高位为1、其余位1、递归）<a href="src/chapter5/T32NumberOf1Between1AndN.java"  target="_blank">前往</a>
33. 把数组排成最小的数（排序规则、快排、比较器）<a href="src/chapter5/T33PrintMinNumber.java"  target="_blank">前往</a>
#### 时间效率与空间效率的平衡
34. 丑数（数组保存已找到的数组、四个指针）<a href="src/chapter5/T34IsUgly.java"  target="_blank">前往</a>
35. 第一个只出现一次的字符（TreeMap保存字符及其出现次数、保证顺序）<a href="src/chapter5/T35FirstNotRepeatingChar.java"  target="_blank">前往</a>
36. 数组中的逆序对（归并排序、辅助数组保存排序元素）<a href="src/chapter5/T36InversePairs.java"  target="_blank">前往</a>
37. 两个链表的第一个公共节点（辅助栈、先求长度差然后同时走直到第一次相遇）<a href="src/chapter5/T37FindFirstCommonNode.java"  target="_blank">前往</a>

### 面试中的各项技能（题目较为复杂，需要多加理解练习）
#### 知识迁移能力
38. 数字在排序数组中出现的次数（二分查找得到第一个k的下标和最后一个k的下标）<a href="src/chapter6/T38GetNumberOfK.java"  target="_blank">前往</a>
39. 二叉树的深度+是否为平衡二叉树（递归遍历）<a href="src/chapter6/T39TreeDepth.java"  target="_blank">前往</a>
40. 数组中只出现一次的数字（异或、根据结果位1分成两个数组再求异或）<a href="src/chapter6/T40FindNumsAppearOnce.java"  target="_blank">前往</a>
41. 和为s的两个数字+和为s的连续正数序列（两个指针、首尾、首首）<a href="src/chapter6/T41FindNumbersWithSum.java"  target="_blank">前往</a>
42. 翻转单词顺序VS左旋转字符串（整体旋转、部分旋转）<a href="src/chapter6/T42ReverseSentence.java"  target="_blank">前往</a>
#### 抽象建模能力
43. n个骰子的点数 <a href="src/chapter6/.java"  target="_blank">前往</a>


### 面试参考算法题目
1. 最长公共子序列（动态规划）<a href="src/chapter_ds/LongestCommonSubsequence.java"  target="_blank">前往</a>
2. 最长公共子串（动态规划）<a href="src/chapter_ds/LongestCommonSubstring.java"  target="_blank">前往</a>
3. 链表相关的考题：单链表反转，是否有环等等 <a href="src/chapter_ds/LongestCommonSubstring.java"  target="_blank">前往</a>
