package model;

import javax.swing.table.AbstractTableModel;
import kriptografi.A_Scytale;

public class T_Scytale extends AbstractTableModel{
    A_Scytale algoScytale;

    public T_Scytale(A_Scytale algorithm) {
        this.algoScytale = algorithm;
    }

    @Override
    public int getRowCount() {
        if(algoScytale.getMode() == A_Scytale.ENCODE){
            return (int) Math.ceil(algoScytale.getPlainText().length() / (algoScytale.getKey()/1.0f));
        }
        else{
            return (int) Math.ceil(algoScytale.getCipherText().length() / (algoScytale.getKey()/1.0f));
        }
    }

    @Override
    public int getColumnCount(){
        return algoScytale.getKey();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return  algoScytale.getTabel()[rowIndex][columnIndex];
    }
    
    
}
