import java.io.*;
import java.util.*;

import javax.sound.midi.Soundbank;

public class TaskListApp{

    private static ArrayList<String> TaskList = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Task List Application !!");
        System.out.println();
        while(true){
            
            menu();
            try{
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    viewTasks();
                    break;     
                case 4:
                    editTask();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
                    break;  
            }
            }catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static void menu(){
            System.out.println("--- USER MENU ---");
            System.out.println("1. ADD Task");
            System.out.println("2. REMOVE/Complete Task");
            System.out.println("3. VIEW Task");
            System.out.println("4. EDIT Task");
            System.out.println("5. EXIT");
            System.out.println();
            System.out.print("Enter Your Choice: ");
    }

    private static boolean addTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task Name to Add: ");
        TaskList.add(sc.nextLine());
        System.out.println("Task Added Successfully !!");
        System.out.println();
        System.out.println("Do you want to continue (Y/N):");
        char ch= sc.next().charAt(0);
        if(ch=='Y' || ch=='y'){
            return true;
        }
        else{
            exit();
            return false;
        }
    }

    private static boolean completeTask() {
        Scanner sc = new Scanner(System.in);
        int taskNum;
        viewTasks();
        if(TaskList.isEmpty()){
            return true;
        }else{
        System.out.print("Enter Task Number To Complete/Remove: ");
        try {
            taskNum = sc.nextInt();
            if (taskNum <= 0 || taskNum > TaskList.size()) {
                throw new IndexOutOfBoundsException();
            }
            TaskList.remove(taskNum - 1);
            System.out.println("Task Completed/ Removed Successfully");
            System.out.println();
            System.out.println("Do you want to continue (Y/N):");
            char ch= sc.next().charAt(0);
            if(ch=='Y' || ch=='y'){
                return true;
            }
            else{
                exit();
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
            return true;
        }
    }
    }

    private static boolean editTask() {
        Scanner in = new Scanner(System.in);
        int taskNum;
        String newTask;

        viewTasks();
        if(TaskList.isEmpty()){
            return true;
        }else{
            System.out.print("Enter task number to edit: ");
            try {
                taskNum = in.nextInt();
                if (taskNum <= 0 || taskNum > TaskList.size()) {
                    throw new IndexOutOfBoundsException();
                }
                System.out.print("Enter new task description: ");
                newTask = in.next();
                TaskList.set(taskNum-1, newTask);
                System.out.println("Task Edited Successfully !!");
                System.out.println();
                System.out.println("Do you want to continue (Y/N):");
                char ch= in.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    return true;
                }
                else{
                    exit();
                    return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                in.nextLine();
                return true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid task number. Please try again.");
                return true;
            }
        }
    }

    private static void viewTasks() {
        Scanner sc = new Scanner(System.in);
        if (TaskList.isEmpty()) {
            System.out.println("No Tasks To Display");
            System.out.println();
            System.out.println("Do you want to continue (Y/N):");
            char ch= sc.next().charAt(0);
            
        } else {
            System.out.println("---Available Tasks---");
            for (int i = 0; i < TaskList.size(); i++) {
                System.out.println((i + 1) + ". " + TaskList.get(i));
            }
            System.out.println();
        }
    }

    private static void exit() {
        System.out.println();
        System.out.println("Thank You for Using Task List Application");
        System.exit(0);
    }
}