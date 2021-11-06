/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.model;

/**
 *
 * @author Sistema 1
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class ArticulosDao {
    //-- 1.- JDBC Template, actualizar dispatcher-servlet.xml
private JdbcTemplate jdbcTmpl;
public void setJdbcTmpl(JdbcTemplate jdbc) {
System.out.println("Asignación de la conexión JDBC");
this.jdbcTmpl = jdbc;
}
//-- Construir las operaciones del CRUD

public int guardar(Articulo a) {
String sql = "INSERT INTO "
+ " inv_articulos (cve_articulo, nombre, descripcion, marca) "
+ " VALUES (?,?,?,?)";
return jdbcTmpl.update(sql,
a.getCveArticulo(),
a.getNombre(),
a.getDescripcion(),
a.getMarca());
}
public int actualiza(Articulo a) {
String sql = "UPDATE inv_articulos "
+ " SET cve_articulo = ?, "
+ " nombre = ?, "
+ " descripcion = ?, "
+ " marca = ? "
+ " WHERE id_articulo = ?";
return jdbcTmpl.update(sql,
a.getCveArticulo(),
a.getNombre(),
a.getDescripcion(),
a.getMarca(),
a.getIdArticulo());
}
public int borrar(int id) {
String sql = "DELETE FROM inv_articulos WHERE id_articulo = ?";
return jdbcTmpl.update(sql, id);
}
public Articulo getArticuloById(int id) {
String sql = "SELECT * FROM inv_articulos WHERE id_articulo = ?";
return jdbcTmpl.queryForObject(sql,
new Object[]{id},
new BeanPropertyRowMapper<Articulo>(Articulo.class));
}
public List<Articulo> getArticulos() {
String sql = "SELECT * FROM inv_articulos";
return this.jdbcTmpl.query(sql, new RowMapper<Articulo>() {
@Override
public Articulo mapRow(ResultSet rs, int i) throws SQLException {
Articulo a = new Articulo();
a.setIdArticulo(rs.getInt("ID_ARTICULO"));
a.setCveArticulo(rs.getString("CVE_ARTICULO"));
a.setNombre(rs.getString("NOMBRE"));
a.setDescripcion(rs.getString("DESCRIPCION"));
return a;
}
});
}

}//fin
