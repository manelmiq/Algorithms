package dataStructures.LinkedList;

public class Solution {
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
