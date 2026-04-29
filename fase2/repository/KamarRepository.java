package repository;

import model.Kamar;
import model.Penghuni;

import java.util.ArrayList;

public class KamarRepository {
    private ArrayList<Kamar> daftarKamar = new ArrayList<>();

    // ── CRUD Kamar ───────────────────────────────────────────────────────────

    public Kamar tambahKamar() {
        int nomor = daftarKamar.size() + 1;
        Kamar baru = new Kamar(nomor);
        daftarKamar.add(baru);
        return baru;
    }

    /**
     * Hapus kamar berdasarkan nomor urut (1-based).
     * Nomor kamar di bawahnya otomatis tidak bergeser — nomor bersifat tetap.
     */
    public boolean hapusKamar(int nomor) {
        Kamar k = cariKamar(nomor);
        if (k == null) return false;
        daftarKamar.remove(k);
        return true;
    }

    /** Cari kamar berdasarkan nomor. Return null jika tidak ditemukan. */
    public Kamar cariKamar(int nomor) {
        for (Kamar k : daftarKamar) {
            if (k.getNomor() == nomor) return k;
        }
        return null;
    }

    public ArrayList<Kamar> getSemuaKamar() {
        return daftarKamar;
    }

    // ── Operasi Penghuni ─────────────────────────────────────────────────────

    public boolean tambahPenghuni(int nomorKamar, Penghuni p) {
        Kamar k = cariKamar(nomorKamar);
        if (k == null) return false;
        k.tambahPenghuni(p);
        return true;
    }

    public boolean hapusPenghuni(int nomorKamar, int nomorUrut) {
        Kamar k = cariKamar(nomorKamar);
        if (k == null) return false;
        return k.hapusPenghuni(nomorUrut) != null;
    }

    // ── Operasi Fasilitas ────────────────────────────────────────────────────

    public boolean tambahFasilitas(int nomorKamar, String namaFasilitas) {
        Kamar k = cariKamar(nomorKamar);
        if (k == null) return false;
        k.tambahFasilitas(namaFasilitas);
        return true;
    }

    // ── Operasi Harga ────────────────────────────────────────────────────────

    public boolean setHarga(int nomorKamar, long harga) {
        Kamar k = cariKamar(nomorKamar);
        if (k == null) return false;
        k.setHarga(harga);
        return true;
    }
}