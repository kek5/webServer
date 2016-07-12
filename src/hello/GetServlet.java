package hello;

import Person.Person;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        if (req.getQueryString() != null && req.getQueryString().trim() != "") { //if any params
            Person person = new Person(req);

            req.setAttribute("person", person);
            req.getRequestDispatcher("/Context/jsp/getJSP.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("Looking for something?"); // GET app
        }
    }
}
