package homework.day04;

import java.io.File;
import java.util.Scanner;

/**
 * 改错练习:
 *
 * 程序启动后要求用户输入一个关键字，然后列出当前项目下所有
 * 名字中包含该关键字的子项
 *
 * 单词记一记:
 * key  计算机中为"关键"的含义，不译为钥匙
 * dir  是单词directory的缩写，目录的意思
 * list 列表
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//1:类名拼写错误  2:需要导包
//		scanner s = new scanner(System.in);
		Scanner s = new Scanner(System.in);
		System.out.println("请输入关键字:");
		//1:scanner应当用变量s   2:方法名拼写错误
//		String key = scanner.nextline();
		String key = s.nextLine();
		//定位当前目录
		File dir = new File(".");//没导包
		//判断是否为目录
		if(dir.isDirectory()) {
			//获取该目录下所有子项
			File files[] = dir.listFiles();
			//1:数组的length不是方法       2:i应当是小于数组的length
//			for(int i=0;i<=files.length();i++) {
			for(int i=0;i<files.length;i++) {
				//获取每一个子项的名字
				//String的类名拼写错误
//				string fileName = files[i].getName();
				String fileName = files[i].getName();
				//判断名字中是否包含key的内容
				//1:filename变量名拼写错误
//				if(filename.不知道什么方法) {
				if(fileName.contains(key)) {
					//包含就输出这个名字
//					System.out.println(f1leNeme);
					System.out.println(fileName);
				}
			}
		}
	}
}







