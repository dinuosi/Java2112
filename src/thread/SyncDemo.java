package thread;

/**
 * 同步块的应用
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能的提高并发效率。
 * 语法:
 * synchronized(同步监视器对象){
 *     需要多个线程同步执行的代码片段
 * }
 *
 */
public class SyncDemo {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Thread t1 = new Thread("王克晶"){
            public void run(){
                shop.buy();
            }
        };
        Thread t2 = new Thread("刘苍松"){
            public void run(){
                shop.buy();
            }
        };
        t1.start();
        t2.start();

    }
}

class Shop{
    /*
        在方法上直接使用synchronized,那么同步监视器是不可选的，就是当前方法的所属对象this
     */
//    public synchronized void buy(){
    public void buy(){
        try {
            Thread t = Thread.currentThread();//获取运行buy的线程

            System.out.println(t.getName() + ":正在挑衣服...");
            Thread.sleep(5000);
            /*
                同步块在使用时需要在"()"中指定同步监视器对象，该对象可以是任何引用
                类型的实例，只要保证多个需要同步执行该代码块的线程看到的这个对象是
                "同一个"即可。实际开发中可结合具体情况选取。
             */
//            synchronized (new Object()) { //无效!两个线程看到的不是同一个对象!
            synchronized (this) {
                System.out.println(t.getName() + ":正在试衣服...");
                Thread.sleep(5000);
            }

            System.out.println(t.getName() + ":结账离开!");

        }catch(Exception e){
        }
    }
}





