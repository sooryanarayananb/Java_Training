// It is only applicable for List collection implemented classes like arraylist, linkedlist etc. 
// It provides bi-directional iteration.

import java.util.ArrayList;
import java.util.ListIterator;

class ListIteratorExample{

	public static void main(String[] args){

		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
			nums.add(i);

		System.out.println(nums);

		ListIterator itr = nums.listIterator();

		while(itr.hasNext()){

			int i = (Integer)itr.next();
			System.out.print(i + " ");

			if(i % 2 == 0){
				i++;
				itr.set(i);
				itr.add(i + 5);
			}
		}

		System.out.println("");
		System.out.println(nums);

	}

}