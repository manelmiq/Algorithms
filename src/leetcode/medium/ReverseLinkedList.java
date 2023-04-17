package leetcode.medium;

import dataStructures.LinkedList.ListNode;
import dataStructures.LinkedList.MainClass;


import java.util.Scanner;
import java.io.PrintWriter;

public class ReverseLinkedList {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
          String input = in.next();
          ListNode n = MainClass.stringToListNode(input);
          out.println(reverseBetween(n, 4, 8).toString());
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, prev = dummy;
        int i = 1;
        while(i < left){
            cur = cur.next;
            prev = prev.next;
            i++;
        }
        ListNode node = prev;
        while(i <= right){
            ListNode saveNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = saveNext;
            i++;
        }
        node.next.next = cur;
        node.next = prev;
        return dummy.next;
    }
}
