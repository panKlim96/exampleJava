
import java.util.*;

//private static final long serialVersionUID = 2L;
//public static List<String> words = new ArrayList<String>();
//public static TestString testString = new TestString();
//    String fileName1 = "C:\\exampleJava\\src\\file1.txt";
//    String fileName2 = "C:\\exampleJava\\src\\file2.txt";

public class Solution {
    private  static List<Integer> figuresOfN = new ArrayList<>();   // лист содержащий текущую комбинацию цифр.
    private  static TreeSet<Long> resultTree = new TreeSet<>();
    private  static List<Long> sums = new ArrayList<>();    // лист для различных вариантов степенных сумм данной комбинации чисел.
    private static long[][] numPows = new long[10][20];
    private static final long base = 10;

    private static void generateMultiSets(long N)
    {
       Collections.sort(figuresOfN);
       // тело while(без последнего for) - алгоритм перебора различных комбинаций цифр числа.
       while (true){
           if (figuresOfN.get(0) == 0){
               for (int j = 1; j < figuresOfN.size(); j++){
                   if ((figuresOfN.get(j) == 0)&&(j == figuresOfN.size() - 1)){
                       figuresOfN.clear();
                       if (!sums.isEmpty()){
                           sums.clear();
                       }
                       return;
                   }
                   else if (figuresOfN.get(j) == 0){
                       continue;
                   }
                   else{
                       figuresOfN.set(j, figuresOfN.get(j) - 1);
                       for (int k = 0; k < j; k++){
                           int f = figuresOfN.get(j);
                           figuresOfN.set(k, figuresOfN.get(j));
                       }
                       break;
                   }
               }
           }

           for(int j = figuresOfN.get(0); j >= 0; j--) {
               figuresOfN.set(0, j);
               calcPossibleSums(N);
           }
       }
    }

    public static long[] getNumbers(long N) {
        if (N <= 0)
            return null;

        long[] result = null;
        if (N < base) {
            result = new long[(int) (N) - 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = i + 1;
            }
            return result;
        }
        fillFigrsOfNum(N, figuresOfN);
        generateMultiSets(N);

        result = new long[resultTree.size()];
        System.out.println("resultArraySize: " + resultTree.size());
        int i = 0;
        for(Long l:resultTree){
            result[i] = l;
            i++;
        }

        resultTree.clear();
        return result;
    }

    private static void fillFigrsOfNum(Long input, List<Integer> list){
        long f = 0;
        // заполняеем все позиции 9-ками.
        while(input > 0){
            list.add(9);
            input = input / 10;
        }
    }

    private static void calcPossibleSums(long N){
        int nullsCounter = 0;
        long sum = 0;
        // вычисляем суммы цифр.
        for(int i = 0; i < figuresOfN.size(); i++){
            if (figuresOfN.get(i) == 0){
                nullsCounter++;
            }
            sum += numPows[figuresOfN.get(i)][figuresOfN.size()];
        }
        sums.add(sum);
        sum = 0;

        if (nullsCounter != 0){
            for(int m = 1; m < nullsCounter + 1; m++){
                for(int i = m; i < figuresOfN.size(); i++){
                    sum += numPows[figuresOfN.get(i)][figuresOfN.size() - m];
                }
                sums.add(sum);
                sum = 0;
            }
        }
        // добавляем валидное число из sums.
        addValidNum(figuresOfN, nullsCounter, N);
        sums.clear();
    }

    private static void addValidNum(List<Integer> list, int nullsCounter, long N){
        long numFromSums = 0;
        int curFigure = 0;
        int counter = 0;
        long newSum = 0;
        for(int i = 0; i < sums.size(); i++){
            numFromSums = sums.get(i);
            if (numFromSums == 0)
                continue;
            while(numFromSums > 0){
                curFigure = (int) (numFromSums % 10);
                newSum += numPows[curFigure][list.size() - i];
                numFromSums = numFromSums / 10;
                counter++;
            }
            if (counter != (list.size() - i)){
               counter = 0;
                newSum = 0;
               continue;
            }
            if (newSum == sums.get(i)){
                if (sums.get(i) < N)
                    resultTree.add(sums.get(i));
                return;
            }
            newSum = 0;
            counter = 0;
        }
    }

     private static void genPows(){
        for(int i = 0; i < numPows.length; i++){
            long p = 1;
            int dff =  numPows[i].length;
            for( int j = 0; j < numPows[i].length; j++){
                numPows[i][j] = p;
                p*=i;
            }
        }
     }

    public static void main(String[] args) {
        genPows();
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

//        a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(1000000)));
//        b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);
    }
}
