# day12

### Map 查找表

Map体现的结构是一个多行两列的表格,其中左列称为key,右列称为value.

- Map总是成对保存数据,并且总是根据key获取对应的value.因此我们可以将查询的条件作为key查询对应的结果作为value保存到Map中.
- Map有一个要求:key不允许重复(equals比较的结果)

java.util.Map接口,是所有Map的顶级接口,规定了Map的相关功能.

常用实现类:

- java.util.HashMap:称为散列表,使用散列算法实现的Map,当今查询速度最快的数据结构.
- java.util.TreeMap:使用二叉树实现的Map

```java
package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口  查找表
 * Map体现的结构像是一个多行两列的表格，其中左列称为key，右列称为value
 * Map总是成对儿(key-value键值对)保存数据，并且总是根据key获取其对应的value
 *
 * 常用实现类:
 * java.util.HashMap:称为散列表，使用散列算法实现的Map，当今查询速度最快的
 *                   数据结构。
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        /*
            V put(K k,V v)
            将给定的键值对儿存入Map
            Map有一个要求，即：Key不允许重复(Key的equals比较)
            因此如果使用重复的key存入value，则是替换value操作，此时put方法
            的返回值就是被替换的value。否则返回值为null。
         */
        /*
            注意，如果value的类型是包装类，切记不要用基本类型接收返回值，
            避免因为自动拆箱导致的空指针
         */
        Integer value = map.put("语文",99);
        System.out.println(value);//null
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",98);
        System.out.println(map);

        value = map.put("物理",66);
        System.out.println(value);//96,物理被替换的值
        System.out.println(map);


        /*
            V get(Object key)
            根据给定的key获取对应的value。若给定的key不存在则返回值为null
         */
        value = map.get("语文");
        System.out.println("语文:"+value);

        value = map.get("体育");
        System.out.println("体育:"+value);//null

        int size = map.size();
        System.out.println("size:"+size);
        /*
            V remove(Object key)
            删除给定的key所对应的键值对，返回值为这个key对应的value
         */
        value = map.remove("语文");
        System.out.println(map);
        System.out.println(value);

        /*
            boolean containsKey(Object key)
            判断当前Map是否包含给定的key
            boolean containsValue(Object value)
            判断当前Map是否包含给定的value
         */
        boolean ck = map.containsKey("英语");
        System.out.println("包含key:"+ck);
        boolean cv = map.containsValue(97);
        System.out.println("包含value:"+cv);
    }
}
```



### Map的遍历

Map支持三种遍历方式:

- 遍历所有的key
- 遍历所有的键值对
- 遍历所有的value(相对不常用)

```java
package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的遍历
 * Map提供了三种遍历方式
 * 1:遍历所有的key
 * 2:遍历每一组键值对
 * 3:遍历所有的value(不常用)
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",99);
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",98);
        System.out.println(map);
        /*
            遍历所有的key
            Set keySet()
            将当前Map中所有的key以一个Set集合形式返回。遍历该集合就等同于
            遍历了所有的key
         */
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println("key:"+key);
        }

        /*
            遍历每一组键值对
            Set<Entry> entrySet()
            将当前Map中每一组键值对以一个Entry实例形式存入Set集合后返回。
            java.util.Map.Entry
            Entry的每一个实例用于表示Map中的一组键值对，其中有两个常用方法:
            getKey()和getValue()
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> e : entrySet){
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }
        /*
            JDK8之后集合框架支持了使用lambda表达式遍历。因此Map和Collection都
            提供了foreach方法，通过lambda表达式遍历元素。
         */
        map.forEach(
             (k,v)-> System.out.println(k+":"+v)
        );


        /*
            遍历所有的value
            Collection values()
            将当前Map中所有的value以一个集合形式返回
         */
        Collection<Integer> values = map.values();
//        for(Integer i : values){
//            System.out.println("value:"+i);
//        }
        /*
            集合在使用foreach遍历时并不要求过程中不能通过集合的方法增删元素。
            而之前的迭代器则有此要求，否则可能在遍历过程中抛出异常。
         */
        values.forEach(
                i -> System.out.println("value:"+i)
        );
    }
}

```