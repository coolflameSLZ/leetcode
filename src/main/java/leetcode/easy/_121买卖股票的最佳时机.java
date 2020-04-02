package leetcode.easy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _121买卖股票的最佳时机 {

    public static void main(String[] args) {


    }


    public int maxProfit(int[] prices) {


        // 定义历史最低点
        int historyMin = Integer.MAX_VALUE;

        // 定义最大收益率
        int maxprofit = 0;
        // 最大收益率，一定是某一天减去历史最低点的值。
        // 从第二天开始计数循环， 用一个变量，记录历史最低点
        // 当天的价格，减去历史最低点，如果是最大收益率，那么记录最大收益率。
        for (int i = 1; i < prices.length; i++) {
            int yeastatadayP = prices[i - 1];
            int todayP = prices[i];

            historyMin = Math.min(yeastatadayP, historyMin);

            maxprofit = Math.max(todayP - historyMin, maxprofit);
        }

        return maxprofit;
    }


}
