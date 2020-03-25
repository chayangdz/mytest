package leetcode;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhayang on 2019/12/11.
 * 三数之和
 */
public class ThreeSum {
    /**
     * 题目，三数之和。
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]
     * 满足要求的三元组集合为：
     *  [
     *     [-1, 0, 1],
     *     [-1, -1, 2]
     *  ]
     */

    /**
     * 思路：
     * 因为数组中可能存在重复的数字，所以需要先对数组进行排序，但是不能去重。因为重复的数字也是要参与运算的。
     * 去重之后，再判断三数字之和，这里还有技巧：
     * 因为是排序后的数字进行计算的，可以把三个数字之和转换为两个数相加是否等于第三个数的负值。
     * 这样可以利用数组的有序性，减少无意义的计算。
     * 运算过程中也要注意去重，比如[-2, 1, 1, 1, 1]这种数组，明显需要对后面的这些1都去重
     */

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        if (nums.length <= 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重，i+1的过程中，重复的值就没必要再次计算了
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    result.add(Lists.newArrayList(nums[i], nums[j], nums[k]));
                    // 相加正好相等，那么接下来j向右挪动，k向左挪动，继续比较。挪动过程中需要去重。
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else {
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

}
