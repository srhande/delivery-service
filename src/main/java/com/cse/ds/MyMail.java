/** File Header: This file is to create mail objects via the MyMail class. The class MyMail extends the abstract class Deliverable.
 * Name: Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds;

/** Class Header: This class extends the abstract class Deliverable. It creates the mail objects. There is one instance variable called message, which is the message stored inside the mail. */
public class MyMail extends Deliverable {

    private String message; //message stored inside the mail
    
    //initializes a MyMail object with id, weight, receiver address, sender address, and message stored inside mail
    public MyMail(int id, String fromAddress, String toAddress, String message) {

        //YOUR CODE HERE
    	this.id = id; //initializes object's id
    	this.weight = 1; //initializes object's weight to 1
    	this.fromAddress = fromAddress; //initializes sender's address
    	this.toAddress = toAddress; //initializes receiver's address
    	this.message = message; //initializes object's message
    	
    }

    /** @return this.message
     * returns message stored inside mail **/
    public String getMessage() { return this.message; }

    /** returns zip code of receiver address. zip code is at end of address.
     * @return toAddressSplit[size-1] */
    @Override
    public String getZipCode() {

        //YOUR CODE HERE
    	String[] toAddressSplit = toAddress.split(", ");
    	int size = toAddressSplit.length;
    	return toAddressSplit[size - 1];

    }

}
