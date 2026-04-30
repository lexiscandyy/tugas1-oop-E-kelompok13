import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class untuk entitas penghuni, terdiri dari nama, nomor telepon, dan riwayat pembayaran penghuni.
 * @author Rama
 * @author Andika
 */
public class Penghuni implements Serializable {
    private String namaPenghuni;
    private String noTelepon;
    private ArrayList<Pembayaran> riwayatPembayaran;

    /**
     * Constructor untuk class Penghuni
     * @param nama Nama penghuni
     * @param noTelepon Nomor telepon penghuni
     */
    public Penghuni(String nama, String noTelepon) {
        this.namaPenghuni = nama;
        this.noTelepon = noTelepon;
        this.riwayatPembayaran = new ArrayList<>();
    }

    /**
     * Menambahkan riwayat pembayaran penghuni
     * @param p Parameter dengan tipe data class Pembayaran
     */
    public void tambahRiwayat(Pembayaran p) {
        riwayatPembayaran.add(p);
    }

    /**
     * Setter untuk mengubah value dari namaPenghuni
     * @param nama Value baru untuk namaPenghuni
     */
    public void setNama(String nama){
        namaPenghuni = nama;
    }

    /**
     * Setter untuk mengubah value dari noTelepon
     * @param nom Value baru untuk noTelepon
     */
    public void setNoTelp(String nom){
        noTelepon = nom;
    }

    /**
     * Getter namaPenghuni
     * @return Mengembalikan value namaPenghuni
     */
    public String getNama() {
        return namaPenghuni;
    }

    /**
     * Getter riwayatPembayaran
     * @return Mengembalikan ArrayList riwayatPembayaran
     */
    public ArrayList<Pembayaran> getRiwayatPembayaran() {
        return riwayatPembayaran;
    }

    /**
     * override method toString
     * @return Mengembalikan value namaPenghuni dan noTelepon yang sudah di format
     */
    @Override
    public String toString() {
        return namaPenghuni + " (" + noTelepon + ")";
    }
}