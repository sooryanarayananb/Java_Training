// We cannot use the static keyword with a class unless it is an inner class.(There can also be 
// other inner classes which are not static).
// A static inner class is a nested class which is a static member of the outer class. 
// It can be accessed without instantiating the outer class, using other static members. 
// Just like static members, a static nested class does not have access to the instance 
// variables and methods of the outer class.

// To access an non-static Inner class, we need to first intalize Outer class object, 
// Then only we would be able to create an instance of non-static Inner class.

class Outer{

	static class Inner{
		public void innerMethod(){
			System.out.println("This is from the inner method.");
		}
	}

}


public class StaticClassExample{

	public static void main(String args[]){

		Outer.Inner instance = new Outer.Inner();
		instance.innerMethod();
	}

}