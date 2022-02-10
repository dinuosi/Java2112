package thread;

public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束了");
    }

}
