package test;

/**
 * use for test
 * @author jiayi
 * 2017年3月2日
 */
public class Test {
	public int[] getNext(int[] find) {
		int length = find.length;
		int[] next = new int[length];
		int head = -1, curr = 0;
		next[0] = -1;
		while (curr < length -1) {
			if (head < 0 || find[curr] == find[head]) {
				head++;
				curr++;
				next[curr] = head;
			} else {
				head = next[head];
			}
		}
		return next;
	}
	public int KMP(int[] origin, int[] find) {
		int originLength = origin.length;
		int findLength = find.length;
		int[] next = getNext(find);
		int originIndex = 0, findIndex = 0;
		while (originIndex < originLength) {
			if (findIndex < 0 || origin[originIndex] == find[findIndex]) {
				if (findIndex == findLength - 1) return originIndex - findIndex;
				originIndex++;
				findIndex++;
			} else {
				findIndex = next[findIndex];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] origin = new int[]{1,2,3,4,5,1,2,3,1,2,3,6};
		int[] find = new int[]{1,2,3,1,2,3};
		Test test = new Test();
		int index = test.KMP(origin, find);
		System.out.println("result : " + index);
	}
}
