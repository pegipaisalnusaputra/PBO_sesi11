import java.io.*;
import java.util.Scanner;

class Buku {
    String judul;
    String pengarang;
    boolean peminjam;

    public Buku (String judul, String pengarang, boolean peminjam) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.peminjam = peminjam;
    }

    @Override
    public String toString() {
        return judul + "," + pengarang + "," + peminjam;
    }

    public static Buku fromString(String data) {
        String[] parts = data.split(",");
        return new Buku (parts[0], parts[1], Boolean.parseBoolean(parts[2]));
    }
}