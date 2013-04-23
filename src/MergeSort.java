
public class MergeSort {
	
	public static void main(String[] args){
		int[] test = new int[8];
		for(int index = 0; index < test.length; index++){
			test[index] = (int)(Math.random()*100);
		}
		
		int[] output = mergeSort(test, 0, test.length);
		for(int i : output){
			System.out.println(i);
		}
		System.out.println("The length of this array is:" + output.length);
		}

	
	
	public static int[] mergeSort(int[] array, Integer start, Integer end){
		if(start<end){
			int half = ((start+end)/2);
			mergeSort(array, start, half);
			mergeSort(array, half+1, end);
			merge(array, start, half, end);
		}
		
		}
		
		
	
	private static int[] merge (int[] array, Integer start, Integer half, Integer end){
		int[] front = new int[half-start + 1];
		int[] back = new int[end-half];
		
		int oneSize = front.length;
		int twoSize = back.length;
		int newSize = oneSize + twoSize;
		int[] returnArray = new int[newSize];
		
		//index for first array
		int i = 0;
		//Index for second array
		int j = 0;
		//Index of return array
		int k = 0;
		
		while(i< oneSize && j< twoSize){
			if(front[i] < back[j]){
				returnArray[k] = front[i];
				i++;
				k++;
			}
			else{
				returnArray[k] = back[j];
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
			returnArray[k] = back[j];
			j++;
			k++;
		}
		
		return returnArray;
	}
}
