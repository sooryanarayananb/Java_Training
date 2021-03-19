// Interface is a blueprint for class.
// It specifies a set of methods that the class has to implement.
// If a class implements an interface and does not provide method bodies for all functions 
// specified in the interface, then the class must be declared abstract.

// void methodOne(); is same as  public abstract Void methodOne(); in interface
// variables in interface are final, public and static by default.

// Java doesn't support multiple inhertiance on classes. But with the help of interface it is possible. 
// We can also add default implementation for interface methods. 

interface Vehicle{

	void changeGear(int a);
	void speedUp(int a);
	void applyBreak(int a);

}

class Bicycle implements Vehicle{

	int speed;
	int gear; 

	@Override
	public void changeGear(int currentGear){
		gear = currentGear;
	}

	@Override
	public void speedUp(int currentSpeed){
		speed += currentSpeed;
	}

	@Override
	public void applyBreak(int reduceSpeed){
		speed -= reduceSpeed;
	}

	public void printStates(){
		System.out.println("Speed :" + speed + ", gear :" + gear);
	}

}


class InterfaceExample{

	public static void main(String[] arg){

		Bicycle instance = new Bicycle();

		instance.printStates();
		instance.changeGear(2);
		instance.speedUp(30);
		instance.applyBreak(5);
		instance.printStates();

	}

}