import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.io.*;
// main -> kamar -> penghuni -> riwayat pembayaran

/**
 * Class main
 * @Author Rama
 * @Author Andika
 */
public class Main{
    static ArrayList<Kamar> kamar;

    public static int cur = 0;
//
//    static ArrayList<Kamar> kamar = new ArrayList<>();
    static NumberFormat rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    static void main(String[] arg) throws IOException {
        load();
        String[] listMenu = {
                "╔══════════════════════════════════════╗\n" +
                "║          SISTEM KOST ADMIN           ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║  1. Masuk                            ║\n" +
                "║  2. Exit                             ║\n" +
                "╚══════════════════════════════════════╝",

                "╔══════════════════════════════════════╗\n" +
                "║              MENU UTAMA              ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ 1. Manajemen kamar                   ║\n" +
                "║ 2. Riwayat pembayaran                ║\n" +
                "║ 3. Kembali                           ║\n" +
                "╚══════════════════════════════════════╝",

                "╔══════════════════════════════════════╗\n" +
                "║           MANAJEMEN KAMAR            ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ 1. Tampilkan kamar                   ║\n" +
                "║ 2. Tambah kamar                      ║\n" +
                "║ 3. Tambah penghuni                   ║\n" +
                "║ 4. Tambah fasilitas                  ║\n" +
                "║ 5. Atur harga                        ║\n" +
                "║ 6. Hapus kamar                       ║\n" +
                "║ 7. Hapus penghuni                    ║\n" +
                "║ 8. Hapus fasilitas                   ║\n" +
                "║ 9. Kembali                           ║\n" +
                "╚══════════════════════════════════════╝",

                "╔══════════════════════════════════════╗\n" +
                "║         MANAJEMEN PEMBAYARAN         ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║  1. Riwayat pembayaran penghuni      ║\n" +
                "║  2. Kembali                          ║\n" +
                "╚══════════════════════════════════════╝",

                "╔══════════════════════════════════════╗\n" +
                "║            MENU PEMBAYARAN           ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║  1. Tampilkan riwayat pembayaran     ║\n" +
                "║  2. Tambah riwayat pembayaran        ║\n" +
                "║  3. Hapus riwayat pembayaran         ║\n" +
                "║  4. Kembali                          ║\n" +
                "╚══════════════════════════════════════╝",
        };

        while (true) { // LOOPING UTAMA MENU
            System.out.println(listMenu[cur]);
            int input = new Utils().ScanInt();
            if(cur == 0) {
                if (input == 2) {
                    simpan();
                    return;
                }
                if (input == 1) cur++;
                else System.out.println("\u001B[31minput tidak valid\u001B[0m");
            }else if(cur == 1){
                if(input == 3) cur--;
                if(input == 1) cur++;
                if(input == 2)cur+=2;
            }else if(cur == 2){ // manajemen kamar
                if(input == 9) cur--;
                if(input == 1) tampilkanKamar();;
                if(input == 2) tambahKamar();
                if(input == 3) tambahPenghuni();
                if(input == 4) tambahFasilitas();
                if(input == 5) aturHarga();
                if(input == 6) hapusKamar();
                if(input == 7) hapusPenghuni();
                if(input == 8) hapusFasilitas();
            }else if(cur == 3){
                if(input == 2) cur-=2;
                if(input == 1) cur++;
            }else if(cur == 4){ // manajemen pembayaran
                if(input == 4) cur--;
                if(input == 1) tampilkanRiwayatPembayaran();
                if(input == 2) tambahRiwayatPembayaran();
                if(input == 3) hapusRiwayatPembayaran();
            }
        }
    }

    public static void tampilkanKamar(){
        for(Kamar i : kamar) {
            System.out.println("=========================================");
            System.out.println("Nomor kamar: " +  i.getNomorKamar());
            System.out.println("Harga: " + rp.format(i.getHarga()));
            System.out.println("Fasilitas: ");
            int idx = 1;
            for(String str : i.getFasilitas()){
                System.out.println(idx + ". " + str);
                idx++;
            }
            System.out.println("STATUS: " + (!i.getIsTerisi() ? "BELUM TERISI" : "SUDAH TERISI"));
            System.out.println("Penghuni: " + i.getPenghuni().toString());
        }
    }

