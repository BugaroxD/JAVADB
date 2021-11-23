import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    
    public void save(Funcionario funcionario) {

        String sql = "INSERT INTO funcionarios(id, nome, cpf, dataNascimento, matricula) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = Funcionario.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getCpf());
            pstm.setDate(4, funcionario.getDataNascimento());
            pstm.setString(5, funcionario.getMatricula());

            pstm.execute();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    }