package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yanwar
 */
@WebServlet(name = "ControllerResult", urlPatterns = {"/ControllerResult"})
public class ControllerResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerResult</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerResult at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String a1 = request.getParameter("angka1");
        String a2 = request.getParameter("angka2");
        int angka1 = Integer.parseInt(a1);
        int angka2 = Integer.parseInt(a2);
        int ra1 = angka1 + 1;
        int ra2 = angka2 - 1;
        int x = (ra2 - ra1) + 1;
        
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<Integer> angkaGanjil = new ArrayList<Integer>();
        ArrayList<Integer> angkaGenap = new ArrayList<Integer>();
        
        /*
        for (int i=ra1; i<=ra2; i++) {
            values.add(i);
        }
        */
        for (int i=angka1; i<=angka2; i++) {
            values.add(i);
        }
        // filter angka ganjil
        for (int val: values) {
            if (val % 2 == 0) {
                angkaGenap.add(val);
            } else {
                angkaGanjil.add(val);
            }
        }
        
        String msg = "<h2>Hasil Proses</h2><table border='1'>";
        msg += "<tr><td>Semua Data</td><td>" + values.toString().replace("[", "").replace("]", "") + "</td></tr>";
        msg += "<tr><td>Angka Ganjil</td><td>" + angkaGanjil.toString().replace("[", "").replace("]", "") + "</td></tr>";
        msg += "<tr><td>Angka Genap</td><td>" + angkaGenap.toString().replace("[", "").replace("]", "") + "</td></tr>";
        msg += "<tr><td>Nilai Terkecil</td><td>" + ra1 + "</td></tr>";
        msg += "<tr><td>Nilai Terbesar</td><td>" + ra2 + "</td></tr>";
        msg += "</table><br><a href='/Tugas_1'>Kembali</a>";
        out.print(msg);  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
