/*Jason Grant
 * 6/11/18
 * CS 610-850 Summer 18
 * Programming Assignment #1 */

public class FrontDesk {//front desk class to handle arriving passengers, servicing passengers, and removing passengers from a line(queue)
	public FrontDesk (int checkintime, int coacharr, int coachserr, int firstarr, int firstserr) {
		this.checkintime = checkintime;//constructor method to set variables based on input from user
		this.coacharr = coacharr;
		this.coachserr = coachserr;
		this.firstarr = firstarr;
		this.firstserr = firstserr;
	}
	
	private int checkintime; //total time allowed for checkin determined by user input
	private int coacharr; //average coach passenger arrival time
	private int coachserr; //average coach passenger service time
	private int firstarr; //average first class passenger arrival time
	private int firstserr; // average first class passenger service time
	private int simtime=0; //how long simulation actually ran for to account for after check-in time but with people still waiting in line
	
	private double createcc= Math.random(); //used to determine randomly when to create a new first class passenger
	private double createfc= Math.random(); //used to determine randomly when to create a new coach passenger
	
	private double servicecc1= Math.random();//used to determine randomly when to service a passenger in coach class line
	private double servicecc2= Math.random();
	private double servicecc3= Math.random();
	
	private double servicefc1= Math.random();//used to determine randomly when to service a passenger in first class line
	private double servicefc2= Math.random();
	
