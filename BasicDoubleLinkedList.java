import java.util.Iterator;
import java.util.ListIterator;
//import LinkedList.Node; - don't remember why I imported it; might be important
import java.util.*;

/**
 * This generic double-linked list that implements the Iterable interface 
 * and relies on a head (reference to first element of the list) and tail 
 * (reference to the last element of the list). Both are set to null when the 
 * list is empty. Both point to the same element when there is only one 
 * element in the list. The class must only define the following entities:
 *
 * 1) an inner class Node, The inner Node class has only three fields: data, 
 * 	  the prev and next references.
 * 
 * 2) an inner class named DoubleLinkedListIterator that implements 
 * 	  ListIterator (for the iterator method), This inner class implements only 
 * 	  the hasNext(), next(), hasPrevious() and previous() methods of ListIterator, 
 * 	  all other methods can throw the UnsupportedOperationException;
 * 
 * All the entities are defined as protected so they can be accessed by the subclasses.
 * 
 * @author etmybarbosa
 * @param <T>
 */
public class BasicDoubleLinkedList<T> extends Object implements Iterable<T> {
	
	public Node head;
	public Node tail;
	public int size;
	public ArrayList<T> myArr;
	
	
	/**
	 * Constructor to set to initialize:
	 * head - null
	 * tail - null
	 * size - 0
	 */
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * Returns the number of nodes in the list.
	 * 
	 * Notice: Do not traverse the list to compute the size. 
	 * This method just returns the value of the instance 
	 * variable you use to keep track of size.
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to the end of the list 
	 * and updated the size of the list
	 * 
	 * DO NOT use iterators to implement this method.
	 * @param data
	 */
	public void addToEnd​(T data) {
		Node newNode = new Node(data);
		if(tail != null) {
			newNode.prev = tail;
			tail.next = newNode;
		}
		else if(tail == null) {
			head = newNode;
		}
		tail = newNode; 
		size++;
	}
	
	/**
	 * Adds element to the front of the list 
	 * and updated the size of the list
	 * 
	 * Do not use iterators to implement this method.
	 * @param data
	 */
	public void addToFront​(T data) {
		Node newNode = new Node(data);
		if(head != null) {
			newNode.next = head;
			head.prev = newNode;
		}
		else if(head == null) {
			tail = newNode;
		}
		head = newNode; 
		size++;
	}
	
	/**
	 * Returns but does not remove the first element from the list.
	 * 
	 * If there are no elements the method returns null.
	 * 
	 * Do not implement this method using iterators.
	 * @return
	 */
	public T getFirst() {
		if(head == null) {
			return null;
		}
		return head.data;// **** HERE **** might be head.next.data
	}
	
	/**
	 * Returns but does not remove the last element from the list.
	 * 
	 * If there are no elements the method returns null. 
	 * Do not implement this method using iterators.
	 * @return
	 */
	public T getLast() {
		if(tail == null) {
			return null;
		}
		return tail.data;// **** HERE **** might be tail.prev.data
	}

	@Override
	/**
	 * This method returns an object of the DoubleLinkedListIterator. 
	 * (the inner class that implements java's ListIterator interface)
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Removes the first instance of the targetData from the list. Notice 
	 * that you must remove the elements by performing a single traversal over the list. 
	 * You may not use any of the other retrieval methods associated with the 
	 * class in order to complete the removal process. 
	 * You must use the provided comparator (do not use equals) to find those elements that 
	 * match the target. Do not implement this method using iterators.
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public BasicDoubleLinkedList.Node remove​(T targetData, Comparator<T> comparator){
		BasicDoubleLinkedList<T>.Node temp = head;
		while(temp.next != null) {
			if(comparator.compare(temp.data, targetData) == 0) {
				break;
			}
			//if not targetData
			temp = temp.next;
		}
		//if temp is the first
		if(temp.prev == null) {
			head.next.prev = null;
			head = temp.next;
		}
		
		//if temp is the last
		else if(temp.next == null) {
			tail.prev.next = null;
			tail = temp.prev;
			
		}
		
		//temp in the middle
		else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
		size--;
		return (BasicDoubleLinkedList.Node)temp;
	}
	
	
	/**
	 * Removes and returns the first element from the list. If there are 
	 * no elements the method returns null. Do not implement this 
	 * method using iterators.
	 * @return
	 */
	public T retrieveFirstElement() { 
		if(head.equals(null)) {
			return null;
		}
		size--;
		Node temp = head;
		head.next.prev = null;
		head = head.next;
		return temp.data;
	}
	
