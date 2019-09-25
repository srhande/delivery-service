/** File Header: This class contains the Mailroom class. This file is to create a system (class) that coordinates all the Deliverable objects.
 * Name: Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds;

import java.util.ArrayList;
import java.util.HashMap;

/** Class Header: This class coordinates the processing/delivering of the Deliverable objects.The mailroom bins the incoming deliverables by zip code of the receiver address and preserves their order of arrival to the mailroom. Hash maps are used to create this process. In this one there is a hashmap called deliveryBins. There is also an instance variable of current timestamp. */
public class Mailroom {

  private HashMap<Deliverable,MyQueue<Deliverable>> deliveryBins; //hashmap that stores key-value pairs iwth Deliverable as a key and MyQueue<Deliverable> as the value
  private int currentTimestamp; //timestamp used to set the next incoming deliverable

    //creates mailroom object by initializing its hashmp and starting currentTimestamp at 0.
  public Mailroom() {

    //YOUR CODE HERE
	this.deliveryBins = new HashMap<Deliverable,MyQueue<Deliverable>>(); //hashmap
	this.currentTimestamp = 0; //current timestamp

  }

  /** sets timestamp of Deliverable object d and adds d into appropriate queue in hashmap. Zipcode determins key. */
  public void registerItem(Deliverable d) throws NullPointerException  {

    //YOUR CODE HERE
	if (d == null) {
		throw new NullPointerException();
	}
	d.setTimestamp(currentTimestamp);
	if (!(deliveryBins.containsKey(d))) {
		deliveryBins.put(d, new MyQueue<Deliverable>());
	}
	deliveryBins.get(d).enqueue(d);
	
	currentTimestamp++; //increment currentTimestamp

  }

  /** removes and returns Deliverable object that currently possesses the earliest timestamp. If there are no Deliverable objects in mailroom, return null.
   * @return object with earliest timestamp or null if no objects in mailroom */
  public Deliverable deliverEarliest() {

    //YOUR CODE HERE
	  int min = Integer.MAX_VALUE;
	  Deliverable min_deliverable = null;
	  for(Deliverable temp : deliveryBins.keySet()) {
		  if(temp.getTimestamp() < min) {
			  min = temp.getTimestamp();
			  min_deliverable = temp;
		  }
	  }
	  if (min_deliverable != null) {
		  deliveryBins.get(min_deliverable).dequeue();
		  if (deliveryBins.get(min_deliverable).isEmpty()) {
			  deliveryBins.remove(min_deliverable);
		  }
	  }
	  return min_deliverable;

  }

  /** removes and returns Deliverable object with earliest timestamp out of all the Deliverable objects that have same receiver address zip code as the input parameter zip.
   * @param zip - check if zipcode matches this zip and then see which of those that match has earliest timestamp
   * @return the one that has earliest timestamp of those that match the input zipcode. if no such Deliverable, return null. */
  public Deliverable deliverEarliest(String zip) {

    //YOUR CODE HERE
	  Deliverable ans = null;
	  for(Deliverable temp : deliveryBins.keySet()) {
		  if(temp.getZipCode().equals(zip)) {
			   ans = deliveryBins.get(temp).dequeue();
		  }
		  if(deliveryBins.get(temp).isEmpty()) {
			  deliveryBins.remove(temp);
		  }
	  }
	  return ans;

  }

  /** Returns Deliverable object that currently has earliest timestamp. If there are no objects in mailroom, return null.
   * @return object with earliest timestamp and null if no Deliverable objects in mailroom. */
  public Deliverable checkEarliest() {

    //YOUR CODE HERE
	  int min = Integer.MAX_VALUE;
	  Deliverable min_deliverable = null;
	  for(Deliverable temp : deliveryBins.keySet()) {
		  if(temp.getTimestamp() < min) {
			  min = temp.getTimestamp();
			  min_deliverable = temp;
		  }
	  }
	  if (min_deliverable != null) {
		  return deliveryBins.get(min_deliverable).peek();
	  }
	  return min_deliverable;

  }

  /** Returns the Deliverable object that currently possesses earliest timestamp out of all Deliverable objects that have same receiver address zip code as input paramater zip.
   * @param zip - zip that should match
   * @return Deliverable object that has earliest timsetamp of all those that match zip; if no such Deliverable object, return null */
  public Deliverable checkEarliest(String zip) {

    //YOUR CODE HERE
	  for(Deliverable temp : deliveryBins.keySet()) {
		  if(temp.getZipCode().equals(zip)) {
			  return deliveryBins.get(temp).peek();
		  }
	  }
	  
	  return null;

  }

