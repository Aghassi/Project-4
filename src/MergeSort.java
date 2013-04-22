
public class MergeSort {

	
	
	public static void mergeSort(int[] array){
		//Array to merge from
		int[][] mergeArray = new int[array.length][1];
		//Half way mark
		int halfSize = (array.length/2);
		//Temp array to sort with
		int[][] firstHalf = new int[halfSize][];
		int[][] secondHalf = new int[array.length-(halfSize+1)][];
		int tempIndex = 0;
		
		for(int index = 0; index < array.length; index++){
			mergeArray[index][0] = array[index];
		}
		
		
		for(int index = 0; index < halfSize; index+=2){
			tempIndex = 0;
			firstHalf[tempIndex] = merge(mergeArray[index], mergeArray[index+1]);
			if(tempIndex != firstHalf.length){
				tempIndex++;
				}
			}
		
		for(int index = halfSize; index < secondHalf.length; index++){
			tempIndex = 0;
			secondHalf[tempIndex] = merge(mergeArray[index], mergeArray[index+1]);
			if(tempIndex != secondHalf.length){
				tempIndex++;
			}
		}
		}
		
		
	
	private static int[] merge (int[] arrayFront, int[] arrayEnd){
		int[] front = arrayFront;
		int[] end = arrayEnd;
		
		int oneSize = arrayFront.length;
		int twoSize = arrayEnd.length;
		int newSize = oneSize + twoSize;
		int[] returnArray = new int[newSize];
		
		//index for first array
		int i = 0;
		//Index for second array
		int j = 0;
		//Index of return array
		int k = 0;
		
		while(i< oneSize && j< twoSize){
			if(front[i] < end[j]){
				returnArray[k] = front[i];
				i++;
				k++;
			}
			else{
				returnArray[k] = end[j];
				j++;
				k++;
			}
		}
		
		while(i< oneSize){
			returnArray[k] = front[i];
			i++;
			k++;
		}
		
		while(j < twoSize){
			returnArray[k] = end[j];
			j++;
			k++;
		}
		
		return returnArray;
	}
}
