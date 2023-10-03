package model;

import javax.swing.table.AbstractTableModel;

import kriptografi.A_RailFence;
import kriptografi.A_Scytale;
import kriptografi.A_SuperEncryption;
import kriptografi.A_XOR;

public class T_Super extends AbstractTableModel{
    A_RailFence algoFence;
    A_Scytale algoScytale;
    A_XOR algoXOR;

    int fenceR = 0;
    int scyR = 0;
    int XORR = 0;
    int mode;

    public T_Super(A_RailFence algorithm1, A_Scytale algorithm2, A_XOR algorithm3) {
        this.algoFence= algorithm1;
        this.algoScytale= algorithm2;
        this.algoXOR= algorithm3;
        this.mode = algorithm1.getMode();
    }

    @Override
    public int getRowCount() {
        return rowCounter();
    }

    @Override
    public int getColumnCount(){
        if(algoXOR.getMode() == A_XOR.ENCODE){
            return algoScytale.getCipherText().length();
        }
        else{
            return algoScytale.getPlainText().length();
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < scyR && columnIndex < algoFence.getTabel()[0].length){
            if(rowIndex == scyR - 1){
                if(columnIndex > 0){
                    return " ";
                }
                if(algoFence.getMode() == A_SuperEncryption.ENCODE){
                    return algoScytale.getCipherText();
                }
                else{
                    return algoScytale.getPlainText();
                }
            }
            else{
                return algoScytale.getTabel()[rowIndex][columnIndex];
            }
        }
        if (rowIndex < scyR + fenceR - 1 && rowIndex >= scyR && columnIndex < algoFence.getTabel().length){
            if (algoFence.getTabel()[columnIndex][rowIndex - scyR] == 0 && rowIndex <= fenceR - 1) {
                return " ";
            }
            else if(columnIndex >= algoFence.getTabel().length){
                return " ";
            }
            else{
                return algoFence.getTabel()[columnIndex][rowIndex - scyR];
            }
        }
        if (rowIndex == fenceR + scyR - 1){
                if(columnIndex > 0){
                    return " ";
                }
                if(algoFence.getMode() == A_SuperEncryption.ENCODE){
                    return algoFence.getCipherText();
                }
                else{
                    return algoFence.getPlainText();
                }
            }
        else{
            if (columnIndex >= algoXOR.getTabel()[0].length){
                return " ";
            }
            else if(rowIndex == scyR + fenceR + 1){
                return algoXOR.getTabel()[0][columnIndex];
            }
            else if(rowIndex == scyR + fenceR + 2){
                return algoXOR.getTabel()[1][columnIndex];
            }
            else if(rowIndex == scyR + fenceR + 3){
                return algoXOR.getTabel()[2][columnIndex];
            }
            else if(rowIndex == scyR + fenceR + 4){
                return algoXOR.getTabel()[3][columnIndex];
            }
            else if(rowIndex == scyR + fenceR + 5){
                return algoXOR.getTabel()[4][columnIndex];
            }
            else if(rowIndex == scyR + fenceR + 6){
                return algoXOR.getTabel()[5][columnIndex];
            }
            else if(rowIndex == scyR + fenceR + 7){
                if(algoXOR.getMode() == A_SuperEncryption.ENCODE){
                    return algoXOR.getCipherText().charAt(columnIndex);
                }
                else{
                    return algoXOR.getPlainText().charAt(columnIndex);
                }
            }
        }
        return "";
    }

    private int rowCounter(){
        int count = 0;

        fenceR = algoFence.getKey() + 1;
        count = count + fenceR;

        if(algoScytale.getMode() == A_Scytale.ENCODE){
            scyR = (int) Math.ceil(algoScytale.getPlainText().length() / (algoScytale.getKey()/1.0f)) + 1;
        }
        else{
            scyR = (int) Math.ceil(algoScytale.getCipherText().length() / (algoScytale.getKey()/1.0f)) + 1;
        }
        count = count + scyR;

        XORR  = 7;
        count = count + XORR;

        return count;
    }
}
