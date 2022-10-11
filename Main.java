package ad211.smyk;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input line: ");
        String line = in.nextLine();

        System.out.println("* * * Task 1 * * *\nThe line ends by 'ed': " + task1(line));

        System.out.println("* * * Task 2 * * *\nSum of all numbers of line: " + task2(line));

        System.out.println("* * * Task 3 * * *\nThe length of the largest block in the line: " + task3(line));

        System.out.println("* * * Task 4 * * *\nAll words in the line: " );
        task4(line);

        System.out.print("Input first line for Task 5: ");
        String firstLine = in.nextLine();
        System.out.print("Input second line for Task 5: ");
        String secondLine = in.nextLine();
        System.out.println("* * * Task 5 * * *\nNew mixed line: " + task5(firstLine, secondLine));
    }
     static boolean task1(String line){
        return line.endsWith("ed");
    }

     static int task2(String line){
        int sum = 0;
        for(int i = 0; i < line.length();i++){
            if(Character.isDigit(line.charAt(i)))
                sum += Character.getNumericValue(line.charAt(i));
        }
        return sum;
    }
     static int task3(String line){
        if(line.length() == 0)
            return 0;
        int maxSizeBlock = 1;
        for(int i = 0, k = 1; i < line.length()-1;i++){
            if(line.charAt(i) == line.charAt(i+1)) {
                k++;
            }
            else{
                if(maxSizeBlock < k)
                    maxSizeBlock = k;
                    k=1;
            }
        }
        return maxSizeBlock;
    }
    static void task4(String line){
        String[] words = line.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
        for(int i=0; i<words.length;i++) {
            System.out.println(words[i]);
        }
    }
    static String task5(String firstLine, String secondLine){
        StringBuilder mixedLine = new StringBuilder();
        int index = firstLine.length() < secondLine.length() ? firstLine.length() : secondLine.length();
        for (int i = 0; i < index; i++) {
            mixedLine.append(firstLine.charAt(i)).append(secondLine.charAt(i));
        }
        if (firstLine.length() > secondLine.length())
            mixedLine.append(firstLine.substring(index));
        else
            mixedLine.append(secondLine.substring(index));
        return mixedLine.toString();
    }

}
