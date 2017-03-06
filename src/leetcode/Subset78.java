package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Subset78 {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		getSubset(res, nums.length - 1, nums);
		return res;
	}
	
	public static void getSubset(List<List<Integer>> res, int end, int[] nums) {
		if (end >= 0) {
			getSubset(res, end - 1, nums);
			merge(res, nums[end]);
		} else {
			res.add(new ArrayList<Integer>());
		}
	}
	
	public static void merge(List<List<Integer>> res, int cur) {
		List<List<Integer>> listCopy = new ArrayList<List<Integer>>(res);
		for (List<Integer> list : listCopy) {
			List<Integer> listTemp = new ArrayList<Integer>(list);
			listTemp.add(cur);
			res.add(listTemp);
		}
		System.out.println("step " + cur + " : " + res);
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = subsetsWithDup(nums);
		System.out.println("result : " + result);
	}
}
