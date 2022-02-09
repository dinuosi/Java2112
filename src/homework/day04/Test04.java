package homework.day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 改正下面程序的错误
 *
 * 程序实现的功能需求:复制一个文件
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) throws IOException {
		/*
			ctrl+alt+L 自动格式化(自动对齐代码)
		 */
		FileInputStream fis
				= new FileInputStream("test.txt");
		//向复制文件中写入数据时要使用输出流,实例化时类名拼写错误
//		FileInputStream fos
//				= new FIleInputStream("test_cp.txt");
		FileOutputStream fos
				= new FileOutputStream("test_cp.txt");

		int d;
		while ((d = fis.read()) != -1) {
			//不能在复制时读取2次，写1次!
//			fos.write(fis.read());
			fos.write(d);
		}
		System.out.println("复制完毕!");
		fis.close();
		fos.close();
	}
}




