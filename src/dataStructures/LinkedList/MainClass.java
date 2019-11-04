package dataStructures.LinkedList;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return MainClass.listNodeToString(this);
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        int len = calculateSize(head);
        System.out.println(len);
        mergeSort(head);
        return head;
    }

    int calculateSize(ListNode l) {
        int size = 0;
        ListNode t = l;
        while (t != null) {
            t = t.next;
            size++;
        }
        return size;
    }

    ListNode mergeSort(ListNode list) {
        if (list == null || list.next == null)
            return list;

        // step 1. cut the list to two halves
        ListNode current = null, endList = list, doublePointer = list;

        while (doublePointer != null && doublePointer.next != null) {
            current = endList;
            endList = endList.next;
            doublePointer = doublePointer.next.next;
        }

        assert current != null;
        current.next = null;

        // step 2. sort each half
        ListNode l1 = mergeSort(list);
        ListNode l2 = mergeSort(endList);

        // step 3. merge l1 and l2
        return merged(l1, l2);
    }


    ListNode merged(ListNode l1, ListNode l2) {
//        return null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merged(l1.next, l2);
            return l1;
        } else {
            l2.next = merged(l1, l2.next);
            return l2;
        }
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";

        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        ListNode l1 = stringToListNode("[4, 5, 3, 1, 99,  5, 8, 9]");
        ListNode ret = new Solution().sortList(l1);
        String out = listNodeToString(ret);
        System.out.println(out);

    }
}