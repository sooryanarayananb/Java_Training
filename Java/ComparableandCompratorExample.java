import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


class Laptop implements Comparable<Laptop>{

	private String brand;
	private int ram;
	private int price;

	public Laptop(String brand, int ram, int price){
		super();
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}

	public String getBrand(){
		return brand;
	}	

	public int getRam(){
		return ram;
	}	

	public int getPrice(){
		return price;
	}

	public int compareTo(Laptop obj){
		if(this.price > obj.price)
			return 1;
		else
			return -1; 
	}

	public void display(){
		System.out.println("Brand: " + brand + ", ram: " + ram + " , price: " + price);
	}

}


class ComparableandCompratorExample{

	public static void main(String[] args){

		ArrayList<Laptop> laptops = new ArrayList<Laptop>();

		laptops.add(new Laptop("Apple", 12, 1200));
		laptops.add(new Laptop("Dell", 6, 200));
		laptops.add(new Laptop("Mi", 8, 100));

		Collections.sort(laptops);

		for(Laptop obj: laptops){
			obj.display();
		}

		System.out.println();

		Comparator<Laptop> com = new Comparator<Laptop>(){
			public int compare(Laptop l1, Laptop l2){
				if(l1.getRam() < l2.getRam())
					return 1;
				else
					return -1;
			}
		};
		
		Collections.sort(laptops, com);

		for(Laptop obj: laptops){
			obj.display();
		}


	}

}