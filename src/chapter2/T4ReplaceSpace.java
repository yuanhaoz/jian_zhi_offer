package chapter2;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * Created by 18710 on 2017/9/6.
 */
public class T4ReplaceSpace {

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = replaceSpace(string, 12);
        System.out.println(new String(string, 0, length));


        char[] string1 = new char[50];
        string1[0] = 'a';
        string1[1] = 'e';
        string1[2] = 'v';
        string1[3] = 'c';
        string1[4] = 'r';
        string1[5] = 'e';
        string1[6] = 'b';
        string1[7] = 'b';
        string1[8] = 'a';
        string1[9] = 'b';
        string1[10] = ' ';
        string1[11] = 'q';

        int length1 = replaceSpace(string1, 12);
        System.out.println(new String(string1, 0, length1));
    }

    /**
     * 计算空格数量得到新字符串的长度，从后往前碰到空格替换成 " %20 "
     * @param string 要转换的字符数组
     * @param usedLength 字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public static int replaceSpace(char[] string, int usedLength) {
        if (string == null || string.length == 0) {
            return -1;
        }
        int whiteCount = 0; // 空格的数量
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }
        int targetLength = usedLength + 2 * whiteCount; // 新的字符数组长度
        int result = targetLength; // 新的字符数组长度
        usedLength--; // 长度减1，开始遍历数组
        targetLength--;
        while (usedLength >= 0 && usedLength < targetLength) { // 两个指针没有相遇
            if (string[usedLength] == ' ') { // 等于空格就替换成 %20
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // 不等于空格就保存原来的字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--; // 移动原数组指针
        }
        return result;
    }

}
