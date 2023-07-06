package Proba_z_Ola.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import java.beans.ConstructorProperties;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
@Repository
public class WnioskiDAO {
    /* Import org.springframework.jd....Template*/
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WnioskiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wnioski> list(){
        String sql = "SELECT * FROM WNIOSKI";

        List<Wnioski> listWnioski = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wnioski.class));

        return listWnioski;
    }

    public void save(Wnioski wnioski) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("wnioski").usingColumns("Nr_wniosku", "Nazwa", "Data_zlozenia", "Czy_pilne", "Nr_sekretatiatu", "Nr_klienta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wnioski);
        insertAction.execute(param);
    }

    /*public Wnioski get(int nr_wniosku) {
        String sql = "SELECT * FROM WNIOSKI WHERE nr_wniosku = ?";
        Object[] args = {nr_wniosku};
        Wnioski wnioski = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Wnioski.class));
        return wnioski;
    }*/

    public Wnioski get(int nr_wniosku){
        Object[] args = {nr_wniosku};
        String sql = "SELECT * FROM WNIOSKI WHERE nr_wniosku = " + args[0];
        Wnioski wnioski = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Wnioski.class));
        return wnioski;
    }

    public void update(Wnioski wnioski){
        String sql = "UPDATE WNIOSKI SET nazwa=:nazwa, czy_pilne=:czy_pilne, nr_sekretatiatu=:nr_sekretatiatu, nr_klienta=:nr_klienta WHERE nr_wniosku=:nr_wniosku";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wnioski);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_wniosku){
        String sql = "DELETE FROM WNIOSKI WHERE nr_wniosku = ?";
        jdbcTemplate.update(sql, nr_wniosku);
    }
}
