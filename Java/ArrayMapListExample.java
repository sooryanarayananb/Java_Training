import java.util.*;

class ArrayMapListExample{

	public static void main(String[] args){

		// Arrays
		String[] cars = {"BMW", "Audi", "Maruti", "Tata Motors"};
		cars[1] = "Benz";

		for(String i: cars){
			System.out.println(i);
		}

		System.out.println();

		// ArrayList
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 5; i++)
			nums.add(i + 1);

		nums.remove(0);
		nums.add(3, 13);

		for(int i: nums)
			System.out.println(i);


		// HashMap

		HashMap<String, String> capitialCities = new HashMap<String, String>();
		capitialCities.put("India", "New Delhi");
		capitialCities.put("USA", "Washington DC");


		// Print keys
		for (String i : capitalCities.keySet()) {
		  System.out.println(i);
		}

        // Print values
		for (String i : capitalCities.values()) {
		  System.out.println(i);
		}

		// Print keys and values
		for (String i : capitalCities.keySet()) {
		  System.out.println("key: " + i + " value: " + capitalCities.get(i));
		}


	}

}