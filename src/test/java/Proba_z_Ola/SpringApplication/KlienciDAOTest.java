package Proba_z_Ola.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KlienciDAOTest {
    private KlienciDAO tao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRC15");
        datasource.setPassword("BDBTGRC15");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        tao = new KlienciDAO(new JdbcTemplate(datasource));
    }
    @Test
    void testList(){
        List<Klienci> listKlienci = tao.list();

        assertTrue(listKlienci.isEmpty());
    }
    @Test
    void testSave(){
        fail("Note yet implemented");
    }
    @Test
    void testGet(){
        int nr_klienta = 4;
        Klienci klienci = tao.get(nr_klienta);

        assertNotNull(klienci);
    }
    @Test
    void testUpdate(){
        Klienci klienci = new Klienci();
    }
    @Test
    void testDelete(){
        int nr_klienta = 1;
        tao.delete(nr_klienta);
    }
}
