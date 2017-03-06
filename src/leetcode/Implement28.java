package leetcode;

import java.util.Arrays;

/**
 * KMP
 * @author jiayi
 * 2017年3月3日
 */
public class Implement28 {
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		if (haystack.length() == 0) return -1;
		int[] next = getNext(needle);
		int haystackIndex = 0, needleIndex = 0;
		while (haystackIndex < haystack.length()) {
			if (needleIndex < 0 ||haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
				if (needleIndex == needle.length() - 1) return haystackIndex - needleIndex;
				haystackIndex++;
				needleIndex++;
			} else {
				needleIndex = next[needleIndex];
			}
		}
		return -1;
	}
	
	public static int[] getNext(String needle) {
		int[] next = new int[needle.length()];
		next[0] = -1;
		int head = -1, curr = 0;
		while (curr < needle.length() - 1) {
		if (head == -1 || needle.charAt(head) == needle.charAt(curr)) {
			head++;
			curr++;
			next[curr] = head;
		}
		else head = next[head];
		}
		return next;
	}
	
	public static void main(String[] args) {
		String haystack = "aaa";
		String needle = "aaa";
		System.out.println("result : " + strStr(haystack, needle));
		System.out.println("result : " + needle.substring(0, 0));
		
	}
}
