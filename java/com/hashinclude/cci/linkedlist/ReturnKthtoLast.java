package com.hashinclude.cci.linkedlist;

/**
 * @author pushpanjay.kumar created on 18/6/20
 */
public class ReturnKthtoLast {

    private static int getLLSize(SingleLinkedList ll){
        int n = 0;
        SingleLinkedListNode temp = ll.head;
        while (temp!=null){
            n++;
            temp=temp.next;
        }
        return n;
    }

    /**
     * TC: O(n)
     * AS: O(1)
     * Two Iteration over SingleLinkedList
     * @param ll
     * @param k
     * @return
     */
    private static SingleLinkedListNode getKthFromLast1(SingleLinkedList ll, int k){
        int n = getLLSize(ll);

        if(k>n){
            return null;
        }

        n = n-(k-1);
        SingleLinkedListNode temp = ll.head;
        while(n>1){
            temp = temp.next;
            n--;
        }
        return temp;
    }

    /**
     * TC: O(n)
     * AS: O(1)
     * One Iteration over SingleLinkedList
     * @param ll
     * @param k
     * @return
     */
    private static SingleLinkedListNode getKthFromLast2(SingleLinkedList ll, int k){
        SingleLinkedListNode fast = ll.head;
        SingleLinkedListNode slow = ll.head;
        while (k>1){
            if(fast == null){
                return null;
            }
            fast = fast.next;
            k--;
        }

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SingleLinkedList ll = SingleLinkedList.createATempLL();
        ll.disp();
        System.out.println();
        System.out.println(getKthFromLast1(ll, 5).data);
        System.out.println(getKthFromLast1(ll, 1).data);
        System.out.println(getKthFromLast1(ll, 9).data);

        System.out.println();

        System.out.println(getKthFromLast2(ll, 5).data);
        System.out.println(getKthFromLast2(ll, 1).data);
        System.out.println(getKthFromLast2(ll, 9).data);
    }
}
