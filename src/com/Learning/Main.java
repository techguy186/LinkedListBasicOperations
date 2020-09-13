package com.Learning;

/*Creating a Node*/
class Node{
    int data;
    Node next;
}

/*Creating a Linked List and Allocation in Memory*/
class LinkedList{
    Node head;
    Node tail;
    int size;

    /*Print the Linked List*/
    void display() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    /*Adding elements to the last Node*/
    void addLast(int val){
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;

        if(size == 0)
            head = tail = newNode;
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /*Adding elements to the First Node*/
    void addFist(int val){
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;

        if(size == 0)
            head = tail = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /*Adding elements to the given Index*/
    void addAtIndex(int val, int index){
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;

        if(index < 0 || index >= size){
            System.out.println("Type a valid Index");
            System.exit(-1);
        }

        else if(index == 0)
            addFist(val);

        else if(index == size-1)
            addLast(val);

        else{
            Node temp = head;

            for(int i=0; i<index-1; i++)
                temp = temp.next;

            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    /*Remove First element of a linked list*/
    void removeFirst(){
        if(size == 0){
            System.out.println("list is empty");
        }
        else if(size == 1){
            head = tail = null;
        }
        else{
            head = head.next;
        }
        size--;
    }

    /*Remove Last element of a Linked List*/
    void removeLast(){
        if(size == 0){
            System.out.println("list is empty");
        }
        else if(size == 1){
            head = tail = null;
        }
        else{
            Node temp = head;

            for(int i=0; i<size-2; i++)
                temp = temp.next;

            temp.next = null;
            size--;
        }
    }

    /*Remove elements from a given Index*/
    void removeAtIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("Type a valid Index");
        }

        else if(index == 0)
            removeFirst();

        else if(index == size-1)
            removeLast();

        else{
            Node temp = head;

            for(int i=0; i<index-1; i++)
                temp = temp.next;

            temp.next = temp.next.next;
            size--;
        }
    }

    /*return an element of a given index*/
    int getElementAtIndex(int index){
        Node temp = head;

        for(int i=0; i<index; i++)
            temp = temp.next;

        return temp.data;
    }

    void updation(int val, int index){
        if(index < 0 || index >= size){
            System.out.println("Type Valid Index");
            System.exit(-1);
        }
        else{
            Node temp = head;
            for(int i=0; i<index; i++)
                temp = temp.next;
            temp.data = val;
        }
    }

    /*Return size of a Linked List*/
    int size(){
        return size;
    }
}

public class Main{

    public static void main(String[] args) {
	// write your code here
        LinkedList list = new LinkedList();
        list.addLast(-20);
        list.addFist(-30);
        list.addLast(-10);
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addAtIndex(0,3);
        list.removeAtIndex(3);
        list.removeAtIndex(0);
        list.removeAtIndex(4);
        list.display();
        System.out.println();
        System.out.println("Current size of linked list : " + list.size());
        System.out.println("Element at Index 2 : " + list.getElementAtIndex(2));
        System.out.println("Updation Element at index 2 : " );
        list.updation(200, 2);
        list.display();
    }
}
