package com.marcosvieirajr.dsa.datastructures.linear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    Array itens;

    @BeforeEach
    void setUp() {
        itens = new Array(3);
        itens.insert(10);
        itens.insert(30);
        itens.insert(20);
    }

    @Test
    void insert() {
        itens.insert(50);
        itens.insert(40);

        assertEquals(5, itens.size());
    }

    @Test
    void get() {
        int item = itens.get(1);

        assertEquals(30, item);
    }

    @Test
    void removeAt() {
        itens.removeAt(0);

        assertEquals(2, itens.size());
        assertEquals(30, itens.get(0));

        assertThrows(
                IllegalArgumentException.class,
                () -> itens.removeAt(-1));

        assertThrows(IllegalArgumentException.class,
                () -> itens.removeAt(3));
    }

    @Test
    void indexOf() {
        int index = itens.indexOf(30);

        assertEquals(1, index);

        index = itens.indexOf(100);

        assertEquals(-1, index);
    }

    @Test
    void max() {
        int max = itens.max();

        assertEquals(30, max);
    }

    @Test
    void intersect() {
        Array other = new Array(4);
        other.insert(40);
        other.insert(20);
        other.insert(30);
        other.insert(50);

        Array intersects = itens.intersect(other);

        assertEquals(2, intersects.size());
        assertEquals(30, intersects.get(0));
        assertEquals(20, intersects.get(1));
    }

    @Test
    void reverse() {
        itens.reverse();

        assertEquals(3, itens.size());
        assertEquals(20, itens.get(0));
        assertEquals(30, itens.get(1));
        assertEquals(10, itens.get(2));
    }

    @Test
    void insertAt() {
        itens.insertAt(50, 0);

        assertEquals(4, itens.size());
        assertEquals(50, itens.get(0));
        assertEquals(10, itens.get(1));

        itens.insertAt(100, 3);

        assertEquals(5, itens.size());
        assertEquals(100, itens.get(3));
        assertEquals(20, itens.get(4));

        assertThrows(IllegalArgumentException.class,
                () -> itens.insertAt(10, -1));

        assertThrows(IllegalArgumentException.class,
                () -> itens.insertAt(10, 6));

    }
}