package thread;

/**
 * 死锁
 * 当多个线程都各自持有一个锁的同时等待对方先释放锁时就会形成一种僵持状态，这个状态
 * 我们称为死锁现象。
 */
public class DeadLockDemo {
    static Object chopstick = new Object();//筷子
    static Object spoon = new Object();//勺，调羹

    public static void main(String[] args) {
        Thread np = new Thread(){
            public void run(){
                try {
                    System.out.println("北方人开始吃饭...");
                    synchronized (chopstick) {
                        System.out.println("北方人拿起了筷子，开始吃饭...");
                        Thread.sleep(5000);
                        System.out.println("北方人吃完了饭，去拿勺...");
                        synchronized (spoon){
                            System.out.println("北方人拿起了勺，开始喝汤...");
                            Thread.sleep(5000);
                            System.out.println("北方人喝完了汤.");
                        }
                        System.out.println("北方人放下了勺");
                    }
                    System.out.println("北方人放下了筷子，吃饭完毕!");
                }catch(Exception e){
                }
            }
        };

        Thread sp = new Thread(){
            public void run(){
                try {
                    System.out.println("南方人开始吃饭...");
                    synchronized (spoon) {
                        System.out.println("南方人拿起了勺，开始喝汤...");
                        Thread.sleep(5000);
                        System.out.println("南方人喝完了汤，去拿筷子...");
                        synchronized (chopstick){
                            System.out.println("南方人拿起了筷子，开始吃饭...");
                            Thread.sleep(5000);
                            System.out.println("南方人吃完了饭.");
                        }
                        System.out.println("南方人放下了筷子");
                    }
                    System.out.println("南方人放下了勺，吃饭完毕!");
                }catch(Exception e){
                }
            }
        };

        np.start();
        sp.start();

    }
}
