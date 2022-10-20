
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import SortedDoubleLinkedListTest.DoubleComparator;

public class myArrTest {

	public static void main(String[] args) {
		
		SortedDoubleLinkedList<Double> sortedLinkedDouble;
		DoubleComparator<Double> comparatorD;
		comparatorD = new DoubleComparator<Double>();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		sortedLinkedDouble.add​(new Double(5));
		sortedLinkedDouble.add​(new Double(10));
		sortedLinkedDouble.add​(new Double(8));
		sortedLinkedDouble.add​(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		System.out.print(iterator.hasNext());
		System.out.print(iterator.next());
		System.out.print(iterator.next());
		System.out.print(iterator.next());
		System.out.print(iterator.hasNext());
		
		/*StringComparator<String> comparator = null;
		
		BasicDoubleLinkedList<String> linkedCar;
		String a="Ford";
		String b="Renegade";
		String c="Honda";
		String d="Subaru";
		String e="Chevrolet";
		String f="Chrysler";
		
		linkedCar= new BasicDoubleLinkedList<String>();
		linkedCar.addToEnd​(b);
		linkedCar.addToEnd​(c);
		
		System.out.print(b + "-" + linkedCar.getFirst());
		System.out.print(c + "-" + linkedCar.getLast());
		linkedCar.addToFront​(a);
		System.out.print(a + "-" + linkedCar.getFirst());
		linkedCar.remove​(a, comparator);
		System.out.print(b + "-" + linkedCar.getFirst());
		//remove from the end of the list
		linkedCar.addToEnd​(d);
		System.out.print(d + "-" + linkedCar.getLast());
		linkedCar.remove​(d, comparator);
		System.out.print(c + "-" + linkedCar.getLast());
		//remove from middle of list
		linkedCar.addToFront​(a);
		System.out.print(a + "-" + linkedCar.getFirst());
		System.out.print(c + "-" + linkedCar.getLast());
		linkedCar.remove​(b, comparator);
		System.out.print(a + "-" + linkedCar.getFirst());
		System.out.print(c + "-" + linkedCar.getLast());
	}
	
	private class StringComparator<T> implements Comparator<T>
	{
		public StringComparator() {
			
		}
		public int compare(T arg0, T arg1) {
			return String. valueOf(arg0).compareTo(String. valueOf(arg1));
		}
		}*/
		class DoubleComparator<T> implements Comparator<Double>
		{

			@Override
			public int compare(Double arg0, Double arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
			
		}
	}

}
