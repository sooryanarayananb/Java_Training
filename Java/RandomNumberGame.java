import java.util.Scanner;
import java.util.Random;


class RandomNumberGame{

	static void startGame(){

		Random rand = new Random(); 
		int randNumber = rand.nextInt(15); 

		Scanner inputObj = new Scanner(System.in);

		System.out.println("Enter your guessed number: ");
		int guessedNumber = inputObj.nextInt();

		if(randNumber == guessedNumber){
			System.out.println("Awesome! You guessed the correct number");
		}else{
			System.out.println("The random number was: " + randNumber);
		}


	}

	public static void main(String[] args){

		Scanner inputObj = new Scanner(System.in);
		int gameStatus = 1;


		System.out.println("Welcome to the Random Game! \n");
		System.out.println("Enter your name:");

		String userName = inputObj.next();
		System.out.println("Hey" + userName);


		while(gameStatus != 0){

			System.out.println("Shall we start the game (1/0).");
			gameStatus = inputObj.nextInt();

			if(gameStatus == 0){

				System.out.println("The game is over.");
				System.exit(0);

			}else if(gameStatus == 1){

				for(int i = 0; i < 5; i++)
					startGame();
				System.out.println("Game Over!");

			}else{

				System.out.println("Incorrect input.");

			}
		}
	}

}