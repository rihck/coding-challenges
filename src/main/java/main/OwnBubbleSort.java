package main;

import java.util.ArrayList;
import java.util.List;

public class OwnBubbleSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{
            add(99);
            add(44);
            add(6);
            add(2);
            add(1);
        }};

        bubbleSort(list);
        System.out.println(list);
    }

    static void bubbleSort(List<Integer> unsortedList){
        int listSize = unsortedList.size() - 1;

        for (int i = 0; i < listSize; i++){
            for (int j = 0; j < listSize; j++){
                if (unsortedList.get(j) > unsortedList.get(j+1)){
                    Integer temp = unsortedList.get(j+1);
                    unsortedList.set(j + 1, unsortedList.get(j));
                    unsortedList.set(j, temp);
                }
            }
        }
    }

}
