import java.util.List;
import java.util.ArrayList;
public class KamarManager {
    private List<Kamar> listKamar = new ArrayList<>();
    public void tambahKamar() {
        int nomorBaru = listKamar.size() + 1;
        listKamar.add(new Kamar(nomorBaru));
        Kamar kamarBaru = new Kamar(nomorBaru);
        System.out.println("Sukses menambahkan kamar baru nomor: " + nomorBaru);
    }
    public Kamar getKamar(int nomorKamar) {
        if (nomorKamar > 0 && nomorKamar <= listKamar.size()) {
            return listKamar.get(nomorKamar - 1);
        }
        return null;
    }
    public List<Kamar> getListKamar() {
        return listKamar;
    }
    public Kamar cariKamar(int nomorKamar) {
        if (nomorKamar > 0 && nomorKamar <= listKamar.size()) {
            return listKamar.get(nomorKamar - 1);
        }
        return null;
    }
    public boolean hapusKamar(int nomorKamar) {
        if (nomorKamar <= 0 || nomorKamar > listKamar.size()) {
            return false;
        }
        return true;
    }
}
