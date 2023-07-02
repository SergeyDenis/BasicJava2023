import java.util.ArrayList;

import java.util.Collections;

public class SortingHomeWork5 {

    private static int methodCreateArraysNum;
    private static final String[] METHOD_CREATE_ARRAYS_LIST ={"Random With Double","   Random Unique","Sorted And Random 50/50" ,"Sorted 100","Sorting in reverse 100" };
    private static final String[] METHOD_SORTING_ARRAYS_LIST ={"BubbleSorting","SelectionSort","FastSort     "};
    private static long[][] resSortedArrays = new long[3][5];

    private static final int COUNT_ITERATION = 1; // Сколько раз прогонять сортировку над одним и тем же исходным массивом

    private static final int MAX_COUNT_ELEMENTS = 25;  // Сколько элементов в массиве.

    public static void main(String[] args)
    {
        ArrayList<Integer> list;
        ArrayList<Integer> list2;
        for (int i = 0; i < METHOD_CREATE_ARRAYS_LIST.length; i++) {
            list = createArray(METHOD_CREATE_ARRAYS_LIST[i],MAX_COUNT_ELEMENTS);
            methodCreateArraysNum=i;
            System.out.println("Result Create Array method:' " + METHOD_CREATE_ARRAYS_LIST[methodCreateArraysNum]+"'");
            printArray(list);
            list2 = bubbleSorting(list,COUNT_ITERATION);
            System.out.println("Результат Метод сортировки "+ METHOD_SORTING_ARRAYS_LIST[0]+" Прошло среднее время, мс: " + resSortedArrays[0][methodCreateArraysNum]);
            printArray(list2);
            list2 = selectionSort(list,COUNT_ITERATION);
            System.out.println("Результат Метод сортировки "+ METHOD_SORTING_ARRAYS_LIST[1]+" Прошло среднее время, мс: " + resSortedArrays[1][methodCreateArraysNum]);
            printArray(list2);
            list2 = fastSort(list,COUNT_ITERATION);
            System.out.println("Результат Метод сортировки "+ METHOD_SORTING_ARRAYS_LIST[2]+" Прошло среднее время, мс: " + resSortedArrays[2][methodCreateArraysNum]);
            printArray(list2);
        }
        printResult();

    }
    public static ArrayList<Integer> createArray (String typeOfArrayFilling ,int maxnumelem) {
        ArrayList<Integer> generateList = new ArrayList<>();
        boolean isuniqarray = false;
        boolean ismaxtomin = false;
        int minValue = 1;
        int maxValue = maxnumelem;
        int numsorted = 0;
        // Random With Double
        if (typeOfArrayFilling.equals(METHOD_CREATE_ARRAYS_LIST[0])) {
           numsorted = 0;
           isuniqarray=false;
           ismaxtomin=false;
         }
        // Random Unique
        if (typeOfArrayFilling.equals(METHOD_CREATE_ARRAYS_LIST[1])) {
            numsorted = maxnumelem;
            isuniqarray=true;
            ismaxtomin=false;
        }
        // Sorted And Random 50/50
        if (typeOfArrayFilling.equals(METHOD_CREATE_ARRAYS_LIST[2])) {
            numsorted = maxnumelem/2;
            isuniqarray=false;
            ismaxtomin=false;
        }
        // Sorted 100
        if (typeOfArrayFilling.equals(METHOD_CREATE_ARRAYS_LIST[3])) {
            numsorted = maxnumelem;
            isuniqarray=false;
            ismaxtomin=false;
        }
        // Sorting in reverse 100
        if (typeOfArrayFilling.equals(METHOD_CREATE_ARRAYS_LIST[4])) {
            numsorted = maxnumelem;
            isuniqarray=false;
            ismaxtomin=true;
        }
        maxnumelem=maxnumelem-numsorted;

        if (!ismaxtomin) {
            for (int i = 0; i < numsorted; i++) {
                generateList.add(i + 1);
            }
        }
        else {
            for (int i = numsorted; i > 0; i--) {
                generateList.add(i);
            }
        }

        for (int i = 0; i <maxnumelem; i++) {
            int x = (int) ((Math.random() * ((maxValue - minValue) + 1)) + minValue);
            generateList.add(x);
        }

        if (isuniqarray) {
            Collections.shuffle(generateList);
            }

        return  generateList;
    }
    public static ArrayList<Integer> bubbleSorting (ArrayList<Integer> arrays,int countIter) {
        int tempres;
        ArrayList<Integer> temparrays = new ArrayList<>();
        boolean truesorting;
        long start;
        long finish;
        long elapsed;
        long sumElapsed = 0;
        for (int j = 0; j < countIter; j++) {
        temparrays.clear();
        temparrays.addAll(arrays);
        //start = System.nanoTime();
        start = System.currentTimeMillis();
        do {
            truesorting = false;
            for (int i = temparrays.size() - 1; i > 0; i--) {
                if (temparrays.get(i-1) > temparrays.get(i)) {
                    tempres = temparrays.get(i-1);
                    temparrays.set(i-1, temparrays.get(i));
                    temparrays.set(i,tempres);
                    truesorting = true;
                }

            }

        }
        while (truesorting);
        //finish = System.nanoTime();
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        sumElapsed = sumElapsed+elapsed;
        }

        sumElapsed=sumElapsed/countIter;
        resSortedArrays[0][methodCreateArraysNum]=sumElapsed;
        return temparrays;
    }

