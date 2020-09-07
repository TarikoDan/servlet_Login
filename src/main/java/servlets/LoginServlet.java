package servlets;

import initions.InputLogin;
import initions.Login;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    List<Login> loginList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputType = req.getParameter("inputType");
        String loginName = req.getParameter("login");
        String password = req.getParameter("password");
        System.out.println(inputType + loginName);
        InputLogin inputLogin = new InputLogin(loginName, password);
        if (inputType.equals("reg")) {
            Login registration = new Login((this.loginList.size() + 1), inputLogin);
            this.loginList.add(registration);
            System.out.println("success");
            JSONObject jsonLogin = new JSONObject(registration);
            resp.getOutputStream().println(jsonLogin.toString());
            System.out.println("------------------------");
        }else if (inputType.equals("log")) {
            System.out.println(loginList);
            List<Login> collectByLogin = loginList.stream().filter(login -> login.getLogin().equals(loginName)).collect(Collectors.toList());
            resp.getOutputStream().println(collectByLogin.isEmpty()? "You are not logined":"Your login is present in the database");
            boolean isPresent = collectByLogin.stream().anyMatch(login -> login.getPassword().equals(password));
            resp.getOutputStream().println(isPresent ? "Correct Password" : "Password is incorrect !!!");
            if (isPresent) {
                System.out.println("correct!!!");
                resp.getOutputStream().println(inputLogin.toString());
//                req.getRequestDispatcher("congrat.jsp").forward(req, resp);
            }
        }
    }
}
