import java.util.*;
class Demo implements Comparable{
	int val;
	String name;
	Demo(int data, String name){
		val = data;
		this.name = name;
	}
	public int compareTo(Object obj){
		Demo d = (Demo)obj;
		return this.name.compareTo(d.name);
		//return d.val - this.val; //descending order
		//return this.val - d.val; //ascending order
	}
	public String toString(){
		return ""+val+" "+name;
	}
}
class Test {
	public static void main(String args[]){
		List<Demo> al = new ArrayList<>();
		al.add(new Demo(101, "Ram"));
		al.add(new Demo(99, "Ajay"));
		al.add(new Demo(202, "Bharath"));
		Collections.sort(al);
		System.out.println(al);
	}
}