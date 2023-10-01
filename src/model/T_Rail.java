package model;

import javax.swing.table.AbstractTableModel;
import kriptografi.A_RailFence;

public class T_Rail extends AbstractTableModel{
    A_RailFence algoRail;

    public T_Rail(A_RailFence algorithm) {
        this.algoRail = algorithm;
    }

    @Override
    public int getRowCount() {
        return algoRail.getKey();
    }

    @Override
    public int getColumnCount(){
        if(algoRail.getMode() == A_RailFence.ENCODE){
            return algoRail.getPlainText().length();
        }
        else{
            return algoRail.getCipherText().length();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (algoRail.getTabel()[columnIndex][rowIndex] == 0) {
            return null;
        }
        else{
            return  algoRail.getTabel()[columnIndex][rowIndex];
        }
    }
    
    
}
