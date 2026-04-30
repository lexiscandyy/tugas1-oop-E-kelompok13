import java.util.ArrayList;
import java.util.List;

public class Penghuni {
    private String namaPenghuni;
    private String noTelepon;
    private ArrayList<Pembayaran> riwayatPembayaran;

    public Penghuni(String nama, String noTelepon) {
        this.namaPenghuni = nama;
        this.noTelepon = noTelepon;
        this.riwayatPembayaran = new ArrayList<>();
    }

    public void tambahRiwayat(Pembayaran p) {
        riwayatPembayaran.add(p);
    }

    public void setNama(String nama){
        namaPenghuni = nama;
    }
    public void setNoTelp(String nom){
        noTelepon = nom;
    }

    public String getNama() {
        return namaPenghuni;
    }
    public ArrayList<Pembayaran> getRiwayatPembayaran() {
        return riwayatPembayaran;
    }

    @Override
    public String toString() {
        return namaPenghuni + " (" + noTelepon + ")";
    }
}