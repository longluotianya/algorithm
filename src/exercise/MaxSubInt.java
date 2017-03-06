package exercise;
/**
 * max sub array
 * @author jiayi
 * 2017年3月2日
 */
public class MaxSubInt {
	public int[] maxInt(int[] array, int start, int end) {
		if (end <= start) return new int[]{start, start, array[start]};
		int middle = (start + end) / 2;
		int[] left = maxInt(array, start, middle - 1);
		int[] right = maxInt(array, middle + 1, end);
		int[] cross = getCross(array, start, end);
		if (left[2] > right[2] && left[2] > cross[2]) return left;
		if (right[2] > left[2] && right[2] > cross[2]) return right;
		return cross;
	}
	public int[] getCross(int[] array, int start, int end) {
		int middle = (start + end) / 2;
		int temp = array[middle];
		int max = array[middle];
		int left = middle, right = middle, i = 0;
		for (i = middle - 1; i >= start; i--) {
			temp += array[i];
			if (temp > max) {
				max = temp;
				left = i;
			}
		}
		for (i = middle + 1, temp = max; i <= end; i++) {
			temp += array[i];
			if (temp > max) {
				max = temp;
				right = i;
			}			
		}
		return new int[]{left, right, max};
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{1,2,-3,-4,5,3,-1,-7,9,2,-4,-3};
		int[] result = new MaxSubInt().maxInt(test, 0, test.length - 1);
		System.out.println("max sub array : left :" + result[0] + " right : " + result[1] + " total : " + result[2]);
	}
}
