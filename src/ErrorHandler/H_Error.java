/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ErrorHandler;

import javax.swing.JOptionPane;

/**
 *
 * @author Raynald Krisnawan
 */
public class H_Error {
    public static void empty_key(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Key", "Empty Key", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void notInt(){
        JOptionPane.showMessageDialog(null, "Tolong Masukkan Key Berupa Angka", "Empty Key", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void LimitField(){
        JOptionPane.showMessageDialog(null, "Input Maximal Adalah 1", "Empty Key", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void SuperKey(){
        JOptionPane.showMessageDialog(null, "Input Maximal Adalah 1 Dan Harus Berupa Angka", "Empty Key", JOptionPane.INFORMATION_MESSAGE);
    }
}
