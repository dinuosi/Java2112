# day11

### 集合的排序

#### java.util.Collections类

Collections是集合的工具类,里面定义了很多静态方法用于操作集合.

#### Collections.sort(List list)方法

可以对List集合进行自然排序(从小到大)

```java
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合的工具类:java.util.Collections提供了一个静态方法sort,可以对List集合
 * 进行自然排序
 */
public class SortListDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
```

#### 排序自定义类型元素

```java
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(3,5));
        list.add(new Point(7,9));
        list.add(new Point(1,1));
        list.add(new Point(8,3));
        list.add(new Point(2,6));
        System.out.println(list);
        /*
            编译不通过的原因:
            Collections.sort(List list)该方法要求集合中的元素类型必须实现接口:
            Comparable,该接口中有一个抽象方法compareTo,这个方法用来定义元素之间比较
            大小的规则.所以只有实现了该接口的元素才能利用这个方法比较出大小进而实现排序
            操作.
         */
        Collections.sort(list);//编译不通过 compare比较  comparable可以比较的
        System.out.println(list);
    }
}
```

实际开发中,我们并不会让我们自己定义的类(如果该类作为集合元素使用)去实现Comparable接口,因为这对我们的程序有**侵入性**.

侵入性:当我们调用某个API功能时,其要求我们为其修改其他额外的代码,这个现象就是侵入性.侵入性越强的API越不利于程序的后期可维护性.应当尽量避免.



#### 重载的Collections.sort(List list,Comparator c)方法

```java
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(3,5));
        list.add(new Point(7,9));
        list.add(new Point(1,1));
        list.add(new Point(8,3));
        list.add(new Point(2,6));
        System.out.println(list);
        /*
            编译不通过的原因:
            Collections.sort(List list)该方法要求集合中的元素类型必须实现接口:
            Comparable,该接口中有一个抽象方法compareTo,这个方法用来定义元素之间比较
            大小的规则.所以只有实现了该接口的元素才能利用这个方法比较出大小进而实现排序
            操作.

            当我们调用某个API时,它反过来要求我们为其修改其他额外的代码时就是侵入性.
            侵入性不利于程序后期的维护,应当在实际开发中尽量避免.
         */
//        Collections.sort(list);//编译不通过 compare比较  comparable可以比较的

        /*
            Collections.sort(List list,Comparator c)
            重载的sort方法要求我们再传入一个Comparator"比较器",该比较器用来为集合元素
            临时定义一种比较规则,从而将List集合中的元素通过该比较器比较大小后进行排序.
            Comparator是一个接口,实际应用中我们需要实现该接口为集合元素提供比较规则.
         */
        Comparator<Point> c = new Comparator<Point>() {
            /**
             * compare方法用来定义两个参数o1,o2的大小关系
             * 返回值用来表示o1与o2的大小关系
             * 当返回值>0时,应当表示的含义是o1>o2
             * 当返回值<0时,表示o1<o2
             * 当返回值=0时,表示o1与o2相等
             */
            public int compare(Point o1, Point o2) {
                int olen1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int olen2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return olen1-olen2;
            }
        };
        Collections.sort(list,c);
        System.out.println(list);
    }
}
```



##### 最终没有侵入性的写法

```java
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(3,5));
        list.add(new Point(7,9));
        list.add(new Point(1,1));
        list.add(new Point(8,3));
        list.add(new Point(2,6));
        System.out.println(list);
        /*
            编译不通过的原因:
            Collections.sort(List list)该方法要求集合中的元素类型必须实现接口:
            Comparable,该接口中有一个抽象方法compareTo,这个方法用来定义元素之间比较
            大小的规则.所以只有实现了该接口的元素才能利用这个方法比较出大小进而实现排序
            操作.

            当我们调用某个API时,它反过来要求我们为其修改其他额外的代码时就是侵入性.
            侵入性不利于程序后期的维护,应当在实际开发中尽量避免.
         */
//        Collections.sort(list);//编译不通过 compare比较  comparable可以比较的

        /*
            Collections.sort(List list,Comparator c)
            重载的sort方法要求我们再传入一个Comparator"比较器",该比较器用来为集合元素
            临时定义一种比较规则,从而将List集合中的元素通过该比较器比较大小后进行排序.
            Comparator是一个接口,实际应用中我们需要实现该接口为集合元素提供比较规则.
         */
//        Comparator<Point> c = new Comparator<Point>() {
//            /**
//             * compare方法用来定义两个参数o1,o2的大小关系
//             * 返回值用来表示o1与o2的大小关系
//             * 当返回值>0时,应当表示的含义是o1>o2
//             * 当返回值<0时,表示o1<o2
//             * 当返回值=0时,表示o1与o2相等
//             */
//            public int compare(Point o1, Point o2) {
//                int olen1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
//                int olen2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
//                return olen1-olen2;
//            }
//        };
//        Collections.sort(list,c);
        
        Collections.sort(list,new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                int olen1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int olen2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return olen1-olen2;
            }
        });
        System.out.println(list);
    }
}
```



