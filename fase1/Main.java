import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main{
    public static int cur = 0;
    static Kamar kamar = new Kamar();

    public static void main(String[] arg){
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
                "║ 8. Kembali                           ║\n" +
                "╚══════════════════════════════════════╝",

                "Manajemen pembayaran\n" +
                        "1. Riwayat pembayaran penghuni\n" +
                        "2. Kembali"
        };

        while (true) {
            System.out.println(listMenu[cur]);
            int input = new Utils().ScanInt();
            if(cur == 0) {
                if (input == 2) return;
                if (input == 1) cur++;
                else System.out.println("input tidak valid");
            }else if(cur == 1){
                if(input == 3) cur--;
                if(input == 1) cur++;
                if(input == 2)cur+=2;
            }else if(cur == 2){ // manajemen kamar
                if(input == 8) cur--;
                if(input == 1) tampilkanKamar();;
                if(input == 2) tambahKamar();
                if(input == 3) tambahPenghuni();
                if(input == 4) tambahFasilitas();
                if(input == 5) aturHarga();
                if(input == 6) hapusKamar();
                if(input == 7) hapusPenghuni();
            }else if(cur == 3){ // manajemen pembayaran

            }
        }
    }

    public static void tampilkanKamar(){
        ArrayList<ArrayList<String>> listKamar = kamar.getKamar();
        ArrayList<ArrayList<String>> listPenghuni = kamar.getPenghuni();
        ArrayList<Boolean> isTerisi = kamar.getIsTerisi();
        ArrayList<String> listHarga = kamar.getHarga();

        for(int i = 0; i < kamar.getKamar().size(); i++){
            int idx= i+1;
            System.out.println("Kamar no-" + idx);
            System.out.println("Harga perbulan: " + listHarga.get(i) + "\nFasilitas: ");
            for(int j = 0;j < listKamar.get(i).size();j++){
                int idx2 = j+1;
                System.out.println(idx2 + ". " + listKamar.get(i).get(j));
            }
            System.out.println();
            System.out.println("Status: " + (isTerisi.get(i) == true ? "Terisi" : "Belum terisi"));
            if(isTerisi.get(i) ==false)continue;

            System.out.println("Penghuni:");
            for(int j = 0;j<listPenghuni.get(i).size();j++){
                int idx2 = j+1;
                System.out.println(idx2 + ". " + listPenghuni.get(i).get(j));
            }
        }
    }

    public static void tambahKamar(){
        System.out.println("Sukses menambahkan kamar baru");
        kamar.addKamar();
    }

    public static void tambahPenghuni(){
        System.out.print("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();
        System.out.print("Masukkan nama penghuni: ");
        String namaPenghuni = new Utils().ScanString(100);

        if(kamar.addPenghuni(nomorKamar, namaPenghuni) == false){
            System.out.println("Input tidak valid. (nomor kamar tidak ada)");
        }
    }

    public static void tambahFasilitas(){
        System.out.print("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();
        System.out.print("Masukkan nama fasilitas: ");
        String namaFasilitas = new Utils().ScanString(1000);

        if(kamar.addFasilitas(nomorKamar, namaFasilitas) == false){
            System.out.println("Input tidak valid. (nomor kamar tidak ada)");
        }else{
            System.out.printf("Sukses menambahkan fasilitas %s pada kamar nomor-%d\n", namaFasilitas,nomorKamar);
        }
    }

    public static void aturHarga(){
        System.out.print("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();
        System.out.print("Masukkan harga baru: ");
        String harga = new Utils().ScanString(100);

        if(kamar.setHarga(nomorKamar, harga) == false){
            System.out.println("Input tidak valid. (nomor kamar tidak ada / harga tidak valid)");
        }else {
            System.out.printf("Sukses mengubah harga kamar nomor-%d menjadi %s harga\n", nomorKamar, harga);
        }
    }

    public static void hapusKamar(){
        System.out.print("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();

        if(kamar.removeKamar(nomorKamar) == false){
            System.out.println("Input tidak valid. (nomor kamar tidak ada)");
        }else{
            System.out.printf("Sukses menghapus kamar nomor-%d\n", nomorKamar);
        }
    }

    public static void hapusPenghuni(){
        System.out.print("Masukkan nomor kamar: ");
        int nomorKamar = new Utils().ScanInt();
        System.out.print("Masukkan nomor penghuni: ");
        int nomorPenghuni = new Utils().ScanInt();

        if(kamar.removePenghuni(nomorKamar, nomorPenghuni) == false){
            System.out.println("Input tidak valid. (nomor kamar tidak ada / nomor penghuni tidak ada)");
        }else{
            System.out.printf("Sukses menghapus penghuni nomor-%d pada kamar nomor-%d\n", nomorPenghuni, nomorKamar);
        }
    }
}
