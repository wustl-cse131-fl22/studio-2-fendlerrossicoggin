package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		
		System.out.print("What is the amount of money you start with?: ");
		double startAmount = in.nextDouble();
		
		System.out.print("What is the win probibility in decimal form?: ");
		double winChance = in.nextDouble();
		
		System.out.print("What is the win limit?: ");
		double winLimit = in.nextDouble();
		
		System.out.print("How many similations do you want to play?: ");
		int totalSimulations = in.nextInt();
		
		
		int lose=0;
		int win=0;
		for (int i = 0; i < totalSimulations; i++) {
			double chance = Math.random();	
			if (startAmount == winLimit) {
				break;
			}
			if (startAmount == 0) {
				break;
			}
			
			if (chance < winChance) {
				
				startAmount++;
				win ++;
			}else {
				
				startAmount--;
				lose++;
			}
		}
		
			
		
		
		
			double ruinRate = (((double)(lose))/totalSimulations); 
			
			double expectedRuinRate; 
			if (winChance == 0.5) {
				expectedRuinRate = 1 - (startAmount/winLimit) ; 
						
			}else {
				double a = ((1 - winChance)/winChance);
				expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
			}
			
	
			double scale = Math.pow(10, 2);
			expectedRuinRate = Math.round(expectedRuinRate*scale)/scale;
			
			
			System.out.println("End money amount: " + startAmount);
			System.out.println("Amount of wins: " + win);
			System.out.println("Amount of losses: " + lose);
			System.out.println("Ruin Rate: " + ruinRate);
			System.out.println("Expected Ruin Rate: " + expectedRuinRate);
						
			
			
			
			
}
}
