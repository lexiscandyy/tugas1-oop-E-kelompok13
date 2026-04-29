import java.util.*;
import java.io.*;

public class Main {
    public static int cur = 0;
    static Kamar kamar = new Kamar();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg) {

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

                "╔══════════════════════════════════════╗\n" +
                "║         MANAJEMEN PEMBAYARAN         ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║  1. Riwayat pembayaran penghuni      ║\n" +
                "║  2. Kembali                          ║\n" +
                "╚══════════════════════════════════════╝",
        };

        while (true) {
            System.out.println("\n" + listMenu[cur]);
            int input = inputAngka("Pilih menu: ");

            if (cur == 0) {
                if (input == 1) {
                    cur++;
                } else if (input == 2) {
                    System.out.println("Program selesai.");
                    return;
                } else {
                    System.out.println("Input tidak valid!");
                }

            } else if (cur == 1) {
                if (input == 1) {
                    cur++;
                } else if (input == 2) {
                    cur += 2;
                } else if (input == 3) {
                    cur--;
                } else {
                    System.out.println("Input tidak valid!");
                }

            } else if (cur == 2) { // manajemen kamar
                switch (input) {
                    case 1:
                        tampilkanKamar();
                        break;
                    case 2:
                        tambahKamar();
                        break;
                    case 3:
                        tambahPenghuni();
                        break;
                    case 4:
                        tambahFasilitas();
                        break;
                    case 5:
                        aturHarga();
                        break;
                    case 6:
                        hapusKamar();
                        break;
                    case 7:
                        hapusPenghuni();
                        break;
                    case 8:
                        cur--;
                        break;
                    default:
                        System.out.println("Input tidak valid!");
                }

            } else if (cur == 3) {
                if (input == 2) {
                    cur -= 2;
                } else {
                    System.out.println("Menu pembayaran belum tersedia.");
                }
            }
        }
    }

    public static int inputAngka(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = Integer.parseInt(sc.nextLine());

                if (angka <= 0) {
                    System.out.println("Input harus lebih dari 0!");
                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    public static String inputTeks(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = sc.nextLine().trim();

            if (teks.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                continue;
            }

            return teks;
        }
    }

    public static void tampilkanKamar() {
        ArrayList<ArrayList<String>> listKamar = kamar.getKamar();
        ArrayList<ArrayList<String>> listPenghuni = kamar.getPenghuni();
        ArrayList<Boolean> isTerisi = kamar.getIsTerisi();
        ArrayList<String> listHarga = kamar.getHarga();

        if (listKamar.size() == 0) {
            System.out.println("Belum ada kamar tersedia.");
            return;
        }

        for (int i = 0; i < listKamar.size(); i++) {
            int idx = i + 1;

            System.out.println("\nKamar no. " + idx);
            System.out.println("Harga perbulan: " + listHarga.get(i));
            System.out.println("Fasilitas:");

            if (listKamar.get(i).size() == 0) {
                System.out.println("- Belum ada fasilitas");
            } else {
                for (int j = 0; j < listKamar.get(i).size(); j++) {
                    System.out.println((j + 1) + ". " + listKamar.get(i).get(j));
                }
            }

            System.out.println("Status: " + (isTerisi.get(i) ? "Terisi" : "Belum terisi"));

            if (!isTerisi.get(i)) continue;

            System.out.println("Penghuni:");
            if (listPenghuni.get(i).size() == 0) {
                System.out.println("- Tidak ada penghuni");
            } else {
                for (int j = 0; j < listPenghuni.get(i).size(); j++) {
                    System.out.println((j + 1) + ". " + listPenghuni.get(i).get(j));
                }
            }
        }
    }

    public static void tambahKamar() {
        kamar.addKamar();
        System.out.println("Sukses menambahkan kamar baru.");
    }

    public static void tambahPenghuni() {
        int nomorKamar = inputAngka("Masukkan nomor kamar: ");
        String namaPenghuni = inputTeks("Masukkan nama penghuni: ");

        if (!kamar.addPenghuni(nomorKamar, namaPenghuni)) {
            System.out.println("Input tidak valid. (Nomor kamar tidak ada)");
        } else {
            System.out.println("Penghuni berhasil ditambahkan.");
        }
    }

    public static void tambahFasilitas() {
        int nomorKamar = inputAngka("Masukkan nomor kamar: ");
        String namaFasilitas = inputTeks("Masukkan nama fasilitas: ");

        if (!kamar.addFasilitas(nomorKamar, namaFasilitas)) {
            System.out.println("Input tidak valid. (Nomor kamar tidak ada)");
        } else {
            System.out.println("Fasilitas berhasil ditambahkan.");
        }
    }

    public static void aturHarga() {
        int nomorKamar = inputAngka("Masukkan nomor kamar: ");
        String harga = inputTeks("Masukkan harga baru: ");

        if (!kamar.setHarga(nomorKamar, harga)) {
            System.out.println("Input tidak valid. (Nomor kamar tidak ada / harga salah)");
        } else {
            System.out.println("Harga berhasil diperbarui.");
        }
    }

    public static void hapusKamar() {
        int nomorKamar = inputAngka("Masukkan nomor kamar: ");

        if (!kamar.removeKamar(nomorKamar)) {
            System.out.println("Input tidak valid. (Nomor kamar tidak ada)");
        } else {
            System.out.println("Kamar berhasil dihapus.");
        }
    }

    public static void hapusPenghuni() {
        int nomorKamar = inputAngka("Masukkan nomor kamar: ");
        int nomorPenghuni = inputAngka("Masukkan nomor penghuni: ");

        if (!kamar.removePenghuni(nomorKamar, nomorPenghuni)) {
            System.out.println("Input tidak valid. (Nomor kamar / penghuni tidak ada)");
        } else {
            System.out.println("Penghuni berhasil dihapus.");
        }
    }
}
