/** File Header: This file contains the abstract class Deliberable. This will help us populate the implemented queues in this assignment.
 * Name: Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds;


/** Class Header: This class is an abstract class. It will act as a data type for populating our implemented queues in this assignment. This means that the objects that will be populating our queues are of type Deliverable. */
public abstract class Deliverable {

    protected int id; //id number of deliverable
    protected int weight; //the weight of the deliverable in pounds reounded to the nearest integer
    protected int timestamp = -1; //the timestamp indicating when the deliverable was registered in the mailroom
    protected String fromAddress; //sender's address
    protected String toAddress; //receiver's address

    public int getId() { return id; } //returns id number of deliverable
    public int getWeight() { return weight; } //returns weight of deliverable in pounds
    public int getTimestamp() { return timestamp; } //returns timestamp of deliverable
    public void setTimestamp(int timestamp) { this.timestamp = timestamp; } //sets timestamp of deliverable
    public String getFromAddress() { return fromAddress; } //returns sender's address
    public String getToAddress() { return toAddress; } //returns receiver's address

    public abstract String getZipCode(); //returns receiver address zipcode

    /** Returns hashcode determined by deliverable. Uses zipcode as a string from receiver's address to get hashcode.
     * @return hashcode using zipcode */
    @Override
    public int hashCode() {

      //YOUR CODE HERE
    	
    	return this.getZipCode().hashCode();

    }

    /** Returns whether this and obj are equivalent.
     @return true if zip code from both object's receiver addresses are identical, else return false.
     @return false if obj is not an instance of Deliverable */
    @Override
    public boolean equals(Object obj) {

      //YOUR CODE HERE
    	if (!(obj instanceof Deliverable)) {
    		return false;
    	}
    	else if (this.hashCode() == (((Deliverable) obj).hashCode())) {
    		return true;
    	}
    	return false;
    }

}
