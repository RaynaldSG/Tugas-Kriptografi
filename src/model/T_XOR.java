/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.table.AbstractTableModel;
import kriptografi.A_XOR;

/**
 *
 * @author Raynald Krisnawan
 */
public class T_XOR extends AbstractTableModel{
    A_XOR algoXOR;

    public T_XOR(A_XOR algorithm) {
        this.algoXOR= algorithm;
    }

    @Override
    public int getRowCount() {
        return  6;
    }

    @Override
    public int getColumnCount(){
        if(algoXOR.getMode() == A_XOR.ENCODE){
            return algoXOR.getPlainText().length();
        }
        else{
            return algoXOR.getCipherText().length();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(rowIndex){
            case 0:
                return algoXOR.getTabel()[0][columnIndex];
            case 1:
                return algoXOR.getTabel()[1][columnIndex];
            case 2:
                return algoXOR.getTabel()[2][columnIndex];
            case 3:
                return algoXOR.getTabel()[3][columnIndex];
            case 4:
                return algoXOR.getTabel()[4][columnIndex];
            case 5:
                return algoXOR.getTabel()[5][columnIndex];
            default:
            return " ";
        }
    }
}
