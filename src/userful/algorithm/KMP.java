package userful.algorithm;

import java.util.Arrays;

/**
 * KMP算法：比较有用的一篇博文，http://blog.csdn.net/v_july_v/article/details/7041827。主要是获取next数组
 * @author zhijungou
 * 2017年3月2日
 */
public class KMP {
    public static void main(String[] args) {
        int[] test = {3,4,2,1,1,1,2,3,1,2,4,5,4};
        int[] find = {1,2,3,1,2,4};
//        int[] next = getNext(test);
        int[] myNext = getMyNext(find);
//        System.out.println("result : " + Arrays.toString(next));
        System.out.println("result : " + Arrays.toString(myNext));
        int i = kmp(test, find);
        System.out.println("result : " + i);
    }

    private static int[] getNext(int[] origin) {
        int[] next = new int[origin.length];
        next[0] = -1; 
        int head = -1, curr = 0;
        while (curr < origin.length - 1) {
            if (head == -1 || origin[curr] == origin[head]) {
                head++;
                curr++;
                next[curr] = head;
            } else {
                head = next[head];
            }
        }
        return next;
    }
    
    private static int[] getMyNext(int[] origin) {
        int[] next = new int[origin.length];
        next[0] = -1;
        next[1] = 0;
        int head = 0, curr = 1;
        while(curr < origin.length - 1) {
            if(head < 0 || origin[curr] == origin[head]) {
                head++;
                curr++;
                next[curr] = head;
            } else {
                head = next[head];
            }
        }
        return next;
    }
    
    private static int kmp(int[] origin, int[] find) {
        int[] next = getNext(find);
        int originIndex = 0, findIndex = 0;
        while ( originIndex  < origin.length ) {
            if (findIndex < 0 || origin[originIndex] == find[findIndex]) {
                if (findIndex == find.length - 1) {
                    return originIndex - findIndex;
                }
                originIndex++;
                findIndex++;
            } else {
                findIndex = next[findIndex];
            }
        }
        return -1;
    }
}
