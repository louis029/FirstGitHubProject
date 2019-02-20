package com.louis.game;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * */
public class test {
	/**
	 * 1 准备工作
	 * */
	// 1-1创建Scanner 对象
	Scanner input = new Scanner(System.in);
	// 1-2创建若干变量,以用来保存相关信息
	String name;// 本人姓名
	String cname;// 挑战者姓名
	int num;// 本人做出的选择
	int cnum;// 挑战者做出的选择
	int count;// 回合数
	int selfcount;// 玩家胜利次数
	int ccount;// 电脑胜利次数
	boolean flag;// 开关器

	/**
	 * 2 创建角色
	 * */
	public void ready() {
		// 2-0初始化胜负次数
		count = 0;
		selfcount = 0;
		ccount = 0;
		// 2-1录入玩家信息
		System.out.println("请输入您的名字:");
		name = input.next();
		// 2-2录入对手信息
		System.out.println("欢迎您'" + name + "':\n请选择对手");
		do {
			flag = false;

			System.out.println("1---AAA");
			System.out.println("2---BBB");
			System.out.println("3---CCC");
			System.out.println("4---DDD");
			int key = input.nextInt();
			switch (key) {
			case 1: {
				cname = "AAA";
				flag = true;
				break;
			}
			case 2: {
				cname = "BBB";
				flag = true;
				break;
			}
			case 3: {
				cname = "CCC";
				flag = true;
				break;
			}
			case 4: {
				cname = "DDD";
				flag = true;
				break;
			}
			default: {
				System.out.println("输入有误,重新输入");
				break;
			}
			}
		} while (!flag);
		System.out.println("********" + name + "VS" + cname + "********");
		play();
	}
	/**
	* 3 找出玩家和电脑的选择
	 * */
	public void play() {
		// 3-1捕捉用户的选择
		do {
			flag = false;
			System.out.println("请输入您的选择:\n1----石头\n2----剪刀\n3----布");
			int key = input.nextInt();
			switch (key) {
			case 1: {
				System.out.println("您出的是-----石头");
				num = 1;
				flag = true;
				break;
			}
			case 2: {
				System.out.println("您出的是-----剪刀");
				num = 2;
				flag = true;
				break;
			}
			case 3: {
				System.out.println("您出的是-----布");
				num = 3;
				flag = true;
				break;
			}
			default: {
				System.out.println("输入有误,重新输入");
				break;
			}
			}
		} while (!flag);

		// 3-2捕捉电脑的选择
		//3-2-1实例化出Random类对象,因为对象有一个方法可以随机生成数字.
		Random random = new Random();
		int key = random.nextInt(3)+1;
		//3-2-2打印出电脑选择的结果
		switch (key) {
		case 1:{
			System.out.println(cname+"出的是-----石头");
			cnum = 1;
			break;
		}
		case 2:{
			System.out.println(cname+"出的是-----剪刀");
			cnum = 2;
			break;
		}
		case 3:{
			System.out.println(cname+"出的是-----布");
			cnum = 3;
			break;
		}
		default:
			break;
		}
		judge();
	}
	/**
	 * 4 计算出本次的胜负
	 * */
	public void judge(){
		flag = false;
		//进行评判
		if(num==cnum){
			System.out.println("这回合打平……");
		}else if((num==1&&cnum!=3)||(num==2&&cnum!=1)||(num==3&&cnum!=2)){
			System.out.println("恭喜你，你赢了……");
			//玩家胜利次数+1
			selfcount++;
		}else{
			System.out.println("很遗憾，你输了……");
			//电脑胜利次数+1
			ccount++;
		}
		//总回合数+1
		count++;
		/**询问是否继续比赛*/
		System.out.println("是否继续Y/N");
		if(input.next().equals("Y")){
			flag = true;
		}
		if(flag){
			play();
		}else{
			end();
		}		
	}
	/**结尾*/
	public void end(){
		flag = false;
		System.out.println("本次比赛回合数"+count);
		System.out.println("你赢了:"+selfcount+"次");
		System.out.println("电脑赢了:"+ccount+"次");
		if(selfcount==ccount){
			System.out.println("平局");
		}else if(selfcount>ccount){
			System.out.println("你赢了");
		}else{
			System.out.println("你输了");
		}
		System.out.println("*****************************************************************");
		System.out.println("是否再次挑战Y/N");
		if(input.next().equals("Y")){
			flag = true;
		}
		if(flag){
			ready();
		}else{
			System.out.println("BYEBYE!!!");
		}
		
	}
	public static void main(String[] args) {
		test tt = new test();
		tt.ready();
	}
}
