package com.example.calculadoraservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.PrintWriter;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OperationServlet", value = "/buscointerdisciplinar")
    public class OperationServlet extends HttpServlet {;
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        String desc = request.getParameter("nome");

        UserRequest user = new UserRequest(desc);
        Conexao conect = new Conexao();
        try {
            conect.inserir(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
