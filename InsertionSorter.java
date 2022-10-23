package app;

import java.util.Comparator;


public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	/*
	 * Insertion sort, returns sorted list
	 * Iterates from item 1 to list.size(), building a sorted and unsorted partition
	 * Each new item is compared against the sorted items to find its place
	 */
	public SwapList<T> sort() {
		// TODO sort

		for (int i = 1; i < list.size(); ++i){
			/*
			 * for each item, compare against every sorted item
			 * until a greater value is found 
			 * check from (j-1) to (0) if necessary
			 */
	
			int j = i;
			while ((j>0) && list.compare((j-1),(j),comparator)>0){
				// if you find a greater element, swap and keep going
				list.swap(j,(j-1));
				--j;
			}
		}
		return list;
	}
}
