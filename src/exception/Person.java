package exception;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception{
        if (age>=100||age<=0) {
            //throw new RuntimeException("年龄不合法！");
            /*
                java中除了RuntimeException之外的其他异常throw抛出是编译器要求
                必须在方法上使用throw声明该异常的抛出
             */
            throw new IndexOutOfBoundsException("年龄不合法！");
        }
        this.age = age;
    }

}
