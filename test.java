package Hosptial;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        ArrayList<String> number = new ArrayList<String>();
        ArrayList<String> name = new ArrayList<String>();

        Scanner scan = new Scanner(System.in);
        number.add("9550789210");
        number.add("9027584702");
        number.add("9283498632");
        name.add("satvik");
        name.add("guru");
        name.add("jakarta");

        System.out.println("Enter number:: ");
        String newNumber = scan.nextLine();
        

        if (number.contains(newNumber)){
            System.out.println("This number is already in the database");
        }
        else{
            number.add(newNumber);
            System.out.println("Enter the name");
            String newName = scan.nextLine();
            name.add(newName);
        }
        System.out.println("Registered name: " + name.get(name.size()-1));
        scan.close();


    }
}
