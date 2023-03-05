package java_task.hw1;

 /*Ну и для особо отличившихся. Написать метод который генерирует двумерный массив длиной N и высотой H
         Далее заполняет получившийся массив числами от 1 до W по спирали.
         Например массив [ ][ ][ ][ ]
         [ ][ ][ ][ ]
         [ ][ ][ ][ ]
         имеет N == 4 and H == 3 и вид
         [ 1 ][ 2 ][ 3 ][ 4 ]
         [10] [11] [12 ][ 5 ]
         [ 9 ][ 8 ][ 7 ][ 6 ]
*/

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        printArray(createSpiralArray(5, 3));
    }

    static int[][] createSpiralArray(int width, int height) {
        int[][] result = new int[height][width];
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = count;
                count++;
            }
        }
        return result;
    }


    static void printArray(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] < 10) {
                    System.out.print(' ');
                }
                System.out.print(input[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

    }
}


