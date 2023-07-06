package Proba_z_Ola.SpringApplication;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WnioskiDAOTest {

    private WnioskiDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRC15");
        datasource.setPassword("BDBTGRC15");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new WnioskiDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList() {
        List<Wnioski> listWniosek = dao.list();

        assertTrue(listWniosek.isEmpty());
    }

    @Test
    void testSave() throws ParseException {
        String value = "1900-01-02";
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) originalFormat.parse(value.toString());
        Wnioski wnioski = new Wnioski(6,"Podanie o przeniesienie", date, "TAK", 1,4);
        dao.save(wnioski);
    }

    @Test
    void testGet(){
        int nr_wniosku = 3;
        Wnioski wnioski = dao.get(nr_wniosku);

        assertNotNull(wnioski);

    }

    @Test
    void testUpdate(){
        Wnioski wnioski = new Wnioski();
        wnioski.setNr_wniosku(4);
        wnioski.setNazwa("Nowa legitymacja");
        wnioski.setCzy_pilne("TAK");
        wnioski.setNr_sekretatiatu(1);
        wnioski.setNr_klienta(2);

        dao.update(wnioski);
    }

    @Test
    void testDelete(){
        int nr_wniosku = 6;
        dao.delete(nr_wniosku);
    }
}
