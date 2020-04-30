import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class InstanceTest {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		ArrayList<Employee> Roster = new ArrayList<Employee>();
		Roster.add(new Employee(1, 20, "田中　太郎"));
		Roster.add(new Employee(2, 40, "鈴木　二郎"));
		Roster.add(new Employee(3, 19, "山田　花子"));
		Roster.add(new Employee(4, 31, "橋本　士郎"));
		Roster.add(new Employee(5, 54, "高橋　五郎"));
		Roster.add(new Employee(6, 22, "吉田　歩"));
		Roster.add(new Employee(7, 30, "和田　花"));
		Roster.add(new Employee(8, 28, "山崎　連"));
		Roster.add(new Employee(9, 33, "三浦　一美"));
		Collections.shuffle(Roster);
		
		mainloop: while(true){
			System.out.print("ソートする基準を選んで下さい[1:社員番号(昇順), 2:社員名(昇順), 3:年齢(降順), 9:終了] > ");
			
			switch (scan.next()){
			case "1":
				Collections.sort(Roster, new CompById());
				System.out.println("****\t社員番号 昇順で並べ替え\t****");
				printRoster(Roster);
				break;
			case "2":
				Collections.sort(Roster, new CompByName());
				System.out.println("****\t社員名 昇順で並べ替え\t****");
				printRoster(Roster);
				break;
			case "3":
				Collections.sort(Roster, new CompByAge());
				System.out.println("****\t年齢 降順で並べ替え\t****");
				printRoster(Roster);
				break;
			case "9":
				System.out.println("**** **** **** 終了します **** **** ****");
				break mainloop;
			default:
				System.out.println("[Err]無効な入力です．次の半角数字を入力して下さい[1/2/3/9]");
				continue;
			}
		}
		scan.close();
	}
	
	
	static void printRoster(ArrayList<Employee> r){
		for(Employee e: r){
			System.out.println(e.toString());
		}
		System.out.println("****\t****\t****\t****\t****\t****\t****");
	}
	
	
	
	static class Employee{
		private int id, age;
		private String name;
		
		
		public Employee(int id, int age, String name){
			this.id = id;
			this.age = age;
			this.name = name;
		}
		
		
		public int getId(){
			return this.id;
		}
		
		
		public int getAge(){
			return this.age;
		}
		
		
		public String getName(){
			return this.name;
		}
		
		public String toString(){
			return "社員番号:\t" + this.id +
					", \t社員名:\t" + this.name +
					", \t年齢:\t " + this.age;
		}
	}
	
	
	
	static class CompById implements Comparator<Employee>{
		public int compare(Employee e1, Employee e2) {
			return e1.getId() - e2.getId();
		}
	}
	
	
	
	static class CompByAge implements Comparator<Employee>{
		public int compare(Employee e1, Employee e2) {
			return e2.getAge() - e1.getAge();
		}
	}
	
	
	
	static class CompByName implements Comparator<Employee>{
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	}
}
