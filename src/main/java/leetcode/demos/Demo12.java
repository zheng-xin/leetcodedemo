package leetcode.demos;
import java.util.HashMap;

//����һ�����������һ������ k������Ҫ�ҵ��������к�Ϊ k ��������������ĸ�����
public class Demo12 {
	 public static int subarraySum(int[] nums, int k) {//�Լ�д��
		 int count = 0;
		 if (nums == null || nums.length == 0) {
			 return 0;
		 }
		 for (int i = 0; i < nums.length; i++) {
			 int shu = nums[i];
			 int j = i;
			 int sum = 0;
			 while (j < nums.length) {
				 sum += i == j ? 0 : nums[j];//�����Լ��������k�����
				 int result = shu + sum;
				 if (result == k) {
					 count ++;
				 } 
				 j++;
			 }
		 }
		 return count;
	 }
	 public int subarraySum2(int[] nums, int k) {//����д��   û����
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
