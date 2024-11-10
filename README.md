# Aplikasi Konversi Suhu   
Tugas 2 - Muhammad Raihan Fadhillah 2210010404

## Daftar Isi
- [Deskripsi](#deskripsi)
- [Prerequisites](#prerequisites)
- [Fitur](#fitur)
- [Cara Menjalankan](#cara-menjalankan)
- [Dokumentasi](#dokumentasi)
- [Screenshots](#screenshots)
- [Contoh Penggunaan](#contoh-penggunaan)
- [Pembuat](#pembuat)

## Deskripsi
Aplikasi Konversi Suhu adalah program berbasis Java yang memungkinkan pengguna untuk mengonversi suhu dari satu satuan ke satuan lainnya, seperti Celsius, Fahrenheit, Kelvin, dan Reaumur. Aplikasi ini memiliki antarmuka pengguna grafis (GUI) yang sederhana dan intuitif, memudahkan pengguna dalam melakukan konversi suhu.

## Prerequisites
Sebelum menjalankan aplikasi ini, pastikan Anda telah menginstal:
- Java Development Kit (JDK) versi 8 atau yang lebih baru.
- IDE seperti IntelliJ IDEA, Eclipse, atau NetBeans untuk menjalankan dan mengembangkan aplikasi.

## Fitur   
1. Input suhu dari pengguna dalam bentuk teks.
2. Pilihan satuan asal suhu melalui combo box.
3. Pilihan satuan tujuan suhu melalui radio button.
4. Konversi suhu secara real-time saat pengguna memasukkan nilai atau mengubah pilihan satuan.
5. Menampilkan hasil konversi dengan format dua desimal.
6. Validasi input untuk memastikan hanya angka yang dapat dimasukkan.


## Cara Menjalankan
1. Clone atau Download Repository:
    - Clone repository ini atau download sebagai ZIP dan ekstrak.

2. Buka Proyek di IDE:
    - Buka IDE Anda dan import proyek Java yang telah diunduh.

3. Jalankan Aplikasi:
    - Jalankan kelas AplikasiKonversiSuhu dari IDE Anda.
  
## Dokumentasi
Method Utama
- Method konstruktor
``` java
 public AplikasiKonversiSuhu() {
        initComponents();
        txt_suhu.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            konversiSuhu();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            konversiSuhu();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            konversiSuhu();
        }
    });
        radio_celcius.addActionListener(e -> konversiSuhu());
        radio_fahrenheit.addActionListener(e -> konversiSuhu());
        radio_reamur.addActionListener(e -> konversiSuhu());
        radio_kelvin.addActionListener(e -> konversiSuhu());
        
        // Add action listener to combo box
        combo_asal.addActionListener(e -> konversiSuhu());
    }
```

- Method untuk konversi suhu
```java
private void konversiSuhu() {
    try {
        // Get the input temperature from the text field
        double suhu = Double.parseDouble(txt_suhu.getText().trim());

        // Check if the combo box has a selected item
        if (combo_asal.getSelectedItem() == null) {
            txt_hasil.setText("Silakan pilih satuan asal.");
            return;
        }

        // Get the selected original unit from the combo box
        String asal = combo_asal.getSelectedItem().toString();

        // Determine the target unit based on the selected radio button
        String tujuan = "";
        if (radio_celcius.isSelected()) {
            tujuan = "Celsius";
        } else if (radio_fahrenheit.isSelected()) {
            tujuan = "Fahrenheit";
        } else if (radio_kelvin.isSelected()) {
            tujuan = "Kelvin";
        } else if (radio_reamur.isSelected()) {
            tujuan = "Reaumur";
        } else {
            txt_hasil.setText("Silakan pilih satuan tujuan.");
            return;
        }

        double hasil = 0.0;

        // Perform conversion based on the original and target units
        if (asal.equals("Celcius")) {
            switch (tujuan) {
                case "Fahrenheit": hasil = (suhu * 9 / 5) + 32; break;
                case "Kelvin": hasil = suhu + 273.15; break;
                case "Reaumur": hasil = suhu * 4 / 5; break;
                case "Celsius": hasil = suhu; break;
            }
        } else if (asal.equals("Fahrenheit")) {
            switch (tujuan) {
                case "Celsius": hasil = (suhu - 32) * 5 / 9; break;
                case "Kelvin": hasil = (suhu - 32) * 5 / 9 + 273.15; break;
                case "Reaumur": hasil = (suhu - 32) * 4 / 9; break;
                case "Fahrenheit": hasil = suhu; break;
            }
        } else if (asal.equals("Kelvin")) {
            switch (tujuan) {
                case "Celsius": hasil = suhu - 273.15; break;
                case "Fahrenheit": hasil = (suhu - 273.15) * 9 / 5 + 32; break;
                case "Reaumur": hasil = (suhu - 273.15) * 4 / 5; break;
                case "Kelvin": hasil = suhu; break;
            }
        } else if (asal.equals("Reamur")) {
            switch (tujuan) {
                case "Celsius": hasil = suhu * 5 / 4; break;
                case "Fahrenheit": hasil = (suhu * 9 / 4) + 32; break;
                case "Kelvin": hasil = suhu * 5 / 4 + 273.15; break;
                case "Reaumur": hasil = suhu; break;
            }
        }

        // Display the result in the result text field
        txt_hasil.setText(String.format("%.2f", hasil));

        } catch (NumberFormatException e) {
        // Display an error message if the input is invalid
        txt_hasil.setText("Inputan tidak valid");
        }
    }
```
- Method untuk menghandle inputan hanya angka
``` java
private void txt_suhuKeyTyped(java.awt.event.KeyEvent evt) {                                  
        // TODO add your handling code here:
        char input = evt.getKeyChar();
        if (!Character.isDigit(input)) {
            evt.consume();  // Mencegah input selain angka
        }
    }            
```

## Screenshots
![Screenshot 2024-11-10 170716](https://github.com/user-attachments/assets/eef91c54-e99c-49ae-9f55-99f29e4ba688)



## Contoh Penggunaan

1. **Memasukkan Angka**:

   - Masukkan suhu yang ingin Anda konversi di kolom "Masukkan suhu".
2. **Pilih Satuan Asal**:

   - Pilih satuan asal dari combo box (misalnya, "Celsius").

3. **Pilih Satuan Tujuan**: 
   - Pilih satuan tujuan menggunakan radio button (misalnya, "Fahrenheit").

4. **Klik Tombol**: 
   - Klik tombol 'Konversi!', dan hasil konversi akan ditampilkan di kolom "Hasil".
## Pembuat

- Nama : Muhammad Raihan Fadhillah
- NPM : 2210010404

