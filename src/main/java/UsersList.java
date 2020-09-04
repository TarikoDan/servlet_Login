import java.util.ArrayList;
import java.util.List;

public class UsersList {
    List<User> userList;

    public UsersList() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        if (userList.isEmpty()) {
            userList.add(new User(1, "One"));
            userList.add(new User(2, "Two"));
        }
        return userList;
    }

    public void setUserToList(User user) {
        this.userList.add(user);
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "userList=" + userList +
                '}';
    }
}
