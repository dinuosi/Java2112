package thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();//获取到主线程

        String name = main.getName();//获取线程的名字
        System.out.println("name"+name);

        long id = main.getId();
        System.out.println("id"+id);

        int priority = main.getPriority();//获取线程优先级
        System.out.println("priority"+priority);

        boolean isAlive = main.isAlive();
        boolean isDaemon = main.isDaemon();
        boolean isInterrupted = main.isInterrupted();

        System.out.println("是否活着"+isAlive);
        System.out.println("是否为守护线程"+isDaemon);
        System.out.println("是否被中断"+isInterrupted);

    }
}
