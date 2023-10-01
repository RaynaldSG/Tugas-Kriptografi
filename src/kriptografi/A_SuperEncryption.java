package kriptografi;

public class A_SuperEncryption {
    public static final int ENCODE = 0;
    public static final int DECODE = 1;
    
    private String plainText = "";
    private String cipherText = "";
    private int mode;
    private int key;

    A_RailFence algoRail = null;
    A_Scytale algoScytale = null;
    A_XOR algoXOR = null;
    
    public A_SuperEncryption(String text, int key, int mode) {
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
        algoScytale = new A_Scytale(plainText, key, mode);
        cipherText = algoScytale.A_encode();
        algoRail = new A_RailFence(cipherText, key, mode);
        cipherText = algoRail.A_encode();
        algoXOR = new A_XOR(cipherText, String.valueOf(key), mode);
        cipherText = algoXOR.A_encode();

        return cipherText;
    }
    
    public String A_decode(){
        algoXOR = new A_XOR(cipherText, String.valueOf(key), mode);
        plainText = algoXOR.A_decode();
        algoRail = new A_RailFence(plainText, key, mode);
        plainText = algoRail.A_decode();
        algoScytale = new A_Scytale(plainText, key, mode);
        plainText = algoScytale.A_decode();
        
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

    public int getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public A_RailFence getAlgoFence() {
        return algoRail;
    }

    public A_Scytale getAlgoScy() {
        return algoScytale;
    }

    public A_XOR getAlgoXOR() {
        return algoXOR;
    }
    
}
