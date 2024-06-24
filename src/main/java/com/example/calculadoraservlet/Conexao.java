package com.example.calculadoraservlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao{
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public Conexao(){

    }

    public void conectar() throws SQLException, ClassNotFoundException {
// Informando qual driver de conexão será utilizado pelo DriveManager
        Class.forName("org.postgresql.Driver");
// Criando a conexão com o BD
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbVendas", "postgres", "admin");
    }

    public void desconectar() throws SQLException{
        if (conn != null && !conn.isClosed()) {
// Desconectando do BD
            conn.close();
        }
    }

    public void inserir(UserRequest request) throws SQLException, ClassNotFoundException {
        conectar(); // Abrindo a conexão com o banco
        pstmt = conn.prepareStatement("INSERT INTO product (descrip) VALUES (?)");
// Setando o valor dos parâmetros
        pstmt.setString(1, request.getDescript());
        pstmt.execute(); // Executando o comando sql do preparedStatement
        desconectar(); // Fechando a conexão com o banco
    }


}
