import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class userServlet extends HttpServlet {
    UsersList usersList = new UsersList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("here is no any User yet");
//        writer.println(users.toString());
        List<User> users = usersList.getUserList();
        resp.getOutputStream().println("1 " + users.toString());

        JSONArray jsa = new JSONArray(users);
        resp.setContentType("application/json");
        resp.getOutputStream().println("2 " + jsa.toString());
    }
}
