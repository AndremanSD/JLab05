package org;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("main.jsp").forward(req, resp);
//        resp.setContentType("text/html");
//        PrintWriter w = resp.getWriter();
//        w.println("<html><head>");
//        w.println("<title>A Sample Servlet!</title>");
//        w.println("</head>");
//        w.println("<body>");
//        w.println("<h1>Hello, World!</h1>");
//        w.println("</body></html>");
//        w.close();
    }
}
