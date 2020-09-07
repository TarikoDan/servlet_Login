package initions;

import java.util.ArrayList;
import java.util.List;

public class Login {
    int id;
    String login;
    String password;

    public Login() {
    }

    public Login(int id, InputLogin inputLogin) {
        this.id = id;
        this.login = inputLogin.login;
        this.password = inputLogin.password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login1 = (Login) o;

        if (id != login1.id) return false;
        if (login != null ? !login.equals(login1.login) : login1.login != null) return false;
        return password != null ? password.equals(login1.password) : login1.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
