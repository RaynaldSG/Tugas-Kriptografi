/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kriptografi;


/**
 *
 * @author Raynald Krisnawan
 */
public class A_XOR {
    public static final int ENCODE = 0;
    public static final int DECODE = 1;
    
    private String plainText = "";
    private String cipherText = "";
    private int mode;
    private char key;

    public A_XOR(String text, char key, int mode) {
        this.key = key;
        this.mode = mode;
        if (mode == 0) {
            this.plainText = text.toUpperCase();
        }
        else{
            this.cipherText = text.toUpperCase();
        }
    }
    
    public String A_encode(){
        int charASCII;
        int keyASCII;
        int encodeASCII;
        
        keyASCII = (int)key;
        for(int i = 0; i < plainText.length(); i++){
            charASCII = (int)plainText.charAt(i);
            encodeASCII = charASCII ^ keyASCII;
            this.cipherText = this.cipherText + (char)encodeASCII;
        }
        return cipherText;
    }
    
    public String A_decode(){
        int charASCII;
        int keyASCII;
        int encodeASCII;
        
        keyASCII = (int)key;
        for(int i = 0; i < cipherText.length(); i++){
            charASCII = (int)cipherText.charAt(i);
            encodeASCII = charASCII ^ keyASCII;
            this.plainText = this.plainText + (char)encodeASCII;
        }
        return plainText;
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

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }
    
}
