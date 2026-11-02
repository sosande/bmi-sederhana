package bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BmiController {

    // Nama variabel HARUS sama dengan fx:id di Scene Builder
    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtTinggi;

    @FXML
    private Label lblHasil;

    // Dipanggil otomatis saat tampilan selesai dimuat.
    // Berguna untuk mengecek apakah fx:id di Scene Builder sudah cocok.
    @FXML
    public void initialize() {
        if (txtBerat == null || txtTinggi == null || lblHasil == null) {
            System.out.println("PERINGATAN: fx:id di bmi.fxml tidak cocok dengan BmiController!");
            System.out.println("Pastikan fx:id: txtBerat, txtTinggi, lblHasil");
        }
    }

    // Nama method HARUS sama dengan "On Action" di Scene Builder (#hitung)
    @FXML
    public void hitung() {
        System.out.println("Tombol Hitung ditekan"); // muncul di jendela Output NetBeans

        String teksBerat = txtBerat.getText().trim().replace(',', '.');
        String teksTinggi = txtTinggi.getText().trim().replace(',', '.');

        // Cek kolom kosong
        if (teksBerat.isEmpty() || teksTinggi.isEmpty()) {
            lblHasil.setText("Isi berat dan tinggi dulu");
            return;
        }

        try {
            double berat = Double.parseDouble(teksBerat);               // kg
            double tinggi = Double.parseDouble(teksTinggi) / 100;       // cm -> meter

            if (berat <= 0 || tinggi <= 0) {
                lblHasil.setText("Angka harus lebih dari 0");
                return;
            }

            // Rumus BMI = berat / (tinggi x tinggi)
            double bmi = berat / (tinggi * tinggi);

            String kategori;
            if (bmi < 18.5) {
                kategori = "Kurus";
            } else if (bmi < 25) {
                kategori = "Normal";
            } else if (bmi < 30) {
                kategori = "Gemuk";
            } else {
                kategori = "Obesitas";
            }

            lblHasil.setText(String.format("BMI: %.1f (%s)", bmi, kategori));

        } catch (NumberFormatException e) {
            // Terjadi kalau kolom berisi huruf
            lblHasil.setText("Masukkan angka yang benar (contoh: 65.5)");
        }
    }

    // Mengosongkan semua isian
    @FXML
    public void reset() {
        txtBerat.clear();
        txtTinggi.clear();
        lblHasil.setText("Hasil akan tampil di sini");
        txtBerat.requestFocus();
    }
}
