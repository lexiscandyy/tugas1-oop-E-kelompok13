import java.util.Scanner;

/**
 * Class utils untuk keperluan dasar seperti validasi input, dalam prpoyek ini hanya dibutuhkan validasi input int dan string
 * @author Rama
 */
public class Utils{

    /**
     * Membaca input String menggunakan Scanner dengan method nextLine dan sudah dibatasi supaya tidak integer overflow
     * Menggunakan metode pengecekan kode ascii untuk memvalidasi setiap kode ascii pada setiap karakter dalam string yang terbaca
     * Hanya unsigned int ( > 0 )
     * @return Mengembalikan nilai unsigned integer yang valid atau mengembalikan -1 jika tidak valid
     */
    public int ScanInt(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        System.out.println(">> tekan enter <<");
//        sc.nextLine();
        if(str.isEmpty()) return -1;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') return -1;
        }

        if(str.length() > 10) return -1;
        return Integer.parseInt(str);
    }

    /**
     * Membaca input String menggunakan Scanner dengan method nextLine
     * @param lenLimit Membatasi jumlah karakter yang di input oleh user
     * @return Mengembalikan nilai String jika memenuhi syarat, mengembalikan null jika sebaliknya
     */
    public String ScanString(int lenLimit){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.isEmpty()) return null;
//        System.out.println(">> tekan enter <<");
//        sc.nextLine();
        return (str.length() > lenLimit ? null : str);
    }
}
