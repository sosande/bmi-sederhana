# Kalkulator BMI (IMT) - JavaFX

Aplikasi desktop sederhana untuk menghitung **Indeks Massa Tubuh (IMT / BMI)**,
dibuat dengan **JavaFX** dan **FXML**, dengan tampilan yang bisa diedit di **Scene Builder**.
Cocok sebagai proyek belajar JavaFX untuk pemula.

## Fitur
- Menghitung BMI dari berat badan (kg) dan tinggi badan (cm)
- Menampilkan kategori: Kurus, Normal, Gemuk, atau Obesitas
- Menerima desimal dengan titik atau koma (`65.5` atau `65,5`)
- Tombol **Hitung** dan **Reset**, serta tekan **Enter** untuk menghitung
- Pesan error jika kolom kosong, bukan angka, atau bernilai 0

## Rumus dan kategori

```
BMI = berat (kg) / (tinggi (m) x tinggi (m))
```

| BMI | Kategori |
|---|---|
| kurang dari 18.5 | Kurus |
| 18.5 sampai 24.9 | Normal |
| 25 sampai 29.9 | Gemuk |
| 30 atau lebih | Obesitas |

Kategori mengikuti standar WHO. Hasil ini hanya perkiraan dan bukan diagnosis medis.

## Struktur proyek

```
bmi-sederhana/
├── pom.xml                                  # Pengaturan Maven (mengunduh JavaFX otomatis)
├── nbactions.xml                            # Membuat tombol Run (F6) NetBeans menjalankan aplikasi
└── src/main/
    ├── java/bmi/
    │   ├── Main.java                        # Pintu masuk aplikasi
    │   └── BmiController.java               # Logika perhitungan BMI
    └── resources/bmi/
        └── bmi.fxml                         # Tampilan (diedit dengan Scene Builder)
```

## Kebutuhan
- JDK 17 atau lebih baru
- Apache NetBeans 17 atau lebih baru (Maven sudah bawaan)
- Scene Builder (opsional, untuk mengedit tampilan): https://gluonhq.com/products/scene-builder/
- Koneksi internet saat pertama kali dijalankan (untuk mengunduh JavaFX)

## Cara menjalankan di NetBeans
1. Clone atau unduh repositori ini.
2. Buka NetBeans, pilih **File > Open Project**, lalu pilih folder `bmi-sederhana`.
3. Tekan **F6** (atau klik tombol Run).

Alternatif lewat terminal:
```bash
mvn javafx:run
```

## Mengedit tampilan dengan Scene Builder
1. Di NetBeans: **Tools > Options > Java > JavaFX**, isi **Scene Builder Home**.
2. Di panel Projects buka `Other Sources > src/main/resources > bmi`.
3. Klik kanan `bmi.fxml`, pilih **Open**.
4. Edit, simpan dengan **Ctrl+S**, lalu jalankan ulang aplikasi.

### Nama yang harus cocok
| Di Scene Builder | Di `BmiController.java` |
|---|---|
| fx:id `txtBerat` | `private TextField txtBerat;` |
| fx:id `txtTinggi` | `private TextField txtTinggi;` |
| fx:id `lblHasil` | `private Label lblHasil;` |
| On Action `#hitung` | `public void hitung()` |
| On Action `#reset` | `public void reset()` |

Jika nama tidak cocok, aplikasi bisa error atau tombol tidak bereaksi.
Lihat jendela **Output** di NetBeans untuk pesan peringatan.

## Pemecahan masalah
- **Tombol ditekan tapi tidak ada hasil**: lihat jendela Output. Jika muncul tulisan
  "PERINGATAN: fx:id ... tidak cocok", periksa tabel di atas.
- **Perubahan tidak terlihat**: klik kanan project, pilih **Clean and Build**, lalu jalankan lagi.
- **Error versi Java**: pastikan NetBeans memakai JDK 17+ (klik kanan project > Properties > Build > Compile).

## Lisensi
Bebas dipakai untuk belajar. Tambahkan file `LICENSE` jika ingin menentukan lisensi.
