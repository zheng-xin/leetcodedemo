package leetcode.demos;
//单向链表删除倒数第n个节点
public class Demo15 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		//先求出链表长度
		int length = 0;
		ListNode first = head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		while (first != null) {
			length ++;
			first = first.next;
		}
		length =length - n;
		first = pre;
		while (length > 0) {
			first = first.next;
			length --;
		}
		first.next = first.next.next;
		return pre.next;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
		removeNthFromEnd(n1, 1);
		System.out.println("ssssss");
		
	}
}
