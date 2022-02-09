package exception;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age)throws IllegalAgeException{
        if(age<0||age>100){
//            throw new RuntimeException("年龄不合法!");
            /*
                java中除了RuntimeException之外的其他异常throw抛出是编译器要求
                必须在方法上使用throws声明该异常的抛出
             */
            //ps:虽然使用try-catch也能保证不报错，但是这里没意义!
//            throw new Exception("年龄不合法!");

            throw new IllegalAgeException("年龄超过了范围:"+age);
        }
        this.age = age;
    }
}






