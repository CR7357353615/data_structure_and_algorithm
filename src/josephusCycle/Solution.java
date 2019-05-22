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
 * 解题思路：使用循环链表进行循环删除
 */
public class Solution {
    public int getLastNum(int n, int k, int m) {
        if (n <= 0) {
            return 0;
        }

        // 简历循环链表
        ListNode curr = new ListNode(0);
        ListNode head = new ListNode(1);
        curr.next = head;
        for (int i = 2; i <= n; i++) {
            curr.next.next = new ListNode(i);
            curr.next = curr.next.next;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = curr.next;
        curr.next.next = head;
        curr.next = head;

        // 从k开始
        for (int i = 0; i < k - 1; i++) {
            curr.next = curr.next.next;
            sentry.next = sentry.next.next;
        }

        // 循环删除节点
        while (curr.next.next != curr.next) {
            for (int i = 0; i < m - 1; i++) {
                curr.next = curr.next.next;
                sentry.next = sentry.next.next;
            }
            remove(sentry);
            curr.next = sentry.next.next;
        }
        return curr.next.val;
    }

    private void remove(ListNode node) {
        System.out.println("delete node val: " + node.next.next.val);
        node.next.next = node.next.next.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLastNum(5, 1, 3));
    }

}
