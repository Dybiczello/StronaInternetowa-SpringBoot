package Proba_z_Ola.SpringApplication;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.text.DateFormat;
public class Wnioski {
    private int nr_wniosku;
    private String nazwa;
    private Date data_zlozenia;
    private String czy_pilne;
    private int nr_sekretatiatu;
    private int nr_klienta;


    public int getNr_wniosku() {
        return nr_wniosku;
    }
    public void setNr_wniosku(int nr_wniosku) {
        this.nr_wniosku = nr_wniosku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getData_zlozenia() {
        return data_zlozenia;
    }

    public void setData_zlozenia(Date data_zlozenia) {
        this.data_zlozenia = data_zlozenia;
    }

    public String getCzy_pilne() {
        return czy_pilne;
    }

    public void setCzy_pilne(String czy_pilne) {
        this.czy_pilne = czy_pilne;
    }

    public int getNr_sekretatiatu() {
        return nr_sekretatiatu;
    }

    public void setNr_sekretatiatu(int nr_sekretatiatu) {
        this.nr_sekretatiatu = nr_sekretatiatu;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public Wnioski(){
    }
    public Wnioski(int nr_wniosku, String nazwa, Date data_zlozenia, String czy_pilne, int nr_sekretariatu, int nr_klienta) {
        super();
        this.nr_wniosku = nr_wniosku;
        this.nazwa = nazwa;
        this.data_zlozenia = data_zlozenia;
        this.czy_pilne = czy_pilne;
        this.nr_sekretatiatu = nr_sekretariatu;
        this.nr_klienta = nr_klienta;
    }
    @Override
    public String toString() {
        return "Wnioski{" +
                "nr_wniosku=" + nr_wniosku +
                ", nazwa='" + nazwa + '\'' +
                ", data_zlozenia=" + data_zlozenia +
                ", czy_pilne='" + czy_pilne + '\'' +
                ", nr_sekretariatu=" + nr_sekretatiatu +
                ", nr_klienta=" + nr_klienta +
                '}';
    }
}
