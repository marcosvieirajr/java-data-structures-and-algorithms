package com.marcosvieirajr.dsa.datastructures.linear;

// Time Complexity: Ω(x), Θ(x), O(x)
// Space Complexity: O(x)

public class Array {
    private int count;
    private int[] itens;

    public Array(int length) {
        itens = new int[length];
    }

    // Time Complexity: Ω(1), Θ(n), O(n)
    // Space Complexity: O(n)
    public void insert(int item) {
        resizeIfRequired();
        itens[count++] = item;
    }

    // Time Complexity: Ω(1), Θ(1), O(1)
    // Space Complexity: O(1)
    public int get(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        return itens[index];
    }

    // Time Complexity: Ω(1), Θ(n), O(n)
    // Space Complexity: O(1)
    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        count--;
        for (int i = index; i < count; i++) {
            itens[i] = itens[i + 1];
        }
    }

    // Time Complexity: Ω(1), Θ(n), O(n)
    // Space Complexity: O(1)
    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (itens[i] == item) return i;

        return -1;
    }

    // Time Complexity: Ω(1), Θ(1), O(1)
    // Space Complexity: O(1)
    public int size() {
        return count;
    }

    // Time Complexity: Ω(1), Θ(1), O(1)
    // Space Complexity: O(1)
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(itens[i]);
        }
    }

    // Time Complexity: Ω(n), Θ(n), O(n)
    // Space Complexity: O(1)
    public int max() {
        int max = 0;
        for (int item : itens)
            if (item > max)
                max = item;

        return max;
    }

    // Time Complexity: Ω(n^2), Θ(n^2), O(n^2)
    // Space Complexity: O(n)
    public Array intersect(Array other) {
        Array intersects = new Array(count);
        for (int item : itens) {
            for (int i = 0; i < other.size(); i++) {
                if (item == other.get(i)) {
                    intersects.insert(item);
                    break;
                }
            }
        }
        return intersects;
    }

    // Time Complexity: Ω(n), Θ(n), O(n)
    // Space Complexity: O(n)
    public void reverse() {
        int[] reversed = new int[count];

        for (int i = 0; i < count; i++)
            reversed[i] = itens[count - i - 1];

        itens = reversed;
    }

    // Time Complexity: Ω(1), Θ(n), O(n)
    // Space Complexity: O(n)
    public void insertAt(int item, int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            itens[i + 1] = itens[i];

        itens[index] = item;
        count++;
    }

    // Time Complexity: Ω(n), Θ(n), O(n)
    // Space Complexity: O(n)
    private void resizeIfRequired() {
        if (itens.length == count) {
            int[] newItens = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItens[i] = itens[i];

            itens = newItens;
        }
    }
}
