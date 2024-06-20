package org.example.lab9_20210535.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab9_20210535.Beans.UsuarioB;
import org.example.lab9_20210535.Daos.UsuarioDao;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        UsuarioB employeeLogged = (UsuarioB) httpSession.getAttribute("usuarioLogueado");

        if(employeeLogged != null && employeeLogged.getIdUsuario() > 0){

            if(request.getParameter("a") != null){//logout
                httpSession.invalidate();
            }
            response.sendRedirect(request.getContextPath());
        }else{
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("username");
        String password = request.getParameter("password");


        UsuarioDao usuarioDao = new UsuarioDao();

        if(usuarioDao.validarUsuarioPasswordHashed(correo, password)){
            int idUser = usuarioDao.obtenerUsuarioPorCorreo(correo);
            UsuarioB usuarioB = usuarioDao.obtenerUsuarioPorID(idUser);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("usuarioLogueado",usuarioB);
            response.sendRedirect(request.getContextPath() + "/WEB-INF/homeUser.jsp");
        }else{
            System.out.println("usuario o password incorrectos");
            request.setAttribute("err","Usuario o password incorrectos");
            request.getRequestDispatcher("loginForm.jsp").forward(request,response);
        }
    }
}
