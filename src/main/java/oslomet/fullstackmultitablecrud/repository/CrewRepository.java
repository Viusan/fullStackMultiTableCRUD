package oslomet.fullstackmultitablecrud.repository;

import oslomet.fullstackmultitablecrud.models.Crew;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrewRepository {
    private final JdbcTemplate jdbcTemplate;//this will handle the connection between database and server

    public CrewRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    protected static final RowMapper<Crew> CrewRowMapper =(rs, RowNum) ->
            new Crew(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("birth_year"),
                    rs.getString("country"),
                    rs.getString("skill"),
                    rs.getInt("ship_id")
            );

    public void insertCrew(int ship_id, Crew crew){
        String sql = "INSERT INTO crew (name, birth_year, country, skill, ship_id) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, crew.getName(), crew.getBirth_year(), crew.getCountry(), crew.getSkill(), ship_id);
    }

    public void updateCrew(int ship_id, Crew crew){
        String sql = "UPDATE crew SET name = ?, birth_year = ?, country = ?, skill = ?, ship_id = ship_id";
        jdbcTemplate.update(sql, crew.getName(), crew.getBirth_year(), crew.getCountry(), crew.getSkill(), ship_id);
    }

    public void deleteCrew(Crew crew){
        String sql = "DELETE FROM crew WHERE id = ?";
        jdbcTemplate.update(sql, crew.getId());
    }

    public List<Crew> getAllCrew(){
        String sql = "SELECT * FROM crew";
        return jdbcTemplate.query(sql, CrewRowMapper);
    }
}
