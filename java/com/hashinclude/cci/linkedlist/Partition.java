package com.hashinclude.cci.linkedlist;

/**
 * @author pushpanjay.kumar created on 18/6/20
 */
public class Partition {
    /**
     * Original order of list is preserved, except for those nodes which are needed to be changed
     * @param node
     * @param x
     * @return
     */
    private static SingleLinkedListNode partitionLL1(SingleLinkedListNode node, int x){
        SingleLinkedListNode beforeListStart = null;
        SingleLinkedListNode beforeListEnd = null;
        SingleLinkedListNode afterListStart = null;
        SingleLinkedListNode afterListEnd = null;

        while (node!=null){
            SingleLinkedListNode next = node.next;
            node.next = null;

            if(node.data<x){
                if(beforeListStart==null){
                    beforeListStart = node;
                    beforeListEnd = beforeListStart;
                } else{
                    beforeListEnd.next = node;
                    beforeListEnd = node;
                }
            } else{
                if(afterListStart==null){
                    afterListStart = node;
                    afterListEnd = afterListStart;
                } else{
                    afterListEnd.next = node;
                    afterListEnd = node;
                }
            }

            node = next;
        }

        if(beforeListStart ==null) {
            return afterListStart;
        }

        beforeListEnd.next = afterListStart;
        return beforeListStart;
    }

    private static SingleLinkedListNode partitionLL2(SingleLinkedListNode node, int x){
        SingleLinkedListNode beg = null;
        SingleLinkedListNode end = null;

        while (node!=null){
            SingleLinkedListNode next = node.next;
            node.next = null;
            if(node.data<x){
                if(beg == null){
                    beg = end = node;
                } else{
                    node.next = beg;
                    beg = node;
                }
            } else{
                if(end == null){
                    beg = end = node;
                } else{
                    end.next = node;
                    end = node;
                }
            }
            node = next;
        }
        return beg;
    }

    public static void main(String[] args) {
        SingleLinkedList ll = SingleLinkedList.createATempLL();
        ll.disp();
        SingleLinkedListNode headNode = partitionLL1(ll.head, 10);
        ll.setHead(headNode);
        ll.disp();

        System.out.println();

        SingleLinkedList ll2 = SingleLinkedList.createATempLL();
        ll2.disp();
        SingleLinkedListNode headNode2 = partitionLL2(ll2.head, 10);
        ll2.setHead(headNode2);
        ll2.disp();
    }
}
