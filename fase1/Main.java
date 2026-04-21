import java.util.*;
import java.io.*;

public class Main{
    public static int cur = 0;
    static ArrayList<String[]> kamar = new ArrayList<>();

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
                "║ 1. List kamar & fasilitas            ║\n" +
                "║ 2. Tambah data penghuni              ║\n" +
                "║ 3. Riwayat pembayaran                ║\n" +
                "║ 4. Kembali                           ║\n" +
                "╚══════════════════════════════════════╝",

                "╔══════════════════════════════════════╗\n" +
                "║           MANAJEMEN KAMAR            ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ 1. Edit kamar                        ║\n" +
                "║ 2. Tambah kamar                      ║\n" +
                "║ 3. Kembali                           ║\n" +
                "╚══════════════════════════════════════╝",
        };

        while (true) {
            System.out.println(listMenu[cur]);
            int input = new Utils().ScanInt();
            if(cur == 0){
                if (input == 2) return;
                if (input == 1) cur++;
                else System.out.println("input tidak valid");
            }else if(cur == 1){
                if(input == 4) cur--;
                if(input == 1) listKamar();
                if(input == 2) tambahPenghuni();
                if(input == 3) riwayatCatatanPembayaran();
            }else if(cur == 2){
                if(input == 3) cur--;
                if(input == 1) editKamar();
                if(input == 2) tambahKamar();
            }
        }
    }

    public static void listKamar(){
//        System.out.println("1. Kamar 1, fasilitas .. .......\n" +
//                "1. Kamar 1, fasilitas .. .......\n" +
//                "1. Kamar 1, fasilitas .. .......\n" +
//                "1. Kamar 1, fasilitas .. .......\n" +
//                "1. Kamar 1, fasilitas .. .......\n" +
//                "1. Kamar 1, fasilitas .. .......\n");
        int nomor = new Integer(1);
        for(String[] data : kamar){
            System.out.println(nomor++ + ". Fasilitas: " + data[0] + "\n\tStatus : " + data[1]);
        }
        cur++;
    }

    public static void editKamar(){
        System.out.println("Masukkan nomor kamar yang ingin di edit");
        while(true){
            if(kamar.size() == 0) return;
            int input = new Utils().ScanInt();
            if(input > kamar.size() || input <= 0) continue;
            input--;
            System.out.println("Ketik fasilitas atau ketik -1 untuk tidak melakukan perubahan");
            String fasilitas = new Utils().ScanString(1000);
            System.out.println("Masukkan status: terisi atau belum terisi");
            String ada = new Utils().ScanString(100);

            while(fasilitas == null) fasilitas = new Utils().ScanString(1000);
            while(ada == null) ada = new Utils().ScanString(100);

            if(fasilitas != "-1") kamar.get(input)[0] = fasilitas;
            kamar.get(input)[1] = ada;
            System.out.println("data berhasil di edit");
            return;
        }
    }

    public static void tambahKamar(){
        kamar.add(new String[]{"Fasilitas", "Belum Terisi"});
        System.out.println("Berhasil menambahkan 1 kamar");
    }

    public static void tambahPenghuni(){

    }

    public static void riwayatCatatanPembayaran(){

    }
}
