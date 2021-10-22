package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PlainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        try {

            String htmlForm =
                    "<!doctype html>" +
                            "<html>" +
                            "<head>" +
                            "    <meta charset=\"UTF-8\">\n"+
                            "    <title>Document</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "<h1>PRIVET</h1>" +
                            "</body>\n" +
                            "</html>";
            writer.println(htmlForm);
        } finally {
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
