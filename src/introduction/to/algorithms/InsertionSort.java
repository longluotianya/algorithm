package introduction.to.algorithms;

// insertion sort 16/12/26
public class InsertionSort {
	private static final int ARRAY_LENGTH = 100;
	public static void main(String[] args) {
		int[] array = new int[ARRAY_LENGTH];
		for(int i = 0; i < ARRAY_LENGTH; i++){
			array[i] = (int)Math.floor(Math.random()*100);
		}
		insertSort(array);
		System.out.println("result is : ");
		for(int element : array){
			System.out.println(element + ' ');
		}
	}
	
	public static void insertSort(int[] array){
		for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int j = i - 1;
			for(; j >= 0&&array[j] >= temp; j--){
				array[j + 1] = array[j];
			}
			array[j+1] = temp;
		}
	}
} 

