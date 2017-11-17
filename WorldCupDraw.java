package 俄罗斯世界杯抽签模拟;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//参赛队伍类
class Team{
	String name;  //国家名称
	String continent;  //所属的大洲
	int level;   //球队档次
	Team(String name,String continent,int level){
		this.name = name;
		this.continent = continent;
		this.level = level;
	}
}
//小组类
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
		//第一档球队
		level_1.add(new Team("德国","Europe",1));
		level_1.add(new Team("巴西","SouthAmerica",1));
		level_1.add(new Team("葡萄牙","Europe",1));
		level_1.add(new Team("阿根廷","SouthAmerica",1));
		level_1.add(new Team("比利时","Europe",1));
		level_1.add(new Team("波兰","Europe",1));
		level_1.add(new Team("法国","Europe",1));
		//第二档球队
		level_2.add(new Team("西班牙","Europe",2));
		level_2.add(new Team("秘鲁","SouthAmerica",2));
		level_2.add(new Team("瑞士","Europe",2));
		level_2.add(new Team("英格兰","Europe",2));
		level_2.add(new Team("哥伦比亚","SouthAmerica",2));
		level_2.add(new Team("墨西哥","NorthAmerica",2));
		level_2.add(new Team("乌拉圭","SouthAmerica",2));
		level_2.add(new Team("克罗地亚","Europe",2));
		//第三档球队
		level_3.add(new Team("丹麦","Europe",3));
		level_3.add(new Team("冰岛","Europe",3));
		level_3.add(new Team("哥斯达黎加","NorthAmerica",3));
		level_3.add(new Team("瑞典","Europe",3));
		level_3.add(new Team("突尼斯","Africa",3));
		level_3.add(new Team("埃及","Africa",3));
		level_3.add(new Team("塞内加尔","Africa",3));
		level_3.add(new Team("伊朗","Asia",3));
		//第四档球队
		level_4.add(new Team("塞尔维亚","Europe",4));
		level_4.add(new Team("尼日利亚","Africa",4));
		level_4.add(new Team("澳大利亚","Asia",4));
		level_4.add(new Team("日本","Asia",4));
		level_4.add(new Team("摩洛哥","Africa",4));
		level_4.add(new Team("巴拿马","NorthAmerica",4));
		level_4.add(new Team("韩国","Asia",4));
		level_4.add(new Team("沙特阿拉伯","Asia",4));
	}
	public static void InitGruop(){
		char x = 'A';
		for(int i=0;i<8;i++){
			group[i] = new Group(x++);
		}
		//A组种子队默认为俄罗斯队
		group[0].team[0] = new Team("俄罗斯","Europe",1);
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
		System.out.println(group[0].groupName + "1: " + "俄罗斯");
		for(int flag=0;flag<4;flag++){
			//抽种子队
			if(flag == 0){
				int i = 1;
				while(level_1.isEmpty()==false){
					k = random.nextInt(level_1.size());
					Team x = (Team)level_1.get(k);
					//检查是否满足各大洲规避
					s = CheckFlag(x,group[i]);
					if(s==true){
						group[i].team[0] = x; 
						System.out.println(group[i].groupName + "1: " + x.name);
						level_1.remove(k);
						i++;
					}
				}
				System.out.println("一档球队抽签完成！");
			}
			//抽四档球队
			else if(flag == 1){
				int i = 0;
				while(level_4.isEmpty()==false){
					k = random.nextInt(level_4.size());
					Team x = (Team)level_4.get(k);
					//检查是否满足各大洲规避
					s = CheckFlag(x,group[i]);
					if(s==true){
						group[i].team[3] = x; 
						System.out.println(group[i].groupName + "4: " + x.name);
						level_4.remove(k);
						i++;
					}
				}
				System.out.println("四档球队抽签完成！");
			}
			//抽三档球队
			else if(flag == 2){
				int i = 0;
				while(level_3.isEmpty()==false){
					k = random.nextInt(level_3.size());
					Team x = (Team)level_3.get(k);
					//检查是否满足各大洲规避
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
							System.out.println("抽签出现矛盾，重新抽取！");
							return false;
						}
					}
				}
				System.out.println("三档球队抽签完成！");
			}
			//抽二档球队
			else{
				int i = 0;
				while(level_2.isEmpty()==false){
					k = random.nextInt(level_2.size());
					Team x = (Team)level_2.get(k);
					//检查是否满足各大洲规避
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
							System.out.println("抽签出现矛盾，重新抽取！");
							return false;
						}
					}
				}
				System.out.println("二档球队抽签完成！");
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
		System.out.println("2018俄罗斯世界杯小组赛分组：");
		for(int i=0;i<8;i++){
			System.out.print("Group " + group[i].groupName + ":   ");
			for(int j=0;j<4;j++){
				System.out.print(group[i].team[j].name + '\t' + '\t');
			}
			System.out.print('\n');
		}
	}
}
