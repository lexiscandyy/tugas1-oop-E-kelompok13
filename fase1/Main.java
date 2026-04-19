import java.util.*;
import java.io.*;

public class Main{
    public static int cur = 0;

    public static void main(String[] arg){
        String[] listMenu = {
                "admin panel\n\n1. Masuk\n" +
                "2. Exit\n",

                "Pilih menu\n1. List kamar dan fasilitas\n" +
                "2. Tambah data penghuni\n" +
                "3. Riwayat Catatan Pembayaran\n" +
                "4. Kembali\n",

                "1. Edit\n" +
                "2. Kembali\n",
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
                if(input == 2) cur--;
                if(input == 1) editKamar();
            }
        }
    }

    public static void listKamar(){
        System.out.println("1. Kamar 1, fasilitas .. .......\n" +
                "1. Kamar 1, fasilitas .. .......\n" +
                "1. Kamar 1, fasilitas .. .......\n" +
                "1. Kamar 1, fasilitas .. .......\n" +
                "1. Kamar 1, fasilitas .. .......\n" +
                "1. Kamar 1, fasilitas .. .......\n");
        cur++;
    }

    public static void editKamar(){

    }

    public static void tambahPenghuni(){

    }

    public static void riwayatCatatanPembayaran(){

    }
}
