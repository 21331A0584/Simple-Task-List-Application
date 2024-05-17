import java.io.*;
import java.util.*;

import javax.sound.midi.Soundbank;

public class TaskListApp{

    private static ArrayList<String> TaskList = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Task List Application !!");
        while(true){
            System.out.println("1. Add Task");
            System.out.println("2. Remove/Complete Task");
            System.out.println("3. View Task");
            System.out.println("4. Edit Task");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice: ");

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
                    break;  
            }
            }catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }


    private static void addTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task Name: ");
        TaskList.add(sc.nextLine());
    }

    private static void completeTask() {
        Scanner sc = new Scanner(System.in);
        int taskNum;
        viewTasks();

        System.out.print("Enter Task Number To Complete/Remove: ");
        try {
            taskNum = sc.nextInt();
            if (taskNum <= 0 || taskNum > TaskList.size()) {
                throw new IndexOutOfBoundsException();
            }
            TaskList.remove(taskNum - 1);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void editTask() {
        Scanner sc = new Scanner(System.in);
        int taskNum;
        String newTask;

        viewTasks();
        System.out.print("Enter Task Number To Edit: ");
        try {
            taskNum = sc.nextInt();
            if (taskNum <= 0 || taskNum > TaskList.size()) {
                throw new IndexOutOfBoundsException();
            }
            System.out.print("Enter New Task: ");
            newTask = sc.nextLine();
            TaskList.set(taskNum-1, newTask);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void viewTasks() {
        if (TaskList.isEmpty()) {
            System.out.println("No Tasks To Display");
        } else {
            for (int i = 0; i < TaskList.size(); i++) {
                System.out.println((i + 1) + ". " + TaskList.get(i));
            }
        }
    }

    private static void exit() {
        System.out.println("Thank You for Using Task List Application");
        System.exit(0);
    }
}