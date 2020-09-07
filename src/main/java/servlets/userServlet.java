package servlets;

import initions.User;
import initions.UsersList;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class userServlet extends HttpServlet {
    UsersList usersList = new UsersList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("here is no any initions.User yet");
//        writer.println(users.toString());
        List<User> users = usersList.getUserList();
        resp.getOutputStream().println("1 " + users.toString());

        JSONArray jsUsers = new JSONArray(users);
        resp.setContentType("application/json");
        resp.getOutputStream().println(jsUsers.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        User user = new User(id, name);
        usersList.setUserToList(user);
        JSONObject jsonUser = new JSONObject(user);
        resp.setContentType("application/json");
        resp.getOutputStream().println(jsonUser.toString());
    }
}
