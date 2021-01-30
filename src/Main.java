import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
   void f(){
        System.out.println("Main class");
    };
   static int[] fun(){
        int[] ar = new int[3];
        //(int i =0; i < ar.length; i++){
            ar[0] = 1;
            ar[1] = 1;
            ar[2] = 1;
       // }
        return ar;
    }

    static int[] removeEl(int indx, int[] schoolBooks){
       //int i = 0;
       for(int i = 0; i < schoolBooks.length; i++) {
           if(schoolBooks[i] == 1) {
               System.arraycopy(schoolBooks, i + 1, schoolBooks, i,
                       schoolBooks.length - i - 1);
               schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length - 1);
               if (schoolBooks.length == 1){
                   System.arraycopy(schoolBooks, 1, schoolBooks, 0,
                           schoolBooks.length - 0 - 1);
                   schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length - 1);
               }
           }
       }
        return schoolBooks;
    }
    public static int findFile(String path) {
        File dir = new File("C:\\filesForJava");
       // boolean isFile = files.isFile();
        int count = 0;
        String fileName = new String();
        String[] list = dir.list();

        for (String fileOrDir : list) {
            if (new File(fileOrDir).isFile()) {
                count++;
                continue;
            }
            count += findFile(fileOrDir);
        }
        return count;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
           InputStream fis = new FileInputStream("C:\\file5.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader brr = new BufferedReader(isr);
            while(brr.ready()){
                int num =0;// Integer.parseInt(br.readLine());
                if ((num % 2 == 0)&&(num != 0)){
                    list.add(num);
                }
            }
            fis.close();
            brr.close();
            Collections.sort(list);
        }
        catch (IOException e){}
        for(Integer in:list)
            System.out.println(in);
    }
}

class r extends Main{
    @Override
    void f(){
        //System.out.println("r class");
        super.f();
    }
    void meth1(Object u){
        System.out.println("obj");
    };
    void meth1(List u){
        System.out.println("list");
    };
    void meth1 (ArrayList u){
        System.out.println("arra");
    };

    public static void main(String[] args) {
        r ex = new r();
        //ex.meth1(null);
        Pattern p3 = Pattern.compile("([abc]+)=\\1");
        Matcher m3 = p3.matcher("ac=ac");
        while (m3.find()) {
          //  System.out.print(m3.start()+" "+m3.group()+" ");
        }
    }
}

 class cSolution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        int counter = 0;
        for(int j = 0; j < 33; j++){
            for(int i = 0; i < 10; i++){
                String out = list.get(i).toLowerCase().replace("a", "");
                counter+=(list.get(i).length() - out.length());
                if  (list.get(i).toLowerCase().contains(alphabet.get(j).toString())){
                    counter++;
                }
            }
            System.out.println(alphabet.get(j) + " " + counter);
            counter = 0;
        }

    }
}

class Human {
    // Напишите тут ваши переменные и конструкторы
    int a;
    int b;
    int c;
    int v;
    int o;
    String aa;

    public Human() {
    }

    public Human(int a, int b, int c, int v, int o, String aa) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.v = v;
        this.o = o;
        this.aa = aa;
    }

    public Human(int a, int b, int c, int v, int o) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.v = v;
        this.o = o;
    }

    public Human(int a, int b, int c, int v) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.v = v;
    }

    public Human(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Human(int b, int a) {
        this.a = a;
        this.b = b;
    }

    public Human(int b) {
        this.b = b;
    }

    public Human(String aa) {
        this.aa = aa;
    }

    public Human(String aa, int b) {
        this.aa = aa;
        this.b = b;
    }

    public Human(String aa, int b, int c) {
        this.aa = aa;
        this.b = b;
        this.c = c;
    }
}