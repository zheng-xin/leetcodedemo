package leetcode.demos;

import java.util.Stack;

/**
 * ��Сջ
 * 
 * @author: zhengxinm
 * @Description:
 * @date: 2020��5��12�� ����1:56:07
 * @version: nccnative
 */
public class Demo06 {
	// ����ջ
	private Stack<Integer> data;
	// ����ջ
	private Stack<Integer> helper;

	/**
	 * initialize your data structure here.
	 */
	public Demo06() {
		data = new Stack<Integer>();
		helper = new Stack<Integer>();
	}

	// ˼· 1������ջ�͸���ջ���κ�ʱ��ͬ��

	public void push(int x) {
		// ����ջ�͸���ջһ��������Ԫ��
		data.add(x);
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		} else {
			helper.add(helper.peek());
		}
	}

	public void pop() {
		// ����ջ���� pop
		if (!data.isEmpty()) {
			helper.pop();
			data.pop();
		}
	}

	public int top() {
		if (!data.isEmpty()) {
			return data.peek();
		}
		throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
	}

	public int getMin() {
		if (!helper.isEmpty()) {
			return helper.peek();
		}
		throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
	}

	public static void main(String[] args) {
		Demo06 myStack = new Demo06();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
	}
}
