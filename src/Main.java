import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("=================================");
        System.out.println(""+
                "1.INSERT\n" +
                "2.DISPLAY\n"+
                "3.SEARCH\n" +
                "4.DELETE\n" +
                "5.UPDATE\n" +
                "0.EXIT\n"   +
                "Enter your choice: ");
    }

    public static void main(String[] args) {
        int temId;
        Scanner sc = new Scanner(System.in);
        Collection<Employee> c = new ArrayList<Employee>();
        int swOption = 0;

        do{
            menu();
            swOption = sc.nextInt();
            switch (swOption){
                case 1:
                    System.out.println("Enter the employee number (id): ");
                    int id = sc.nextInt();
                    sc.nextLine(); // this line of code is to clean the scanner
                    System.out.println("Enter the employee name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the employee salary: ");
                    int salary = sc.nextInt();
                    c.add(new Employee(id, name, salary));
                    break;
                case 2:
                    System.out.println("=================================");
                    c.forEach(employee -> {
                        System.out.println( employee.toString());
                    });
                    System.out.println("=================================");
                    break;
                case 3:
                    boolean foundEmployee = false;
                    System.out.println("Enter the id your looking for: ");
                    temId = sc.nextInt();
                    for (Employee employee : c) {
                        if (employee.getId() == temId) {
                            System.out.println(employee.toString());
                            foundEmployee = true;
                            break;
                        }
                    }
                    if(foundEmployee == false){
                        System.out.println("We did not find the employee.");
                    }
                    break;
                case 4:

                    System.out.println("Enter the id you'd like to eliminate: ");
                    temId = sc.nextInt();
                    for(Employee employee: c){
                        if (employee.getId() == temId){
                            c.remove(employee);
                            break;
                        }
                    }
                    System.out.println("Employee deleted ");
                    break;
                case 5:
                    System.out.println("Enter the id: ");
                    temId = sc.nextInt();
                    for (Employee employee: c){
                        if(employee.getId() == temId){
                            System.out.println("what do you want to update: ");
                            System.out.println("1.Id\n" +
                                    "2.Name\n" +
                                    "3.Salary\n" +
                                    "0.Exit");
                            System.out.println("Enter your choice: ");
                            int option = sc.nextInt();
                            sc.nextLine();
                            switch (option){
                                case 1:
                                    System.out.println("Enter the new id: ");
                                    id = sc.nextInt();
                                    employee.setId(id);
                                    System.out.println("ID updated. ");
                                    break;
                                case 2:
                                    System.out.println("Enter the new name: ");
                                    name = sc.nextLine();
                                    employee.setName(name);
                                    System.out.println("name updated. ");
                                    break;
                                case 3:
                                    System.out.println("Enter the new salary: ");
                                    salary = sc.nextInt();
                                    employee.setSalary(salary);
                                    System.out.println("salary updated. ");
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("This option does not exist, try ag1ain.");
                                    break;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }

        }while(swOption != 0);
    }
}