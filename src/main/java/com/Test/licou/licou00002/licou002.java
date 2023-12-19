package com.Test.licou.licou00002;

public class licou002 {

    public static void main(String[] args) {
        //new licou002().addTwoNumbers();
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = addd(l1,l2,0);
        return l;

    }

    private ListNode addd(ListNode l1, ListNode l2, int i) {
        if(l1 == null && l2 == null && i == 0){
            return null;
        }
        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        i = val1 + val2 + i;
        ListNode listNode = new ListNode(i % 10);
        if(l1!=null){
            l1 = l1.next;
        }
        if(l2!=null){
            l2 = l2.next;
        }
        if(l1 != null || l2 != null || i != 0) {
            listNode.next = addd(l1, l2, i / 10);
        }
        return listNode;
    }
}
