package dataStructures;


import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class TestLinkedList {

    @Test
    public void testAdd() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("john");
        list.addFirst("mary");
        assertEquals(list.size, 2);
    }

    @Test
    public void testInsertOrder() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("mary");
        list.addFirst("john");
        assertEquals(list.toString(), "mary, john");
    }

    @Test
    public void testInsertLast() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast("mary");
        list.addLast("john");
        assertEquals(list.toString(), "mary, john");
    }

    @Test
    public void testRemoveByValue() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst("mary");
        list.addFirst("john");
        list.addFirst("natalie");
        list.addFirst("joseph");
        list.removeByValue("natalie");
        assertEquals(list.toString(), "joseph, john, mary");
    }
}
