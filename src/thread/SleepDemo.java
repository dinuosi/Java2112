package thread;

/**
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 当一个线程调用sleep后就会进入阻塞状态指定的毫秒。超时后线程会自动回到RUNNABLE状态
 * 再次开始并发运行
 *
 * sleep:睡觉，睡眠
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了!");
        /*
            倒计时程序
            程序启动后输入一个数字，从该数字开始每秒递减。到0时输出时间到!
         */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束了!");
    }
}