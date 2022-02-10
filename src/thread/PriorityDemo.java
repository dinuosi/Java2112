package thread;

/**
 * 线程的优先级
 * 线程有10个优先级，分别对应整数1-10 其中1为最低优先级，10为最高优先级。5为默认值
 *
 * 线程start方法调用后便纳入到了线程调度器中统一管理，此时线程只能被动被分配时间片来
 * 并发运行。线程不能主动索取时间片。调度器会尽可能均匀的将时间片分配给每一个线程。
 * 修改线程的优先级可以最大程度改善获取时间片的次数。原则上优先级越高的线程获取时间片的
 * 次数越多。
 * priority:优先级
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for (int i=0;i<10000;i++){
                    System.out.println("min");
                }
            }
        };
        Thread norm = new Thread(){
            public void run(){
                for (int i=0;i<10000;i++){
                    System.out.println("nor");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for (int i=0;i<10000;i++){
                    System.out.println("max");
                }
            }
        };
//        min.setPriority(1);
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        min.start();
        norm.start();
        max.start();
    }
}
