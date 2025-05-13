package oslomet.fullstackmultitablecrud.repository;

import oslomet.fullstackmultitablecrud.models.Ships;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipRepository {
    private final JdbcTemplate jdbcTemplate;//this will handle the connection between database and server

    public ShipRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    protected static final RowMapper<Ships> ShipsRowMapper =(rs, rowNum) ->
            new Ships(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("price")
            );

    public List<Ships> getAllShips(){
        String sql = "SELECT * FROM ships";
        return jdbcTemplate.query(sql, ShipsRowMapper);
    }

    public void createShip(Ships ship){
        String sql = "INSERT INTO ships(name, description, price) VALUES(?,?,?)";
        jdbcTemplate.update(sql, ship.getName(), ship.getDescription(), ship.getPrice());
    }

    public void updateShip(int id, Ships ship){
        String sql = "UPDATE ships SET name = ?, description = ?, price = ? WHERE id = id";
        jdbcTemplate.update(sql, ship.getName(), ship.getDescription(), ship.getPrice(), id);
    }

    public void deleteShip(int id){
        String sql = "DELETE FROM ships WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
