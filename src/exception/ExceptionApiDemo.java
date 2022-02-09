package exception;

/**
 * 异常常用的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        try{
            String str = "abc";
            System.out.println(Integer.parseInt(str));
        }catch(Exception e){
            //该方法用来在控制台输出异常的堆栈信息，便于程序员debug
            e.printStackTrace();
            //message:消息
            String message = e.getMessage();//获取错误信息
            //message一般用于给用户进行提示，或者记录log日志时使用。
            System.out.println(message);

        }
    }
}
