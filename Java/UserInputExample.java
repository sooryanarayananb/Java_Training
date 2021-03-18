// It should be String[] args not String args[]. 
// Both works becuse Java adopted it to help C/C++ programmers. 
// Using String[] args is preferred though. 

import java.util.Scanner;

class UserInputExample{

	public static void main(String[] args){

		Scanner myObj = new Scanner(System.in); 
		System.out.println("Enter Name:");

		String userName = myObj.nextLine(); 
		System.out.println("Name is :" + userName);

	}

}