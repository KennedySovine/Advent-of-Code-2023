import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day1 {
    public static void main(String[] args) {
        try {
            File myObj = new File("/Users/keennedy/Documents/GitHub/Advent-of-Code-2023/Day 1/input.txt");
            Scanner myReader = new Scanner(myObj);
            Pattern pattern = Pattern.compile("\\d+"); // Regular expression for one or more digits
            String originNumber;
            int finalNumber = 0; // Initialize finalNumber variable
            String num;

            while (myReader.hasNextLine()) {
                originNumber = "";
                num = "";
                String data = myReader.nextLine();
                Matcher matcher = pattern.matcher(data);
                int number = 0;
                while (matcher.find()) { // For each match (each number in the string)
                    originNumber += matcher.group();
                }
                if (originNumber.length() == 1){
                    num = originNumber + originNumber;
                }
                else if (originNumber.length() >=3){
                    num = originNumber.substring(0, 1);
                    num += originNumber.substring(originNumber.length() - 1);
                }
                else num = originNumber;
                number = Integer.parseInt(num); // Convert the match to an integer
                finalNumber += number;
                System.out.println(number);
            }
            myReader.close();
            System.out.println("Final Number: " + finalNumber);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}