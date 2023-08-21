package 删除链表的倒数第N个结点;

import java.util.ArrayList;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-04-17-16:04
 * @descirbe ：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *    输入：head = [1,2,3,4,5], n = 2
 *    输出：[1,2,3,5]
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2= new ListNode(2);
//        ListNode node3= new ListNode(3);
//        ListNode node4= new ListNode(4);
//        ListNode node5= new ListNode(5);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        ListNode listNode = removeNthFromEnd(node1, 2);
//        ListNode listNode = Answer(node1, 1);
        ListNode listNode = superme(node1, 1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
  /**
   * @Author Xiaobaishushu
   * @Description :执行结果：通过
   *执行用时：3 ms, 在所有 Java 提交中击败了5.15%的用户
   *内存消耗：41 MB, 在所有 Java 提交中击败了5.15%的用户
   * 通过测试用例：208 / 208
   * @Date 2022/4/17 16:36
   * @Param [head, n]
   * @return 删除链表的倒数第N个结点.ListNode
   **/
  //自己的思路就是遍历链表同时存在一个集合中，删除指定的元素后在遍历集合取出数据赋给链表。
  //看了答案后发现自己就是个憨批，根本不需要取出来，只需要第一次遍历记住长度就行，这样省了创建新链表的时间还有空间
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
              if (head.next==null){
                  return null;
              }
          while (head!=null){
              list.add(head.val);
              head=head.next;
          }
          if (list.size()==2){
              if (n==1){
                  return new ListNode(list.get(0));
              }else {
                  return new ListNode(list.get(1));
              }
          }
        list.remove(list.size()-n);
        System.out.println(list);
        ListNode node = new ListNode(list.get(0));
        ListNode node2 = new ListNode(list.get(1));
        node.next=node2;
        for (int i = 2; i < list.size(); i++) {
           node2.next=new ListNode(list.get(i));
           node2=node2.next;
        }
        return node;
    }
    public static ListNode superme(ListNode head, int n){
        int i=0;
        ListNode m=head;
        ListNode index=new ListNode(0);
        index.next=head;
        ListNode flag=new ListNode(0);
        flag=index.next;
        while (m!=null){
            m=m.next;
            i++;
        }
        for (int j = 1; j < i-n; j++) {
            index=index.next;
        }
        index.next=index.next.next;
//        System.out.println(i);
        return flag;
    }
     /**
      * @Author Xiaobaishushu
      * @Description :执行结果：
      * 通过
      * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
      * 内存消耗：39.6 MB, 在所有 Java 提交中击败了39.99%的用户
      * 通过测试用例：
      * 208 / 208
      * @Date 2022/4/17 18:42
      * @Param [head, n]
      * @return 删除链表的倒数第N个结点.ListNode
      **/
    //解法有用栈的还有其他的，感觉这个双指针（快慢指针）比较巧妙，设置两个指针，其中一个比另一个快n，当快的那个指到末位的时候
    // 慢的那个指的就是需要删除的位置
    public static  ListNode Answer(ListNode head, int n){
        ListNode index = new ListNode();
        index.next=head;
        //这个slow起到标记的作用，记住头结点
        ListNode slow=index;
        for (int i = 0; i < n; i++) {
            head=head.next;
        }
        //快指针已经遍历了n个了，此时需要快慢指针同时遍历
       while (head!=null){
           head=head.next;
           slow=slow.next;
       }
        slow.next=slow.next.next;
        ListNode ans=index.next;
           return ans;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
