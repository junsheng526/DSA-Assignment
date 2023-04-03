/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import adt.*;
import entity.*;
import java.util.Scanner;

/**
 *
 * @author Choo Jun Sheng
 */
public class CompanyRecruiting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SortedListInterface <Job> jobList = new SortedArrayList<>();
        
        int add = 8, remove = 0, edit = 0;
        
        
        jobList.add(new CompanyInfo(1001,"Computer Science", "Software Engineering", 1000, "Available", "TAR UC"));
        jobList.add(new CompanyInfo(1002,"Computer Science", "Data Analyst", 2000, "Available", "TAR UC"));
        jobList.add(new CompanyInfo(1003,"Restaurant", "Waiter", 5000, "Not Available", "Haidilao"));
        jobList.add(new CompanyInfo(1004,"Restaurant", "CEO", 25000, "Available", "Moo Noi"));
        jobList.add(new CompanyInfo(1005,"Restaurant", "Chicken Rice Hawker", 5000, "Available", "TAR UC"));
        jobList.add(new CompanyInfo(1006,"Health Care", "Nurse", 800, "Available", "Columbia Hospital"));
        jobList.add(new CompanyInfo(1007,"Services", "Cleaner", 95000, "Available", "Google"));
        jobList.add(new CompanyInfo(1008,"Human Resource", "Admin", 2000, "Not Available", "Metaverse"));
        
        
        int action;
        Scanner sc = new Scanner(System.in);
        
        
        do{
        //Display Whole Job List Every time in Menu
            heading();
            System.out.print(jobList.toString());
            System.out.print("|| Total Number of Job: " + jobList.totalNumberOfObject() + " ||\n"); 
            drawLine();
            
            System.out.println("1. Create New Job");
            System.out.println("2. Remove Existing Job");
            System.out.println("3. Edit Existing Job");
            System.out.println("4. Searching and Filtering Job");
            System.out.println("5. Job List Action Record");
            System.out.println("6. Exit Program");
            System.out.print("Enter your action (6 to Exit Program) --> ");
            
            //Validation for action
            while (!sc.hasNextInt()) {
                System.out.println("ID only valid in DIGIT!(1-6)");
                System.out.print("Invalid action. Please try again!\n");
                sc.next();
                System.out.print("Enter your action (6 to Exit Program) --> ");
            }
            action = sc.nextInt();

            switch(action){
                case 1:
                    Job testID;
                    int count = 0;
                    int jID = 0;
                    boolean checkID = false;
                    //validation for Job ID
                    do{
                        int jSalary = 0;
                        if(count>=1){
                            System.out.print("\nJob ID existed. Please enter again.");
                        }
                        System.out.print("\nEnter new Job ID   : ");
                        while (!sc.hasNextInt()) {
                            System.out.println("ID only valid in DIGIT!E.g. 1000-9999");
                            System.out.print("Invalid ID. Please try again!\n");
                            sc.next();
                            System.out.print("\nEnter new Job ID   : ");
                        }
                        
                        jID = sc.nextInt();
                        if(jID >= 1000 && jID <= 9999){
                            checkID = true;
                            //jobList.add(new CompanyInfo(1008,"Human Resource", "Admin", 2000, "Not Available", "Metaverse"));
                            testID = new CompanyInfo(jID, "", "", jSalary, " ", " ");
                            if(jobList.contain(testID)){
                                count = 1;
                            }
                        }
                        else{
                            System.out.print("Invalid input. Please try again. (1000-9999)\n");
                        }

                        testID = new CompanyInfo(jID, "", "", jSalary, " ", " ");
                        
                        

                    }while(jobList.contain(testID)||checkID!=true); //if list ady exist id or id invalid will loop back again

                    System.out.print("Enter Job Category : ");
                    String jCategory = sc.next();
                    System.out.print("Enter Job Name     : ");
                    String jName = sc.next();
                    
                    //Validation for Job Salary
                    boolean checkInt = false;
                    int jSalary = 0;
                    do{
                        System.out.print("Enter Job Salary   : ");
                        
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a number!");
                            System.out.print("Invalid input.\n");
                            sc.next();
                            System.out.print("Enter Job Salary   : ");
                        }
                        
                        jSalary = sc.nextInt();
                        
                            
                        if(jSalary >= 0){
                            checkInt = true;
                        }
                        else{
                            System.out.print("Invalid input. Please enter positive value!\n");
                        }

                        
                    }while(checkInt!=true);
                    
                    
                    System.out.print("Enter Job Status   : ");
                    String jStatus = sc.next();

                    System.out.print("Enter Company Name   : ");
                    String jCompany = sc.next();

                    //Job j = new Job(jID, jCategory, jName, jSalary, jStatus, jCompany);
                    jobList.add(new CompanyInfo(jID, jCategory, jName, jSalary, jStatus, jCompany));

                    //System.out.println("\nJob add Status : " + jobList.add(j));
                    //System.out.println("\nTotal Job in the list: " + jobList.totalNumberOfObject());
                    add++;
                    break;
                    
                case 2:
                    
                    boolean status;
                    boolean listStatus = jobList.isListEmpty();
                    int jRmvID;
                    
                    if(listStatus == true){
                        System.out.print("There is no any job left...\n\n");
                    }
                    else if(listStatus == false){
                        do{
                            System.out.print("\nEnter Job ID to remove(-1 to EXIT)   : ");
                            int jRmvSalary = 0;
                            jRmvID = sc.nextInt();
                            Job jobRemove = new Job (jRmvID, " ", " ", jRmvSalary, " ");
                            if(jRmvID==-1){
                                break;
                            }
                            else{
                                status = jobList.remove(jobRemove);
                                if (status == true){
                                    heading();
                                    System.out.print(jobList.toString());
                                    System.out.print("|| Total Number of Job: " + jobList.totalNumberOfObject() + " ||\n");
                                    drawLine();
                                    System.out.print("Job has been successfully remove!");
                                    remove++;
                                }
                                else if(status == false){
                                    System.out.print("Job ID not exist, Please try again!");
                                }
                            }
                        }while(status!=true || jRmvID != -1);
                    }
                    break;
                    
                case 3:
                    boolean status2;
                    boolean listStatus2 = jobList.isListEmpty();//check is the list empty or not, if empty then will skip the input
                    int jRpcID;
                    if(listStatus2 == true){
                        System.out.print("There is no any job left...");
                    }
                    else if(listStatus2 == false){
                        do{
                            int jRpcSalary = 0;
                            System.out.print("\nEnter Job ID to edit(-1 to EXIT)   : ");
                            jRpcID = sc.nextInt();
                            Job job = new Job (jRpcID, " ", " ", jRpcSalary, " ");
                            if(jRpcID==-1){
                                break;
                            }
                            else{
                                status2 = jobList.contain(job);
                                if (status2 == true){
                                    
                                    System.out.print("Enter new job category :");
                                    String newCategory = sc.next();
                                    System.out.print("Enter new job name     :");
                                    String newName = sc.next();
                                    
                                    boolean checkInt2 = false;
                                    int newSalary = 0;
                                    do{
                                        System.out.print("Enter new job salary   :");

                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a number!");
                                            System.out.print("Invalid input.\n");
                                            sc.next();
                                            System.out.print("Enter new job salary   :");
                                        }

                                        newSalary = sc.nextInt();


                                        if(newSalary >= 0){
                                            checkInt2 = true;
                                        }
                                        else{
                                            System.out.print("Invalid input. Please enter positive value!\n");
                                        }


                                    }while(checkInt2!=true);
                                    
                                    
                                    System.out.print("Enter new job status   :");
                                    String newStatus = sc.next();

                                    System.out.print("Enter new company   :");
                                    String newCompany = sc.next();
                                    
                                    Job newJob = new CompanyInfo(jRpcID, newName, newCategory, newSalary, newStatus, newCompany);
                                    jobList.replace(job, newJob);
                                    
                                    heading();
                                    System.out.print(jobList.toString());
                                    System.out.print("|| Total Number of Job: " + jobList.totalNumberOfObject() + " ||\n");
                                    drawLine();
                                    System.out.print("Job has been successfully edit!");
                                    edit++;
                                }
                                else if(status2 == false){
                                    System.out.print("Job ID not exist, Please try again!");
                                }
                            }
                        }while(status2!=true || jRpcID != -1);
                    }
                    break;
                    
                case 4:
                    int option;
                    
                    do{
                        System.out.println("==================================");
                        System.out.println("*Searching and Filtering Job List* ");
                        System.out.println("==================================");
                        System.out.println("| 1. Filtering by Category       |");
                        System.out.println("| 2. Searching by Name           |");
                        System.out.println("| 3. Searching by Status         |");
                        System.out.println("| 4. Back to main menu           |");
                        System.out.println("----------------------------------\n");
                        System.out.print("Enter your selection: ");  
                        option = sc.nextInt();
                        sc.nextLine();
                        
                        switch(option){
                            case 1:
                                System.out.print("\nEnter Job Category : ");
                                String jCategoryF = sc.nextLine();
                                //sc.next();
                                Job fCategory = new Job(0, jCategoryF, " ", 0, " ");//find category
                                boolean exist = false;
                                headingFilter();    
                                for(int i = 0; i < jobList.totalNumberOfObject(); i++){
                                    if(jobList.getObject(i).equals(fCategory)){
                                        System.out.println(jobList.getObject(i));
                                        exist = true;
                                     }
                                }
                                drawLine();
                                
                                if(exist == false){
                                    System.out.println("Job category not exist...\n");
                                }
                                System.out.print("Enter any value to proceed -> ");
                                sc.next();
                                break;
                                
                            case 2:
                                System.out.print("\nEnter Job Name : ");
                                String jNameF = sc.nextLine();
                                Job fName = new Job(0, " ", jNameF, 0, " ");//find name
                                boolean exist2 = false;
                                headingFilter();
                                for(int i = 0; i < jobList.totalNumberOfObject(); i++){
                                    if(jobList.getObject(i).equals(fName)){
                                        System.out.println(jobList.getObject(i));
                                        exist2 = true;
                                     }
                                }
                                drawLine();
                                
                                if(exist2 == false){
                                    System.out.println("Job name not exist...\n");
                                }
                                System.out.print("Enter any value to proceed -> ");
                                sc.next();
                                break;
                                
                            case 3:
                                System.out.print("\nEnter Job Status : ");
                                String jStatusF = sc.nextLine();
                                Job fStatus = new Job(0, " ", " ", 0, jStatusF);//find name
                                boolean exist3 = false;
                                headingFilter();
                                for(int i = 0; i < jobList.totalNumberOfObject(); i++){
                                    if(jobList.getObject(i).equals(fStatus)){
                                        System.out.println(jobList.getObject(i));
                                        exist3 = true;
                                     }
                                }
                                drawLine();
                                
                                if(exist3 == false){
                                    System.out.println("Invalid input...Please try again...\n");
                                }
                                System.out.print("Enter any value to proceed -> ");
                                sc.next();
                                break;
                                
                            case 4:
                                break;
                                
                            default:
                                System.out.println("Invalid input! Please try again.");
                                break;
                        }
                        
                        
                    }while(option!=4);
                    break;
                    
                case 5:
                    heading();
                    System.out.print(jobList.toString());
                    drawLine();
                    
                    System.out.println("|| Total Number of Job -> " + jobList.totalNumberOfObject());
                    System.out.println("|| Total Job Created   -> " + add);
                    System.out.println("|| Total Job Edited    -> " + edit);
                    System.out.println("|| Total Job Removed   -> " + remove);
                    drawLine();
                    System.out.print("Enter any value to proceed -> ");
                    sc.next();
                    
                    break;
                    
                case 6:
                    break;
                    
                default:
                    System.out.println("Invalid input! Please try again.");
                    break;
            }
        }while(action!=6);
    }
    
    public static void drawLine(){
        for(int i=0; i<=130; i++){
            System.out.print("=");
        }
        System.out.print("\n");
    }
    public static void headingTitle(){
        System.out.println("No  " + " Job ID  " + " Job Category        " + " Job Name                      " + " Job Salary      " + "Job Status    " + "  Date Added     " + "Company Name");
    }
    public static void headingSubTitle(){
        System.out.println(" Job ID  " + " Job Category        " + " Job Name                      " + " Job Salary      " + "Job Status    " + "  Date Added     " + "Company Name");
    }
    public static void heading(){
        drawLine();
        headingTitle();
        drawLine();
    }
    public static void headingFilter(){
        drawLine();
        headingSubTitle();
        drawLine();
    }
    
}



