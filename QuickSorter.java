package app;

import java.util.Comparator;


public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO sort
		// Partition(list, 0, list.size()-1);
		quickSortRecursive(0, (list.size()-1));
		return list;				
	}


	/*
	 * Helper method which recursively partitions smaller and smaller portions
	 * of the list
	 */
	public void quickSortRecursive(int lowDex, int highDex){
		if ((lowDex < highDex) && list.size()>1){
			int endLow = forLoopPart(lowDex, highDex);
			quickSortRecursive(lowDex, endLow-1);
			quickSortRecursive(endLow+1, highDex);
		}
	}

	/*
	 * Partitioning method for the list, returns the int of the highest index
	 * of the low partition.  Makes partitions based on middle element's value
	 */
	public int forLoopPart(int lowDex, int highDex){
		// pvt index is the middle index
		int pvt = (highDex+lowDex)/2;
		/*
		 * Swap the values of the pvt and the highIndex
		 */
		list.swap(pvt,highDex);
		/* 
		 * current counter set to low, and iteration counter set to low
		 */
		int i = lowDex;
		/*
		 * iterates from lowDex to less than highDex
		 */
		for (int j = lowDex; j < highDex ; j++){
			/*
			 * if the element at the current value is less than the pivot value
			 * then swap the low point and the current point
			 * You build out the low partition, by marking first high with i
			 */
			if (list.compare(j,highDex, comparator) <= 0){
				list.swap(i,j);
				i++;
			}
		}
		// swap first high partition value with pivot value
		list.swap(i,highDex);
		return i;

	}

	/*
	 * UNSUCCESSFUL
	 * Partition method within quicksort
	 * Takes area of the list, and partitions into high and low partitions
	 * Partitions are based on pivot value, which I've chosen to be the middle value
	 * Returns highest index of low partition
	 */
	/*
	public int Partition(int lowDex, int highDex){
		
		// returns highDex 
		if (lowDex >= highDex){
			return highDex;
		}


		// set mdpt as middle of high and low
		int mdpt = (highDex + lowDex)/2;
		// if (mdpt!=highDex){
		// 	list.swap(mdpt,highDex);
		// }


		// iterate while high is greater than low
		while ((lowDex<highDex)){
			while ((lowDex < highDex) && ((list.compare((lowDex),(mdpt),comparator)<0))){
				lowDex++;
			}
			while ((highDex > lowDex) && (list.compare((mdpt),(highDex),comparator)<0)){
				highDex--;
			}
			if (lowDex >= highDex){
				continue;
			}
			else {
				list.swap(lowDex,highDex);
				lowDex++;
				highDex--;
			}
		}
		return highDex;


	}
	*/


}
