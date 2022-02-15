package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5推出时，推出了一个新的特性：增强型for循环
 * 通常也称为新循环。
 * 新循环不取代传统for循环的工作，它的出现仅为了使用相同的语法遍历集合或数组。
 * 语法：
 * for(元素类型 e : 集合数组){
 *
 * }
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        for(String s : array){
            System.out.println(s);
        }
        /*
            JDK5之后还推出了一个特性:泛型
            泛型也称为参数化类型，它的原型就是Object，泛型的目的是让我们将定义的Object
            类型当做什么看待。
            例如下面的集合中保存的每个元素都是用Object接收的，但是集合将它改成了E类型
            这样一来，我们在使用集合时可以告知集合应当将E当做什么类型看待。
            public class XXX{
                public Object xx;
            }

            XXX o = new XXX();
            o.xx = 任何类型的值;

            泛型的写法:
            public class XXX<E>{
                public E xx;
            }

            XXX<String> o = new XXX<>();
            o.xx = "abc";


         */
        Collection<String> c = new ArrayList<>();
        c.add("一");//编译器会检查传入的E对应的实参是否为E指定的实际类型
        c.add("二");
        c.add("三");
        c.add("四");
        c.add("五");
//        c.add(1);//当实参不符合E指定的实际类型时，编译不通过
        for(String str : c){
            System.out.println(str);
        }
        //改回成下面的样子
        Iterator<String> it = c.iterator();
        while (it.hasNext()){

            String str = (String) it.next();
            System.out.println(str);
        }

    }
}
