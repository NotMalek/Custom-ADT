import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        File file1 = new File("EHITS_test_file1.txt");
        File file2 = new File("EHITS_test_file2.txt");
        File file3 = new File("EHITS_test_file3.txt");
        File file4 = new File("customtest.txt");

        Scanner scan = new Scanner(System.in);

        ElasticERL list = new ElasticERL();

        System.out.println("Welcome to EHITS, please enter a threshold size: ");

        int nextInput = scan.nextInt();
        list.SetEINThreshold(nextInput);

        try{
            BufferedReader dataReader = new BufferedReader(new FileReader(file3));

            String str = "";

            while ((str = dataReader.readLine()) != null){
                int value = Integer.parseInt(str);
                list.add(value, "");
            }

        }

        catch (IOException e){
            e.printStackTrace();
        }



        while (true){

            System.out.print("""
          Please choose a valid option:
          1. SetEINThreshold
          2. Generate and add a random key
          3. Output all keys
          4. Add a key
          5. Remove a key
          6. Output a key's info
          7. Output next key
          8. Output previous key
          9. Output range between two keys
          """);


            int input = scan.nextInt();
            nextInput = 0;

            if (input == 1) {
                System.out.println("Please enter the size: ");
                nextInput = scan.nextInt();
                list.SetEINThreshold(nextInput);
                System.out.println("Size successfully updated.");
            }
            else if (input == 2) {

                System.out.println("Info to add: ");
                String info = scan.nextLine();
                info = scan.nextLine();
                list.generate(info);

            }
            else if (input == 3) {
                list.allKeys();
            }

            else if (input == 4) {
                System.out.println("Key of new element: ");
                int input1 = scan.nextInt();
                if (list.containsNode(input1)) {
                    System.out.println("This key already exists!");
                } else {
                    System.out.println("Info of new key: ");
                    String inputInfo = scan.nextLine();
                    inputInfo = scan.nextLine();
                    list.add(input1, inputInfo);
                    System.out.println("Key successfully added.");
                }
            }
            else if (input == 5) {
                System.out.println("Key of element: ");
                int input1 = scan.nextInt();
                if (!list.containsNode(input1)) {
                    System.out.println("This key does not exist.");

                } else {
                    list.remove(input1);
                    System.out.println("Key successfully removed.");

                }
            }
            else if (input == 6) {
                System.out.println("Key of element: ");
                int input1 = scan.nextInt();
                if (!list.containsNode(input1)) {
                    System.out.println("This key does not exist.");
                } else {
                    list.getValues(input1);

                }
            }
            else if (input == 7) {
                System.out.println("Key of element: ");
                int input1 = scan.nextInt();
                if (!list.containsNode(input1)) {
                    System.out.println("This key does not exist.");

                } else {
                    list.nextKey(input1);

                }
            }
            else if (input == 8) {
                System.out.println("Key of element: ");
                int input1 = scan.nextInt();
                if (!list.containsNode(input1)) {
                    System.out.println("This key does not exist.");

                } else {
                    list.prevKey(input1);

                }
            }
            else if (input == 9) {
                System.out.println("Key of element 1: ");
                int input1 = scan.nextInt();
                System.out.println("Key of element 2: ");
                int input3 = scan.nextInt();
                if (!list.containsNode(input1) || !list.containsNode(input3)) {
                    System.out.println("One or both keys do not exist.");

                } else {
                    System.out.print("Range: ");
                    list.rangeKey(input1, input3);

                }
            }


        }
    }
}