  /** removes and returns all Deliverable objects currently in mailroom as an ArrayList of type Deliverable.
   * @return all Deliverable objects as an array list. If no Deliverable objects, return empty ArrayList. */
  public ArrayList<Deliverable> deliverAll() {

    //YOUR CODE HERE
	  ArrayList<Deliverable> currentObjects = new ArrayList<Deliverable>();
	  
	  for(Deliverable temp : deliveryBins.keySet()) {
		  while(! deliveryBins.get(temp).isEmpty()) {
			  currentObjects.add(deliveryBins.get(temp).dequeue());
		  }
		  deliveryBins.remove(temp);
	  }
	  return currentObjects;

  }

  /** removes and returns all Deliverable objects, that have zip as its receiver address zip code, as an array list of type Deliverable.
   * @return all Deliverable objects that have the same receiver address zip code as zip in an ArrayList; return an empty ArrayList if no such Deliverable objects. */
  public ArrayList<Deliverable> deliverAll(String zip){

    //YOUR CODE HERE
	  ArrayList<Deliverable> currentObjects = new ArrayList<Deliverable>();
	  
	  for(Deliverable temp : deliveryBins.keySet()) {
		  if(temp.getZipCode().equals(zip)) {
			  while(! deliveryBins.get(temp).isEmpty()) {
				  currentObjects.add(deliveryBins.get(temp).dequeue());
				  System.out.println(temp.toString());
			  }
			  deliveryBins.remove(temp);
			  break;
		  }
	  }
	  
	  return currentObjects;

  }

  /**Removes the Deliverable object that currently possesses the earliest timestamp and adds it into an ArrayList of type Deliverable. Repeat, and then stop if the capacity is going to be exceeded if another object is added.
   * @return resulting ArrayList */
  public ArrayList<Deliverable> deliverByWeight(int capacity) {

    //YOUR CODE HERE
	  ArrayList<Deliverable> obj = new ArrayList<>();
	  int temp = 0;
	  while(true) {
		  if((checkEarliest()!= null) && ((temp + checkEarliest().getWeight()) <= capacity)) {
			  temp += checkEarliest().getWeight();
			  obj.add(deliverEarliest());
		  }
		  else {
			  break;
		  }
			
	  }
	  return obj;

  }

  /**Removes the Deliverable object that currently possesses the earliest timestamp out of those whose receiver address zip code matches input @param zip and adds it into an ArrayList of type Deliverable. Repeat, and then stop if the capacity is going to be exceeded if another object is added or if there are no more such matching Deliverable objects.
   * @return resulting ArrayList */
  public ArrayList<Deliverable> deliverByWeight(int capacity, String zip) {

    //YOUR CODE HERE
	  ArrayList<Deliverable> obj = new ArrayList<>();
	  boolean exists = false;
	  int temp = 0;
	  
	  for(Deliverable data : deliveryBins.keySet()) {
		  if(data.getZipCode().equals(zip)) {
			  exists = true;
		  }
	  }
	  
	  while(exists) {
		  if((checkEarliest()!= null) && (temp + checkEarliest(zip).getWeight() <= capacity)) {
			  temp += checkEarliest(zip).getWeight();
			  obj.add(deliverEarliest(zip));
		  }
		  else {
			  break;
		  }
	  }
	  
	  return obj;
	  

  }

  /** Merges all of the queues stored by each key that has a corresponding zip code that starts with the prefix. Merged queue will be stored in a hashmap. */
  public void mergeBins(String prefix) {

    //YOUR CODE HERE
	  if(!(prefix.equals("") || prefix == null)) {
		  int length = prefix.length();
		  ArrayList<String> temp_zips = new ArrayList<String>();
		  HashMap<Deliverable,MyQueue<Deliverable>> copy = deliveryBins;
		  for(Deliverable temp : copy.keySet()) {
			  String ans = temp.getZipCode().substring(0, length);
			  if(prefix.equals(ans)) {
				  temp_zips.add(temp.getZipCode());
			  }
		  }
		  
		  ArrayList<Deliverable> result = new ArrayList<Deliverable>();
		  for(String str : temp_zips) {
			  ArrayList<Deliverable> temp = deliverAll(str);
			  for(Deliverable d : temp) {
				  result.add(d);
			  }
		  }
		  int minIndex;
		  for (int i = 0; i < result.size() - 1; i++) {
			  minIndex = i;
			  for (int j = i + 1; j < result.size(); j++) {
				  if(result.get(j).getTimestamp() < result.get(minIndex).getTimestamp()) {
					  minIndex = j;
				  }
			  }
			  Deliverable temporary = result.get(i);
			  result.set(i, result.get(minIndex));
			  result.set(minIndex, temporary);
			  
	      }
		  	  
		  String temp_zip = prefix;
		  
		  for(int i = length; i<5; i++) {
			  temp_zip = temp_zip + "-";
		  }
		  temp_zip = temp_zip + ", ";
		  
		  MyMail dummy = new MyMail(-1, " ", temp_zip, "fake");
		  
		  deliveryBins.put(dummy, new MyQueue<Deliverable>());
		  
		  for(Deliverable d: result) {
			  deliveryBins.get(dummy).enqueue(d);
		  }
		  
	  }
  }

}