##### 排序字符串

java中提供的类,如:String,包装类都实现了Comparable接口,但有时候这些比较规则不能满足我们的排序需求时,同样可以临时提供一种比较规则来进行排序.

```java
package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("Tom");
//        list.add("jackson");
//        list.add("rose");
//        list.add("jill");
//        list.add("ada");
//        list.add("hanmeimei");
//        list.add("lilei");
//        list.add("hongtaoliu");
//        list.add("Jerry");

        list.add("传奇");
        list.add("小泽老师");
        list.add("苍老师");
        System.out.println(list);
        
        //按照字符多少排序
//        Collections.sort(list);
//        Collections.sort(list, new Comparator<String>() {
//            public int compare(String o1, String o2) {
////                return o1.length()-o2.length();
//                return o2.length()-o1.length();//反过来减就是降序
//            }
//        });

        Collections.sort(list,(o1,o2)->o2.length()-o1.length());
        System.out.println(list);
    }
}
```



### 队列

#### java.util.Queue接口

Queue接口继承自Collection.队列可以保存一组元素,存取元素必须遵循先进先出原则.(FIFO first input first output)

常用实现类:java.util.LinkedList

![image-20210408142425463](image-20210408142425463.png)

```java
package collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        /*
            boolean offer(E e)
            入队操作,将给定元素添加到队列末尾
         */
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        queue.offer("five");
        System.out.println(queue);
        /*
            E poll()
            出队操作,获取并删除队列中的队首元素
         */
        String str = queue.poll();
        System.out.println(str);
        System.out.println(queue);
        /*
            E peek()
            引用队首元素,获取队首元素后元素还在队列中
         */
        str = queue.peek();
        System.out.println(str);
        System.out.println(queue);

        //队列的遍历
        for(String s : queue){//新循环(迭代器)遍历后,元素并不会出队.
            System.out.println(s);
        }
        System.out.println(queue);

        queue.forEach(e-> System.out.println(e));//foreach遍历

        System.out.println(queue);

        //使用poll方法
        while(queue.size()>0){
            str = queue.poll();
            System.out.println(str);
        }
        System.out.println(queue);
    }
}
```



#### java.util.Deque接口,双端队列

Deque继承自Queue,双端队列的特点是队列的两端都可以做出入队操作.

常用实现类:LinkedList

![image-20210408142645158](image-20210408142645158.png)

```java
package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列 java.util.Deque接口
 * Deque继承自Queue,双端队列的特点是队列的两端都可以做出入队操作.
 * 常用实现类:LinkedList
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offer("one");
        deque.offer("two");
        deque.offer("three");
        System.out.println(deque);//[one,two,three]
        deque.offerFirst("four");//从队首方向入队
        System.out.println(deque);//[four,one,two,three]
        deque.offerLast("five");//从队尾方向入队,与offer一致
        System.out.println(deque);//[four,one,two,three,five]

        String e = deque.poll();//队首出队
        System.out.println(e);
        System.out.println(deque);
        e = deque.pollLast();//队尾出队
        System.out.println(e);
        System.out.println(deque);
        e = deque.pollFirst();//队首出队
        System.out.println(e);
        System.out.println(deque);

    }
}
```



#### 栈结构

栈结构可以保存一组元素,存取元素必须遵循先进后出原则.

使用双端队列,并且仅从同一侧做出入队操作时,就形成了栈结构,对此Deque也为栈结构提供了对应的经典方法:push(入栈),pop(出栈)

通常使用栈用来完成如"后退","前进"这样的功能.

![image-20210408144356866](image-20210408144356866.png)



```java
package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈结构
 * 栈结构可以保存一组元素,存取元素必须遵循先进后出原则.
 * 使用双端队列,并且仅从同一侧做出入队操作时,就形成了栈结构,对此Deque也为栈结构提供了
 * 对应的经典方法:push(入栈),pop(出栈)
 *
 * 通常使用栈用来完成如"后退","前进"这样的功能.
 */
public class StackDemo {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        System.out.println(stack);
        String str = stack.pop();
        System.out.println(str);//five
        System.out.println(stack);
    }
}
```