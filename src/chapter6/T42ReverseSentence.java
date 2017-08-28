package chapter6;

/**
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，单核单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串“I am a student.”，则输出“student. a am I”。
 * 思路：先对整个字符串翻转，然后在对每个单词翻转。
 *
 * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串“abcdefg”和数字2，该函数将返回左旋转2位后得到的结果“cdefgab”。
 * 思路：先翻转左半部分字符，后翻转右半部分字符，最终翻转整个字符串。
 *
 * 本题考点：
 * 考查知识迁移能力。当面试的时候遇到第二个问题，而之前我们做过“翻转句子中单词的顺序”这个题目，那么如果能够把多次翻转字符串
 * 的思路迁移过来，就能轻易地解决字符串左旋转的问题。
 * 考查对字符串的编程能力。
 *
 * Created by 18710 on 2017/8/28.
 */
public class T42ReverseSentence {

    public static void main(String[] args) {
        System.out.println(new String(reverseSentence("I am a student.")));
        System.out.println(new String(reverseSentence("Wonderful")));
//        System.out.println(new String(reverseSentence("")));
        System.out.println(new String(reverseSentence("    ")));

//        System.out.println("-------------------------");
//        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 2)));
//        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 1)));
//        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 6)));
//        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 7)));
//        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 0)));
    }

    /**
     * 交换str从start到end上每个字符，实现字符的反转
     * @param str 字符数组
     * @param start 交换起始位置
     * @param end 交换结束位置
     */
    public static void reverse(char[] str, int start, int end) {
        if (start > end) {
            return;
        }
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 字符串反转
     * 反转两次：第一次整个句子，第二次每个单词
     * @param sen 英文句子字符串
     * @return
     */
    public static char[] reverseSentence(String sen) {
        if (sen == null || sen.length() == 0) {
            return null;
        }
        char[] str = sen.toCharArray();
        reverse(str, 0 ,str.length - 1); // 第一次：反转整个句子
        int start = 0;
        int end = 0;
        while (start < str.length) { // 第二次：反转句子中的每个单词
            if (str[start] == ' ') { // 起始元素是空格往前移动
                start++;
                end++;
            } else if (end == str.length || str[end] == ' ') { // end为空或者是最后一个单词  则反转字符串，并且重新设置start和end
                reverse(str, start, end - 1);
                end++;
                start = end;
            } else { // 否则加1到空格位置
                end++;
            }
        }
        return str;
    }

    /**
     * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     *
     * 举例：先对前若干个元素反转，然后再对后若干个元素反转，最后对整个字符串反转
     * abcde -> baedc -> cdeab
     *
     * @param sen 输入字符串
     * @param num 前num个子串进行反转
     * @return 左旋后的字符串
     */
    public static char[] leftRotateString(String sen, int num) {
        if (sen == null || sen.length() == 0) {
            return null;
        }
        char[] str = sen.toCharArray();
        reverse(str, 0, num - 1); // 先反转前num个元素
        reverse(str, num, str.length - 1); // 后反转剩余的元素
        reverse(str, 0, str.length - 1); // 最后反转整个字符串
        return str;
    }

}
