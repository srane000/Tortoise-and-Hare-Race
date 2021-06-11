import java.security.SecureRandom;
public class TortoiseAndHare {
/**
 * static variables 4 of them
 * a timer to keep count of the race
 * a random number class to create random numbers
 */
	public final static int MAX_MOVES = 100;
	public final static int MAX_ITERATIONS = 2000;
	public static int tortpos = 1;
	public static int harepos = 1;
	private static int timer = 0;
	SecureRandom rand = new SecureRandom();
	
	public static void main(String[] args) {
		
		//TortoiseAndHare obj1 = new TortoiseAndHare();
		
	}
	/**
	 * default constructor which calls the other 
	 * methods in the class. Uses a timer to keep
	 * track of the iterations.
	 */
		public TortoiseAndHare() {
			System.out.println("On your mark, Get Set");
			System.out.println("Bang!!!!");
			System.out.println("And they're off!!!");
			
			do {
				printPositions();
				simulateTortoiseMove();
				simulateHareMove();
				timer++;
			}
			
			/**
			 * If-else statement to determine
			 * if the hare or tortoise wins then it prints that respectively.
			 * otherwise both wins then there is a tie.
			 * A boundary check if the hare wins which in
			 * this program it always wins
			 */
			while(tortpos < MAX_MOVES && harepos < MAX_MOVES && timer < MAX_ITERATIONS); {
			if(tortpos > harepos) {
				printPositions();
				System.out.println("Tortoise Wins!!");
			}
			else if(harepos > tortpos) {
				printPositions();
				System.out.println("Hare wins. Yuch!!");
			}
			else if(harepos == tortpos) {
				printPositions();
				System.out.println("Its a tie.");
			}
			if(timer >= MAX_ITERATIONS) {
				System.out.println("Time out!");
				System.out.println("Hare wins. Yuch!!");
			}
			System.out.println("Time elapsed = " + timer + "seconds");
		}
		}
			
		
		
	/**
	 * There are a finite cap of max moves
	 * and if both are equal to index, it prints B on the track.
	 * Otherwise the tortoise or hare is ahead.
	 * If none of the mammals is on that spot an empty space is printed.
	 * The track is printed in the for loop capped by max moves.
	 */
	private void printPositions() {
		int index;
		
		
		for (index = 1; index <= MAX_MOVES; index++) {
			if(index == tortpos && index == harepos) {
				System.out.print("B");
			}
			else if(index == tortpos) {
				System.out.print("T");
			}
			else if(index == harepos) {
				System.out.print("H");
			}
			else
				System.out.print(" ");
		}
		System.out.println();
		for(int i = 1; i<= MAX_MOVES ; i++) {
			
			System.out.printf("%s","-");
		}
		System.out.println();
		
		}
	
	/**
	 * a randomBetween which returns a random
	 * number between two limits that are inclusive 
	 * of each other
	 * @param a lower limit
	 * @param b upper limit
	 * @return
	 */
	private int randomBetween(int b,int a){
		return a+(int)(Math.random()*((b - a)+1));
	}
	
	/**
	 * simulate the moves of the tortoise
	 * based on figure 1. Based on a randomBetween function
	 * it takes values from 0 through 9 indicates categories the tortoise falls under.
	 * The randomBetween method also randomizes the movement of the tortoise when printed on the track.
	 */
	private void simulateTortoiseMove(){
		int counter = randomBetween(9,0);
		if(counter >= 0 && counter <= 3) { //if tortoise jumps
			tortpos = tortpos + randomBetween(3,1);
		}
	 
			else if(counter >= 4 && counter <= 6) { //if tortoise slips
			tortpos = tortpos - randomBetween(6,1);
			}

			else if(counter >= 7 && counter <=8) { //if tortoise walks 
			tortpos = tortpos + randomBetween(1,0);
			}
			else{//if tortoise sleeps
			
			}
			
		if (tortpos < 1) {
			tortpos = 1;
		}
		else if (tortpos > MAX_MOVES) {
			tortpos = MAX_MOVES;
		}
	}
	/**
	 * simulates the movement for the hare.
	 * a switch statement is used to defines how the hare
	 * will move using the same randomBetween function.
	 * Cases indicate category and randomBetween is used for movement of the hare.
	 */
	private void simulateHareMove() {
		int count = randomBetween(9,0);
		switch(count) {
		case 0://Sleep for hare
			break;
		case 1:
		case 2:
		case 3://jump for hare
			harepos += randomBetween(5,1);
			break;
		case 4:
		case 5://small slip for hare
			harepos -= randomBetween(2,1);
			if (harepos < 1) {
				harepos = 1;
			}
			break;
		case 6://big slip for hare
			harepos -= randomBetween(7,1);
			if (harepos < 1) {
				harepos = 1;
			}
			break;
		case 7:
		case 8:
		case 9://walk for hare
			harepos += randomBetween(1,0);
			break;
		}
		
		if (harepos > MAX_MOVES) {
			harepos = MAX_MOVES;
		}
	}
	
	}


