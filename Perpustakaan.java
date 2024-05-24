import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Perpustakaan {
    private File file;

    public Perpustakaan(String filePath) {
        this.file = new File(filePath);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println(" File baru berhasil dibuat: " + filePath);
                }else {
                    System.out.println("Gagal membuat file baru: " + filePath);
                }
            }
        }catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membuat file: " + e.getMessage());
        }
    }

    public void tambahBuku(Buku buku) {
        try (FileWriter writer = new FileWriter(file, true)) {
            if (file.canWrite()) {
                writer.write(buku.toString() + "\n");
                System.out.println("Buku berhasil ditambahkan");
            }else {
                System.out.println("Tidak dapat menulis ke file.");
            }
        }catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menambah buku: " + e.getMessage());
        }
    }

    public void lihatBuku() {
        try (Scanner scanner = new Scanner(file)) {
            if (file.canRead()) {
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    Buku buku = Buku.fromString(data);
                    System.out.println("Judul: " + buku.judul + ", Pengarang: " + buku.pengarang + ", Peminjam: " + buku.peminjam);
                }
            } else {
                System.out.println("Tidak dapat membaca file atau file tidak ada.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca buku: " + e.getMessage());
        }
    }

    public void hapusData() {
        try {
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Data buku berhasil dihapus.");
                } else {
                    System.out.println("Gagal menghapus data buku.");
                }
            } else {
                System.out.println("File tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus data buku: " + e.getMessage());
        }
    }
}
