
public class OGFD {
	/*if(firstarr >0 && simtime % firstarr == 0) {//handle first class customers. if average time for firstclass arrival passes, add one to shortest first class line
	
	Passenger customer = new Passenger(1,coacharr, coachserr, firstarr, firstserr);
	if(a <=b) {
		fcone.insertQ(customer);
	}
	else {
		fctwo.insertQ(customer);
	}
}*/
	
	/*if(coacharr > 0 && simtime % coacharr == 0) {//handle coach customers. if average time for coach class arrival passes, add one to shortest line
	Passenger customer = new Passenger(0,coacharr, coachserr, firstarr, firstserr);
	
	if((a == 0 || b ==0) && x !=0 && y!= 0 && z !=0) {//check if either of the first class queues are free and add them here if none of the coach lines are empty
		if(a ==0) {
			fcone.insertQ(customer);
		}
		else {
			fctwo.insertQ(customer);
		}
	}
	else {
		if(x <= y && x <=z) { //find the shortest coach customer line and add customer to it
			coachone.insertQ(customer);
		}
		else {
			if(y <=x && y <= z) {
				coachtwo.insertQ(customer);
			}
			else {
				coachthree.insertQ(customer);
			}
		}
	}
}*/
	
	
	//if first class passenger is at front, and their service time has passed remove them from the queue
	/*if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1 && fcone.frontOfLine().getIPTime() >= firstserr ) {
		fcone.removeQ();
	}
	else {
		if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1) {
			fcone.frontOfLine().updateIPTime();
		}
	}*/
	
	/*if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1 && fctwo.frontOfLine().getIPTime() >= firstserr) {
		fctwo.removeQ();
	}
	else {
		if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1) {
			fctwo.frontOfLine().updateIPTime();
		}
	}*/
	
	/*if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1 && fcone.frontOfLine().getIPTime() >= coachserr) {
	fcone.removeQ();
}
else {
	if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1) {
		fcone.frontOfLine().updateIPTime();
	}
}

if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1&& fctwo.frontOfLine().getIPTime() >= coachserr) {
	fctwo.removeQ();
}
else {
	if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1) {
		fctwo.frontOfLine().updateIPTime();
	}
}*/
	
	
	/*if(!coachone.isEmpty() && coachone.frontOfLine().getIPTime() >= coachserr) {
	coachone.removeQ();
}
else {
	if(!coachone.isEmpty()) {
		coachone.frontOfLine().updateIPTime();
	}
}
//coachtwo removals
if(!coachtwo.isEmpty() && coachtwo.frontOfLine().getIPTime() >= coachserr) {
	coachtwo.removeQ();
}
else {
	if(!coachtwo.isEmpty()) {
		coachtwo.frontOfLine().updateIPTime();
	}
}
//coachthree removals
if(!coachthree.isEmpty() && coachthree.frontOfLine().getIPTime() >= coachserr) {
	coachthree.removeQ();
}
else {
	if(!coachthree.isEmpty()) {
		coachthree.frontOfLine().updateIPTime();
	}
}*/
	
	
	
	
	
	/*if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1 && fcone.frontOfLine().getIPTime() >= firstserr ) {
		fcone.removeQ();
	}
	else {
		if(!fcone.isEmpty() && fcone.frontOfLine().getID() == 1) {
			fcone.frontOfLine().updateIPTime();
		}
	}
	
	if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1 && fctwo.frontOfLine().getIPTime() >= firstserr) {
		fctwo.removeQ();
	}
	else {
		if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() == 1) {
			fctwo.frontOfLine().updateIPTime();
		}
	}


//check to see if coach class passenger in first class line can be serviced
	if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1 && fcone.frontOfLine().getIPTime() >= coachserr) {
		fcone.removeQ();
	}
	else {
		if(!fcone.isEmpty() && fcone.frontOfLine().getID() != 1) {
			fcone.frontOfLine().updateIPTime();
		}
	}
	
	if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1&& fctwo.frontOfLine().getIPTime() >= coachserr) {
		fctwo.removeQ();
	}
	else {
		if(!fctwo.isEmpty() && fctwo.frontOfLine().getID() != 1) {
			fctwo.frontOfLine().updateIPTime();
		}
	}
	//coachone removal
	if(!coachone.isEmpty() && coachone.frontOfLine().getIPTime() >= coachserr) {
		coachone.removeQ();
	}
	else {
		if(!coachone.isEmpty()) {
			coachone.frontOfLine().updateIPTime();
		}
	}
	//coachtwo removals
	if(!coachtwo.isEmpty() && coachtwo.frontOfLine().getIPTime() >= coachserr) {
		coachtwo.removeQ();
	}
	else {
		if(!coachtwo.isEmpty()) {
			coachtwo.frontOfLine().updateIPTime();
		}
	}
	//coachthree removals
	if(!coachthree.isEmpty() && coachthree.frontOfLine().getIPTime() >= coachserr) {
		coachthree.removeQ();
	}
	else {
		if(!coachthree.isEmpty()) {
			coachthree.frontOfLine().updateIPTime();
		}
	}*/
}
