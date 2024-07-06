package com.justiceasare.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class BucketSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        bucketSort(array);
    }

    void bucketSort(int[] array) {
        int max = getMax(array);
        int min = getMin(array);
        int bucketCount = max - min + 1;

        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];

        for (int i = 0; i < bucketCount; i++)
            buckets[i] = new ArrayList<>();

        for (int value : array)
            buckets[value - min].add(value);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket)
                array[index++] = value;
        }
    }

    int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }
}

