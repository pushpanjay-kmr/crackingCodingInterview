package com.hashinclude.cci.linkedlist;

import java.util.HashSet;

/**
 * @author pushpanjay.kumar created on 18/6/20
 */
public class RemoveDups {

    /**
     * TC: O(n)
     * AS: O(n)
     * @param ll
     */
    private static void removeDups1(SingleLinkedList ll){
        HashSet<Integer> set = new HashSet<>();
        SingleLinkedListNode temp = ll.head;
        SingleLinkedListNode prev = null;
        while (temp!=null){
            if(set.contains(temp.data)){
                prev.next = temp.next;
            } else{
                set.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * TC: O(n^2)
     * AS: O(1)
     * @param ll
     */
    private static void removeDups2(SingleLinkedList ll){
        SingleLinkedListNode current = ll.head;
        while (current!=null){
            SingleLinkedListNode runner = current;
            while (runner.next!=null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList ll1 = SingleLinkedList.createATempLL();
        ll1.disp();
        removeDups1(ll1);
        ll1.disp();


        SingleLinkedList ll2 = SingleLinkedList.createATempLL();
        ll2.disp();
        removeDups2(ll2);
        ll2.disp();
    }
}
