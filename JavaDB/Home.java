import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Home { 

    public static void main(String[] args) throws ParseException {

        int opcao;
        int id;
        String nome;
        String cpf;
        String dataNascimento;
        String matricula;


        try{
            final String url = "jdbc:mysql://localhost:3306/POO?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println(
                               "Digite a opção de sua escolha:" +
                               "Opção 1 - INSERT informações:" +
                               "Opção 2 - UPDATE informações:" +
                               "Opção 3 - DELETE informações:" +
                               "Opção 4 - SELECT informações:" 
                               );
            opcao = sc.nextInt();
            
            
            switch (opcao) {

            case 1:
            /*Funcionario funcionario = new Funcionario(
                nome = scanner.next(),
                cpf = scanner.next(),
                dataNascimento = scanner.next(),
                matricula = scanner.next());*/

                System.out.println("Nome: ");
                nome = sc.nextLine();
                System.out.println("Cpf: ");
                cpf = sc.nextLine();
                System.out.println("Data de nascimento: *dd/mm/aaaa* ");
                dataNascimento = sc.nextLine();
                System.out.println("Matricula do funcionário:");
                matricula = sc.nextLine();
                
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Date date = f.parse(dataNascimento);
                System.out.println("Enter cliente data: ");
                Funcionario funcionario = new Funcionario(nome, cpf, (java.sql.Date) date, matricula);
            
                sc.close();
            statement.execute ("INSERT funcionario (nome, cpf, data_nascimento, matricula) VALUES ('" + funcionario.getNome() + "','" + funcionario.getCpf() + "','" + funcionario.getDataNascimento() + "','" + funcionario.getMatricula() + "')");
            break;

           /* case 2:
            statement.execute ("UPDATE funcionario SET nome = 'Baita' WHERE id = 2 ");
            break;

            case 3:
            statement.execute ("DELETE FROM funcionario WHERE id = 2");
            break;
            
            case 4:
            ResultSet results = statement.executeQuery("SELECT * FROM funcionario");
            while(results.next())
            {
                Funcionario funcionario = new Funcionario(
                   results.getInt("id"),
                   results.getString("nome"),
                   results.getString("cpf"),
                   results.getDate("data_nascimento"),
                   results.getString("matricula")
                );
                System.out.println(results.getString("nome"));
            break;*/
            }  
            con.close();
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
}