package thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        /*
            注意，启动线程要调用start方法，而非直接调用run方法。
            当调用start后线程便会纳入到线程调度器程序中被统一管理。
            一旦他被分配到了CPU的时间片就会开始自动执行它的run方法。
         */
        myThread1.start();
        myThread2.start();
    }
}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println("你是谁啊？");
        }
    }

}class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println("开门，查水表的！");
        }
    }
}
