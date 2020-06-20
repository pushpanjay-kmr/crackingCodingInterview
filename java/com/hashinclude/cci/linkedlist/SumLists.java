package com.hashinclude.cci.linkedlist;

/**
 * @author pushpanjay.kumar created on 19/6/20
 */
class CarryWrapper{
    int v =0;
}

public class SumLists {

    private static SingleLinkedList sumListOfReverseOrder(SingleLinkedList l1, SingleLinkedList l2){
        SingleLinkedListNode l1h = l1.head;
        SingleLinkedListNode l2h = l2.head;
        if (l1h==null)
            return l2;
        if (l2h==null)
            return l1;

        int c = 0;
        SingleLinkedList op = null;

        while(l1h!=null && l2h!=null){
            int sum = l1h.data + l2h.data + c;
            c = sum/10;
            sum = sum%10;
            if(op==null){
                op = new SingleLinkedList(sum);
            } else{
                op.insertInEnd(sum);
            }
            l1h=l1h.next;
            l2h=l2h.next;
        }

        while (l1h!=null){
            int sum = l1h.data+c;
            c = sum/10;
            sum = sum%10;
            op.insertInEnd(sum);
            l1h=l1h.next;
        }

        while (l2h!=null){
            int sum = l2h.data+c;
            c = sum/10;
            sum = sum%10;
            op.insertInEnd(sum);
            l1h=l2h.next;
        }

        if(c>0)
            op.insertInEnd(c);

        return op;
    }

    private static SingleLinkedListNode sumListUtils(SingleLinkedListNode n1, SingleLinkedListNode n2, CarryWrapper c){
        if(n1.next==null && n2.next==null){
            int s = n1.data + n2.data;
            c.v = s/10;
            s = s%10;
            return new SingleLinkedListNode(s);
        }

        SingleLinkedListNode next = sumListUtils(n1.next, n2.next, c);
        int s = n1.data + n2.data + c.v;
        c.v = s/10;
        s = s%10;
        SingleLinkedListNode cur = new SingleLinkedListNode(s);
        cur.next = next;
        return cur;
    }

    private static int length(SingleLinkedList ll){
        SingleLinkedListNode temp = ll.head;
        int l = 0;
        while (temp!=null){
            l++;
            temp=temp.next;
        }
        return l;
    }

    private static void padZero(SingleLinkedList ll, int n){
        SingleLinkedListNode temp = ll.head;
        for(int i=0;i<n;i++){
            SingleLinkedListNode node = new SingleLinkedListNode(0);
            node.next = temp;
            temp = node;
        }
        ll.setHead(temp);
    }

    private static SingleLinkedList sumListRecursive(SingleLinkedList l1, SingleLinkedList l2){
        CarryWrapper c = new CarryWrapper();
        int n1 = length(l1);
        int n2 = length(l2);

        if(n1<n2){
            padZero(l1, n2-n1);
        } else{
            padZero(l2, n1-n2);
        }

        SingleLinkedListNode head = sumListUtils(l1.head, l2.head, c);
        if(c.v>0){
            SingleLinkedListNode t = new SingleLinkedListNode(c.v);
            t.next = head;
            head = t;
        }
        return new SingleLinkedList(head);
    }

    public static void main(String[] args) {
        SingleLinkedList l1 = new SingleLinkedList(7);
        l1.insertInEnd(1);
        l1.insertInEnd(6);
        l1.disp();

        SingleLinkedList l2 = new SingleLinkedList(5);
        l2.insertInEnd(9);
        l2.insertInEnd(9);
        l2.disp();

        SingleLinkedList op = sumListOfReverseOrder(l1, l2);
        op.disp();

        System.out.println();

        SingleLinkedList l3 = new SingleLinkedList(6);
        l3.insertInEnd(1);
        l3.insertInEnd(7);
        l3.disp();

        SingleLinkedList l4 = new SingleLinkedList(9);
        l4.insertInEnd(9);
        l4.insertInEnd(9);
        l4.insertInEnd(7);
        l4.insertInEnd(7);
        l4.insertInEnd(2);
        l4.disp();

        SingleLinkedList op2 = sumListRecursive(l3, l4);
        op2.disp();
    }
}
