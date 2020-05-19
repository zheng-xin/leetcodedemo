package leetcode.demos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 三数之和
* 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向nums[i]后面的两端，数字分别为
* nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
* 如果 nums[i]大于0，则三数之和必然无法等于 0，结束循环
* 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
* 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
* 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
* 时间复杂度：O(n^2)，n 为数组长度
*/
public class Demo10 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return results;
		Arrays.sort(nums);
		List<Integer> result = null;
		for (int i = 0;i<nums.length - 2;i++) {
			if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i-1])
				continue;
			int l = i+1;
			int r = nums.length -1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[l]);
					result.add(nums[r]);
					results.add(result);
					while (l < r && nums[l] == nums[l+1]) l++;
					while (l < r && nums[r] == nums[r-1]) r--;
					l++;
					r--;
				}
				else if (sum > 0)
					r--;
				else l++;
			}	
		}
		return results;
	}
	public static void main(String[] args) {
		int[] nums =  new int[] {1,-1,-1,0};
		
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result);
	}
}
