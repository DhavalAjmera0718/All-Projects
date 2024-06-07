package StreamPractise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class StreamDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> Slist = Arrays.asList(9,2,8,3,7,4,6,5);
		
	List<String> NameList = new ArrayList<>();
	NameList.add("Dhaval");
	NameList.add("kashyap");
	NameList.add("Dhoni");
	NameList.add("Virat");
		
		
		Stream<Integer> obj1 = Slist.stream();
		
		List<Integer> collect = obj1.filter(a->a%2==0).collect(Collectors.toList());
		System.out.println("New List >>> " + collect);
		
/**********************************************Comparision Of Variable Using OBJ of List***************************************************************************/	
		Integer x = 5;
		List<Integer> collect1 = Slist.stream().filter(a -> a == x).collect(Collectors.toList());
		System.out.println("Comparision With X Variable >> " + collect1);
	
	
/**********************************************************Find Elements Starts With D***************************************************************************/	

		List<String> collect2 = NameList.stream().filter(b -> b.startsWith("D")).collect(Collectors.toList());
		System.out.println("Find Eliments By Alphabet >> " + collect2);

		
/**********************************************************SQURE OF LIST***************************************************************************/	
		
		List<Integer> Squre = Slist.stream().map(c -> c * c).collect(Collectors.toList());
		System.out.println("Squre Of All Elemnts Is >>  " +Squre);

/**********************************************************Convert List To Upper Case***************************************************************************/	
		
		List<String> UpperCase = NameList.stream().map(c -> c.toUpperCase()).collect(Collectors.toList());
		System.out.println("All Elemnts Is In Uppercase >>  " +UpperCase);
	
	
/**********************************************************SQURE BY USING FOR EACH***************************************************************************/	
		
		Slist.stream().map(d -> d * d).forEach(e->{System.out.println(e + " ");});
		System.out.println("----------------------------------");
		Slist.stream().map(f -> f*f).forEach(System.out::println);
		//Slist.stream().map(d->d*d).forEach(y->System.out.println(y));
/**********************************************************Minimum From List Using Min Function***************************************************************************/	

		Integer Minumum = Slist.stream().min((z,w) -> z.compareTo(w)).get();
		 System.out.println("Minimum Value Of List Is >>>| " + Minumum);
		 
/**********************************************************Maximum From List Using max Function***************************************************************************/	

			Integer maximum = Slist.stream().max((z,w) -> z.compareTo(w)).get();
			 System.out.println("Minimum Value Of List Is >>>| " + maximum);		 
	
/**********************************************************Sorted List ***************************************************************************/	
			 List<Integer> SortedList = Slist.stream().sorted().collect(Collectors.toList());
			 System.out.println("Sorted Array is >>| " + SortedList);

/**********************************************************Square Using Anothor Class ***************************************************************************/	
			 
			 
			 OPR op = new OPR();
			 
			 List<Integer> GetDatabyClass = Slist.stream().map(G -> op.Squre(G) ).collect(Collectors.toList());
			 System.out.println("Get Square By Using Another Class >>| " + GetDatabyClass);
/**********************************************************Square Root Of List ***************************************************************************/	
			 
			 List<Double> SqureRoot = Slist.stream().map(h -> Math.sqrt(h)).collect(Collectors.toList());
			 System.out.println("Squre Root Of All List >>| " + SqureRoot);
			 
			 
	}
}
