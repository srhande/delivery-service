/**File Header: This file contains the MyQueue<E> class. implements a queue using the MyQueueNode<E> class to represent each element that is in the queue. Changes in the queue will only happen at either the beginning or the end and these are accomplished via the functions in this file. Name: Samruddhi Hande Email: shande@ucsd.edu **/

package com.cse.ds;

import java.util.*;

/** This class implements MyQueueNode<E> class. It enforces the constraints on the possible operations that can be performed on the queue. There are 3 instance variables: head, tail, and nElements. **/
public class MyQueue<E> {

    private MyQueueNode<E> head; //reference to node at beginning of queue.
    private MyQueueNode<E> tail; //reference to node at the end of queue.
    private int nElements; //records number of elements in queue

    public MyQueue() {
        
        //YOUR CODE HERE
//    	Queue<E> MyQueue = new LinkedList<E>();
    	this.head = null;
    	this.tail = null;
    	this.nElements = 0;

    }

    /**adds an element of generic type E to the end of the queue
     * @param element - element to be added */
    public void enqueue(E element) throws NullPointerException {
        
        //YOUR CODE HERE
    	if (element == null) {
    		throw new NullPointerException();
    	}
    	//add element
    	MyQueueNode<E> newNode = new MyQueueNode<E>(element);
    	if (isEmpty()) {
    		head = newNode;
    		tail = newNode;
    		newNode.setNext(null);
    	} else {
    		tail.setNext(newNode);
    		tail = newNode;
    		newNode.setNext(null);
    	}
    	
    }

    /** removes and returns element of generic type E from the head of the queue
     * @return headElement - element that is removed */
    public E dequeue() throws NoSuchElementException {
        
        //YOUR CODE HERE
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	//remove element
    	E headElement = head.getElement();
    	MyQueueNode<E> tempNode = head;
    	//remove the first node!!
    	head = head.getNext();
    	tempNode.setNext(null);
    	if (head == null) {
    		tail = head;
    	}
    	return headElement;
    }

    /** returns element of generic type E at the head of the queue
     * @return head.getElement() - element that is at the head */
    public E peek() throws NoSuchElementException {
		        
        //YOUR CODE HERE
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	return head.getElement();
        
    }

    /** checks if queue is empty
     * @return true if empty, else return false */
    public boolean isEmpty() {
        
        //YOUR CODE HERE
    	if (head == null) {
    		return true;
    	}
    	return false;

    }

    /** returns number of elements in queue
     @return nElements - number of elements */
    public int size() {
        
        //YOUR CODE HERE
    	return nElements;

    }

}
