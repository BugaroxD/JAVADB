import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Home { 

    public static void main(String[] args) {
        try{
            final String url = "jdbc:mysql://localhost:3306/POO?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            //ResultSet results = 
            //statement.execute ("INSERT funcionario (nome, cpf, data_nascimento, matricula) VALUES ('Jeff', '11122233344', '2010/02/23', '123456')");
            //statement.execute ("UPDATE funcionario SET nome = 'Baita' WHERE id = 2 ");
            //statement.execute ("DELETE FROM funcionario WHERE id = 2");
            ResultSet results = statement.executeQuery("SELECT * FROM funcionario");
            while(results.next())
            /*{
                Funcionario funcionario = new Funcionario(
                   results.getInt("id"),
                   results.getString("nome"),
                   results.getString("cpf"),
                   results.getDate("data_nascimento"),
                   results.getString("matricula")
                );*/
                System.out.println(results.getString("nome"));
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
}