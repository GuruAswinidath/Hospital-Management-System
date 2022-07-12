package Hosptial;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Hosptial.PNode.Patientlist;

public class Hosptial1{

    static Patientlist plist = new Patientlist();
    static DoctorList dlist=new DoctorList();
    public static void main(String[] args){

       
        
        writeDFile();

        readDFile();
        Scanner sc=new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        String choice;

        while(true){
            MainMenu();
            choice=sc.nextLine();
            if(choice.equals("1")){
                System.out.println("\n Doctor ID");
                String id=sc.nextLine();

                System.out.println("\n Doctor Name");
                String name=sc2.nextLine();

                String Contact = validate_mobile();

                
                /*do{
                    //System.out.print("\n\t\t\t\tEnter mobile number : ");      // input mobile number
                    //Contact = sc.next();
                    if(!validate_mobile(Contact)){           // ask for mobile number again if the input is not correct
                        System.out.println("\n\t\t\t\tPlease enter a valid mobile number! ");
                        
                    }
                    //}while(validate_mobile(Contact)==false);  // repeat the loop until a valid mobile number is entered
                    
                /*if(Contact>n){
                    System.out.println("Invalid Contact Number");
                else 
                    System.out.println(Contact);    
                }*/

                System.out.println("\n Doctor specilization");
                String spec=sc2.nextLine();

                System.out.println("\n Doctor fees");
                int fees=sc.nextInt();
                sc.nextLine();

                Doctor d=new Doctor(id,name,Contact,spec,fees);
                dlist.Insert(d);
                System.out.println("Added Successfully");

            }

            else if(choice.equals("2")){
                System.out.println("\n Patient ID");
                String id=sc.nextLine();

                System.out.println("\n Paitent Nmae");
                String name=sc2.nextLine();

                String Contact = mobile_Number();

                /*System.out.println("\n Patient Contact");
                String contact=sc.nextLine();*/

                System.out.println("\n Patient Blood group");
                String B_Group=sc.nextLine();

                System.out.println("\n Patient Blood pressure");
                String B_P=sc.nextLine();

                Patient patient=new Patient(id,name,Contact,B_Group,B_P);
                plist.Insert(patient);
                System.out.println("Added the patient successfully");

            }

            else if(choice.equals("3")){      //prints the doctor's list
                dlist.PrintData();
            }

            else if(choice.equals("4")){       //prints the patient's list
                plist.PrintData();
            }
            else if(choice.equals("5")){      //It intputs the online medicine list
                Main1 Medical = new Main1(); 
                Main1.medical();
            }
            
             else if(choice.equals("6")){    //It connets to the blood donor
                Phone BinaryTree=new Phone();
                Phone.BinaryTree();
                }

            else if(choice.equals("7")){
                System.out.println("\n Welcome to check up menu \n");

                CheckupList[] cList=new CheckupList[dlist.size()];
                //System.out.println(clist.length);
                for(int i=0;i<cList.length;i++){
                    cList[i]=new CheckupList();
                    Doctor doctor=dlist.getAtIndex(1);
                    System.out.println("\n\n Enter the patient for Doctor");
                    System.out.println("Name   :"+doctor.getName());
                    System.out.println("Specialization  :"+doctor.getSpecialization());
                    System.out.println("Fees  "+doctor.getFees());

                    System.out.println("All patients:");
                    plist.PrintData();
                    
                    while(true){
                        System.out.println("Enter the patient Id or type null to stop");
                        String id=sc.nextLine();

                        if(id.equals("null")){
                            break;
                        }

                        System.out.println("Prority 3 for the emergency 2 for thr intermediates any other key for normal");
                        String per=sc.nextLine();

                        int p=1;

                        if(per.equals("3")){
                            p=3;
                        }
                        else if(per.equals("2")){
                            p=2;
                        }

                        Patient patient=plist.searchByID(id);
                        if(patient==null){
                            System.out.println("\n Invalid patient Id!\n");

                        }
                        else {
                            Checkup cup=new Checkup(doctor,patient,p,"",""+java.util.Calendar.getInstance().getTime().toString());
                            cList[i].Enqueue(cup);  

                        }
                    }   
                }

                for(int i=0;i<cList.length;i++){
                    System.out.println("\n\n patient "+(i+1)+"In the queue for the doctor"+dlist.getAtIndex(i).getName());
                    
                    for(int j=0;j<cList.length;j++){
                        System.out.println("Enter the recommendation: "+cList[i].getpatient(j));
                        String rec=sc.nextLine();
                        cList[i].addrecommendation(j,rec);
                    }

                }
            }

    

            else if(choice.equals("0")){
                break;
            }
            else{
             System.out.println("\n\n Invalid choice!\n");

             
            }
        }


    }



