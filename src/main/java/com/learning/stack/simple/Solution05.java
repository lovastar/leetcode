package com.learning.stack.simple;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2020-03-29

 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
  
 */
public class Solution05 {

   public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};

   }
    public int[] maxSlidingWindow01(int[] nums, int k) {
        int resultLength = 0;
        if(nums.length!=0){
            resultLength = nums.length - k +1;
        }

        int[] result = new int[resultLength];

        int startIndex = 0;
        int endIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <resultLength; i++) {
            startIndex = i;
            endIndex = i+k-1;
            while (startIndex <= endIndex) {
                if(nums[startIndex]>max){
                    max = nums[startIndex];
                }
                if(startIndex == endIndex){
                    result[i] = max ;
                    max = Integer.MIN_VALUE;
                }
                startIndex++;
            }
        }
        return result;
    }
}
