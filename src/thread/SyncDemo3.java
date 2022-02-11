package thread;

/**
 * 静态方法锁
 * 如果我们在静态方法上使用synchronized,那么该方法就一定具有同步效果。
 */
public class SyncDemo3 {
    public static void main(String[] args) {

    }
}

class Boo{
    public static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+":正在执行dosome方法...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println(t.getName()+":执行dosome方法完毕!");
    }
}



