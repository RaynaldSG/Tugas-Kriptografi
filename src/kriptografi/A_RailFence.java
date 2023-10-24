package kriptografi;

public class A_RailFence {
    public static final int ENCODE = 0;
    public static final int DECODE = 1;

    private String plainText = "";
    private String cipherText = "";
    private int mode;
    private int key;
    private char[][] stepTable;

    public A_RailFence(String text, int key, int mode) {
        this.key = key;
        this.mode = mode;
        text = text.replace(" ", "");
        if (mode == 0) {
            this.plainText = text.toUpperCase();
        } else {
            this.cipherText = text.toUpperCase();
        }

    }

    public String A_encode() {
        char[][] tabel = new char[plainText.length()][key];
        int rowFence = 0;
        boolean turn = false;

        for (int i = 0; i < plainText.length(); i++) {
            if (rowFence < key && !turn) {
                tabel[i][rowFence] = plainText.charAt(i);
                rowFence++;
            } else {
                if (rowFence == key) {
                    rowFence--;
                }
                rowFence--;
                if (rowFence < 0) {
                    rowFence = 0;
                }
                tabel[i][rowFence] = plainText.charAt(i);
                turn = true;
                if (rowFence == 0) {
                    turn = false;
                    rowFence++;
                }
            }
        }

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < plainText.length(); j++) {
                if (tabel[j][i] != 0) {
                    cipherText = cipherText + tabel[j][i];
                }
            }
        }
        setTable(tabel);
        return cipherText;
    }

    public String A_decode() {
        char[][] tabel = new char[cipherText.length()][key];
        int rowFence = 0; //kedalaman row
        int textCounter = 0; //menentukan indeks text
        int j;
        boolean checker; //untuk mengecek mode zig zag
        int jCol = 0; //digunakan untuk melakukan perhitungan jarak cell selanjutnya yang harus diisi
        boolean turn = false; //digunakan untuk menentukan apakah arah baca keatas atau kebawah 

        for (int i = 0; i < key; i++) { //pembuatan tabel
            checker = false;

            if (i == key - 1 || i == 0 || key == 1) { //mengecek baris paling atas dan paling bawah
                for (j = rowFence; j < cipherText.length(); j = j + (key) * 2 - 2) { 
                    if (textCounter >= cipherText.length()) { //melakukan pengecekan apabila baris sudah terisi semua
                        break;
                    }
                    tabel[j][i] = cipherText.charAt(textCounter); //isi tabel
                    textCounter++;
                    if(key == 1){ //bug handler
                        j++;
                    }
                }
            } else {
                for (j = rowFence; j < cipherText.length(); j = j + jCol) {
                    if (!checker) {
                        tabel[j][i] = cipherText.charAt(textCounter);
                        textCounter++;
                        jCol = (key - i) * 2 - 2;
                        checker = true;
                    } else if (checker) {
                        tabel[j][i] = cipherText.charAt(textCounter);
                        textCounter++;
                        jCol = i * 2;
                        checker = false;
                    }
                }
            }

            rowFence = key - (key - (i + 1)); //menghitung kedalaman baris
        }

        rowFence = 0;
        for (int i = 0; i < cipherText.length(); i++) { //membaca tabel
            if (rowFence < key && !turn) {
                plainText = plainText + tabel[i][rowFence];
                rowFence++;
            } else {
                if (rowFence == key) {
                    rowFence--;
                }
                if (key == 1) {
                    plainText = plainText + tabel[i][rowFence];
                }
                else{
                    rowFence--;
                    plainText = plainText + tabel[i][rowFence];
                }
                turn = true;
                if (rowFence == 0) {
                    turn = false;
                    rowFence++;
                }
            }
        }
        setTable(tabel);
        return plainText;
    }

    private void setTable(char[][] stepTable) {
        this.stepTable = stepTable;
    }

    public char[][] getTabel() {
        // Test
        // for(int i = 0; i < key; i++){
        // for(int j = 0; j < plainText.length(); j++){
        // if(stepTable[j][i] != 0){
        // System.out.print(stepTable[j][i] + "|");
        // }
        // else{
        // System.out.print(" |");
        // }
        // }
        // System.out.println();
        // }
        return stepTable;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }
}
