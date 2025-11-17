import java.util.*;

class Test1{
	public static void main(String[] args){
		List list = new ArrayList();
		list.add("apple");
		list.add(12);
		list.add(45.67);

		/*Collections.sort(list);
		System.out.println(list);*/
		for(Object item : list)
			System.out.println(item);
	}
}

class Test2{
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		//list.add(12);

		for(String item : list)
			System.out.println(item);
	}
}


class Test3{
	public static void main(String[] args){
		List<String> fruits = new ArrayList<>();
		fruits.add("Mango");
		fruits.add("Apple");
		fruits.add("Banana");
		
		Collections.sort(fruits);
		System.out.println(fruits);

		/*Collections.sort(fruits, Comparator.reverseOrder());
		System.out.println(fruits);*/
	}
}


class Test4{
	public static void main(String[] args){
		List<Integer>  numbers  = new ArrayList<>();
		numbers.add(12);
		numbers.add(9);
		numbers.add(10);
		
		Collections.sort(numbers, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return a-b;
			}
		});
		
		System.out.println(numbers);
	}
}

class Test5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<Integer>  numbers  = new ArrayList<>();
		//type -1 for to stop
		while(true){
			System.out.println("Enter Number : ");
			int num = sc.nextInt();
			if(num == -1)
				break;
			if(numbers.contains(num))
				System.out.println("Duplicate entry " + num);
			else
				numbers.add(num);
		}
		
		System.out.println(numbers);
	}
}

class Employee
{
	public String toString(){
		return "Employee Object";
	}
}
class Test6{
	public static void main(String[] args){	
		List list = new ArrayList();
		list.add(new Employee());
		list.add(new Employee());
		list.add(new Employee());

		for(Object item : list)
			System.out.println(item);
	}
}