    private static String validate_mobile() { // checks whether the entered mobile number is correct

        Scanner sc = new Scanner(System.in);

        System.out.println("\n Doctor Contacts");
        String contact=sc.next();
    // check if length of input is 10 digits
    if(contact.length()!=10){
        System.out.println("Invalid");
        validate_mobile();
    }
    
    
        // check whether any character other than digits 0-9 is present in input
        for(int i=0; i<contact.length();i++)
        {
            if (contact.charAt(i)<48 || contact.charAt(i)>57){
            System.out.println("Invalid");
            validate_mobile();
            }
        }
    
     
    

    return contact;   
    }


    private static String mobile_Number() { // checks whether the entered mobile number is correct

        Scanner sc = new Scanner(System.in);

        System.out.println("\n Patient Contacts");
        String contact=sc.next();
    // check if length of input is 10 digits
    if(contact.length()!=10){
        System.out.println("Invalid");
        validate_mobile();
    }
    
    
        // check whether any character other than digits 0-9 is present in input
        for(int i=0; i<contact.length();i++)
        {
            if (contact.charAt(i)<48 || contact.charAt(i)>57){
            System.out.println("Invalid");
            mobile_Number();
            }
        }   
    return contact;   
}



    public static void MainMenu(){
        

        System.out.println("\n\n||  ******Hospatial Management System ******|| \n");
        System.out.println("    ||Main Menu||  ");
        System.out.println("\n Enter the 1 for insert New Doctor");
        System.out.println("\n Enter the 2 for insert patient");
        System.out.println("\n Enter the 3 for print all the Doctor");
        System.out.println("\n Enter the 4 for the print all the paitents");
        System.out.println("\n Enter the 5 for  purpose of medicine online");
        System.out.println("\n Enter the 6 for the Blood donor");
        System.out.println("\n Enter the 7 for checkup memu");
        System.out.println("\n Enter the 8 for exit");

    }

    private static void writeDFile(){
        System.out.println("Hello world");
        try{
            String data="";
            for(int i=0;i<dlist.size();i++){
                Doctor doc=dlist.getAtIndex(i);
                data+=doc.getId()+";"+doc.getName()+";"+doc.getContact()+";"+doc.getSpecialization()+";"+doc.getFees()+"\n";

        }
        FileWriter myWriter=new FileWriter("File1.txt");

        myWriter.write(data);
        myWriter.close();
        System.out.println("Successfully record added.");
    }catch(IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    }


    }

    private static void readDFile(){
        try{
            File myObj=new File("File1.txt");
            Scanner myReader=new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
                if(data.length()>5){
                    String [] cus=data.split(";");
                    plist.Insert(new Patient(cus[0],cus[1],cus[2],cus[3],cus[4]));

                }

            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();

        }
        
    }
        


    private static void printperRec(String did,String pid,String pdata){
        String []da=pdata.split("\n");
        System.out.println("\n Previous record\n");
        for(int i=0;i<da.length;i++){
            if(da[i].length()>1){
                if(did.equals(da[i].split(";")[0])  && pid.equals(da[i].split(";")[2])){
                    System.out.println("Recommendation"+da[i].split(";")[4]+"   Data"+da[i].split(";")[5]);

                }
            }
                
        }
        System.out.println("\n");
    }
    
}
