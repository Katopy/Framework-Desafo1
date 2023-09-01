package sv.edu.udb.www.beans;

public class LogBeans {
	private String usuarioLogin;
	private String contraLogin;
	private String tipoUsuario;
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public String getContraLogin() {
		return contraLogin;
	}
	public void setContraLogin(String contraLogin) {
		this.contraLogin = contraLogin;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	 public LogBeans() {
	    }
	public LogBeans(String usuarioLogin, String contraLogin, String tipoUsuario) {
		super();
		this.usuarioLogin = usuarioLogin;
		this.contraLogin = contraLogin;
		this.tipoUsuario = tipoUsuario;
	}
	

	
}