	/**
	 * Removes and returns the last element from the list. If there are 
	 * no elements the method returns null. Do not implement implement 
	 * this method using iterators.
	 * @return
	 */
	public T retrieveLastElement() {
		if(tail.equals(null)) {
			return null;
		}
		size--;
		Node temp = tail;
		tail.prev.next = null;
		tail = tail.prev;
		return temp.data;
	}
	
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return
	 */
	public ArrayList<T> toArrayList(){
		myArr = new ArrayList<>();
		BasicDoubleLinkedList<T>.DoubleLinkedListIterator<T> temp = new DoubleLinkedListIterator();    
		while(temp.hasNext()) {
			myArr.add(temp.next());
		}
		return myArr;
	}
	
	//----------------------------------- INNER CLASSES -----------------------------------
	/**
	 * A generic inner class Node - This class has the following attributes:
	 * data of type T
	 * prev of type Node
	 * next of type Node
	 * @author etmybarbosa
	 */
	public class Node extends Object{
		Node next;
		Node prev;
		T data;
		
		public Node(T dataNode) {
			this.data = dataNode;
			this.next = null;
			this.prev = null;
		}
	}
	
	
	/**
	 * A generic inner class named DoubleLinkedListIterator that 
	 * implements java’s ListIterator interface (for the iterator method).
	 * 
	 * This class only implements (methods of the ListIterator interface): 
	 * next()
	 * hasNext() 
	 * previous()
	 * hasPrevious()
	 * 
	 * The rest of the methods should throw the UnsupportedOperationException.
	 * 
	 * @author etmybarbosa
	 * @param <T>
	 */
	public class DoubleLinkedListIterator<T> extends Object implements ListIterator<T>{

		public Node pointer;
		public boolean isAfterLast = false;//
		public boolean isbeforeFirst = false;
		
		public DoubleLinkedListIterator() {
			//HINT: You need at least one attribute for this class that can be initialized to the head of the 
			 //BasicDoubleLinkList in order to implement the methods of this class.
			this.pointer = head;
		}
		
		//IMPLEMENTED METHODS
		
		/**
		 * return true if pointer next is not null;
		 * else return false;
		 */
		@Override
		// ################## WORKING HERE ##################
		public boolean hasNext() {
			if(isbeforeFirst && head != null) {
				return true;
			}
			if(pointer != null){
				return true;
			}
			return false;
		}

		/**
		 * if next is null throw exception;
		 * else return the data on the next
		 */
		@Override
		public T next() throws NoSuchElementException{
			/*if(pointer == head) {
				pointer = pointer.next;
				return (T)head.data;
			}*/
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			T temp = (T)pointer.data;
			if(pointer == tail && size>1) {
				isAfterLast = true;
			}
			pointer = pointer.next;
			return temp;
			
		}

		/**
		 * return true if pointer prev is not null;
		 * else return false;
		 */
		@Override
		// ################## WORKING HERE ##################
		public boolean hasPrevious() {
			if(isAfterLast && tail != null) {
				return true;
			}
			if(pointer != null){
				return true;
			}
			return false;
		}

		/**
		 * if prev is null throw exception;
		 * else return the data on the prev
		 */
		public T previous() throws NoSuchElementException{
			/*if(pointer == tail) {
				pointer = pointer.prev;
				return (T)tail.data;
			}*/
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(isAfterLast && size>1) {
				pointer = tail;
				isAfterLast = false;
			}
			T temp = (T)pointer.data;
			if(pointer == head) {
				isbeforeFirst = true;
			}
			pointer = pointer.prev;
			return temp;
		}

		
		//------------------------------ NOT IMPLEMENTED METHODS ------------------------------
		/**
		 * EXAMPLE:
		 * 	public void remove() throws UnsupportedOperationException{ 
		 * 		throw new UnsupportedOperationException(); 
		 * 	}
		 */
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
	}
}

