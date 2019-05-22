package josephusCycle;

/**
 * @author lihao
 * @date 2019-05-21 14:12
 * 约瑟夫环
 * 约瑟夫环（约瑟夫问题）是一个数学的应用问题：
 * 已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围，从编号为k的人开始报数，数到m的那个人出列；
 * 他的下一个人又从1开始报数，数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人只有一个没有出列。
 * 假设n=1000,k=5,m=13,问剩下最后一个人编号。
 *
 * 解题思路：使用递推公式
 * 递推公式如下：f(i) = (f(i - 1) + m) % i
 */
public class Solution1 {
    public int getLastNum(int n, int k, int m) {
        if (n == 1) {
            return 0;
        }
        return (getLastNum(n - 1, k, m) + m) % n;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.getLastNum(5, 1, 3));
    }

}
