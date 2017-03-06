package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//想法：通过每次维护一个dupList来获取上次新增的数组。如果下个要增加的元素与上一次相同，
//则是基于dupList来进行扩展。否则是基于所有现有数组进行扩展。
public class SubsetII90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		getSubSets(res, 0, nums);
		return res;
	}
	
	public List<List<Integer>> getSubSets(List<List<Integer>> res, int curr, int[] nums) {
		if (curr < nums.length) {
			List<List<Integer>> dupList = getSubSets(res, curr + 1, nums);
			List<List<Integer>> copyDupList = new ArrayList<List<Integer>>();
			if (curr + 1 < nums.length && nums[curr] == nums[curr + 1]) {
				for (List<Integer> list : dupList) {
					List<Integer> tempList = new ArrayList<Integer>(list);
					tempList.add(nums[curr]);
					res.add(tempList);
					copyDupList.add(tempList);
				}
			} else {
				List<List<Integer>> copyRes = new ArrayList<List<Integer>>(res);
				for (List<Integer> list : copyRes) {
					List<Integer> tempList = new ArrayList<Integer>(list);
					tempList.add(nums[curr]);
					res.add(tempList);
					copyDupList.add(tempList);
				}
			}
			return copyDupList;
		} else {
			res.add(new ArrayList<Integer>());
			return res;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,2};
		List<List<Integer>> res = new SubsetII90().subsetsWithDup(nums);
		System.out.println("result : " + res);
	}
}
