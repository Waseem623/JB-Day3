package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Main mainObj = new Main();
        mainObj.printArrayElement(arr);
        mainObj.findElementFrequency();
        System.out.println("Largest Element from array is : " + mainObj.findLargestElement(arr));
        System.out.println("Largest Element from array is : " + mainObj.findSmallestElement(arr));
        mainObj.printEvenIndexElements(arr);
        mainObj.printReverseArray(arr);
        mainObj.printOddIndexElements(arr);
        mainObj.printDuplicateElements();
        mainObj.sortArrayAsc();
        System.out.println(mainObj.findSecondLargestElement());

    }

    private int findSecondLargestElement() {
        int[] arr = {1, 2, 3, 4, -1, 3, 4, 6, 4, 6, 3, 35, 5, -1, 35, 322, 3, 5, 6, 6};
        //Approch 1
        int firstLargest = findLargestElement(arr);
        int secondLargest = arr[0];
        for (int i : arr) {
            if (i > secondLargest && i < firstLargest)
                secondLargest = i;
        }
        return secondLargest;
        //Approch 2
        /* arr=Arrays.stream(arr).distinct().sorted().toArray();
           return arr[arr.length-2];*/
    }

    private void sortArrayAsc() {
        int[] arr = {1, 2, 3, 4, -1, 3, 4, 6, 4, 6, 3, 35, 5, -1, 35, 322, 3, 5, 6, 6};

        //Approch 1
        /* Arrays.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i +" "));*/

        //Approch 2
        int i = 0;
        int temp;
        while (i < arr.length) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[j] > arr[k]) {
                        temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
            i++;
        }
        printArrayElement(arr);
    }

    private void printDuplicateElements() {
        int[] arr = {1, 2, 3, 4, -1, 3, 4, 6, 4, 6, 3, 35, 5, -1, 35, 322, 3, 5, 6, 6};
        boolean isRepeated;
        for (int i = 0; i < arr.length; i++) {
            isRepeated = false;
            if (checkIsVisited(arr, i, arr[i]))
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isRepeated = true;
                    break;
                }
            }
            if (isRepeated)
                System.out.print(arr[i] + "  ");
        }
    }

    private void printOddIndexElements(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0)
                System.out.print(arr[i] + " ");
        }
    }

    private void printReverseArray(int[] arr) {
        System.out.println();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    private void printEvenIndexElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                System.out.print(arr[i] + " ");
        }
    }

    private int findSmallestElement(int[] arr) {
        int smallest = arr[0];
        for (int i : arr) {
            if (i < smallest)
                smallest = i;
        }
        return smallest;
    }

    private int findLargestElement(int[] arr) {
        int largest = arr[0];
        for (int i : arr) {
            if (i > largest)
                largest = i;
        }
        return largest;
    }

    private void printArrayElement(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println("\n");
    }

    private void findElementFrequency() {
        int[] arr = {1, 2, 3, 4, -1, 3, 4, 6, 4, 6, 3, 35, 5, -1, 35, 322, 3, 5, 6, 6};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = 1;
            if (checkIsVisited(arr, i, arr[i]))
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            System.out.println(arr[i] + " -> " + count);
        }
    }

    private boolean checkIsVisited(int[] arr, int uptoIndex, int n) {
        boolean isVisited = false;
        for (int i = 0; i < uptoIndex; i++) {
            if (arr[i] == n) {
                isVisited = true;
                break;
            }
        }
        return isVisited;
    }
}