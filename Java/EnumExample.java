// Every enum extends from Enum class which is in Java. 
// An enum is a special "class" that represents a group of constants 
// (unchangeable variables, like final variables).
// enum can be inside or outside a class. 
// enum can also have attributes, methods as same as classes. 

// enum is converted by compiler tos:
// class Mobile {
//   static final Mobile APPLE = new Mobile();  
// }


//Grouping 

enum Mobile {

	APPLE(400), SAMSUNG(200), MI;

	int price; 

	Mobile(){
		price = 80;
	}

	Mobile(int p){
		price = p;
	}

	public int getPrice(){
		return price;
	}

}

class EnumExample{

	public static void main(String args[]){

		System.out.println(Mobile.APPLE.getPrice());

		Mobile m[] = Mobile.values();

		for(Mobile i: m){
			System.out.println(i.getPrice());
		}

	}

}