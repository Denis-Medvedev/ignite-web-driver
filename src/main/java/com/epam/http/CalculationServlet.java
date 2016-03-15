package com.epam.http;

import com.epam.ignite.main.IgniteDriver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalculationServlet extends HttpServlet {

    private IgniteDriver driver = new IgniteDriver();
    private Gson gson = new GsonBuilder().create();

    public void init() throws ServletException {
        super.init();
        driver.start("127.0.0.1","48501..48503");
    }

    public void destroy() {
        driver.close();
        super.destroy();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mode = request.getParameter("mode");
        try {
            Result result = new Result(0l,"Success");
            try {
                if (mode.equals("clear")) {
                    driver.clearCache();
                } else if (mode.equals("fill")) {
                    driver.fillCache();
                } else if (mode.equals("check")) {
                    driver.checkCache();
                } else if (mode.equals("calc")) {
                    result.setTotal( driver.calcFromCache() );
                }
            } catch (Exception exc) {
                result.setCode(-1l);
                result.setText(exc.getMessage());
            }
            out.write(gson.toJson(result));
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
