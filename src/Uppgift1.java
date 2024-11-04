import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
enum userRole {
    ADMIN, USER, GUEST
}

public class Uppgift1 {
    public List<UserStream> getAdmins(List<User> users) {
        return users.stream()
               .filter(user -> user.getRole() == userRole.ADMIN)
               .map(user -> new UserStream(user.getId(), user.getName(), user.getEmail()))
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Uppgift1 u1 = new Uppgift1();
        ArrayList<User> users = new ArrayList<User>();
        new User(1, "Pavlos", "Pavlos@gmail.com", userRole.ADMIN);
        new User(2, "William", "William@gmail.com", userRole.ADMIN);
        new User(3, "John", "John@gmail.com", userRole.USER);
        new User(4, "Max", "Max@gmail.com", userRole.GUEST);

        List<UserStream> getAdminV = u1.getAdmins(users);

        getAdminV.forEach(System.out::println);
    }
}

class User {
    private int id;
    private String name;
    private String email;
    private userRole role;

    public User(int id, String name, String email, userRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {return name;}
    public int getId() {return id;}
    public String getEmail() {return email;}
    public userRole getRole() {return role;}

}

class UserStream {
    private int id;
    private String username;
    private String email;

    public UserStream(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'';
    }
}
