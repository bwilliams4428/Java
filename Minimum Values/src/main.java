import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please provide the number of values to input:");
        int arraySize = scanner.nextInt();
        int [] myValues = getIntegers(arraySize);
        //System.out.print("Values in DESC order: ");
        int [] descSortVals = sortIntegers(myValues);
        int minimumValue = findMin(descSortVals);
        printMinValue(minimumValue);
    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i=0; i<values.length; i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static int [] sortIntegers(int [] array){
        int temp;
        int [] tempArray = new int[array.length];

        /*for (int i = 0; i < array.length; i++)
        {
            tempArray[i] = array[i];

        }*/

        tempArray = Arrays.copyOf(array,array.length);

        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (tempArray[i] < tempArray[j])
                {
                    temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;
                }
            }
        }
        for (int i=0; i<array.length; i++){
            array[i] = tempArray[i];
        }
        return array;
    }

    public static int findMin(int [] array){

        int minValue = array[array.length -1];
        return minValue;
    }

    public static void printMinValue(int minValue){
        System.out.println("The minimum value in the array is " + minValue);

    }
}
