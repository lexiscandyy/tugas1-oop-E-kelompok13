import model.Kamar;
import model.Pembayaran;
import model.Penghuni;
import repository.KamarRepository;
import repository.PembayaranRepository;
import utils.Utils;

import java.util.ArrayList;

public class Main {

    static KamarRepository kamarRepo = new KamarRepository();
    static PembayaranRepository pembayaranRepo = new PembayaranRepository();

    // ── Halaman menu (0=login, 1=utama, 2=kamar, 3=pembayaran) ──────────────
    static int halaman = 0;

    public static void main(String[] args) {
        while (true) {
            switch (halaman) {
                case 0 -> menuLogin();
                case 1 -> menuUtama();
                case 2 -> menuKamar();
                case 3 -> menuPembayaran();
                default -> halaman = 0;
            }
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MENU
    // ════════════════════════════════════════════════════════════════════════

    static void menuLogin() {
        System.out.println(
                "╔══════════════════════════════════════╗\n" +
                        "║          SISTEM KOST ADMIN           ║\n" +
                        "╠══════════════════════════════════════╣\n" +
                        "║  1. Masuk                            ║\n" +
                        "║  2. Keluar                           ║\n" +
                        "╚══════════════════════════════════════╝"
        );
        System.out.print("Pilihan: ");
        int input = Utils.bacaInt();
        switch (input) {
            case 1 -> halaman = 1;
            case 2 -> {
                System.out.println("Sampai jumpa!");
                System.exit(0);
            }
            default -> System.out.println("Pilihan tidak valid.\n");
        }
    }

    static void menuUtama() {
        System.out.println(
                "╔══════════════════════════════════════╗\n" +
                        "║              MENU UTAMA              ║\n" +
                        "╠══════════════════════════════════════╣\n" +
                        "║  1. Manajemen Kamar                  ║\n" +
                        "║  2. Manajemen Pembayaran             ║\n" +
                        "║  3. Kembali (Logout)                 ║\n" +
                        "╚══════════════════════════════════════╝"
        );
        System.out.print("Pilihan: ");
        int input = Utils.bacaInt();
        switch (input) {
            case 1 -> halaman = 2;
            case 2 -> halaman = 3;
            case 3 -> halaman = 0;
            default -> System.out.println("Pilihan tidak valid.\n");
        }
    }

    static void menuKamar() {
        System.out.println(
                "╔══════════════════════════════════════╗\n" +
                        "║           MANAJEMEN KAMAR            ║\n" +
                        "╠══════════════════════════════════════╣\n" +
                        "║  1. Tampilkan semua kamar            ║\n" +
                        "║  2. Tambah kamar                     ║\n" +
                        "║  3. Tambah penghuni                  ║\n" +
                        "║  4. Tambah fasilitas                 ║\n" +
                        "║  5. Atur harga kamar                 ║\n" +
                        "║  6. Hapus kamar                      ║\n" +
                        "║  7. Hapus penghuni                   ║\n" +
                        "║  8. Kembali                          ║\n" +
                        "╚══════════════════════════════════════╝"
        );
        System.out.print("Pilihan: ");
        int input = Utils.bacaInt();
        switch (input) {
            case 1 -> tampilkanSemuaKamar();
            case 2 -> tambahKamar();
            case 3 -> tambahPenghuni();
            case 4 -> tambahFasilitas();
            case 5 -> aturHarga();
            case 6 -> hapusKamar();
            case 7 -> hapusPenghuni();
            case 8 -> halaman = 1;
            default -> System.out.println("Pilihan tidak valid.\n");
        }
    }

    static void menuPembayaran() {
        System.out.println(
                "╔══════════════════════════════════════╗\n" +
                        "║         MANAJEMEN PEMBAYARAN         ║\n" +
                        "╠══════════════════════════════════════╣\n" +
                        "║  1. Tampilkan semua riwayat          ║\n" +
                        "║  2. Cari riwayat per kamar           ║\n" +
                        "║  3. Cari riwayat per penghuni        ║\n" +
                        "║  4. Tambah riwayat pembayaran        ║\n" +
                        "║  5. Hapus riwayat pembayaran         ║\n" +
                        "║  6. Kembali                          ║\n" +
                        "╚══════════════════════════════════════╝"
        );
        System.out.print("Pilihan: ");
        int input = Utils.bacaInt();
        switch (input) {
            case 1 -> tampilkanSemuaPembayaran();
            case 2 -> cariPembayaranPerKamar();
            case 3 -> cariPembayaranPerPenghuni();
            case 4 -> tambahPembayaran();
            case 5 -> hapusPembayaran();
            case 6 -> halaman = 1;
            default -> System.out.println("Pilihan tidak valid.\n");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  AKSI — KAMAR
    // ════════════════════════════════════════════════════════════════════════

    static void tampilkanSemuaKamar() {
        ArrayList<Kamar> list = kamarRepo.getSemuaKamar();
        if (list.isEmpty()) {
            System.out.println("Belum ada kamar yang terdaftar.\n");
            return;
        }
        System.out.println("\n=== DAFTAR KAMAR ===");
        for (Kamar k : list) {
            k.tampilkan();
        }
        System.out.println();
    }

    static void tambahKamar() {
        Kamar baru = kamarRepo.tambahKamar();
        System.out.printf("Sukses menambah Kamar No. %d%n%n", baru.getNomor());
    }

    static void tambahPenghuni() {
        System.out.print("Nomor kamar: ");
        int nomorKamar = Utils.bacaInt();

        System.out.print("Nama penghuni: ");
        String nama = Utils.bacaString(100);

        System.out.print("No HP penghuni: ");
        String noHP = Utils.bacaString(20);

        System.out.print("Tanggal masuk (dd-MM-yyyy): ");
        String tanggalMasuk = Utils.bacaString(20);

        if (nomorKamar == -1 || nama == null || noHP == null || tanggalMasuk == null) {
            System.out.println("Input tidak valid.\n");
            return;
        }

        try {
            Penghuni p = new Penghuni(nama, noHP, tanggalMasuk);
            if (kamarRepo.tambahPenghuni(nomorKamar, p)) {
                System.out.printf("Sukses menambah penghuni \"%s\" ke Kamar No. %d%n%n",
                        nama, nomorKamar);
            } else {
                System.out.println("Kamar tidak ditemukan.\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    static void tambahFasilitas() {
        System.out.print("Nomor kamar: ");
        int nomorKamar = Utils.bacaInt();

        System.out.print("Nama fasilitas: ");
        String fasilitas = Utils.bacaString(100);

        if (nomorKamar == -1 || fasilitas == null) {
            System.out.println("Input tidak valid.\n");
            return;
        }

        if (kamarRepo.tambahFasilitas(nomorKamar, fasilitas)) {
            System.out.printf("Sukses menambah fasilitas \"%s\" ke Kamar No. %d%n%n",
                    fasilitas, nomorKamar);
        } else {
            System.out.println("Kamar tidak ditemukan.\n");
        }
    }

    static void aturHarga() {
        System.out.print("Nomor kamar: ");
        int nomorKamar = Utils.bacaInt();

        System.out.print("Harga baru (angka, contoh: 1500000): ");
        long harga = Utils.bacaLong();

        if (nomorKamar == -1 || harga == -1) {
            System.out.println("Input tidak valid.\n");
            return;
        }

        try {
            if (kamarRepo.setHarga(nomorKamar, harga)) {
                System.out.printf("Sukses mengatur harga Kamar No. %d%n%n", nomorKamar);
            } else {
                System.out.println("Kamar tidak ditemukan.\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    static void hapusKamar() {
        System.out.print("Nomor kamar yang ingin dihapus: ");
        int nomorKamar = Utils.bacaInt();

        if (nomorKamar == -1) {
            System.out.println("Input tidak valid.\n");
            return;
        }

        if (kamarRepo.hapusKamar(nomorKamar)) {
            System.out.printf("Sukses menghapus Kamar No. %d%n%n", nomorKamar);
        } else {
            System.out.println("Kamar tidak ditemukan.\n");
        }
    }

    static void hapusPenghuni() {
        System.out.print("Nomor kamar: ");
        int nomorKamar = Utils.bacaInt();

        System.out.print("Nomor urut penghuni: ");
        int nomorUrut = Utils.bacaInt();

        if (nomorKamar == -1 || nomorUrut == -1) {
            System.out.println("Input tidak valid.\n");
            return;
        }

        if (kamarRepo.hapusPenghuni(nomorKamar, nomorUrut)) {
            System.out.printf("Sukses menghapus penghuni No. %d dari Kamar No. %d%n%n",
                    nomorUrut, nomorKamar);
        } else {
            System.out.println("Kamar atau nomor penghuni tidak ditemukan.\n");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  AKSI — PEMBAYARAN
    // ════════════════════════════════════════════════════════════════════════

    static void tampilkanSemuaPembayaran() {
        ArrayList<Pembayaran> list = pembayaranRepo.getSemuaPembayaran();
        if (list.isEmpty()) {
            System.out.println("Belum ada riwayat pembayaran.\n");
            return;
        }
        System.out.println("\n=== RIWAYAT PEMBAYARAN ===");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("Riwayat #%d%n", i + 1);
            list.get(i).tampilkan();
        }
        System.out.println();
    }

    static void cariPembayaranPerKamar() {
        System.out.print("Nomor kamar: ");
        int nomorKamar = Utils.bacaInt();
        if (nomorKamar == -1) { System.out.println("Input tidak valid.\n"); return; }

        ArrayList<Pembayaran> hasil = pembayaranRepo.cariPerKamar(nomorKamar);
        if (hasil.isEmpty()) {
            System.out.printf("Tidak ada riwayat untuk Kamar No. %d%n%n", nomorKamar);
            return;
        }
        System.out.printf("\n=== RIWAYAT KAMAR NO. %d ===%n", nomorKamar);
        for (Pembayaran p : hasil) p.tampilkan();
        System.out.println();
    }

    static void cariPembayaranPerPenghuni() {
        System.out.print("Nama penghuni: ");
        String nama = Utils.bacaString(100);
        if (nama == null) { System.out.println("Input tidak valid.\n"); return; }

        ArrayList<Pembayaran> hasil = pembayaranRepo.cariPerPenghuni(nama);
        if (hasil.isEmpty()) {
            System.out.printf("Tidak ada riwayat untuk penghuni \"%s\"%n%n", nama);
            return;
        }
        System.out.printf("\n=== RIWAYAT PENGHUNI: %s ===%n", nama);
        for (Pembayaran p : hasil) p.tampilkan();
        System.out.println();
    }

    static void tambahPembayaran() {
        System.out.print("Nomor kamar: ");
        int nomorKamar = Utils.bacaInt();

        System.out.print("Nama penghuni: ");
        String nama = Utils.bacaString(100);

        System.out.print("Tanggal (1-31): ");
        int tanggal = Utils.bacaInt();

        System.out.print("Bulan (1-12): ");
        int bulan = Utils.bacaInt();

        System.out.print("Tahun (2020-2030): ");
        int tahun = Utils.bacaInt();

        System.out.print("Jumlah pembayaran (angka): ");
        long jumlah = Utils.bacaLong();

        System.out.print("Status (LUNAS / BELUM LUNAS): ");
        String status = Utils.bacaString(20);

        if (nomorKamar == -1 || nama == null || tanggal == -1 ||
                bulan == -1 || tahun == -1 || jumlah == -1 || status == null) {
            System.out.println("Input tidak valid.\n");
            return;
        }

        try {
            Pembayaran p = new Pembayaran(nomorKamar, nama, tanggal, bulan, tahun, jumlah, status);
            pembayaranRepo.tambah(p);
            System.out.println("Sukses menambah riwayat pembayaran.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    static void hapusPembayaran() {
        tampilkanSemuaPembayaran();
        if (pembayaranRepo.size() == 0) return;

        System.out.print("Nomor riwayat yang ingin dihapus: ");
        int nomor = Utils.bacaInt();

        if (pembayaranRepo.hapus(nomor)) {
            System.out.printf("Sukses menghapus riwayat #%d%n%n", nomor);
        } else {
            System.out.println("Nomor riwayat tidak valid.\n");
        }
    }
}