import java.io.Serializable;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Class untuk entitas pembayaran, yang terdiri dari nomor kamar, nama penghuni, tanggal, bulan, tahun, jumlah harga, dan status lunas.
 * @author Rama
 * @author Andika
 */
public class Pembayaran implements Serializable {
    private int kamar;
    private String penghuni;
    private int bulan;
    private int tahun;
    private int tanggal;
    private int jumlah;
    private boolean lunas;
    NumberFormat rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    /**
     * Constructor untuk Pembayaran
     * @param kamar Nomor kamar
     * @param penghuni Nama penghuni
     * @param tanggal Tanggal dibayar
     * @param bulan Bulan
     * @param tahun Tahun
     * @param jumlah Jumlah bulan dibayarkan
     * @param lunas Status lunas
     */
    public Pembayaran(int kamar, String penghuni,int tanggal, int bulan, int tahun, int jumlah, String lunas){
        try {
            LocalDate.of(tahun, bulan, tanggal); // otomatis validasi
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Tanggal tidak valid!");
        }
        if(tahun <= 2020 || tahun > 2026){
            throw new IllegalArgumentException("\u001B[33mTahun harus antara 2021-2026\u001B[0m");
        }
        if(lunas == null || (lunas.equals("LUNAS") == false && lunas.equals("BELUM LUNAS") == false)){
            throw new IllegalArgumentException("KETIK: LUNAS atau BELUM LUNAS");
        }
        this.kamar = kamar;
        this.penghuni = penghuni;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
        this.jumlah = jumlah;
        this.lunas = lunas.equals("LUNAS") ? true : false;
    }

    /**
     * Menampilkan data dari setiap instance variables.
     */
    public void tampilkanData(){
        System.out.println("\u001B[36m╔════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[36m║         DATA PEMBAYARAN KOST       ║\u001B[0m");
        System.out.println("\u001B[36m╠════════════════════════════════════╣\u001B[0m");
        System.out.println("║ Kamar     : Kamar no. " + kamar);
        System.out.println("║ Penghuni: " + penghuni);
        System.out.println("║ Tanggal: " + tanggal + '-' + cvbulan(bulan) + '-' + tahun);
        System.out.println("║ Jumlah: " + rp.format(jumlah));
        System.out.println("║ Status: " + (lunas ? "Lunas" : "Belum lunas"));
        System.out.println("\u001B[36m╚════════════════════════════════════╝\u001B[0m");
    }

    /**
     * Convert bulan (dalam bentuk angka) menjadi nama bulan
     * @param n Bulan 1-12
     * @return Return string kosong jika tidak case tidak terpenuhi (Tidak mungkin terjadi karena sudah divalidasi di constructor)
     */
    private String cvbulan(int n){
        switch (n){
            case 1: return "Januari"; 
            case 2: return "Februari"; 
            case 3: return "Maret"; 
            case 4: return "April"; 
            case 5: return "Mei"; 
            case 6: return "Juni"; 
            case 7: return "Juli"; 
            case 8: return "Agustus"; 
            case 9: return "September"; 
            case 10: return "Oktober"; 
            case 11: return "November"; 
            case 12: return "Desember";
        }
        return "";
    }
}
