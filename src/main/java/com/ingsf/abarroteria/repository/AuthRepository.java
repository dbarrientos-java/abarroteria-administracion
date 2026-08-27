
package main.java.com.ingsf.abarroteria.repository;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.com.ingsf.abarroteria.config.DataBaseConnection;
import main.java.com.ingsf.abarroteria.dto.request.LoginDTORequest;
import main.java.com.ingsf.abarroteria.dto.response.LoginDTOResponse;

public class AuthRepository {
    public LoginDTOResponse findUserByEmail(LoginDTORequest request){
        String sql = "select u.nombre, u.apellido, u.contrasena_hash, r.id_rol from usuarios as u\n" +
                            "inner join roles as r\n" +
                            "on u.id_rol = r.id_rol\n" +
                            "where u.email = ?";
        try(PreparedStatement pstm = DataBaseConnection.getDataBaseConnection().prepareCall(sql)){
            pstm.setString(1, request.getEmail());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                return new LoginDTOResponse(
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("contrasena_hash"),
                rs.getString("id_rol")
                );
            }
        }catch(SQLException e){
                    System.out.println("Error al buscar el usuario.");
                    }
        return null;
    }
}