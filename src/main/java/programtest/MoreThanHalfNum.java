package programtest;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2022-10-05
 */
public class MoreThanHalfNum {

    /**
     * 思路：这个数字出现的次数比其他所有数字出现的次数之和还要多
     * 遍历数组，保存对比数字和该数字出现的次数，继续遍历下一个数字
     * 如果下一个数字和对比数字相同，则次数加1， 如果不相同，则次数减1.
     * 次数为0则把当前数字作为对比数字，依次遍历。
     * 最后留下的对比数字就是要寻找的数字
     */
    private static int moreThanHalfNum(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (result == nums[i]) {
                times++;
            } else {
                times--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 4, 2, 2, 5};
        int result = moreThanHalfNum(nums);
        System.out.println(result);
    }
}
