package test;

import java.util.Arrays;

public class MergeSortTest {
	public int[] mergeSort(int[] array, int start, int end) {
		if (end <= start) return new int[]{array[start]};
		int middle = (start + end) / 2;
		int[] left = mergeSort(array, start, middle);
		int[] right = mergeSort(array, middle + 1, end);
		return merge(left, right);
	}
	
	public int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int[] newLeft = new int[left.length + 1];
		for (int i = 0; i < left.length; i++) newLeft[i] = left[i];
		newLeft[left.length] = Integer.MAX_VALUE;
		int[] newRight = new int[right.length + 1];
		for (int i = 0; i < right.length; i++) newRight[i] = right[i];
		newRight[right.length] = Integer.MAX_VALUE;	
		for (int i = 0, j = 0, k = 0; i < right.length + left.length; i++) {
			if (newLeft[j] <= newRight[k]) {
				result[i] = newLeft[j];
				j++;
			} else {
				result[i] = newRight[k];
				k++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{1,3,2,5,4,2,1,7,8,5,13,21,14};
		int[] result = new MergeSortTest().mergeSort(test, 0, test.length - 1);
		System.out.println("result : " + Arrays.toString(result));
	}
}
