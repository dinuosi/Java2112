package homework.day05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * 设计一个类:User
 * 里面有四个属性:String name,String pwd,String nick,int age
 * 定义get,set方法以及toString方法和构造方法
 *
 * 单词记一记:
 * pwd   是单词password的缩写，是密码的意思
 * user  用户
 *
 *
 * 当前程序启动后要求用户顺序输入以上四个信息
 * 然后实例化一个User对象保存着四个信息并将
 * 该对象序列化到文件中。
 * 文件名的命名规则:用户名.obj
 * 比如该用户输入用户名为张三，那么这个对象
 * 序列化后的文件名为:张三.obj
 *
 * 提高(选做):
 * 可以在用户输入信息后做必要的格式验证，比如4个信息是否
 * 都输入内容了。不能有空的。
 * 用户名只能包含字母数字下划线，并且1-32位
 *
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = scanner.nextLine().trim();
        System.out.println("请输入密码:");
        String pwd = scanner.nextLine().trim();
        System.out.println("请输入昵称:");
        String nick = scanner.nextLine().trim();
        System.out.println("请输入年龄");
        int age = scanner.nextInt();

        /*
            提高部分：
            String的isEmpty方法用来判断当前字符串是否为空字符串
         */
        if(name.isEmpty()||pwd.isEmpty()||nick.isEmpty()||
                !name.matches("[a-zA-Z0-9_]{1,32}")){
            System.out.println("注册信息输入有误!");
            return;
        }

        User user = new User(name,pwd,nick,age);
        try(
                FileOutputStream fos = new FileOutputStream(name+".obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(user);
            System.out.println("注册完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
