// Iterator is a universal iterator and we can apply it to any collection object.
// Only forward direction iterating is possible.
// Replacement and addition of new element is not supported by Iterator.

import java.util.ArrayList; 
import java.util.Iterator; 

class IteratorExample{

	public static void main(String[] args){

		ArrayList<Integer> nums = new ArrayList<Integer>();


		for(int i = 0; i < 5; i++)
			nums.add(i);

		System.out.println(nums);

		Iterator itr = nums.iterator();

		while(itr.hasNext()){

			int i = (Integer)itr.next();
			System.out.println(i + " ");

			if(i % 2 != 0)
				itr.remove();

		}
		System.out.println();
		System.out.println(nums);
	}

}