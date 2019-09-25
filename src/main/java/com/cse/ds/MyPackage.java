/** File Header: This file contains the class named MyPackage<E>. That class exists to create a package object of type MyPackage.
 * Name: Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds;

/** Class Header: This class creates the MyPackage object. It extendes the abstract class Deliverable. There is one instance variable called content which is the content of the package of generic type. */
public class MyPackage<E> extends Deliverable {

  private E content; //content of package of generic type

  /** initializes package object with id, sender address, receiver address, content of package, and weight of package */
  public MyPackage(int id, String fromAddress, String toAddress,
                 E content, int weight)
  {

      //YOUR CODE HERE
	  this.id = id; //id of package
	  this.fromAddress = fromAddress; //sender of package address
	  this.toAddress = toAddress; //receiver of package address
	  this.content = content;//content of package
	  this.weight = weight;//weight of package
  }
  
  /** @return this.content - returns content of package */
  public E getContent() { return this.content; }

  /**returns zip code of the receiver address. Package address zip codes will be at the beginning.
   * @return toAddressSplit[0] - receiver address's zip code*/
  @Override
  public String getZipCode() {

    //YOUR CODE HERE
	String[] toAddressSplit = toAddress.split(",");
  	return toAddressSplit[0];

  }

}
