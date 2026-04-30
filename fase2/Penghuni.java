import java.util.ArrayList;
import java.util.List;

public class Penghuni {
    private String namaPenghuni;
    private String noTelepon;
    private List<Pembayaran> riwayatPembayaran;

    public Penghuni(String nama, String noTelepon) {
        this.namaPenghuni = nama;
        this.noTelepon = noTelepon;
        this.riwayatPembayaran = new ArrayList<>();
    }

    public void tambahRiwayat(Pembayaran p) {
        this.riwayatPembayaran.add(p);
    }

    public String getNama() { return namaPenghuni; }
    public List<Pembayaran> getRiwayatPembayaran() { return riwayatPembayaran; }

    @Override
    public String toString() {
        return namaPenghuni + " (" + noTelepon + ")";
    }
}