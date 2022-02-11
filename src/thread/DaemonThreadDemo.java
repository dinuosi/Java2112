package thread;

/**
 * 守护线程
 * java将线程认为两类:用户线程和守护线程。也称为前台线程和后台线程。
 * 守护线程是通过普通的用户线程通过调用setDaemon(true)设置而转变而来的。
 * 因此创建和使用上与用户线程并无区别。但是主要区别在于:
 * 进程的结束:当一个java进程中所有的用户线程都结束时，进程就会结束，此时会将所有的
 *          守护线程全部杀死。
 *
 *
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for (int i = 0;i<5;i++){
                    System.out.println("rose:let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("rose:aaaaaaaaaaaaaa!");
                System.out.println("噗通！");
            }
        };

        Thread jack = new Thread(){
            public void run(){
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("jack:you jump , I jump!");
                }
            }
        };

        rose.start();
        jack.setDaemon(true);
        jack.start();
        while(true);//当主线程不会结束时，进程就不会结束(因为主线程也是普通线程)
    }

}





