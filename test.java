package com.louis.game;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * */
public class test {
	/**
	 * 1 ׼������
	 * */
	// 1-1����Scanner ����
	Scanner input = new Scanner(System.in);
	// 1-2�������ɱ���,���������������Ϣ
	String name;// ��������
	String cname;// ��ս������
	int num;// ����������ѡ��
	int cnum;// ��ս��������ѡ��
	int count;// �غ���
	int selfcount;// ���ʤ������
	int ccount;// ����ʤ������
	boolean flag;// ������

	/**
	 * 2 ������ɫ
	 * */
	public void ready() {
		// 2-0��ʼ��ʤ������
		count = 0;
		selfcount = 0;
		ccount = 0;
		// 2-1¼�������Ϣ
		System.out.println("��������������:");
		name = input.next();
		// 2-2¼�������Ϣ
		System.out.println("��ӭ��'" + name + "':\n��ѡ�����");
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
				System.out.println("��������,��������");
				break;
			}
			}
		} while (!flag);
		System.out.println("********" + name + "VS" + cname + "********");
		play();
	}
	/**
	* 3 �ҳ���Һ͵��Ե�ѡ��
	 * */
	public void play() {
		// 3-1��׽�û���ѡ��
		do {
			flag = false;
			System.out.println("����������ѡ��:\n1----ʯͷ\n2----����\n3----��");
			int key = input.nextInt();
			switch (key) {
			case 1: {
				System.out.println("��������-----ʯͷ");
				num = 1;
				flag = true;
				break;
			}
			case 2: {
				System.out.println("��������-----����");
				num = 2;
				flag = true;
				break;
			}
			case 3: {
				System.out.println("��������-----��");
				num = 3;
				flag = true;
				break;
			}
			default: {
				System.out.println("��������,��������");
				break;
			}
			}
		} while (!flag);

		// 3-2��׽���Ե�ѡ��
		//3-2-1ʵ������Random�����,��Ϊ������һ���������������������.
		Random random = new Random();
		int key = random.nextInt(3)+1;
		//3-2-2��ӡ������ѡ��Ľ��
		switch (key) {
		case 1:{
			System.out.println(cname+"������-----ʯͷ");
			cnum = 1;
			break;
		}
		case 2:{
			System.out.println(cname+"������-----����");
			cnum = 2;
			break;
		}
		case 3:{
			System.out.println(cname+"������-----��");
			cnum = 3;
			break;
		}
		default:
			break;
		}
		judge();
	}
	/**
	 * 4 ��������ε�ʤ��
	 * */
	public void judge(){
		flag = false;
		//��������
		if(num==cnum){
			System.out.println("��غϴ�ƽ����");
		}else if((num==1&&cnum!=3)||(num==2&&cnum!=1)||(num==3&&cnum!=2)){
			System.out.println("��ϲ�㣬��Ӯ�ˡ���");
			//���ʤ������+1
			selfcount++;
		}else{
			System.out.println("���ź��������ˡ���");
			//����ʤ������+1
			ccount++;
		}
		//�ܻغ���+1
		count++;
		/**ѯ���Ƿ��������*/
		System.out.println("�Ƿ����Y/N");
		if(input.next().equals("Y")){
			flag = true;
		}
		if(flag){
			play();
		}else{
			end();
		}		
	}
	/**��β*/
	public void end(){
		flag = false;
		System.out.println("���α����غ���"+count);
		System.out.println("��Ӯ��:"+selfcount+"��");
		System.out.println("����Ӯ��:"+ccount+"��");
		if(selfcount==ccount){
			System.out.println("ƽ��");
		}else if(selfcount>ccount){
			System.out.println("��Ӯ��");
		}else{
			System.out.println("������");
		}
		System.out.println("*****************************************************************");
		System.out.println("�Ƿ��ٴ���սY/N");
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
