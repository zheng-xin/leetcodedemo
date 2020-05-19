package leetcode.demos;
import java.util.HashMap;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
public class Demo12 {
	 public static int subarraySum(int[] nums, int k) {//自己写的
		 int count = 0;
		 if (nums == null || nums.length == 0) {
			 return 0;
		 }
		 for (int i = 0; i < nums.length; i++) {
			 int shu = nums[i];
			 int j = i;
			 int sum = 0;
			 while (j < nums.length) {
				 sum += i == j ? 0 : nums[j];//处理自己本身等于k的情况
				 int result = shu + sum;
				 if (result == k) {
					 count ++;
				 } 
				 j++;
			 }
		 }
		 return count;
	 }
	 public int subarraySum2(int[] nums, int k) {//别人写的   没看懂
	        int count = 0, pre = 0;
	        HashMap<Integer,Integer>mp = new HashMap<Integer, Integer>();
	        mp.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            pre += nums[i];
	            if (mp.containsKey(pre - k))
	                count += mp.get(pre - k);
	            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
	        }
	        return count;
	    }

	 public static void main(String[] args) {
		 int[] nums = new int[] {1,1,1};
		 int k = 2;
		 System.out.println(subarraySum( nums, k) );
	}
}
