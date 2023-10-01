package model;

import javax.swing.table.AbstractTableModel;

import kriptografi.A_RailFence;
import kriptografi.A_Scytale;
import kriptografi.A_XOR;

public class T_Super extends AbstractTableModel{
    A_RailFence algoFence;
    A_Scytale algoScytale;
    A_XOR algoXOR;

    public T_Super(A_RailFence algorithm1, A_Scytale algorithm2, A_XOR algorithm3) {
        this.algoFence= algorithm1;
        this.algoScytale= algorithm2;
        this.algoXOR= algorithm3;
    }

    @Override
    public int getRowCount() {
        return  algoFence.getKey();
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

    private int rowCounter(){
        int count = 0;


        return count;
    }
}
