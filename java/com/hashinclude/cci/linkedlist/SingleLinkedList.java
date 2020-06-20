package com.hashinclude.cci.linkedlist;

/**
 * @author pushpanjay.kumar created on 18/6/20
 */
public class SingleLinkedList {
    SingleLinkedListNode head;

    public SingleLinkedList(int data) {
        this.head = new SingleLinkedListNode(data);
    }

    public SingleLinkedList(SingleLinkedListNode head) {
        this.head = head;
    }

    public SingleLinkedList() {
    }

    public void setHead(SingleLinkedListNode node){
        this.head = node;
    }

    public void insertInBeg(int data){
        SingleLinkedListNode node = new SingleLinkedListNode(data);
        node.next = this.head;
        setHead(node);
    }

    public void insertInEnd(int data){
        SingleLinkedListNode node = new SingleLinkedListNode(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        SingleLinkedListNode temp = this.head;
        while (temp.next!=null)
            temp=temp.next;
        temp.next = node;
    }

    public void disp(){
        System.out.println();
        SingleLinkedListNode temp = this.head;
        while (temp!=null){
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
    }

    public static SingleLinkedList createATempLL(){
        SingleLinkedList ll = new SingleLinkedList(3);
        ll.insertInBeg(5);
        ll.insertInEnd(10);
        ll.insertInBeg(9);
        ll.insertInBeg(5);
        ll.insertInEnd(10);
        ll.insertInEnd(10);
        ll.insertInEnd(12);
        ll.insertInBeg(56);
        return ll;
    }
}
