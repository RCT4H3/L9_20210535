package org.example.lab9_20210535.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab9_20210535.Daos.UsuarioDao;

import java.io.IOException;

@WebServlet(name = "UsuarioSevlet", value = "/UsuarioSevlet")
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;
        UsuarioDao usuarioDao = new UsuarioDao();
        switch (action) {
            case "lista":
                request.setAttribute("listaUsuariosOperativo", usuarioDao.listarUsuarioOperativo());
                view = request.getRequestDispatcher("WEB-INF/listaUsuarioOperativo.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
