import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    private List<User> users;

    public Main() {
        users = new ArrayList<>();
        users.add(new User(1, "Pavlos", "Pavlos@gmail.com", userRole.ADMIN));
        users.add(new User(2, "William", "William@gmail.com", userRole.ADMIN));
        users.add(new User(3, "John", "John@gmail.com", userRole.USER));
    }



    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Uppgift 1 - Show Admins");
            System.out.println("2. Uppgift 2 - ArrayList Implementation");
            System.out.println("3. Uppgift 3 - Calculator");
            System.out.println("4. Uppgift 4 - Autocalling System..?");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAdminUsers();
                    break;
                case 2:
                    ArrayListExample.testArrayList();
                    break;
                case 3:
                    CalculatorExample.CalcTest();
                    break;
                case 4:
                    AutoCalling.invokeMethod();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);

        scanner.close();
    }

    private void showAdminUsers() {
        Uppgift1 u1 = new Uppgift1();
        List<UserStream> adminUsers = u1.getAdmins(users);
        adminUsers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.displayMenu();
    }
}
