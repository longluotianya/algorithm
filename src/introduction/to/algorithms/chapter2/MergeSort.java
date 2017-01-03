package introduction.to.algorithms.chapter2;

import java.util.Arrays;

// merge sort 16/12/27
public class MergeSort {
	private static final int ARRAY_LENGTH = 100;
	public static void main(String[] args) {
		int[] array = new int[ARRAY_LENGTH];
		for(int i = 0; i < ARRAY_LENGTH; i++){
			array[i] = (int)Math.floor(Math.random()*100);
		}
		mergeSort(array, 0, array.length - 1);
		System.out.println("result is : ");
		for(int element : array){
			System.out.println(element + ' ');
		}
	}
	public static int[] mergeSort(int[] array, int p, int r){
		if(p >= r) return array;
		int q = (p + r)/2;
		mergeSort(array, p, q);
		mergeSort(array, q + 1, r);
		merge(array, p, q, r);
		return array;
	}
	public static void merge(int[] array, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r -q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for(int i = 0; i < n1; i++) L[i] = array[p + i];
		L[n1] = Integer.MAX_VALUE;
		for(int i = 0; i < n2; i++) R[i] = array[q + 1 + i];
		R[n2] = Integer.MAX_VALUE;
		for(int i = p, j = 0, k = 0; i <= r; i++){
			if(L[j] <= R[k]) {
				array[i] = L[j];
				j++;
			} else {
				array[i] = R[k];
				k++;
			}
		}
	}
}
