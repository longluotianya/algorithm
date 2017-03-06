package userful.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * all sort algorithm
 * @author jiayi
 * 2017年3月2日
 */
public class AllSortAlgorithm {
	public static final int LENGTH = 30;
	public static final int BOUND = 100;
	public static void main(String[] args) {
		Random rand = new Random();
		int[] test = new int[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			test[i] = rand.nextInt(BOUND);
		}
		System.out.println("source : " + Arrays.toString(test));
		AllSortAlgorithm algorihtm = new AllSortAlgorithm();
//		algorihtm.bubbleSort(test);
//		System.out.println("bubble : " + Arrays.toString(test));
		algorihtm.insertSort(test);
		System.out.println("insert : " + Arrays.toString(test));
	}
	
	//冒泡
	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++){
			for (int j = array.length -1; j > 0; j--) {
				if (array[j - 1] > array[j]) swap(array, j-1, j);
			}
		}
	}
	
	//插入
	public void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i;
			while (j > 0 && temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
	}
	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
