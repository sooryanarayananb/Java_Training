class Emp{

  	int empId;
  	static String ceo;

  	//Use static block to execute code once even though it may have many objects.
  	static{
  		ceo = "Larry";
  	}

  	public void show(){
  		System.out.println("empId is :" + empId + ", CEO is :" + ceo);
  	}

}

public class StaticExample {
  

  public static void main(String[] args) {
  	
  	// Emp.ceo = "Larry"; - Accessing static variable using classname.  

  	Emp obj1 = new Emp();
  	obj1.empId = 13;

  	Emp obj2 = new Emp();
  	obj2.empId = 22;

  	obj1.show();
  	obj2.show();

  }
}

//By making ceo static, it would stored in the heap area and would be shared with all the objects. 
//To access static variables you don't need an object. You can use the classname itself. 