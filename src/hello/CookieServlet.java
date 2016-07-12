package hello;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");

        Cookie pageVisitCookie;
        if(req.getCookies() != null) {
            pageVisitCookie = CookieServlet.findCookie(req);
            if(pageVisitCookie == null) {
                CookieServlet.setCookie(resp);
            } else {
                CookieServlet.printResult(pageVisitCookie, resp);
            }
        } else {
            CookieServlet.setCookie(resp);
        }
    }

    private static Cookie findCookie(HttpServletRequest req) {
        for(Cookie cookie : req.getCookies()) {
            if(cookie.getName().equals("page_visit")) {
                return cookie;
            }
        }

        return null;
    }

    private static void setCookie(HttpServletResponse resp) {
        Cookie newCookie = new Cookie("page_visit", "1");
        try {
            resp.getWriter().print("page_visit_1");
            newCookie.setValue("2");
            resp.addCookie(newCookie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(Cookie cookie, HttpServletResponse resp) {
        try {
            int newValue = Integer.parseInt(cookie.getValue());
            resp.getWriter().println(cookie.getName() + "_" + cookie.getValue());
            newValue++;
            cookie.setValue(String.valueOf(newValue));
            resp.addCookie(cookie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
