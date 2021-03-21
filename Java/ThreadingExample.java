
class OddClass extends Thread{

	private int[] nums = {1, 3, 5, 7, 9};
	
	public void run(){

		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
			try{Thread.sleep(2000);} catch(Exception e){}; 
		}

	}

}


class EvenClass extends Thread{

	private int[] nums = {2, 4, 6, 8, 10};
	
	public void run(){

		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
			try{Thread.sleep(2000);} catch(Exception e){}; 
		}

	}

}

class ThreadingExample{

	public static void main(String[] args){

		OddClass obj1 = new OddClass();
		EvenClass obj2 = new EvenClass();

		obj1.start();
		obj2.start();

	}

}