package leetcode.demos;
/**
 *快速排序
* @author: zhengxinm
* @Description:
* @date: 2020年5月14日 下午3:56:56 
* @version: nccnative
 */
public class Demo03 {
	public static void main(String[] args) {
		int[] nums = new int[] { 3,1,2,5,4,6,9,7,10,8 };
		quickSort(nums, 0, nums.length - 1);
		for (int a : nums) {
			System.out.println(a);
		}
	}

	public static void quickSort(int[] nums, int start, int end) {
		if (start > end)
			return;
		int mid = nums[start];
		int low = start;
		int high = end;
		while (low < high) {
			while(low < high && nums[high] > mid) {
				high --;
			}
			nums[low] = nums[high];
			while(low < high && nums[low] < mid) {
				low ++;
			}
			nums[high] = nums[low];
		}
		nums[low] = mid;
		quickSort( nums , start, low-1 );
		
		quickSort( nums , low +1 , end );
	}

	public static void swip(int start, int end, int[] shus) {
		int temp = shus[start];
		shus[start] = shus[end];
		shus[end] = temp;
	}
}
