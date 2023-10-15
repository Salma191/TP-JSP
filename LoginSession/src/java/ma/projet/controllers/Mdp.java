package ma.projet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.projet.entity.Client;
import ma.projet.services.ClientService;
import ma.projet.util.EmailSender;


@WebServlet(name = "Mdp", urlPatterns = {"/Mdp"})
public class Mdp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String email = request.getParameter("email");
    ClientService cl = new ClientService();
    Client c = cl.getByEmail(email);
    if (c != null) {
        double i = Math.random() * 100000;
        String code = (i + "").substring(0, 4);
        c.setCode(code);
        cl.update(c);
        HttpSession session = request.getSession();
        session.setAttribute("client", c);
        
        // Envoi du code par e-mail
        EmailSender.sendEmail(email, "Code de validation", "Votre code de validation est : " + code);
        
        response.sendRedirect("Verifier.jsp");
    } else {
        request.setAttribute("msg", "Email n'existe pas");
        request.getRequestDispatcher("Mdp.jsp").forward(request, response);
    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
