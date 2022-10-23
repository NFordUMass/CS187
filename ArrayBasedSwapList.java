package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ArrayBasedSwapList<T> implements SwapList<T> {
	private final ArrayList<T> arrayList;
	private int swaps = 0;
	private int comparisons = 0;

	public ArrayBasedSwapList(T[] array) {
		arrayList = new ArrayList<T>(Arrays.asList(array));
	}

	public ArrayBasedSwapList(Collection<T> coll) {
		arrayList = new ArrayList<T>(coll);
	}

	@Override
	public int compare(int index1, int index2, Comparator<T> comparator) {
		comparisons++;
		return comparator.compare(arrayList.get(index1), arrayList.get(index2));
	}

	@Override
	public void swap(int index1, int index2) {
		swaps++;
		T temp = arrayList.get(index1);
		arrayList.set(index1, arrayList.get(index2));
		arrayList.set(index2, temp);
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	// Returns true iff the list is sorted in ascending order according to the given comparator.
	/*
	 * Returns boolean based on if elements in a list are sorted
	 * Accesses the comparator's compare method to compare consecutive items
	 */
	@Override
	public boolean isSorted(Comparator<T> comparator) {
		// TODO isSorted
		// iterates each list element
		for (int i = 0; i < arrayList.size()-1; i++){
			// uses compare method by calling comparator
			if (comparator.compare(arrayList.get(i),arrayList.get(i+1))>0){
				// false if any item isn't less than adjacent item
				return false;
			}
		}
		return true;
	}

	public int getSwaps() {
		return swaps;
	}

	public int getComparisons() {
		return comparisons;
	}

	// Returns a whole-number percentage of elements sorted. Traverses the list once and tallys all
	// correct ordered consecutive pairs (ex: [1, 2] is correct but [2, 1] is not).  Then divides 
	// this by the number of comparisons completed.
	// Ex: [1, 2, 3, 4] returns 100 (3 correctly sorted pairs ( [1,2], [2,3], [3,4] ) divided by 3 total comparisons)
	// Ex: [4, 3, 2, 1] returns 0
	// Ex: [4, 1, 2, 3, 5] returns 75
	@Override
	public int scoreList(Comparator<T> comparator) {
		// TODO scoreList
		/*
		 * iterate array and compare each pair of values using comparator
		 */
		double ret = 0;
		for (int i = 0; i < arrayList.size()-1; i++){
			if (compare(i,i+1,comparator)<=0){
				ret+= 1;
			}
		}
		// check that size is greater than 1
		if (arrayList.size()>1){
			// retInt equals double value of actual decimal percentage
			double retInt = ((ret)/(arrayList.size()-1));

			// returns percentage as a whole number
			return (int) (retInt*100);
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return arrayList.toString();
	}
}
