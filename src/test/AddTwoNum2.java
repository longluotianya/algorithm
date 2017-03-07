package test;

public class AddTwoNum2 {
	public ListNode addTwoNum(ListNode l1, ListNode l2) {
		if (null == l1 && null == l2) return null;
		ListNode resTemp = new ListNode(0);
		int addition = addTwoNumWithAddition(l1, l2, resTemp, 0);
		ListNode curr = resTemp;
		ListNode l1Temp = l1.next;
		ListNode l2Temp = l2.next;
		while (null != l1Temp || null != l2Temp || addition != 0) {
			ListNode next = new ListNode(0);
			addition = addTwoNumWithAddition(l1Temp, l2Temp, next, addition);
			curr.next = next;
			if (null != l1Temp) l1Temp = l1Temp.next;
			if (null != l2Temp) l2Temp = l2Temp.next;
			curr = next;
		}
		return resTemp;
	}
	public int addTwoNumWithAddition(ListNode l1, ListNode l2, ListNode l3, int addition) {
		if (null == l1 && null == l2) {
			l3.val = addition;
			return 0;
		}
		if (null == l1) {
			l3.val = (l2.val + addition) % 10;
			return (l2.val + addition) / 10;
		}
		if (null == l2) {
			l3.val = (l1.val + addition) % 10;
			return (l1.val + addition) / 10;
		}
		l3.val = (l1.val + l2.val + addition) % 10;
		return (l1.val + l2.val + addition) / 10;
		
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(3);
		ListNode l12 = new ListNode(7);
		ListNode l21 = new ListNode(9);
		ListNode l22 = new ListNode(2);
		l11.next = l12; 
		l21.next = l22; 
		ListNode res = new AddTwoNum2().addTwoNum(l11, l21);
		System.out.println("l1 : " + l11);
		System.out.println("l2 : " + l21);
		System.out.println("res : " + res);
	}
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	public String toString() {
		StringBuilder resStr= new StringBuilder().append(val);
		ListNode temp = this;
		while (null != temp.next) {
			temp = temp.next;
			resStr.append(" -> ").append(temp.val);
		}
		return resStr.toString();
	}
}