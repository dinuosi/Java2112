package exception;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，java推出了自动关闭特性。
 * 使得我们在源代码中异常处理机制在IO应用中得到了简化。
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try(
                /*
                    只有实现了AutoCloseable接口的类才可以在这里定义并初始化。
                    并且编译器在编译时会将在这里定义的变量在finally中调用close将其关闭。
                    最终编译器会将当前代码改为FinallyDemo2的样子。
                 */
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ){
            String line = "hello";
            fos.write(1);
        }catch(IOException e){
            System.out.println("出错了");
        }

    }
}
