import java.util.*;
import java.util.Comparator;
//import BasicDoubleLinkedList.Node;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	Comparator<T> linkedList;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		// Creates an empty list that is associated with the specified comparator.
		linkedList = compareableObject;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list. 
	 * Notice we can insert the same element several times. Your implementation must 
	 * traverse the list only once in order to perform the insertion.Do not implement
	 * this method using iterators. Notice that you don't need to call any of the 
	 * super class methods in order to implement this method.
	 * @param data
	 */
	public void add​(T data) {
		Node newNode = new Node(data);
		if(head == null || tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		
		else if(linkedList.compare(newNode.data, head.data)<0 || newNode == head) {
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
		else if(linkedList.compare(newNode.data, tail.data)>0 || newNode == tail) {
			if(tail != null) {
				newNode.prev = tail;
				tail.next = newNode;
			}
			else if(tail == null) {
				head = newNode;
			}
			tail = newNode; 
			size++;
		}else {
			Node myNode = head;
			boolean findingPlace = true;
			do { 
				if (linkedList.compare(newNode.data, myNode.data) < 0) {
					newNode.next = myNode;
					newNode.prev = myNode.prev;
					myNode.prev = newNode;
					newNode.prev.next = newNode;
					size++;
					
					break;
				} 
				else if (linkedList.compare(newNode.data, myNode.data) > 0) {
					myNode = myNode.next;
				}
			}while(findingPlace);
		}
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException 
	 * will be generated using the message "Invalid operation for sorted list."
	 */
	public void addToEnd​(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException 
	 * will be generated using the message "Invalid operation for sorted list."
	 */
	public void addToFront​(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 */
	public BasicDoubleLinkedList.Node remove​(T data, Comparator<T> comparator){
		return super.remove​(data, comparator);
	}
	/*
	 * save
	 * if(isAfterLast) {
				pointer = tail;
				isAfterLast = false;
			}
	 */
}
