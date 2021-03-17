// Helps method that needs variable number of arguments. 
// A method that takes a variable number of arguments is a varargs method
//
// Example:
//
// public static void fun(int ... a) 
// {
//    method body
// }
//
// This syntax tells the compiler that fun() can be called with zero or more arguments.
// yntax tells the compiler that varargs has been used and these arguments should be stored 
// in the array referred to by a.
// The variable a is operated on as an array. In this case, we have defined the 
// data type of a as int. So it can take only integer values.


public class VariableArgumentsExample{

	static void variableArgumentMethod(int ... variableParameter){

		System.out.println("Number of arguments: " + variableParameter.length);

		// To display each content
		for(int i: variableParameter)
			System.out.print(i + " ");
		System.out.println();

	}

	public static void main(String args[]){

		variableArgumentMethod(100);
		variableArgumentMethod(10, 20, 30);
		variableArgumentMethod();

	}

}