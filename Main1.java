package Hosptial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {
    public static void medical()
    {
        M_Order ph= new M_Order();                       // create object of M_oder class
        Scanner sc= new Scanner(System.in);
        int choice=0;

        // add all the available M_order to menu
        ph.accept_menu("Paracetmol","Tabelt",35);
        ph.accept_menu("Hydrocodone","Liquid",30);
        ph.accept_menu("Nexium","liquid",315);
        ph.accept_menu("Enbrel","Liquid",185);
        ph.accept_menu("Azithral","Tabelt" ,119);
        ph.accept_menu("Alex ","Liquid", 123);
        ph.accept_menu("Thrombolytics","Tabelt",115);
        ph.accept_menu("Folitrax","Tablet",426);
        ph.accept_menu("Lubrex","Eyedrops",120);
        ph.accept_menu("Naxpro","Tablet",156);

        // add registered customers
        ph.accept_customer("Ananya", "B3- Silver Township, Aundh",2, "8983282880");
        ph.accept_customer("Esha", "401, KB Society, Baner",3, "7517362175");
        ph.accept_customer("Prerana", "22, Greenland County, Deccan Gymkhana",5, "8345267906");
        
        int main_choice_mismatch=0;
        do
        {
           
            // Display options to customer
            main_choice_mismatch=0;
            try
            {
                System.out.print("\n\t\t\t\t\tWhat would you like to do? \n\t\t\t\t\t1. Medicine order \n\t\t\t\t\t2. View the list \n\t\t\t\t\t3. Exit\n\t\t\t\t");
                choice= sc.nextInt();
            }
            catch(InputMismatchException e)  // catch invalid input
            {
                sc.next();
                System.out.print("\n\t\t\t\tIncorrect choice! Please enter again!");
                main_choice_mismatch=1;
            }

            switch(choice)
            {
                case 1: ph.clearScreen();
                        ph.take_order();
                        break;
                case 2: ph.clearScreen();
                        ph.display_menu();
                        System.out.print("\n\n\t\t\t\t\t(Enter 0 to return to main menu) ");
                        sc.nextInt();
                        break;
                case 3: break;
                default: System.out.println("\n\t\t\t\t\tInvalid choice! Please enter again.");
            }
        }while(main_choice_mismatch==1 || choice!=3);

    }
}
    
