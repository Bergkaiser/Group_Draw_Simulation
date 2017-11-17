package ����˹���籭��ǩģ��;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//����������
class Team{
	String name;  //��������
	String continent;  //�����Ĵ���
	int level;   //��ӵ���
	Team(String name,String continent,int level){
		this.name = name;
		this.continent = continent;
		this.level = level;
	}
}
//С����
class Group{
	char groupName;
	Team[] team = new Team[4];
	int flag_Europe = 2;
	int flag_Asia = 1;
	int flag_Africa = 1;
	int flag_SouthAmerica = 1;
	int flag_NorthAmerica = 1;
	Group(char k){
		this.groupName = k;
	}
}
public class WorldCupDraw {
	static List level_1 = new ArrayList();
	static List level_2 = new ArrayList();
	static List level_3 = new ArrayList();
	static List level_4 = new ArrayList();
	static Group[] group = new Group[8];
	public static void InitTeam(){
		//��һ�����
		level_1.add(new Team("�¹�","Europe",1));
		level_1.add(new Team("����","SouthAmerica",1));
		level_1.add(new Team("������","Europe",1));
		level_1.add(new Team("����͢","SouthAmerica",1));
		level_1.add(new Team("����ʱ","Europe",1));
		level_1.add(new Team("����","Europe",1));
		level_1.add(new Team("����","Europe",1));
		//�ڶ������
		level_2.add(new Team("������","Europe",2));
		level_2.add(new Team("��³","SouthAmerica",2));
		level_2.add(new Team("��ʿ","Europe",2));
		level_2.add(new Team("Ӣ����","Europe",2));
		level_2.add(new Team("���ױ���","SouthAmerica",2));
		level_2.add(new Team("ī����","NorthAmerica",2));
		level_2.add(new Team("������","SouthAmerica",2));
		level_2.add(new Team("���޵���","Europe",2));
		//���������
		level_3.add(new Team("����","Europe",3));
		level_3.add(new Team("����","Europe",3));
		level_3.add(new Team("��˹�����","NorthAmerica",3));
		level_3.add(new Team("���","Europe",3));
		level_3.add(new Team("ͻ��˹","Africa",3));
		level_3.add(new Team("����","Africa",3));
		level_3.add(new Team("���ڼӶ�","Africa",3));
		level_3.add(new Team("����","Asia",3));
		//���ĵ����
		level_4.add(new Team("����ά��","Europe",4));
		level_4.add(new Team("��������","Africa",4));
		level_4.add(new Team("�Ĵ�����","Asia",4));
		level_4.add(new Team("�ձ�","Asia",4));
		level_4.add(new Team("Ħ���","Africa",4));
		level_4.add(new Team("������","NorthAmerica",4));
		level_4.add(new Team("����","Asia",4));
		level_4.add(new Team("ɳ�ذ�����","Asia",4));
	}
	public static void InitGruop(){
		char x = 'A';
		for(int i=0;i<8;i++){
			group[i] = new Group(x++);
		}
		//A�����Ӷ�Ĭ��Ϊ����˹��
		group[0].team[0] = new Team("����˹","Europe",1);
		group[0].flag_Europe--;
	}
	public static boolean CheckFlag(Team x,Group group){
		if(x.continent.equals("Europe")){
			if(group.flag_Europe > 0){
				group.flag_Europe--;
				return true;
			}
			else{
				return false;
			}
		}
		else if(x.continent.equals("Asia")){
			if(group.flag_Asia > 0){
				group.flag_Asia--;
				return true;
			}
			else{
				return false;
			}
		}
		else if(x.continent.equals("Africa")){
			if(group.flag_Africa > 0){
				group.flag_Africa--;
				return true;
			}
			else{
				return false;
			}
		}
		else if(x.continent.equals("SouthAmerica")){
			if(group.flag_SouthAmerica > 0){
				group.flag_SouthAmerica--;
				return true;
			}
			else{
				return false;
			}
		}
		else{
			if(group.flag_NorthAmerica > 0){
				group.flag_NorthAmerica--;
				return true;
			}
			else{
				return false;
			}
		}
	}
	public static boolean Draw(){
		Random random = new Random();
		int k;
		int falseCount = 0;
		boolean s;
		System.out.println(group[0].groupName + "1: " + "����˹");
		for(int flag=0;flag<4;flag++){
			//�����Ӷ�
			if(flag == 0){
				int i = 1;
				while(level_1.isEmpty()==false){
					k = random.nextInt(level_1.size());
					Team x = (Team)level_1.get(k);
					//����Ƿ���������޹��
					s = CheckFlag(x,group[i]);
					if(s==true){
						group[i].team[0] = x; 
						System.out.println(group[i].groupName + "1: " + x.name);
						level_1.remove(k);
						i++;
					}
				}
				System.out.println("һ����ӳ�ǩ��ɣ�");
			}
			//���ĵ����
			else if(flag == 1){
				int i = 0;
				while(level_4.isEmpty()==false){
					k = random.nextInt(level_4.size());
					Team x = (Team)level_4.get(k);
					//����Ƿ���������޹��
					s = CheckFlag(x,group[i]);
					if(s==true){
						group[i].team[3] = x; 
						System.out.println(group[i].groupName + "4: " + x.name);
						level_4.remove(k);
						i++;
					}
				}
				System.out.println("�ĵ���ӳ�ǩ��ɣ�");
			}
			//���������
			else if(flag == 2){
				int i = 0;
				while(level_3.isEmpty()==false){
					k = random.nextInt(level_3.size());
					Team x = (Team)level_3.get(k);
					//����Ƿ���������޹��
					s = CheckFlag(x,group[i]);
					if(s==true){
						group[i].team[2] = x; 
						System.out.println(group[i].groupName + "3: " + x.name);
						level_3.remove(k);
						i++;
						falseCount = 0;
					}
					else{
						falseCount++;
						if(falseCount >= level_3.size()){
							System.out.println("��ǩ����ì�ܣ����³�ȡ��");
							return false;
						}
					}
				}
				System.out.println("������ӳ�ǩ��ɣ�");
			}
			//��������
			else{
				int i = 0;
				while(level_2.isEmpty()==false){
					k = random.nextInt(level_2.size());
					Team x = (Team)level_2.get(k);
					//����Ƿ���������޹��
					s = CheckFlag(x,group[i]);
					if(s==true){
						group[i].team[1] = x;
						System.out.println(group[i].groupName + "2: " + x.name);
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						level_2.remove(k);
						i++;
						falseCount = 0;
					}
					else{
						falseCount++;
						if(falseCount >= level_2.size()){
							System.out.println("��ǩ����ì�ܣ����³�ȡ��");
							return false;
						}
					}
				}
				System.out.println("������ӳ�ǩ��ɣ�");
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		while(!flag){
			InitTeam();
			InitGruop();
			flag = Draw();
			if(flag == false){
				level_1.clear();
				level_2.clear();
				level_3.clear();
				level_4.clear();
			}
		}
		System.out.print('\n');
		System.out.println("2018����˹���籭С�������飺");
		for(int i=0;i<8;i++){
			System.out.print("Group " + group[i].groupName + ":   ");
			for(int j=0;j<4;j++){
				System.out.print(group[i].team[j].name + '\t' + '\t');
			}
			System.out.print('\n');
		}
	}
}
