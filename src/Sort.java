import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * A class that sorts an array of items three different ways
 * @author davidaghassi
 *
 */

public class Sort {
	/*Main method should have a file object and a scanner object
	 * This scanner should scan through the file using delimeters. 
	 * An exception should be thrown if there is no file object
	 */
	public static void main(String[] args){
		int[] test = new int[17];
		for(int index = 0; index < test.length; index++){
			test[index] = (int)(Math.random()*100);
		}
		
		int[] output = mergeSort(test);
		for(int i : output){
			System.out.println(i);
		}
		
		/**
		//Create a new file object to read in the file
		File input = new File(args[0]);
		//Scan the file and then read from the scanner into the array
		try {
			Scanner scan = new Scanner(input);
			scan.useDelimiter("/n");
		} catch (FileNotFoundException e) {
			// TO DO Auto-generated catch block
			System.out.print("No file was input!");
			System.exit(0);
		}
		**/
		
	}
	
	/**
	 * A method to perform heap sort
	 * Data is copied into a priority queue
	 * and then popped back into the array.
	 * @param array The array being fed in
	 * **/
	public static void heapSort(int [] array){
		int size = array.length;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(size);
		for (int index = 0; index < size; index ++){
			heap.add(array[index]);
		}
		for(int index = 0; index < size; index++){
			array[index] = (Integer) heap.poll();
		}
	}
	
	/**
	 * A method to perform a quick sort
	 * @param array The array being fed in
	 *
	 */
	public static void quickSort(int [] array){
		
	}

	/**
	 * A method to perform a merge sort
	 * @param array The array being fed in
	 */
	public static int[] mergeSort(int [] array){
		if(array.length == 1){
			return array;
		}
		
		int size = array.length;
		int[][] miniArrayList;
		
		if(size%2 == 0){
			miniArrayList = new int[size][1];
		}
		else{
			miniArrayList = new int[size-1][1];
		}
		
		int[][] oddMiniArrayList = new int[1][1];
		
		if(size%2 == 0){
			for(int index = 0; index < size; index ++){
				miniArrayList[index][0] = array[index];
			}
			while(miniArrayList.length > 1){
				int[][] tempSortList = new int[miniArrayList.length/2][];
				int tempIndex = 0;
					for(int index = 0; index < miniArrayList.length; index+=2){
						tempSortList[tempIndex] = merge(miniArrayList[index], miniArrayList[index+1]);
						if(tempIndex != tempSortList.length){
							tempIndex++;
						}
					}
				miniArrayList = tempSortList;
		}
		}
		else{
			/**
			 * The concept is to call the even merge method on the even part
			 * of the list and then once I get to one array, I merge that array
			 * with the extra array.
			 */
			for(int index = 0; index < miniArrayList.length; index++){
				miniArrayList[index][0] = array[index];
			}
			
			oddMiniArrayList[0][0] = array[size-1];
			
			while(miniArrayList.length > 1){
				int[][] tempSortList = new int[miniArrayList.length/2][];
				int tempIndex = 0;
				for(int index = 0; index < miniArrayList.length; index+=2){
					tempSortList[tempIndex] = merge(miniArrayList[index], miniArrayList[index+1]);
					if(tempIndex != tempSortList.length){
						tempIndex++;
					}
				}
				miniArrayList = tempSortList;
			}
			miniArrayList[0] = merge(miniArrayList[0], oddMiniArrayList[0]);
			
			
		}
		
		
		return miniArrayList[0];
		
		
	}
	
	/**
	 * A merge method to merge smaller arrays to bigger
	 * arrays
	 * @param arrayOne The first array being fed in
	 * @param arrayTwo The second array being fed in
	 * @return A new integer array which is the sum of the 
	 * length of the two arrays
	 */
	private static int[] merge(int[] arrayOne, int[] arrayTwo){
		/*
		 * To make a proper method that deals with odd array sizes
		 * look into seeing if it odd, only merging length of the array -1
		 * and then once that is all merged merge that array with the last part of the array
		 */
		//Creating the size of the new subarray
		int[] mergedArray;
		
		if(arrayOne.length%2 == 0 && arrayTwo.length%2 == 0){
			int size = arrayOne.length;
			int doubleSize = 2*size;
			mergedArray  = new int[doubleSize];
			
			//Positions of each array
			int posOne = 0;
			int posTwo = 0;
			int mergeIndex = 0;
			
			while(posOne < size && posTwo < size){
				if (arrayOne[posOne] < arrayTwo[posTwo]){
					mergedArray[mergeIndex] = arrayOne[posOne];
					mergeIndex++;
					posOne++;
				}
				else{
					mergedArray[mergeIndex] = arrayTwo[posTwo];
					mergeIndex++;
					posTwo++;
				}
			}
			
			if(posOne == size){
				for(int rest = posTwo; rest < size; rest++){
					mergedArray[mergeIndex] = arrayTwo[rest];
					mergeIndex++;
				}
			}
			else{
				for(int rest = posOne; rest < size; rest++){
					mergedArray[mergeIndex] = arrayOne[rest];
					mergeIndex++;
				}
			}
			
		}
		else{
			int arrayOneSize = arrayOne.length;
			int arrayTwoSize = arrayTwo.length;
			int newArraySize = arrayOneSize + arrayTwoSize;
			mergedArray = new int[newArraySize];
			
			//Position in each array
			int posOne = 0;
			int posTwo = 0;
			int mergeIndex = 0;
			
			while(posOne<arrayOneSize && posTwo < arrayTwoSize){
				if (arrayOne[posOne] < arrayTwo[posTwo]){
					mergedArray[mergeIndex] = arrayOne[posOne];
					mergeIndex++;
					posOne++;
				}
				else{
					mergedArray[mergeIndex] = arrayTwo[posTwo];
					mergeIndex++;
					posTwo++;
				}
			}
			if(posOne==arrayOneSize){
				mergedArray[mergeIndex] = arrayTwo[posTwo];
				mergeIndex++;
			}
			else{
				for(int rest = posOne; rest < arrayOneSize; rest++){
					mergedArray[mergeIndex] = arrayOne[rest];
					mergeIndex++;
			}
		}
			
		}
		
		return mergedArray;
	}
	
	/**
	 * A method to populate three arrays of size 1000 that are sorted from
	 * least to greatest. This will be timed and the average taken.
	 */
	public static void sortedArrays(){
		/*Sorted arrays*/
		//Arrays of size 1000 sorted
		int size = 1000;
		int[] hashArray = new int[size];
		int[] quickArray = new int[size];
		int[] mergeArray = new int[size];
		for(int index = 0; index < size; index ++){
			hashArray[index] = index;
			quickArray[index] = index;
			mergeArray[index] = index;
		}
		
	}
}
