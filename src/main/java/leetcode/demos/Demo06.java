package leetcode.demos;

import java.util.Stack;

/**
 * 最小栈
 * 
 * @author: zhengxinm
 * @Description:
 * @date: 2020年5月12日 下午1:56:07
 * @version: nccnative
 */
public class Demo06 {
	// 数据栈
	private Stack<Integer> data;
	// 辅助栈
	private Stack<Integer> helper;

	/**
	 * initialize your data structure here.
	 */
	public Demo06() {
		data = new Stack<Integer>();
		helper = new Stack<Integer>();
	}

	// 思路 1：数据栈和辅助栈在任何时候都同步

	public void push(int x) {
		// 数据栈和辅助栈一定会增加元素
		data.add(x);
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		} else {
			helper.add(helper.peek());
		}
	}

	public void pop() {
		// 两个栈都得 pop
		if (!data.isEmpty()) {
			helper.pop();
			data.pop();
		}
	}

	public int top() {
		if (!data.isEmpty()) {
			return data.peek();
		}
		throw new RuntimeException("栈中元素为空，此操作非法");
	}

	public int getMin() {
		if (!helper.isEmpty()) {
			return helper.peek();
		}
		throw new RuntimeException("栈中元素为空，此操作非法");
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
