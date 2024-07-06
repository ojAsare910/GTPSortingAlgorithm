package com.justiceasare.service;

import com.justiceasare.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SortingServiceImpl implements SortingService {
    private final Map<String, SortingAlgorithm> algorithms = new HashMap<>();

    @Autowired
    public SortingServiceImpl(HeapSort heapSort, QuickSort quickSort, MergeSort mergeSort, RadixSort radixSort, BucketSort bucketSort) {
        algorithms.put("heap", heapSort);
        algorithms.put("quick", quickSort);
        algorithms.put("merge", mergeSort);
        algorithms.put("radix", radixSort);
        algorithms.put("bucket", bucketSort);
    }

    @Override
    public int[] sort(int[] array, String algorithm) {
        SortingAlgorithm sortingAlgorithm = algorithms.get(algorithm);
        if (sortingAlgorithm != null) {
            sortingAlgorithm.sort(array);
            return array;
        } else {
            throw new IllegalArgumentException("Invalid sorting algorithm");
        }
    }
}

