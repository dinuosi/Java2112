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
//            String str = null;
//            String str = "";
            String str = "a";
            //这里会出现空指针异常，虚拟机会实例化空指针异常实例并在这里抛出
            System.out.println(str.length());
            System.out.println(str.charAt(0));
            System.out.println(Integer.parseInt(str));
            //try语句块中某句话报错后，那么try语句块中这句话之后的代码均不会执行!
            System.out.println("!!!!!!!!!!!!!!!!");

          //批量注释:选中需要注释的代码片段按"ctrl+/"
//        }catch(NullPointerException e){
//            System.out.println("出现了空指针，并在这里得以解决!");
//        //catch可以定义多个，针对不同的异常有不同处理办法时，可以分别捕获并进行处理
//        }catch(StringIndexOutOfBoundsException e){
//            System.out.println("出现了字符串下标越界了！并在这里解决!");
//        }
        //可以合并捕获异常，当不同异常处理手段相同时，可以用这种方式。
        }catch(NullPointerException|StringIndexOutOfBoundsException e){
            System.out.println("出现了空指针或下标越界的处理!");

        }catch(Exception e){
            System.out.println("反正就是出了个错!");
        }
        System.out.println("程序结束了");
    }

}




