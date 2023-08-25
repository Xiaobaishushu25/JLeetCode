/**
 * @author Xbss
 * @version 1.0
 * @create 2022-03-17-19:28
 * @descirbe :给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class NodeSum {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2= new ListNode(2, node1);
        ListNode node3= new ListNode(3, node2);//321

        ListNode listNode2 = new ListNode(3, new ListNode(2, new ListNode(1)));
//        new NodeSum().addTwoNumbers(node3,listNode2);
        add(node3,listNode2,0);

    }
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            System.out.println(88888);
        }
        return null;
//    return add(l1,l2,0);
    }

    public static ListNode add(ListNode m1,ListNode m2,int bit){
        if (m1==null&&m2==null&&bit==0){
            return null;
        }
        int val=bit;
        if (m1!=null){
            val+=m1.val;
            m1=m1.next;
        }
        if (m2!=null){
            val+=m2.val;
            m2=m2.next;
        }
        System.out.println(val);
        //将两个链表对应位置的数相加取余，再将两个数相加的进位数（如果大于10）递归给下面的
        ListNode listNode = new ListNode(val % 10);
        listNode.next=add(m1,m2,val/10);
        return listNode;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
