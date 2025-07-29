package Day15;

import java.util.ArrayList;

public class TheAList {
    static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) {
        num.add(2);
        num.add(18);
        num.add(5);
        num.add(8);
        num.add(3);
        System.out.println("Array ELements: "+num);
        bubbleSort(num,num.size());
        System.out.println("Using Recursive Bubble: "+num);
        noset();
        System.out.println("Using Inner outer for: "+num);

    }

    static void bubbleSort(ArrayList<Integer> arr,int n)
    {/*
      |----|
    [min][MAX][min][min][min] - select the first value and second value
    [min][min][min][min][MAX] - put the highest at the end (inner LOOP)
    [min][min][min][MAX][---] - exclude the last slot, find the new max (outer LOOP)
    [min][---][---][---][---] - if nothing else to compare, return the result (BASE)
    */
        // Base case
        if (n == 1)
            return;

        int count = 0;
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr.get(i) < arr.get(i+1))
            {
                // swap arr[i], arr[i+1]
                int temp = arr.get(i);
                arr.set(i, arr.get(i + 1));
                arr.set(i + 1, temp);
                count = count+1;
            }

        // Check if any recursion happens or not
        // If any recursion is not happen then return
        if (count == 0)
            return;

        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, n-1);
    }

    static void noset()
    {
        for(int i = 0; i > num.size()-1; i++)
        {
            for(int j = 0; j < num.size()-1-i; j++)
            {
                if(num.get(j)<num.get(j+1))
                {
                    int x = num.get(j);
                    int y = num.get(j+1);
                    num.remove(j+1);
                    num.remove(j);
                    num.add(j, y);
                    num.add(j+1, x);
                }
            }
        }
    }
}

/*
ArrayList - is a resizeable array

basic function
add()
remove()
clear()

get()
set()

*/