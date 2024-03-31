package org.example.lab3;

public class BubbleSort {
    public int[] bubbleSort(int[] arr){
        int n = arr.length;
        if(n < 2) return arr;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
