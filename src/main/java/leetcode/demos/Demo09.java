package leetcode.demos;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 两数之和
* @author: zhengxinm
* @Description:
* @date: 2020年5月14日 上午9:21:27 
* @version: nccnative
 */
public class Demo09 {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0;i < nums.length - 1;i++) {
			for (int j = i+1;j<nums.length;j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
	public static int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0;i < nums.length;i++) {
			int shu = target - nums[i];
			if (map.containsKey(shu)) {
				result[0] = i;
				result[1] = map.get(shu);
				return result;
			}
			map.put(nums[i], i);
		}
		
		return result;
	} 
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum2(new int[] {2, 7, 11, 15}, 9)));
	}
}
