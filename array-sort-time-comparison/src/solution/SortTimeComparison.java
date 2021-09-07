package solution;

import java.util.Arrays;

public class SortTimeComparison {
    public static void main(String[]Args){

        int[] randomArray = new int[10000];
        for(int i = 0; i<randomArray.length; i++){
            randomArray[i] = (int)(Math.random()*10000000);
        }

        int[] copyOfRandomArray = randomArray.clone();

        long startTime = System.nanoTime();
        int[]newArray = selectionSort(randomArray);
        long endTime = System.nanoTime();
        long computationTime1 = endTime-startTime;
        System.out.println("The selectionSort took " + computationTime1 + " nanoseconds, or "
                + computationTime1/1000000000.0 + " seconds.");


        long startTime1 = System.nanoTime();
        Arrays.sort(copyOfRandomArray);
        long endTime1 = System.nanoTime();
        long computationTime2 = endTime1-startTime1;
        System.out.println("The Arrays.sort method took " + computationTime2 + " nanoseconds, or "
                + computationTime2/1000000000.0 + " seconds.");

    }

    public static int[] selectionSort(int[] originalArray){

        for(int lastPlace = originalArray.length-1; lastPlace>0; lastPlace--){
            int maxNumLocation = 0;

            for(int i=1; i<=lastPlace; i++ ){
                if(originalArray[i]>originalArray[maxNumLocation]){
                    maxNumLocation = i;
                }
            }
            int tempMaxNum = originalArray[maxNumLocation];
            originalArray[maxNumLocation]=originalArray[lastPlace];
            originalArray[lastPlace]=tempMaxNum;
        }
        return originalArray;
    }
}