    public static void tambahKamar(){
        System.out.println("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        System.out.println("Masukkan harga: ");
        int harga = new Utils().ScanInt();

        if(nomorKamar <= 0 || harga <= 0){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        if(harga < 500000 || harga > 5e6){
            System.out.println("HARGA TIDAK VALID\nHARGA HARUS RANGE (Rp500.000,00 - Rp5.000.000,00)");
            return;
        }

        for(Kamar i : kamar){
            if(i.getNomorKamar() == nomorKamar){
                System.out.println("NOMOR KAMAR SUDAH ADA");
                return;
            }
        }

        kamar.add(new Kamar(nomorKamar, harga));
        System.out.println("SUKSES");
    }

    public static void tambahPenghuni(){
        System.out.print("- Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        System.out.print("- Masukkan nama penghuni: ");
        String namaPenghuni = new Utils().ScanString(100);

        System.out.println("- Masukkan No.Telepon: ");
        String notelp = new Utils().ScanString(100);

        if(namaPenghuni == null || notelp == null || nomorKamar <= 0){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        for(Kamar i : kamar){
            if(i.getNomorKamar() == nomorKamar){
                i.setPenghuni(namaPenghuni, notelp);
                i.setIsTerisi(true);
                System.out.println("SUKSES");
                return;
            }
        }
        System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
    }

    public static void tambahFasilitas(){
        System.out.print("- Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();
        System.out.print("- Masukkan nama fasilitas: ");
        String namaFasilitas = new Utils().ScanString(1000);

        if(nomorKamar <= 0 || namaFasilitas == null){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        for(Kamar i  : kamar){
            if(i.getNomorKamar() == nomorKamar){
                i.addFasilitas(namaFasilitas);
                System.out.println("SUKSES");
                return;
            }
        }
        System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
    }

    public static void aturHarga(){
        System.out.print("- Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();
        System.out.print("- Masukkan harga baru: ");
        int harga = new Utils().ScanInt();

        if(nomorKamar <= 0 || harga <= 0){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        if(harga < 500000 || harga > 5e6){
            System.out.println("HARGA TIDAK VALID\nHARGA HARUS RANGE (Rp500.000,00 - Rp5.000.000,00");
            return;
        }

        for(Kamar i  : kamar){
            if(i.getNomorKamar() == nomorKamar){
                i.setHarga(harga);
                System.out.println("SUKSES");
                return;
            }
        }
        System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
    }

    public static void hapusKamar(){
        System.out.print("- Masukkan nomor kamar yang ingin dihapus: ");
        int nomorKamar = new Utils().ScanInt();

        if(nomorKamar <= 0){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        for(int i = 0 ;i < kamar.size(); i++) if(kamar.get(i).getNomorKamar() == nomorKamar){
            kamar.remove(i);
            System.out.println("SUKSES");
            return;
        }
        System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
    }

    public static void hapusPenghuni(){
        System.out.print("- Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        if(nomorKamar<=0){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        for(Kamar i : kamar){
            if(i.getNomorKamar() == nomorKamar){
                i.setPenghuni("BELUM ADA PENGHUNI", "-");;
                i.setIsTerisi(false);
                System.out.println("SUKSES");
                return;
            }
        }
        System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
    }

    public static void hapusFasilitas(){
        System.out.println("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        System.out.println("- Masukkan nomor fasilitas: ");
        int idx = new Utils().ScanInt();
        idx--;

        int idxkamar = -1;
        for(int i = 0;i < kamar.size();i++) if(kamar.get(i).getNomorKamar() == nomorKamar){
            idxkamar = i;
            break;
        }

        if(idxkamar == -1){
            System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
            return;
        }

        if(nomorKamar <= 0 || idx < 0 || idx >= kamar.get(idxkamar).getFasilitas().size()){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        kamar.get(idxkamar).getFasilitas().remove(idx);
        System.out.println("SUKSES");
    }

    public static void tampilkanRiwayatPembayaran(){
        for(Kamar i : kamar){
            System.out.println("Nomor kamar: " + i.getNomorKamar());
            System.out.println("Riwayat pembayaran: ");
            int id = 1;
            for(Pembayaran j : i.getPenghuni().getRiwayatPembayaran()){
                System.out.println("ID RIWAYAT PEMBAYARAN : " + id);
                j.tampilkanData();
                id++;
            }
        }
    }

    public static void tambahRiwayatPembayaran(){
        System.out.print("- Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        System.out.print("- Masukkan tanggal: ");
        int tanggal = new Utils().ScanInt();

        System.out.print("- Masukkan bulan (angka): ");
        int bulan = new Utils().ScanInt();

        System.out.print("- Masukkan tahun: ");
        int tahun = new Utils().ScanInt();

        System.out.print("- Masukkan jumlah bulan (berapa bulan dibayar): ");
        int jumlah = new Utils().ScanInt();

        System.out.print("- Status (LUNAS/BELUM LUNAS): ");
        String lunas = new Utils().ScanString(100);

        if(lunas == null || nomorKamar == -1 || tanggal == -1 || bulan == -1 || tahun == -1 || jumlah == -1){
            System.out.println("\u001B[31mInput tidak valid\u001B[0m");
            return;
        }

        if(lunas.equals("LUNAS") == false && lunas.equals("BELUM LUNAS") == false){
            System.out.println("KETIK (LUNAS/BELUM LUNAS");
            return;
        }

        try {
            LocalDate.of(tahun, bulan, tanggal); // otomatis validasi
        } catch (DateTimeException e) {
            System.out.println("TANGGAL TIDAK VALID");
            return;
        }

        if(tahun <= 2020 || tahun > 2026){
            System.out.println("TAHUN HARUS ANTARA 2021 - 2026");
            return;
        }

        int idxkamar = -1;
        for(int i = 0;i < kamar.size();i++) if(kamar.get(i).getNomorKamar() == nomorKamar){
            idxkamar = i; break;
        }
        if(idxkamar == -1){
            System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
            return;
        }

        if(jumlah >= 12){ // takutnya integer overflow
            System.out.println("MAX 12 BULAN");
            return;
        }

        int TOTAL = jumlah * kamar.get(idxkamar).getHarga();

        Pembayaran newPembayaran = new Pembayaran(nomorKamar, kamar.get(idxkamar).getPenghuni().getNama(), tanggal, bulan, tahun, TOTAL, lunas);
        kamar.get(idxkamar).getPenghuni().tambahRiwayat(newPembayaran);
    }

    public static  void hapusRiwayatPembayaran(){
        System.out.println("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        System.out.print("Masukkan ID riwayat pembayaran: ");
        int id = new Utils().ScanInt();

        if(nomorKamar <= 0 || id <= 0){
            System.out.println("INPUT TIDAK VALID");
            return;
        }

        for(int i = 0;i < kamar.size();i++){
            if(kamar.get(i).getNomorKamar() == nomorKamar){
                for(int j = 0;j < kamar.get(i).getPenghuni().getRiwayatPembayaran().size(); j++){
                    if(j+1 == id){
                        kamar.get(i).getPenghuni().getRiwayatPembayaran().remove(j);
                        System.out.println("SUKSES");
                        return;
                    }
                }
                System.out.println("ID RIWAYAT PEMBAYARAN TIDAK DITEMUKAN");
                return;
            }
        }
        System.out.println("NOMOR KAMAR TIDAK DITEMUKAN");
    }

    public static void load(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data_kamar_kos.dat"));
            kamar = (ArrayList<Kamar>) in.readObject();
            in.close();
        } catch (Exception e) {
            kamar = new ArrayList<>(); // kalau belum ada file
        }
    }

    public static void simpan() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data_kamar_kos.dat"));
        out.writeObject(kamar);
        out.close();
        System.out.println("DATA DISIMPAN");
    }
}
