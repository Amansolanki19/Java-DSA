package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leet54 {

    public static void main(String...args) {
        int[][] arr=Leet59.spiralMatrix(3);
        List<Integer> list = spiralOrder(arr);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }


    public static List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>();

        if (arr == null || arr.length == 0) return list;

        int rowTop = 0;
        int rowBottom = arr.length - 1;
        int colLeft = 0;
        int colRight = arr[0].length - 1;

        while (rowTop <= rowBottom && colLeft <= colRight) {

            for (int i = colLeft; i <= colRight; i++) {
                list.add(arr[rowTop][i]);
            }
            rowTop++;

            for (int i = rowTop; i <= rowBottom; i++) {
                list.add(arr[i][colRight]);
            }
            colRight--;

            if (rowTop <= rowBottom) {
                for (int i = colRight; i >= colLeft; i--) {
                    list.add(arr[rowBottom][i]);
                }
                rowBottom--;
            }

            if (colLeft <= colRight) {
                for (int i = rowBottom; i >= rowTop; i--) {
                    list.add(arr[i][colLeft]);
                }
                colLeft++;
            }
        }

        return list;
    }
}
