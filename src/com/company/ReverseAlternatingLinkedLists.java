package com.company;

//todo clean this up :)
//this application reverses k nodes in a linkedlist,
//followed by k nodes in original order,
//for every group of k, and
//returns the new head node
class ReverseAlternatingLinkedLists {
    public static void main(String[] args) {
        LinkedList list15 = new LinkedList(15);
        LinkedList list14 = new LinkedList(14);
//        list14.next = list15;
        LinkedList list13 = new LinkedList(13);
        list13.next = list14;
        LinkedList list12 = new LinkedList(12);
        list12.next = list13;
        LinkedList list11 = new LinkedList(11);
        list11.next = list12;
        LinkedList list10 = new LinkedList(10);
        list10.next = list11;
        LinkedList list9 = new LinkedList(9);
        list9.next = list10;
        LinkedList list8 = new LinkedList(8);
        list8.next = list9;
        LinkedList list7 = new LinkedList(7);
        list7.next = list8;
        LinkedList list6 = new LinkedList(6);
        list6.next = list7;
        LinkedList list5 = new LinkedList(5);
        list5.next = list6;
        LinkedList list4 = new LinkedList(4);
        list4.next = list5;
        LinkedList list3 = new LinkedList(3);
        list3.next = list4;
        LinkedList list2 = new LinkedList(2);
        list2.next = list3;
        LinkedList head = new LinkedList(1);
        head.next = list2;

        LinkedList newHead = reverseAlternatingKNodes(head, 3);
    }
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


    public static LinkedList reverseAlternatingKNodes(LinkedList head, int k) {
        LinkedList prev = null;
        LinkedList current = head;
        boolean reverse = true;
        LinkedList newHead = null;
        LinkedList nextCurrent = current;
        LinkedList nextPrev = null;

        while (current != null) {
            if (reverse) {
                LinkedList temp = current; //1
                //prev = null
                for (int i = 0; i < k; i++) {
                    if (current.next == null) {
                        current.next = prev;
                        nextCurrent.next = null;
                        //edge case if we didn't have one rotation already
                        if (nextPrev == null) return current;
                        nextPrev.next = current;

                        return newHead;
                    }
                    temp = temp.next;
                    current.next = prev; //1.next points to null
                    prev = current; //prev = 1
                    current = temp; //current = 2
                }
                reverse = false;
                if (nextPrev != null) nextPrev.next = prev;
                nextCurrent.next = current;

                if (newHead == null) {
                    newHead = prev;
                }
            } else {

                for (int i = 0; i < k; i++) {
                    if (current == null) {
                        return newHead;
                    }
                    prev = current;
                    current = current.next;
                }
                reverse = true;
                nextCurrent = current;
                nextPrev = prev;

            }


        }


        return newHead;
    }

}
