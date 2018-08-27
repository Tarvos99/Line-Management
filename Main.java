/*Jason Grant
 * 6/11/18
 * CS 610-850 Summer 18
 * Programming Assignment #1 */
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		//scan for user input for each of the following
		
		System.out.println("Hey there Zhenliang, how much time (in minutes) would you like to give passengers to check-in?");
		int x = scanner.nextInt();
		
		System.out.println("What is the average coach arrival rate (in minutes and non-zero) ?");
		int y = scanner.nextInt();
		
		System.out.println("What is the average coach service rate (in minutes and non-zero) ?");
		int z = scanner.nextInt();
		
		System.out.println("What is the average first class arrival rate (in minutes and non-zero) ?");
		int w = scanner.nextInt();
		
		System.out.println("What is the average first class service rate (in minutes and non-zero) ?");
		int v = scanner.nextInt();
		
		FrontDesk airport = new FrontDesk(x,y,z,w,v);
		airport.arrivals();//handle initial passenger arrival/servcing prior to conclusion of user inputted check in time
		airport.overTime();//handle passenger arrival/servicing after conclusion of user inputted check in time
		airport.testA();//used to print out desired output results
		
		scanner.close();
		
	}
}
