package com.justiceasare.model;

import org.springframework.stereotype.Component;

@Component
public class RadixSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        radixSort(array);
    }

    void radixSort(int[] array) {
        int max = getMax(array);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(array, exp);
    }

    int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(array[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }
}
