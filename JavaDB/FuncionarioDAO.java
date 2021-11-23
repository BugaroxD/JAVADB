import java.sql.Connection;

public class FuncionarioDAO {
    
    public void save(Funcionario funcionario) {

        String sql = "INSERT INTO funcionarios(id, nome, cpf, dataNascimento, matricula) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
    }
}
