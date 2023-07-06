package Proba_z_Ola.SpringApplication;

import java.sql.Date;

public class Klienci {
    private int nr_klienta;
    private String imie;
    private String nazwisko;
    private String plec;
    private Date data_urodzenia;
    private String nr_telefonu;
    private int pesel;
    private int nr_sekretatiatu;
    private int nr_adresu;

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getNr_sekretatiatu() {
        return nr_sekretatiatu;
    }

    public void setNr_sekretatiatu(int nr_sekretatiatu) {
        this.nr_sekretatiatu = nr_sekretatiatu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public Klienci(){
    }

    public Klienci(int nr_klienta, String imie, String nazwisko, String plec, Date data_urodzenia, String nr_telefonu, int pesel, int nr_sekretatiatu, int nr_adresu) {
        super();
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.data_urodzenia = data_urodzenia;
        this.nr_telefonu = nr_telefonu;
        this.pesel = pesel;
        this.nr_sekretatiatu = nr_sekretatiatu;
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Klienci{" +
                "nr_klienta=" + nr_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", pesel=" + pesel +
                ", nr_sekretatiatu=" + nr_sekretatiatu +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
