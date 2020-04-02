package lcof;

import java.util.HashSet;
import java.util.Set;

public class _3数组中重复的数字 {

    public static void main(String[] args) {


    }


    public static int findRepeatNumber(int[] nums) {

        Set<Integer> memo = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int curNum = nums[i];
            boolean ifContain = memo.contains(curNum);
            if (ifContain) {
                return curNum;
            } else {
                memo.add(curNum);
            }
        }

        throw new RuntimeException("字母没有重复");
    }

}
