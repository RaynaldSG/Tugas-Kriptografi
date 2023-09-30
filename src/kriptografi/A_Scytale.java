package kriptografi;

public class A_Scytale {
    public static final int ENCODE = 0;
    public static final int DECODE = 1;
    
    private String plainText = "";
    private String cipherText = "";
    private int mode;
    private int key;

    public A_Scytale(String text, int key, int mode) {
        this.key = key;
        this.mode = mode;
        text = text.replace(" ", "");
        if (mode == 0) {
            this.plainText = text.toUpperCase();;
        }
        else{
            this.cipherText = text.toUpperCase();;
        }
        
    }

    public String A_encode(){
        char[][] tabel = new char[(int) Math.ceil(plainText.length()/(key*1.0f))][key];
        int text_lenght_counter = 0;

        for(int i = 0; i < (int) Math.ceil(plainText.length()/(key*1.0f)); i++){
            for(int j = 0; j < key; j++){
                if(text_lenght_counter == plainText.length()){
                    tabel[i][j] = 'Z';
                }
                else{
                    tabel[i][j] = plainText.charAt(text_lenght_counter);
                    text_lenght_counter++;
                }
            }
        }

        // Tes
        // for(int i = 0; i < (int) Math.ceil(plainText.length()/(key*1.0f)); i++){
        //     for(int j = 0; j < key; j++){
        //         System.out.print(tabel[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        text_lenght_counter = 0;
        for(int i = 0; i < key; i++){
            for(int j = 0; j < (int) Math.ceil(plainText.length()/(key*1.0f)); j++){
                if(tabel[j][i] == 0){
                    continue;
                }
                cipherText = cipherText + tabel[j][i];
            }
        }

        return cipherText;
    }
    
    public String A_decode(){
        char[][] tabel = new char[(int) Math.ceil(cipherText.length()/(key*1.0f))][key];
        int text_lenght_counter = 0;


        for(int i = 0; i < key; i++){
            for(int j = 0; j < (int) Math.ceil(cipherText.length()/(key*1.0f)); j++){
                tabel[j][i] = cipherText.charAt(text_lenght_counter);
                text_lenght_counter++;
                if(text_lenght_counter >= cipherText.length()){
                    break;
                }
            }
        }

        // Test
        // text_lenght_counter = 0;
        // for(int i = 0; i < (int) Math.ceil(cipherText.length()/(key*1.0f)); i++){
        //     for(int j = 0; j < key; j++){
        //         System.out.print(tabel[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(cipherText.length());

        text_lenght_counter = 0;
        for(int i = 0; i < (int) Math.ceil(cipherText.length()/(key*1.0f)); i++){
            for(int j = 0; j < key; j++){
                plainText = plainText + tabel[i][j];
                text_lenght_counter++;
                // if(text_lenght_counter == cipherText.length()){
                //     break;
                // }
            }
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

    public int getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }
}
