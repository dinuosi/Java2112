package homework.day08;
/**
 * 修改下面的错误
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//1:符号错误
		//2:Thread不能使用lambda表达式创建(因为其方法众多)
//		Thread t1 = ()—>{
		Thread t1 = new Thread(()->{
			System.out.println("你是谁?");
		});

		Thread t2 = new Thread(
			//符号错误
			()->System.out.println("我是查水表的!")
		);

		t1.start();
		t2.start();
	}
}



