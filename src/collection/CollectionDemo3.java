package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Point p = new Point(1,2);
        c.add(p);//将p元素存入集合
        System.out.println("p:"+p);//(1,2)
        System.out.println("c:"+c);//[(1,2)]

        p.setX(2);//将p对象中的x属性改为2
        System.out.println("p:"+p);//(2,2)
        System.out.println("c:"+c);//[(2,2)]


    }
}