	public FCQueue coachone = new FCQueue(10); //create 5 new instances of FCQueue class, 3 for coach, 2 for first class
	public FCQueue coachtwo = new FCQueue(10);
	public FCQueue coachthree = new FCQueue(10);
	public FCQueue fcone = new FCQueue(10);
	public FCQueue fctwo = new FCQueue(10);
	
	
	public void arrivals() {//handle arrivals to line and servicing passengers at front of line
		
		while(simtime < checkintime) {//allow passengers to arrive in line as long as checkintime is not over
			
			int a = fcone.size();//get the current size of each line
			int b = fctwo.size();
			
			if(firstarr >0 && createfc <= 1/firstarr) {//check if its time to create new first class passenger
				createfc = Math.random();
				Passenger customer = new Passenger(1,coacharr, coachserr, firstarr, firstserr);
				if(a <=b) {
					fcone.insertQ(customer);
				}
				else {
					fctwo.insertQ(customer);
				}
			}
			else {//if not, de increment the createfc variable and continue on
				createfc = createfc -0.1;
			}
			
			int c = coachone.size(); //get the current size of each line
			int d = coachtwo.size();
			int e = coachthree.size();
			int f = fcone.size();
			int g = fctwo.size();

			if(coacharr >0 && createcc <= 1/coacharr) {//check if its time to create new coach class passenger
				createcc = Math.random();
				Passenger customer = new Passenger(0,coacharr, coachserr, firstarr, firstserr);
				if((f == 0 || g ==0) && c !=0 && d!= 0 && e !=0) {//check if either of the first class queues are free and add them here if none of the coach lines are empty
					if(f ==0) {
						fcone.insertQ(customer);
					}
					else {
						fctwo.insertQ(customer);
					}
				}
				else {
					if(c <= d && c <=e) { //find the shortest coach customer line and add customer to it
						coachone.insertQ(customer);
					}
					else {
						if(d <=c && d <= e) {
							coachtwo.insertQ(customer);
						}
						else {
							coachthree.insertQ(customer);
						}
					}
				}
			}
			else {//if note time, de-increment createcc variable and move on
				createcc = createcc - 0.1;
			}
			
			//set of code to track current status of each line
			Passenger[] noice = coachone.printArray();//get current coachone array entries
			System.out.print("Current CoachOne line array for Minute "+simtime+": [");
			for(int i =coachone.getFront(); i <coachone.getBack(); i++) {
				if(noice[i] != null) {
					System.out.print(noice[i].getID()+", ");
				}
			} System.out.print("]");
			System.out.println();
			
			Passenger[] noice1 = coachtwo.printArray();//get current coachtwo array entries
			System.out.print("Current CoachTwo line array for Minute "+simtime+": [");
			for(int i =coachtwo.getFront(); i <coachtwo.getBack(); i++) {
				if(noice1[i] != null) {
					System.out.print(noice1[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			Passenger[] noice2 = coachthree.printArray();//get current coachthree array entries
			System.out.print("Current CoachThree line array for Minute "+simtime+": [");
			for(int i =coachthree.getFront(); i <coachthree.getBack(); i++) {
				if(noice2[i] != null) {
					System.out.print(noice2[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			Passenger[] noice3 = fcone.printArray();//get current fcone array entries
			System.out.print("Current FCOne line array for Minute "+simtime+": [");
			for(int i =fcone.getFront(); i <fcone.getBack(); i++) {
				if(noice3[i] != null) {
					System.out.print(noice3[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			Passenger[] noice4 = fctwo.printArray();//get current fctwo array entries
			System.out.print("Current FCTwo line array for Minute "+simtime+": [");
			for(int i =fctwo.getFront(); i <fctwo.getBack(); i++) {
				if(noice4[i] != null) {
					System.out.print(noice4[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();

			
			coachone.updateMaxSize();//update max size for each queue
			coachtwo.updateMaxSize();
			coachthree.updateMaxSize();
			fcone.updateMaxSize();
			fctwo.updateMaxSize();
			
			if(coachone.frontOfLine() != null) {//if someone is at front of the line, update busy time of front desk of that specific line
				coachone.updateBusyTime();
			}
			
			if(coachtwo.frontOfLine() != null) {
				coachtwo.updateBusyTime();
			}
			if(coachthree.frontOfLine() != null) {
				coachthree.updateBusyTime();
			}
			if(fcone.frontOfLine() != null) {
				fcone.updateBusyTime();
			}
			if(fctwo.frontOfLine() != null) {
				fctwo.updateBusyTime();
			}
			
			//check if there is a first class passenger at the front of the queue and if its time to remove one
			if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1 && servicefc1 <= 1/firstserr) {
				servicefc1 = Math.random();
				fcone.removeQ();
			}
			else {//if not, then de-increment the servicefc variable
				if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1) {
					servicefc1 = servicefc1 - 0.1;
				}
			}
			
			if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1 && servicefc2 <= 1/firstserr) {
				servicefc2 = Math.random();
				fctwo.removeQ();
			}
			else {
				if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1) {
					servicefc2 = servicefc2 - 0.1;
				}
			}

			//check to see if coach class passenger in first class line can be serviced
			if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1 && servicefc1 <= 1/coachserr) {
				servicefc1 = Math.random();
				fcone.removeQ();
			}
			else {
				if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1) {
					servicefc1 = servicefc1 - 0.1;
				}
				
			}
			
			if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1 && servicefc2 <= 1/coachserr) {
				servicefc2 = Math.random();
				fctwo.removeQ();
			}
			else {
				if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1) {
					servicefc2 = servicefc2 - 0.1;
				}
			}
			

			
				//check to see if coach class passenger in coach class line can be serviced
			if(!coachone.isEmpty() && servicecc1 <= 1/coachserr) {
				servicecc1 = Math.random();
				coachone.removeQ();
			}
			else {
				servicecc1 = servicecc1 - 0.1;
			}
			
			if(!coachtwo.isEmpty() && servicecc2 <= 1/coachserr) {
				servicecc2 = Math.random();
				coachtwo.removeQ();
			}
			else {
				servicecc2 = servicecc2 - 0.1;
			}
			
			if(!coachthree.isEmpty() && servicecc3 <= 1/coachserr) {
				servicecc3 = Math.random();
				coachthree.removeQ();
			}
			else {
				servicecc3 = servicecc3 - 0.1;
			}
			
			

			coachone.updateWT(); //update wait times for each line
			coachtwo.updateWT();
			coachthree.updateWT();
			fcone.updateWT();
			fctwo.updateWT();
			

			
			simtime++;
		}
	}
	
	
	public void overTime() {//while there are still passengers in the line, continue to service the remaining passengers after check-in time has concluded
		//essentially same come from removal part of arrivals method copy pasta
		while(coachone.size()!= 0 || coachtwo.size()!= 0 || coachthree.size()!= 0 || fcone.size()!= 0 || fctwo.size() !=0) {
			
			//set of code to track current status of each line
			Passenger[] noice = coachone.printArray();//get current coachone array entries
			System.out.print("Current CoachOne line array for Minute "+simtime+": [");
			for(int i =coachone.getFront(); i <coachone.getBack(); i++) {
				if(noice[i] != null) {
					System.out.print(noice[i].getID()+", ");
				}
			} System.out.print("]");
			System.out.println();
			
			Passenger[] noice1 = coachtwo.printArray();//get current coachtwo array entries
			System.out.print("Current CoachTwo line array for Minute "+simtime+": [");
			for(int i =coachtwo.getFront(); i <coachtwo.getBack(); i++) {
				if(noice1[i] != null) {
					System.out.print(noice1[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			Passenger[] noice2 = coachthree.printArray();//get current coachthree array entries
			System.out.print("Current CoachThree line array for Minute "+simtime+": [");
			for(int i =coachthree.getFront(); i <coachthree.getBack(); i++) {
				if(noice2[i] != null) {
					System.out.print(noice2[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			Passenger[] noice3 = fcone.printArray();//get current fcone array entries
			System.out.print("Current FCOne line array for Minute "+simtime+": [");
			for(int i =fcone.getFront(); i <fcone.getBack(); i++) {
				if(noice3[i] != null) {
					System.out.print(noice3[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			Passenger[] noice4 = fctwo.printArray();//get current fctwo array entries
			System.out.print("Current FCTwo line array for Minute "+simtime+": [");
			for(int i =fctwo.getFront(); i <fctwo.getBack(); i++) {
				if(noice4[i] != null) {
					System.out.print(noice4[i].getID()+", ");
				}
			}System.out.print("]");
			System.out.println();
			
			if(coachone.frontOfLine() != null) {//if someone is at front of the line, update busy time
				coachone.updateBusyTime();
			}
			
			if(coachtwo.frontOfLine() != null) {//if someone is at front of the line, update busy time
				coachtwo.updateBusyTime();
			}
			if(coachthree.frontOfLine() != null) {//if someone is at front of the line, update busy time
				coachthree.updateBusyTime();
			}
			if(fcone.frontOfLine() != null) {//if someone is at front of the line, update busy time
				fcone.updateBusyTime();
			}
			if(fctwo.frontOfLine() != null) {//if someone is at front of the line, update busy time
				fctwo.updateBusyTime();
			}
			
			//check if there is a first class passenger at the front of the queue and if its time to remove one
			if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1 && servicefc1 <= 1/firstserr) {
				servicefc1 = Math.random();
				fcone.removeQ();
			}
			else {//if not, then de-increment the servicefc variable
				if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1) {
					servicefc1 = servicefc1 - 0.1;
				}
			}
			
			if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1 && servicefc2 <= 1/firstserr) {
				servicefc2 = Math.random();
				fctwo.removeQ();
			}
			else {
				if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1) {
					servicefc2 = servicefc2 - 0.1;
				}
			}

			//check to see if coach class passenger in first class line can be serviced
			if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1 && servicefc1 <= 1/coachserr) {
				servicefc1 = Math.random();
				fcone.removeQ();
			}
			else {
				if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1) {
					servicefc1 = servicefc1 - 0.1;
				}
				
			}
			
			if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1 && servicefc2 <= 1/coachserr) {
				servicefc2 = Math.random();
				fctwo.removeQ();
			}
			else {
				if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1) {
					servicefc2 = servicefc2 - 0.1;
				}
			}
			

			
				//check to see if coach class passenger in coach class line can be serviced
			if(!coachone.isEmpty() && servicecc1 <= 1/coachserr) {
				servicecc1 = Math.random();
				coachone.removeQ();
			}
			else {
				servicecc1 = servicecc1 - 0.1;
			}
			
			if(!coachtwo.isEmpty() && servicecc2 <= 1/coachserr) {
				servicecc2 = Math.random();
				coachtwo.removeQ();
			}
			else {
				servicecc2 = servicecc2 - 0.1;
			}
			
			if(!coachthree.isEmpty() && servicecc3 <= 1/coachserr) {
				servicecc3 = Math.random();
				coachthree.removeQ();
			}
			else {
				servicecc3 = servicecc3 - 0.1;
			}

		coachone.updateWT(); //update wait times for each line
		coachtwo.updateWT();
		coachthree.updateWT();
		fcone.updateWT();
		fctwo.updateWT();

		simtime++;
		}
		//set of code to track current status of each line
		Passenger[] noice = coachone.printArray();//get current coachone array entries
		System.out.print("Current CoachOne line array for Minute "+simtime+": [");
		for(int i =coachone.getFront(); i <coachone.getBack(); i++) {
			if(noice[i] != null) {
				System.out.print(noice[i].getID()+", ");
			}
		} System.out.print("]");
		System.out.println();
		
		Passenger[] noice1 = coachtwo.printArray();//get current coachtwo array entries
		System.out.print("Current CoachTwo line array for Minute "+simtime+": [");
		for(int i =coachtwo.getFront(); i <coachtwo.getBack(); i++) {
			if(noice1[i] != null) {
				System.out.print(noice1[i].getID()+", ");
			}
		}System.out.print("]");
		System.out.println();
		
		Passenger[] noice2 = coachthree.printArray();//get current coachthree array entries
		System.out.print("Current CoachThree line array for Minute "+simtime+": [");
		for(int i =coachthree.getFront(); i <coachthree.getBack(); i++) {
			if(noice2[i] != null) {
				System.out.print(noice2[i].getID()+", ");
			}
		}System.out.print("]");
		System.out.println();
		
		Passenger[] noice3 = fcone.printArray();//get current fcone array entries
		System.out.print("Current FCOne line array for Minute "+simtime+": [");
		for(int i =fcone.getFront(); i <fcone.getBack(); i++) {
			if(noice3[i] != null) {
				System.out.print(noice3[i].getID()+", ");
			}
		}System.out.print("]");
		System.out.println();
		
		Passenger[] noice4 = fctwo.printArray();//get current fctwo array entries
		System.out.print("Current FCTwo line array for Minute "+simtime+": [");
		for(int i =fctwo.getFront(); i <fctwo.getBack(); i++) {
			if(noice4[i] != null) {
				System.out.print(noice4[i].getID()+", ");
			}
		}System.out.print("]");
		System.out.println();
	}
	
	public void testA() {
		//print out desired outputs for each line

		System.out.println();
		
		System.out.println("Duration of Simulation: "+simtime+" minutes");
		System.out.println();
		
		System.out.println("Here is information about Coach Service Station 1");
		System.out.println("Average Wait Time: "+coachone.getAverageWT()+" minutes");
		System.out.println("Maximum Wait Time: "+coachone.getMaxWT()+" minutes");
		System.out.println("Maximum Line Size: "+coachone.getMaxSize());
		System.out.println("Rate of Occupancy: "+(double)coachone.getBusyTime()/simtime);
		System.out.println();
		
		System.out.println("Here is information about Coach Service Station 2");
		System.out.println("Average Wait Time: "+coachtwo.getAverageWT()+" minutes");
		System.out.println("Maximum Wait Time: "+coachtwo.getMaxWT()+" minutes");
		System.out.println("Maximum Line Size: "+coachtwo.getMaxSize());
		System.out.println("Rate of Occupancy: "+(double)coachtwo.getBusyTime()/simtime);
		System.out.println();
		
		System.out.println("Here is information about Coach Service Station 3");
		System.out.println("Average Wait Time: "+coachthree.getAverageWT()+" minutes");
		System.out.println("Maximum Wait Time: "+coachthree.getMaxWT()+" minutes");
		System.out.println("Maximum Line Size: "+coachthree.getMaxSize());
		System.out.println("Rate of Occupancy: "+(double)coachthree.getBusyTime()/simtime);
		System.out.println();
		
		System.out.println("Here is information about First Class Service Station 1");
		System.out.println("Average Wait Time: "+fcone.getAverageWT()+" minutes");
		System.out.println("Maximum Wait Time: "+fcone.getMaxWT()+" minutes");
		System.out.println("Maximum Line Size: "+fcone.getMaxSize());
		System.out.println("Rate of Occupancy: "+(double)fcone.getBusyTime()/simtime);
		System.out.println();
		
		System.out.println("Here is information about First Class Service Station 2");
		System.out.println("Average Wait Time: "+fctwo.getAverageWT()+" minutes");
		System.out.println("Maximum Wait Time: "+fctwo.getMaxWT()+" minutes");
		System.out.println("Maximum Line Size: "+fctwo.getMaxSize());
		System.out.println("Rate of Occupancy: "+(double)fctwo.getBusyTime()/simtime);
	}

}
