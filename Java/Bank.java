import java.util.*;
import java.text.*;
import java.io.*;

enum BankLocation{
	
	CHENNAI,
	KOCHI,
	PUNE
}


interface SavingsAccount
{
	void deposit(double n);
	void withdraw(double n);
}


class Customer implements SavingsAccount
{
	String username, password, name, address, phone;
	double balance;
	BankLocation homeBranch;
	ArrayList<String> transactions;
	
	Customer(String username, String password, String name, String address, String phone, double balance, BankLocation homeBranch)
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.balance = balance;
		this.homeBranch = homeBranch;

		transactions  =  new ArrayList<String>(5);
		addTransaction("Initial deposit - " + balance);
	}

	@Override
	public void deposit(double amount)
	{
		balance += amount;
		addTransaction(amount + " credited to your account. Balance - " + balance);
	}

	@Override
	public void withdraw(double amount)
	{
		if(amount > (balance - 200))
		{
			System.out.println("Insufficient balance.");
			return;
		}
		balance -= amount;
		addTransaction( amount +" debited from your account. Balance - " + balance);
	}

	private void addTransaction(String message)
	{
			transactions.add(0, message);
			if(transactions.size() > 5)
			{
				transactions.remove(5);
				transactions.trimToSize();
			}
	}

	public static void displayMenu(){

			System.out.println("\n-------------------");
			System.out.println("Welcome to the bank.");
			System.out.println("-------------------\n");
			System.out.println("1. Register account.");
			System.out.println("2. Login.");
			System.out.println("3. Exit.");
			System.out.print("\nEnter your choice : ");

	}
}


class Bank
{
	
	final static String outputFilePath = "banking_records.txt";

	Map<String,Customer> customerMap;

	Bank()
	{
		customerMap = new HashMap <String,Customer>();
	}
	
	public static void main(String []args)
	{
		
		Scanner sc  =  new Scanner(System.in);
		Customer customer;
		String username,password;double amount;
		Bank bank  =  new Bank();
		int choice;
	outer:	while(true)
		{

			Customer.displayMenu();
			choice = sc.nextInt();
			sc.nextLine();

			switch(choice)
			{
				case 1:

					System.out.print("Enter name : ");
					String name = sc.nextLine();
					System.out.print("Enter address : ");
					String address = sc.nextLine();
					System.out.print("Enter contact number : ");
					String phone = sc.nextLine();
					System.out.println("Set username : ");
					
					username = sc.next();
					while(bank.customerMap.containsKey(username))
					{
						System.out.println("Username already exists. Set again : ");
						username = sc.next();
					}
					
					System.out.println("Set a password :");
					password = sc.next();
					sc.nextLine();
					
					System.out.print("Enter initial deposit : ");
					while(!sc.hasNextDouble())
					{
						System.out.println("Invalid amount. Enter again :");
						sc.nextLine();
					}
					
					amount = sc.nextDouble();
					
					BankLocation homeBranch = BankLocation.CHENNAI;
					customer = new Customer(username, password, name, address, phone, amount, homeBranch);
					bank.customerMap.put(username,customer);

					File file = new File(outputFilePath);
					BufferedWriter bf = null;

					try{

						bf = new BufferedWriter(new FileWriter(file));

						for(Map.Entry<String, Customer> entry:  bank.customerMap.entrySet()){

							bf.write(entry.getKey() + " : " + entry.getValue());
							bf.newLine();

						}

						bf.flush();

					} catch(IOException e){

						e.printStackTrace();

					} finally{

						try{
							bf.close();

						}catch(Exception e){

							e.printStackTrace();
						}
					}
					
					break;

				case 2:

					System.out.println("Enter username : ");
					username = sc.next();
					sc.nextLine();
					System.out.println("Enter password : ");
					password = sc.next();
					sc.nextLine();
					if(bank.customerMap.containsKey(username))
					{
						customer = bank.customerMap.get(username);
						if(customer.password.equals(password))
						{
							while(true)
							{
								System.out.println("\n-------------------");
								System.out.println("W  E  L  C  O  M  E");
								System.out.println("-------------------\n");
								System.out.println("1. Deposit.");
								System.out.println("2. Transfer.");
								System.out.println("3. Last 5 transactions.");
								System.out.println("4. User information.");
								System.out.println("5. Log out.");
								System.out.print("\nEnter your choice : ");
								choice = sc.nextInt();
								sc.nextLine();
								switch(choice)
								{
									case 1:
									       System.out.print("Enter amount : ");
									       while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									       amount = sc.nextDouble();
									       sc.nextLine();
	                                       customer.deposit(amount);
									       break;

									case 2:
									       System.out.print("Enter payee username : ");
									       username = sc.next();
									       sc.nextLine();
									       System.out.println("Enter amount : ");
									       while(!sc.hasNextDouble())
									       {
										       System.out.println("Invalid amount. Enter again :");
										       sc.nextLine();
									       }
									       amount = sc.nextDouble();
									       sc.nextLine();
									       if(amount > 300000)
									       {
										       System.out.println("Transfer limit exceeded. Contact bank manager.");
										       break;
									       }
									       if(bank.customerMap.containsKey(username))
									       {
										       Customer payee = bank.customerMap.get(username);
										       payee.deposit(amount);
										       customer.withdraw(amount);
									       }
									       else
									       {
										       System.out.println("Username doesn't exist.");
									       }
									       break;

									case 3:
									       for(String transactions : customer.transactions)
									       {
										       System.out.println(transactions);
									       }
									       break;

									case 4:

									       System.out.println("Accountholder name : " + customer.name);
									       System.out.println("Accountholder address : " + customer.address);
									       System.out.println("Accountholder contact : " + customer.phone);
									       break;

									case 5:
									       continue outer;

								    default:
									        System.out.println("Wrong choice!");
								}
							}
						}
						else
						{
							System.out.println("Wrong username/password.");
						}
					}
					else
					{
						System.out.println("Wrong username/password.");
					}
					break;
				case 3:
					System.out.println("\n Have a nice day."); 
					System.exit(1);
					break;
				default:
					System.out.println("Wrong choice!");
			}
		}
	}
}