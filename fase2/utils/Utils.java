package utils;

import java.util.Scanner;

public class Utils {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Membaca satu baris input sebagai bilangan bulat positif.
     * Mengembalikan -1 jika input tidak valid atau melebihi batas panjang.
     */
    public static int bacaInt() {
        String str = sc.nextLine().trim();
        if (str.isEmpty() || str.length() > 10) return -1;
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Membaca satu baris input sebagai bilangan bulat panjang (long).
     * Mengembalikan -1 jika input tidak valid.
     */
    public static long bacaLong() {
        String str = sc.nextLine().trim();
        if (str.isEmpty() || str.length() > 15) return -1;
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Membaca satu baris input sebagai String.
     * Mengembalikan null jika melebihi batas panjang atau kosong.
     */
    public static String bacaString(int maxLen) {
        String str = sc.nextLine().trim();
        if (str.isEmpty() || str.length() > maxLen) return null;
        return str;
    }

    /** Menampilkan separator baris. */
    public static void garis() {
        System.out.println("──────────────────────────────────────");
    }
}