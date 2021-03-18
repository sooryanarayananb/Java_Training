// A lambda expression is a short block of code which takes in parameters and returns a value. 
// Lambda expressions are similar to methods, but they do not need a name and they can be 
// implemented right in the body of a method.

// Lambda expressions can be stored in variables if the variable's type is an interface 
// which has only one method. The lambda expression should have the same number of parameters 
// and the same return type as that method. Java has many of these kinds of interfaces built in, 
// such as the Consumer interface (found in the java.util package) used by lists.

import java.util.ArrayList;

class LambdaExpressionExample{

	public static void main(String args[]){

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);

		numbers.forEach((n) -> { System.out.println(n); });

	}

}