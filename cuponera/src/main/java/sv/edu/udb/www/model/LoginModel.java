package sv.edu.udb.www.model;
import sv.edu.udb.www.model.Conexion;
import sv.edu.udb.www.beans.LogBeans;
import sv.edu.udb.www.controller.LogControler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginModel extends Conexion{
	public LogBeans login(String usuarioLogin) throws SQLException{
		LogBeans logBeans = null;
		try {
			String sql = "SELECT usuarioLogin, contraLogin, tipoUsuario FROM usuarios WHERE usuarioLogin =?;";
			this.conectar();
			st = conexion.prepareStatement(sql);
			st.setString(1,usuarioLogin);
			rs = st.executeQuery();
			if (rs.next()) {
				logBeans = new LogBeans();
                logBeans.setUsuarioLogin(rs.getString("usuarioLogin"));
                logBeans.setContraLogin(rs.getString("contraLogin"));
                logBeans.setTipoUsuario(rs.getString("tipoUsuario"));
                return logBeans;
            }
			this.desconectar();
			return null;
		}catch(SQLException ex){
			Logger.getLogger(LogControler.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}	
	}
}
