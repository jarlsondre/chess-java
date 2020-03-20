package uke12.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Feiltyper {


		// Diverse feiltyper! Alle er kommentert ut da de, naturlig nok, krasjer programmet.
	public static void main(String[] args) {


		// Nullpointerexception:
		//				String foo = null;
		//		        int length = foo.length();   

		// Classcastexception:
		//		        Object i = Integer.valueOf(42);
		//		        String s = (String)i; 

		// Indexoutofboundserror:
		//		List<String> ls=new ArrayList<>();
		//	      ls.add("a");
		//	      ls.add("b");
		//	      ls.get(3); // Element nummer 3 er...

		// nosuchelementexception:
		//				List<String> ls = new ArrayList<>();
		//				Iterator<String> it = ls.iterator();
		//				System.out.println(it.next());

		
		// UnsupportedOperationException
//				String[] flowers = { "Ageratum", "Allium", "Poppy", "Catmint" }; 
//				List<String> flowerList = Arrays.asList(flowers);  

				// Sjekk javadoc for Arrays.asList() eller hold mus over asList - 
				// lister som lages på denne måten kan ikke endre størrelse!
//				flowerList.add("Celosia"); // Utløser unntak
//				flowerList.forEach(System.out::println);

//				System.out.println(flowerList.getClass());
//				List<String> flowerList2 = new ArrayList<>(Arrays.asList(flowers));
//				flowerList2.add("Celosia"); // Nå utløses ikke unntak. Hva er ulikt?
//				flowerList2.forEach(System.out::println);

		

		// IllegalArgumentException: Her: to like nøkler
		//		Map<String, Integer> tempMap = Map.of(
		//		        "Ost",    13,
		//		        "Pølse",      19,
		//		        "Ost",    13, // !
		//		        "Bacalao",      14
		//		);
	}

}
