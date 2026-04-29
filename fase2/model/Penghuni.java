package model;

public class Penghuni {
    private String nama;
    private String noHP;
    private String tanggalMasuk; // format: dd-MM-yyyy

    public Penghuni(String nama, String noHP, String tanggalMasuk) {
        if (nama == null || nama.isBlank())
            throw new IllegalArgumentException("Nama penghuni tidak boleh kosong.");
        if (noHP == null || noHP.isBlank())
            throw new IllegalArgumentException("No HP tidak boleh kosong.");
        if (tanggalMasuk == null || tanggalMasuk.isBlank())
            throw new IllegalArgumentException("Tanggal masuk tidak boleh kosong.");

        this.nama = nama;
        this.noHP = noHP;
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getNama() { return nama; }
    public String getNoHP() { return noHP; }
    public String getTanggalMasuk() { return tanggalMasuk; }

    @Override
    public String toString() {
        return nama + " | HP: " + noHP + " | Masuk: " + tanggalMasuk;
    }
}