import sv.edu.udb.www.beans.AeBeans;
import sv.edu.udb.www.controller.LogControler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeModel extends Conexion {

    public List<AeBeans> listarOfertas() throws SQLException {
        try {
            List<AeBeans> lista = new ArrayList<>();
            String sql = "SELECT * FROM oferta";
            this.conectar();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                AeBeans oferta = new AeBeans();
                oferta.setCodigoOferta(rs.getString("codigoOferta"));
                oferta.setTituloOferta(rs.getString("tituloOferta"));
                oferta.setPrecioRegular(rs.getDouble("precio"));
                oferta.setPrecioOferta(rs.getDouble("precioOferta"));
                oferta.setFechaInicioOferta(rs.getDate("fechaInicioOferta"));
                oferta.setFechaFinOferta(rs.getDate("fechaFinOferta"));
                oferta.setFechaLimiteCupon(rs.getDate("fechaLimiteCupon"));
                oferta.setCantidadLimiteCupones(rs.getInt("cantidadLimiteCupones"));
                oferta.setCuponesVendidos(rs.getInt("cuponesVendidos"));
                oferta.setEstado(rs.getString("estado"));
                oferta.setDescripcionOferta(rs.getString("descripcionOferta"));
                oferta.setComision(rs.getDouble("comision"));
                oferta.setIngresosTotales(rs.getDouble("ingresostotales"));
                lista.add(oferta);
            }
            this.desconectar();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(AeModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return null;
        }
    }
}
