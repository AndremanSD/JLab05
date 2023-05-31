package org;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.db.DbWorker;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] capacity = req.getParameterValues("capacity");
        String[] size = req.getParameterValues("size");
        DbWorker.demoQuery(capacity[0]);
        System.out.println(DbWorker.demoQuery(capacity[0]));
        if (!size[0].equals(2)) {
            DbWorker.dirtyReadDemo(capacity[0], size[0]);

        } else {
            req.getRequestDispatcher("notfound.jsp").forward(req, resp);
        }
    }
}
