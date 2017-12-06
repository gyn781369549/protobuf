package com.protobuf.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class saveSql implements Runnable {
	private static ExecutorService mt = Executors.newSingleThreadExecutor();

	public saveSql() {
		// TODO Auto-generated constructor stub
	}

	public static int count = 100;

	public static void main(String[] args) throws IOException {
		count = 10000 * 10 * 10 * 10 ;// 一千万
		
//		 saveSql.saveTable();
//		 saveSql.dropTable();
		// truncateTable();
		saveSql.insert();

	}

	/**
	 * 使用BufferWriter泪写文本文件
	 */
	public static void bufferedWriterTest() {
		try {
			//生成 文件地址 文件名
			BufferedWriter bw = new BufferedWriter(new FileWriter("E:/test3.txt"));
			bw.write("第一行");
			bw.newLine();
			bw.write("第二行");
			bw.newLine();
			bw.close();//关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void truncateTable() {
		Random RANDOM = new Random();
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {

			String strdrop = "Truncate Table  t_order" + i + ";";

			System.out.println(strdrop);

		}
	}

	public static void dropTable() throws IOException {
		Random RANDOM = new Random();
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter("D:/insertNewSql/" + "dropTable" + ".sql"));
		for (int i = 1; i <=count; i++) {

			String strdrop = "DROP TABLE t_order" + i + ";";

			System.out.println(strdrop);
			bw.write(strdrop);
			bw.newLine();
		}
		bw.close();
	}

	public static void saveTable() throws IOException {
		Random RANDOM = new Random();
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter("D:/insertNewSql/" + "table" + ".sql"));
		for (int i = 1; i <=count; i++) {
			String str = "CREATE TABLE `t_order" + i + "` (" + " `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ " `name` varchar(255) NOT NULL," + "`t_user_id` int(11) NOT NULL," + " PRIMARY KEY (`id`)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;";

			System.out.println(str);
			bw.write(str);
			bw.newLine();
			
		
			
		}
		bw.close();
		
	}

	public static void insert() throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter("D:/insertNewSql/" + "1kw"
				+ "" + ".sql"));
		int g = 1;
		for (int i = 0; i < count; i++) {
			int c = count;
//			if (i % 1000000 == 0) {
//				g = i / 1000000;
//				System.out.println("第" + g + "次分割 i=" + i);
//				if (i != 0) {
//					bw.close();
//					bw = null;
//				}
//
//				bw = new BufferedWriter(new FileWriter("D:/insertNewSql/" + (g + 1) + ".sql"));
//
//			}

			String instr = "INSERT INTO  t_testorder(id,name,t_user_id) VALUES(" + i + ",'dd" + i + "'," + 1 + ");";
			if (i == 0) {
				continue;
			}
			System.out.println(instr);
			bw.write(instr);
			bw.newLine();
			if (i == c - 1) {
				bw.close();
			}

		}

	}

	public void run() {
		System.out.println("时间戳" + System.currentTimeMillis() + "线程：" + Thread.currentThread());
		try {
			Thread.sleep(1000 * 2 * 5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("时间戳" + System.currentTimeMillis() + "线程：" + Thread.currentThread()
				+ "------------------------------------------");
		// TODO Auto-generated method stub
		// try {
		// saveSql.insert();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
