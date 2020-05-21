package leetcode.demos;

/**
 * @Auther: zhengxin
 * @Date: 2020/5/21 - 05 - 21 - 11:27
 * @Description: leetcode.demos  合并两个有序链表 从小到大
 * @version: 1.0
 */
public class Demo19 {


     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
      }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//官方题解1
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public  static  ListNode mergeTwoLists2(ListNode l1, ListNode l2) {//自己写的
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            }
            else if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                int val1 = l1.val;
                int val2 = l2.val;
                if (val1 <= val2) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 =l2.next;
                }
            }
            curr = curr.next;

        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(4);
        ListNode result = mergeTwoLists2(node1, node2);
        System.out.println(result);
    }

}
