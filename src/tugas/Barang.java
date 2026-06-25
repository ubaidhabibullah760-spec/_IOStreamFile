package tugas;

public class Barang {
    // Atribut barang
    private String nama;
    private double harga;
    private int stok;

    // Constructor lengkap
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mengubah objek menjadi format teks sebaris untuk disimpan berkas
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Mengembalikan keterangan barang untuk tampilan layar
    public String info() {
        return nama + " - Rp" + harga + " (Stok: " + stok + ")";
    }
}