/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import kriptografi.A_RailFence;
import kriptografi.A_Scytale;
import kriptografi.A_SuperEncryption;
import kriptografi.A_XOR;
import model.T_Rail;
import model.T_Scytale;
import model.T_XOR;
import view.UI_Kriptografi;

/**
 *
 * @author Raynald Krisnawan
 */
public class C_Kripto {
    public static final String ALGO_XOR = "XOR";
    public static final String ALGO_RAIL = "RAIL";
    public static final String ALGO_SCYTALE = "SCYTALE";
    public static final String ALGO_SUPER = "SUPER";
    public static final int ENCODE = 0;
    public static final int DECODE = 1;
    
    UI_Kriptografi UI;
    A_XOR algoXOR = null;
    A_RailFence algoRail = null;
    A_Scytale algoScytale = null;
    A_SuperEncryption algoSuper = null;
    String algorithm;
    int mode;

    public C_Kripto(UI_Kriptografi UI) {
        this.UI = UI;
        this.algorithm = UI.algorithm;
        setTitle();
    }
    
    public void setTitle(){
        switch (algorithm) {
            case ALGO_XOR:
                UI.getL_Judul().setText("ALGORITMA XOR");
                break;
            case ALGO_RAIL:
                UI.getL_Judul().setText("ALGORITMA RAIL FENCE");
                break;
            case ALGO_SCYTALE:
                UI.getL_Judul().setText("ALGORITMA SCYTALE");
                break;
            case ALGO_SUPER:
                UI.getL_Judul().setText("ALGORITMA SUPER");
                break;
            default:
                System.out.println("Set Title Case Error");
        }
    }
    
    public void buttonPressed(){
        switch (this.algorithm) {
            case ALGO_XOR:
                algoXOR = new A_XOR(UI.getTextArea1().getText(), UI.getTKey().getText(), mode);
                if (mode == ENCODE) {
                    algoXOR.A_encode();
                    UI.getTextArea2().setText(algoXOR.getCipherText());
                }
                else{
                    algoXOR.A_decode();
                    UI.getTextArea2().setText(algoXOR.getPlainText());
                }
                setStepArea();
                break;
            case ALGO_RAIL:
                algoRail = new A_RailFence(UI.getTextArea1().getText(), Integer.parseInt(UI.getTKey().getText()), mode);
                if (mode == ENCODE) {
                    algoRail.A_encode();
                    UI.getTextArea2().setText(algoRail.getCipherText());
                }
                else{
                    algoRail.A_decode();
                    UI.getTextArea2().setText(algoRail.getPlainText());
                }
                setStepArea();
                break;
            case ALGO_SCYTALE:
                algoScytale = new A_Scytale(UI.getTextArea1().getText(), Integer.parseInt(UI.getTKey().getText()), mode);
                if (mode == ENCODE) {
                    algoScytale.A_encode();
                    UI.getTextArea2().setText(algoScytale.getCipherText());
                }
                else{
                    algoScytale.A_decode();
                    UI.getTextArea2().setText(algoScytale.getPlainText());
                }
                setStepArea();
                break;
            case ALGO_SUPER:
                algoSuper = new A_SuperEncryption(UI.getTextArea1().getText(), Integer.parseInt(UI.getTKey().getText()), mode);
                if (mode == ENCODE) {
                    algoSuper.A_encode();
                    UI.getTextArea2().setText(algoSuper.getCipherText());
                }
                else{
                    algoSuper.A_decode();
                    UI.getTextArea2().setText(algoSuper.getPlainText());
                }
                break;
            default:
                System.out.println("Button Action error");
        }
    }

    public void setStepArea(){
        switch (this.algorithm) {
            case ALGO_XOR:
                T_XOR tabelXor = new T_XOR(algoXOR);
                UI.getT_Langkah().setModel(tabelXor);
                break;
            case ALGO_RAIL:
                T_Rail tabelRail = new T_Rail(algoRail);
                UI.getT_Langkah().setModel(tabelRail);
                break;
            case ALGO_SCYTALE:
                T_Scytale tabelScytale = new T_Scytale(algoScytale);
                UI.getT_Langkah().setModel(tabelScytale);
                break;
            case ALGO_SUPER:
                T_XOR tabXor = new T_XOR(algoXOR);
                UI.getT_Langkah().setModel(tabXor);
                break;
            default:
                System.out.println("Button Action error");
        }
    }
    
    public void C_RadioButtonE(){
        UI.getL_Atas().setText("Plain-Text");
        UI.getL_Bawah().setText("Cipher-Text");
        UI.getSubmit().setText("Encode");
        mode = ENCODE;
    }
    
    public void C_RadioButtonD(){
        UI.getL_Bawah().setText("Plain-Text");
        UI.getL_Atas().setText("Cipher-Text");
        UI.getSubmit().setText("Decode");
        mode = DECODE;
    }
}
