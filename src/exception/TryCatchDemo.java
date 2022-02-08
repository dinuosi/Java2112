package exception;

/**
 * JAVA异常处理机制中的try-catch
 * 语法:
 * try{
 *     可能出现异常的代码片段
 * }catch(XXXException e){
 *     当try中出现XXXException后的解决办法
 * }
 *
 * try语句块不能独立存在，后面必须跟catch或finally。
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String str = "a";
            System.out.println(str.length());
            System.out.println(str.charAt(0));
        }catch (NullPointerException|StringIndexOutOfBoundsException e){
            System.out.println("出现空指针或下标越界异常，并在这里得到解决");
        }

//        catch (NullPointerException e){
//            System.out.println("出现空指针异常，并在这里解决");
//        }catch (StringIndexOutOfBoundsException e){
//            System.out.println("出现字符串下标越界异常，并在这里得到解决");
//        }

        System.out.println("程序结束了");
    }
}




