import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.text.*;
import java.util.*;

/**
 * Class untuk entitas kamar, terduru dari nomor kamar, penghuni, status terisi, harga, dan fasilitas kamar.
 * @author Rama
 * @author Andika
 */
public class Kamar implements Serializable {
    private int nomorKamar;
    private Penghuni penghuni;
    private boolean isTerisi;
    private int harga;
    private ArrayList<String> fasilitas = new ArrayList<>();

    /**
     * Constructor untuk kelas Kamar
     * @param nomorKamar Nomor kamar
     * @param harga Harga
     */
    public Kamar(int nomorKamar, int harga){
        if(nomorKamar<=0) throw new IllegalArgumentException("Nomor kamar tidak valid");
        this.nomorKamar = nomorKamar;
        this.harga = harga;
        this.penghuni = new Penghuni("BELUM ADA PENGHUNI", "-");
        this.isTerisi = false;
    }

    /**
     * Method untuk menambahkan 1 fasilitas pada ArrayList fasilitas
     * @param namaFasilitas Nama fasilitas bertipe String
     */
    public void addFasilitas(String namaFasilitas){
        if(namaFasilitas == null) throw new IllegalArgumentException("Nama fasilitas null");
        fasilitas.add(namaFasilitas);
    }

    // SETTER

    /**
     * Setter untuk penghuni yang berisi nama, dan nomor telepon
     * Jika ingin hanya mengubah salah satu, gunakan Kamar.getPenghuni().setNama dan Kamar.getPenghuni().setNoTelp
     * @param nama Nama penghuni
     * @param notelp Nomor telepon penghuni
     */
    public void setPenghuni(String nama, String notelp){
        this.isTerisi = true;
        penghuni.setNama(nama);
        penghuni.setNoTelp(notelp);
    }

    /**
     * Setter untuk harga pada instance variable
     * @param n Value baru untuk harga
     */
    public void setHarga(int n){
        if(n <= 0) throw new IllegalArgumentException("Harga tidak valid");
        if(n < 500000 || n > 5e6) throw new IllegalArgumentException("HARGA TIDAK MASUK AKAL");
        this.harga = n;
    }

    /**
     * Setter untuk isTerisi untuk status kamar, jika false maka belum terisi dan sebaliknya.
     * @param cek Value bool true atau false
     */
    public void setIsTerisi(boolean cek){
        this.isTerisi = cek;
    }

    // GETTER

    /**
     * Getter untuk ArrayList fasilitas
     * @return Mengembalikan data berupa String ArrayList yang berisi kumpulan fasilitas
     */
    public ArrayList<String> getFasilitas(){
        return fasilitas;
    }

    /**
     * Getter untuk mengembalikan nomorKamar instance variable
     * @return Mengembalikan nomorKamar
     */
    public int getNomorKamar(){
        return nomorKamar;
    }

    /**
     * Getter untuk mengembalikan class penghuni instance variable
     * @return Mengembalikan penghuni
     */
    public Penghuni getPenghuni(){
        return penghuni;
    }

    /**
     * Getter untuk mengembalikan isTerisi instance variable
     * @return Mengembalikan isTerisi
     */
    public boolean getIsTerisi(){
        return isTerisi;
    }

    /**
     * Getter untuk mengembalikan harga instance variable
     * @return Mengembalikan harga
     */
    public int getHarga(){
        return harga;
    }
}
