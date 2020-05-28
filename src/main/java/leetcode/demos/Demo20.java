package leetcode.demos;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/28 - 05 - 28 - 18:25
 * @Description: 盛水最多的容器  双指针发
 * @version: 1.0
 */
public class Demo20 {
    public static int maxArea(int[] height) {
        int result = 0;
        if (height == null || height.length == 0)
            return 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            result = Math.max(result,Math.min(height[i],height[j]) * (j - i));
            if (height[j] > height[i]) {
                i ++;
            } else if (height[j] < height[i]) {
                j --;
            } else {
                i++;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] shus = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(shus));
    }
}
