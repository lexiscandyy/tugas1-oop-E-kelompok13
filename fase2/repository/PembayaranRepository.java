package repository;

import model.Pembayaran;

import java.util.ArrayList;

public class PembayaranRepository {
    private ArrayList<Pembayaran> daftarPembayaran = new ArrayList<>();

    public void tambah(Pembayaran p) {
        daftarPembayaran.add(p);
    }

    public boolean hapus(int nomorUrut) {
        if (nomorUrut <= 0 || nomorUrut > daftarPembayaran.size()) return false;
        daftarPembayaran.remove(nomorUrut - 1);
        return true;
    }

    public ArrayList<Pembayaran> getSemuaPembayaran() {
        return daftarPembayaran;
    }

    /** Filter riwayat berdasarkan nomor kamar. */
    public ArrayList<Pembayaran> cariPerKamar(int nomorKamar) {
        ArrayList<Pembayaran> hasil = new ArrayList<>();
        for (Pembayaran p : daftarPembayaran) {
            if (p.getNomorKamar() == nomorKamar) hasil.add(p);
        }
        return hasil;
    }

    /** Filter riwayat berdasarkan nama penghuni (case-insensitive). */
    public ArrayList<Pembayaran> cariPerPenghuni(String nama) {
        ArrayList<Pembayaran> hasil = new ArrayList<>();
        for (Pembayaran p : daftarPembayaran) {
            if (p.getNamaPenghuni().equalsIgnoreCase(nama)) hasil.add(p);
        }
        return hasil;
    }

    public int size() {
        return daftarPembayaran.size();
    }
}