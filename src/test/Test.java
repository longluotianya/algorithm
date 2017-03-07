package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * use for test
 * @author jiayi
 * 2017年3月2日
 */
public class Test {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> each = new ArrayList<>();
	    helper(res, each, 0, nums);
	    return res;
	}
	public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
	    if (pos <= n.length) {
	        res.add(each);
	        System.out.println("each : " + each);
	    }
	    int i = pos;
	    while (i < n.length) {
	        each.add(n[i]);
	        helper(res, new ArrayList<>(each), i + 1, n);
	        each.remove(each.size() - 1);
	        i++;
	        while (i < n.length && n[i] == n[i - 1]) {i++;}
	    }
	    return;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,2};
		List<List<Integer>> result = new Test().subsetsWithDup(nums);
		System.out.println("result : " + result);
	}
}
