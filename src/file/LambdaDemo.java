package file;

import java.io.File;
import java.io.FileFilter;

/**
 * JDK8之后推出了一个新的特性：lambda表达式
 * lambda表达式可以用更精简的方式创建匿名内部类。
 * 语法：
 * (参数列表)->{
 *     方法体
 * }
 *
 * 不是所有匿名内部类创建的情景都可以替换为lambda，
 * 前提要求是实现的接口中只能有一个抽象方法时才可以使用lambda表达式
 */
public class LambdaDemo {
    public static void main(String[] args) {
        File dir =new File("");
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().contains("o");
            }
        };
        //忽略了接口名和方法名
        FileFilter filter1 = (File file)->{
            return file.getName().contains("o");
        };
        //参数类型可以忽略。如果方法只有一个参数时，那么"()"也可以省略。
        FileFilter filter2 = file->{
            return file.getName().contains("o");
        };

        FileFilter filter3 = file->file.getName().contains("o");
        /*
            lambda表达式也是编译器认可的，最终会被编译器改回成内部类创建的形式
         */
        File[] subs = dir.listFiles(f->f.getName().contains("o"));
    }
}
