package chapter_dp.behavior.iterator;

/**
 * 使用 NameRepository 来获取迭代器，并打印名字。
 * @author yuanhao
 * @date 2018/6/12 21:03
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext(); ) {
            String name = (String)iter.next();
            System.out.println("Name :" + name);
        }
    }

}
