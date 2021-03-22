


class ThreadingSynchronizedExample{

	private static int count = 0; 

	public static synchronized void incount(){
		count++;
	}

	public static void main(String[] args){

		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i < 1000; i++)
					incount();
			}
		});

		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i < 1000; i++)
					incount();
			}
		});

		t1.start();
		t2.start();

		try{
			t1.join();
			t2.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}

		System.out.println(count);

	}

}