/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helloworld;
import java.util.Scanner;
/**
 *
 * @author Choirul Adji
 */
public class Bioskop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ROWS = 5; // jumlah baris
        int COLUMNS = 5; // jumlah kolom
        String[][] kursi = new String[ROWS][COLUMNS];
        boolean[][] isVIP = new boolean[ROWS][COLUMNS];

        // Inisialisasi kursi
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                kursi[i][j] = "kosong";
                isVIP[i][j] = (i == 0 && j < 2); // Kursi VIP di baris pertama kolom 0 dan 1
            }
        }

        while (true) {
            System.out.println("    BIOSKOP YUPIEN   ");
            System.out.println("=====================");
            System.out.println("\nMenu");
            System.out.println("1. Tampilkan Kursi");
            System.out.println("2. Isi kursi");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();

            if (opsi == 1) {
                tampilkanKursi(kursi, isVIP);
            } else if (opsi == 2) {
                System.out.print("Masukkan baris (0-4): ");
                int baris = scanner.nextInt();
                System.out.print("Masukkan kolom (0-4): ");
                int kolom = scanner.nextInt();

                if (baris >= 0 && baris < ROWS && kolom >= 0 && kolom < COLUMNS) {
                    if (kursi[baris][kolom].equals("kosong")) {
                        System.out.print("Masukkan nama penonton: ");
                        String namaPenonton = scanner.next();
                        kursi[baris][kolom] = namaPenonton;
                        System.out.println("Kursi berhasil diisi!");
                    } else {
                        System.out.println("Kursi sudah terisi!");
                    }
                } else {
                    System.out.println("Indeks tidak valid!");
                }
            } else if (opsi == 3) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Opsi tidak valid!");
            }
        }

        scanner.close();
    }

    public static void tampilkanKursi(String[][] kursi, boolean[][] isVIP) {
        System.out.println("Status Kursi:");
        for (int i = 0; i < kursi.length; i++) {
            for (int j = 0; j < kursi[i].length; j++) {
                if (isVIP[i][j]) {
                    System.out.print("[VIP] ");
                }
                String status = kursi[i][j].equals("kosong") ? "kosong" : kursi[i][j];
                String color = kursi[i][j].equals("kosong") ? "putih" : "merah"; // Putih untuk kosong, Merah untuk terisi
                System.out.print(status+ " (" + color + ")\t");
            }
            System.out.println();
        }
    }
}

    
    

