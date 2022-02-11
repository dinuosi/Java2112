package thread;

/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一个临界资源，由于线程切换实际不确定，导致操作顺序出现混乱而引起各种逻辑错误
 * 临界资源：操作该资源的完整过程同一时刻只能由单线程进行。
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    Thread.yield();//让出
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    Thread.yield();//让出
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class Table {
    private int bean = 20;

    public synchronized int getBean() {//加把锁
        if (bean == 0) {//豆子没有了
            throw new RuntimeException("没有豆子了！");
        }
        Thread.yield();//让出
        return bean--;
    }
}
