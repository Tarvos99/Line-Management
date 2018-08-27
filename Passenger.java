/*Jason Grant
 * 6/11/18
 * CS 610-850 Summer 18
 * Programming Assignment #1 */
public class Passenger {

	public Passenger (int x, int coacharr, int coachser, int firstarr, int firstser){//constructor to create instance of a Passenger
		this.idnum = x;
		if (x == 1 ) { //if integer is equal to 1, customer is first class, otherwise they are coach class
			this.atime = firstarr;
			this.stime = firstser;
		}
		else {
			this.atime = coacharr;
			this.stime = coachser;
		}
	}
	
	private int idnum;// 1 for first class, 0 for coach
	private int atime; // arrival time
	private int stime;//service time
	private int wtime; //timer variable to track how long customer has been waiting in line
	
	public int getID() {//getter method for idnum
		return idnum;
	}
	
	public int getatime() {//getter method for arrival time
		return atime;
	}
	
	public int getstime() {//getter method for service time
		return stime;
	}
	
	public void updateWTime() {//setter method used to update wtime variable
		wtime++;
	}
	
	public int getWTime() {//getter method for wtime variable
		return wtime;
	}
}
