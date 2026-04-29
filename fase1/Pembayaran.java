import java.text.NumberFormat;
import java.util.Locale;

public class Pembayaran {
    private int kamar;
    private String penghuni;
    private int bulan;
    private int tahun;
    private int tanggal;
    private int jumlah;
    private boolean lunas;
    NumberFormat rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public Pembayaran(int kamar, String penghuni,int tanggal, int bulan, int tahun, int jumlah, String lunas){
        if(bulan <= 0 || bulan > 12) {
            throw new IllegalArgumentException("\u001B[33mBulan harus 1-12!\u001B[0m");
        }
        if(tanggal <= 0 || tanggal > 31){
            throw new IllegalArgumentException("\u001B[33mTanggal harus antara 1-31!\u001B[0m");
        }
        if(tahun <= 2020 || tahun > 2026){
            throw new IllegalArgumentException("\u001B[33mTahun harus antara 2021-2026\u001B[0m");
        }
        if((lunas.equals("LUNAS") == false && lunas.equals("BELUM LUNAS") == false) || lunas == null){
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
            //case KONTOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
        }
        return "";
    }
}
