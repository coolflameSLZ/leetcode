package leetcode.mid;

import java.util.Map;

public class _322零钱兑换 {

    public static void main(String[] args) {

        throw new RuntimeException();

    }


    // 递归法
    public int coinChange(int[] coins, int amount) {
        throw new RuntimeException();


    }

    public int coinChange(int[] coins, int amount, Map mem) {


        if (amount == 0) return 0;
        if (amount < 0) return -1;


        Integer result = -1;
        for (int coin : coins) {

            // 选择最优解，
            // 1 amount == coin
            // 2 以前的最优解+1
            result = Integer.min(result,
                    1 + coinChange(coins, amount - coin, mem));
        }

        throw new RuntimeException();

    }

//
//    public int coinChangeDP(int[] coins, int amount) {
//
//        int[] dpTable = new int[amount];
//
//
//        for (int n = 0; n < amount; n++) {
//            dpTable[n] = dp(n);
//
//        }
//
//
//    }
//
//    private int dp(int[] coins, int n) {
//
//        if (n == 0) return 0;
//
//        if (n < 0) return -1;
//
//
//        for (int coin : coins) {
//
//        }
//
//
//    }

}
