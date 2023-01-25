package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = input.nextInt();
        System.out.println();

        Employee employee = new Employee();
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ": ");

            System.out.print("id: ");
            int id = input.nextInt();
            while (hasId(list, id)) {
                System.out.println("Id already taken. Try Again: ");
                id = input.nextInt();
            }

            input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Salary: ");
            double salary = input.nextDouble();

            list.add(new Employee(id, name, salary));

            System.out.println();
        }


        System.out.print("Enter the employee id that will have salary increase: ");
        int id = input.nextInt();
        Integer pos = position(list, id);
        if (pos == null){
            System.out.println("This ID doesn't exist!");
        }else{
            System.out.print("Enter the percentage: ");
            double percent = input.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees: ");
        for(Employee obj : list){
            System.out.println(obj);
        }



    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

}
