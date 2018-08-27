/*Jason Grant
 * 6/11/18
 * CS 610-850 Summer 18
 * Programming Assignment #1 */
public class FCQueue {//class that represents the line in front of a front desk where passengers wait in line
	public FCQueue(int x){
		fcline = new Passenger [x];//create new line queue of size x
	}
	
private Passenger [] fcline;
private int front = 0;//used to keep track of front of line
private int back = 0;//used to keep track of back of line
private int msize = 0;//variable to track largest achieved size of the line (queue)
private int mwtime;//variable to track the longest any passenger has waited in line to be serviced
private int avgwtime;//at conclusion of simulation, this variable calculates how long on average a passenger waited to be serviced in this line (queue)
private int busytime;//calculate how long passenger is waiting at front of line(queue) while being serviced

	public void insertQ(Passenger P){ //insert new passenger into queue
		if (back == fcline.length -1) { //if circular array is about to be full, double it, then continue adding passengers
			Passenger [] nfc = new Passenger [fcline.length*2];
			
			for(int i = 0; i < fcline.length; i ++) {
				nfc[i] = fcline[i];
			}
			fcline = nfc;
		}
		
		fcline[back] = P;
		back = (back +1 )  % (fcline.length);
	}
	
	public void removeQ (){//removes a passenger from the front of the line, typically after they have been serviced
		int cool = fcline.length;
		if(this.isEmpty() == false)
			front = (front + 1) % cool;
	}
	
	public int size() {//caculate current length of line, using current position of front/back pointer variables
		int size = fcline.length;
		return ((size - front + back)% size);
	}
	
	public boolean isEmpty() {//check if line is currently empty
		return front == back;
	}
	
	public Passenger frontOfLine() {//return the passenger at the front of the line
		if(this.isEmpty() == false) {
			return fcline[front];
		}
		else
			return null;
	}
	
	
	public void updateMaxSize() {//keeps track of largest size for queue
		int y = this.size();
		if (msize <= y) {
			msize = y;
		}
			
	}
	
	public int getMaxSize() {//getter method for msize variable
		return msize;
	}
	
	public void updateWT() {//update wait time of each passenger who is still waiting in line
		for (int i = front; i <back; i++) {
			if(fcline[i] !=null) {
				fcline[i].updateWTime();
			}	
		}
	}
	
	public int getMaxWT() {//after conclusion of checkin, find max wait time in this instance of the line (queue)
		for(int i = 0; i <fcline.length; i++) {
			if(fcline[i] !=null) {
				if(fcline[i].getWTime() > mwtime) {
					mwtime = fcline[i].getWTime();
				}
			}
		}
		return mwtime;
	}
	
	public double getAverageWT() {//after conclusion of checkin, find average wait in this instance of the line (queue)
		int x = 0;
		double q =0;
		for(int i = 0; i < fcline.length; i++) {
			if(fcline[i] !=null) {
				avgwtime = avgwtime + fcline[i].getWTime();
				x++;
			}
		}
		if(x > 0) {
			q = (double)avgwtime/x;
		}
		return q;
	}
	
	public void updateBusyTime() {//update busytime variable for this instance of queue
		busytime++;
	}
	
	public int getBusyTime() {//getter method for busytime variable
		return busytime;
	}
	
	
	
	public Passenger [] printArray() { //getter method to get current array
		return fcline;
	}
	
	public int getFront() {//getter method to get front of current array
		return front;
	}
	public int getBack() {//getter method to get back of current array
		return back;
	}
}
