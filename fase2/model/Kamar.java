package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Kamar {
    private int nomor;
    private long harga;           // -1 berarti belum diset
    private ArrayList<String> fasilitas;
    private ArrayList<Penghuni> penghuni;

    private static final NumberFormat RP =
            NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public Kamar(int nomor) {
        this.nomor = nomor;
        this.harga = -1;
        this.fasilitas = new ArrayList<>();
        this.penghuni = new ArrayList<>();
    }

    // ── Getter ──────────────────────────────────────────────────────────────

    public int getNomor() { return nomor; }

    public String getHargaFormatted() {
        return harga == -1 ? "Belum diset" : RP.format(harga);
    }

    public long getHarga() { return harga; }

    public ArrayList<String> getFasilitas() { return fasilitas; }

    public ArrayList<Penghuni> getPenghuni() { return penghuni; }

    public boolean isTerisi() { return !penghuni.isEmpty(); }

    // ── Operasi ─────────────────────────────────────────────────────────────

    public void setHarga(long harga) {
        if (harga <= 0) throw new IllegalArgumentException("Harga harus lebih dari 0.");
        this.harga = harga;
    }

    public void tambahFasilitas(String namaFasilitas) {
        if (namaFasilitas == null || namaFasilitas.isBlank())
            throw new IllegalArgumentException("Nama fasilitas tidak boleh kosong.");
        fasilitas.add(namaFasilitas.trim());
    }

    public void tambahPenghuni(Penghuni p) {
        penghuni.add(p);
    }

    /**
     * Hapus penghuni berdasarkan nomor urut (1-based).
     * @return Penghuni yang dihapus, atau null jika nomor tidak valid.
     */
    public Penghuni hapusPenghuni(int nomorUrut) {
        if (nomorUrut <= 0 || nomorUrut > penghuni.size()) return null;
        return penghuni.remove(nomorUrut - 1);
    }

    // ── Tampilkan ────────────────────────────────────────────────────────────

    public void tampilkan() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf ("│  Kamar No. %-26d│%n", nomor);
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf ("│  Harga  : %-27s│%n", getHargaFormatted());
        System.out.printf ("│  Status : %-27s│%n", isTerisi() ? "Terisi" : "Kosong");

        // fasilitas
        if (fasilitas.isEmpty()) {
            System.out.printf("│  Fasilitas : %-24s│%n", "(belum ada)");
        } else {
            System.out.printf("│  Fasilitas :%-25s│%n", "");
            for (int i = 0; i < fasilitas.size(); i++) {
                System.out.printf("│    %d. %-32s│%n", i + 1, fasilitas.get(i));
            }
        }

        // penghuni
        if (isTerisi()) {
            System.out.println("├─────────────────────────────────────┤");
            System.out.printf ("│  Penghuni :%-26s│%n", "");
            for (int i = 0; i < penghuni.size(); i++) {
                Penghuni p = penghuni.get(i);
                System.out.printf("│    %d. %-32s│%n", i + 1, p.getNama());
                System.out.printf("│       HP    : %-23s│%n", p.getNoHP());
                System.out.printf("│       Masuk : %-23s│%n", p.getTanggalMasuk());
            }
        }

        System.out.println("└─────────────────────────────────────┘");
    }
}