    public static ArrayList<Integer> selectionSort (ArrayList<Integer> arrays,int countIter)
    {
        ArrayList<Integer> temparrays = new ArrayList<>();
        int minelemnts;
        int minnumelem;
        int tempres;
        long start;
        long finish;
        long elapsed;
        long sumElapsed = 0;

        for (int k = 0; k < countIter; k++) {
            //start = System.nanoTime();
            temparrays.clear();
            temparrays.addAll(arrays);
            start = System.currentTimeMillis();
            for (int i = 0; i < temparrays.size(); i++) {
                minelemnts = temparrays.get(i);
                minnumelem = i;
                for (int j = i + 1; j < temparrays.size(); j++) {
                    if (temparrays.get(j) < minelemnts) {
                        minelemnts = temparrays.get(j);
                        minnumelem = j;
                    }
                }
                tempres = temparrays.get(i);
                temparrays.set(i, minelemnts);
                temparrays.set(minnumelem, tempres);
            }
            //finish = System.nanoTime();
            finish = System.currentTimeMillis();
            elapsed = finish - start;
            sumElapsed=sumElapsed+elapsed;
        }
        sumElapsed=sumElapsed/countIter;
        resSortedArrays[1][methodCreateArraysNum]=sumElapsed;
        //System.out.println("Прошло среднее время, нс: " + sumElapsed);
        return temparrays;
    }
    public static ArrayList<Integer> fastSort (ArrayList<Integer> arrays, int countIter) {
        ArrayList<Integer> temparrays = new ArrayList<>();
        long start;
        long finish;
        long elapsed;
        long sumElapsed = 0;
        for (int j = 0; j < countIter; j++) {
            //start = System.nanoTime();
            temparrays.clear();
            temparrays.addAll(arrays);
            start = System.currentTimeMillis();
            Collections.sort(temparrays);
            //finish = System.nanoTime();
            finish = System.currentTimeMillis();
            elapsed = finish - start;
            sumElapsed=sumElapsed+elapsed;
        }
        sumElapsed=sumElapsed/countIter;
        resSortedArrays[2][methodCreateArraysNum]=sumElapsed;
        return temparrays;
    }
    public static void printArray(ArrayList<Integer> arrays)
    {
        if (arrays.size()>30) {
            System.out.print("[");
            for (int i = 0; i < 31; i++) {
                System.out.print(arrays.get(i) + ",");
            }
            System.out.println("...]");
        }
        else {
            System.out.println("arrays = " + arrays.toString());
        }
    }
    public static void printResult()
    {
        System.out.println("==================================================================================================================================================");
        System.out.printf("%22s","COUNT="+MAX_COUNT_ELEMENTS+" Iter="+COUNT_ITERATION+" |");
        for (int i = 0; i < METHOD_CREATE_ARRAYS_LIST.length; i++) {
            System.out.printf("%25s", METHOD_CREATE_ARRAYS_LIST[i]+" |");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < METHOD_SORTING_ARRAYS_LIST.length; i++) {
            System.out.print(METHOD_SORTING_ARRAYS_LIST[i]+"        |");
            for (int j = 0; j < METHOD_CREATE_ARRAYS_LIST.length ; j++) {
                System.out.printf("%25s",resSortedArrays[i][j]+" ms |");
            }
            System.out.println();
        }
        System.out.println("==================================================================================================================================================");
    }
}