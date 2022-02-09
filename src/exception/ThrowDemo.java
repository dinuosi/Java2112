package exception;

/**
 * 异常的抛出
 * throw关键字可以主动对外抛出一个异常。
 * 通常下列情况我们会主动抛出异常:
 * 1:当前代码片段出现了异常，但是该异常不应当在当前代码片段被解决时，可以将其抛出
 * 2:程序可以运行，但是不满足业务要求时可以对外抛出一个异常告知。(满足语法不满足业务)
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        /*
            当我们调用一个含有throws声明异常抛出的方法时，编译器要求我们必须处理该异常
            否则编译不通过。
            处理手段有两种:
            1:使用try-catch捕获其声明的异常
            2:在当前方法上继续使用throws声明该异常的抛出
         */
        try {
            p.setAge(10000);//满足语法，但是不满足业务需求。
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }


        System.out.println("此人年龄:"+p.getAge());
    }
}



