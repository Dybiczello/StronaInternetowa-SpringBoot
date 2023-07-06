package Proba_z_Ola.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class KlienciDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klienci> list(){
        String sql = "SELECT * FROM KLIENCI";

        List<Klienci> listKlienci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return listKlienci;
    }
    public void save(Klienci klienci){

    }
    public Klienci get(int nr_klienta){
        Object[] args = {nr_klienta};
        String sql = "SELECT * FROM KLIENCI WHERE nr_klienta = " + args[0];
        Klienci klienci = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return klienci;
    }

    public void update(Klienci klienci){
        String sql = "UPDATE KLIENCI SET nr_klienta=:nr_klienta, imie=:imie, nazwisko=:nazwisko, plec=:plec, data_urodzenia=:data_urodzenia, nr_telefonu=:nr_telefonu, pesel=:pesel, nr_sekretatiatu=:nr_sekretatiatu, nr_adresu=:nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int nr_klienta){
        String sql = "DELETE FROM KLIENCI WHERE nr_klienta = ?";
        jdbcTemplate.update(sql, nr_klienta);
    }
}
