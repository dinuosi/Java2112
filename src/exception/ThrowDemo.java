package exception;

/**
 * 异常的抛出
 * throw关键字可以主动对外抛出一个异常。
 * 通常下列情况我们会主动抛出异常：
 * 1：当前代码片段出现异常，但是该异常不应当在当前代码片段中被解决时，可以将其抛出
 * 程序可以运行，但是不满足业务要求时可以对外抛出一个异常告知。(满足语法不满足业务)
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setAge(100000);//满足语法不满足业务需求。
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p.getAge());
    }
}
