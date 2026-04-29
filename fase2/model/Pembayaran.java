package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Pembayaran {
    private int nomorKamar;
    private String namaPenghuni;
    private int tanggal;
    private int bulan;
    private int tahun;
    private long jumlah;
    private boolean lunas;

    private static final NumberFormat RP =
            NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public Pembayaran(int nomorKamar, String namaPenghuni,
                      int tanggal, int bulan, int tahun,
                      long jumlah, String statusLunas) {

        // Validasi — cek null dulu sebelum .equals()
        if (namaPenghuni == null || namaPenghuni.isBlank())
            throw new IllegalArgumentException("Nama penghuni tidak boleh kosong.");
        if (statusLunas == null)
            throw new IllegalArgumentException("Status lunas tidak boleh kosong.");
        if (!statusLunas.equalsIgnoreCase("LUNAS") &&
                !statusLunas.equalsIgnoreCase("BELUM LUNAS"))
            throw new IllegalArgumentException("Status harus: LUNAS atau BELUM LUNAS");
        if (tanggal < 1 || tanggal > 31)
            throw new IllegalArgumentException("Tanggal harus antara 1–31.");
        if (bulan < 1 || bulan > 12)
            throw new IllegalArgumentException("Bulan harus antara 1–12.");
        if (tahun < 2020 || tahun > 2030)
            throw new IllegalArgumentException("Tahun harus antara 2020–2030.");
        if (jumlah <= 0)
            throw new IllegalArgumentException("Jumlah pembayaran harus lebih dari 0.");

        this.nomorKamar  = nomorKamar;
        this.namaPenghuni = namaPenghuni;
        this.tanggal = tanggal;
        this.bulan   = bulan;
        this.tahun   = tahun;
        this.jumlah  = jumlah;
        this.lunas   = statusLunas.equalsIgnoreCase("LUNAS");
    }

    // ── Getter ──────────────────────────────────────────────────────────────

    public int getNomorKamar()    { return nomorKamar; }
    public String getNamaPenghuni() { return namaPenghuni; }
    public int getBulan()         { return bulan; }
    public int getTahun()         { return tahun; }
    public boolean isLunas()      { return lunas; }

    // ── Tampilkan ────────────────────────────────────────────────────────────

    public void tampilkan() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf ("│  Kamar No.  : %-23d│%n", nomorKamar);
        System.out.printf ("│  Penghuni   : %-23s│%n", namaPenghuni);
        System.out.printf ("│  Tanggal    : %-23s│%n",
                tanggal + " " + namaBulan(bulan) + " " + tahun);
        System.out.printf ("│  Jumlah     : %-23s│%n", RP.format(jumlah));
        System.out.printf ("│  Status     : %-23s│%n", lunas ? "✓ Lunas" : "✗ Belum Lunas");
        System.out.println("└─────────────────────────────────────┘");
    }

    private String namaBulan(int n) {
        String[] bulanArr = {
                "", "Januari","Februari","Maret","April","Mei","Juni",
                "Juli","Agustus","September","Oktober","November","Desember"
        };
        return (n >= 1 && n <= 12) ? bulanArr[n] : "?";
    }
}