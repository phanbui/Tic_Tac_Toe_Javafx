package ca.cmpt213.asn4.tictactoe.game;

import java.util.ArrayList;

public class Table {
    private ArrayList<ArrayList<Integer>> table;
    private boolean tie;
    private boolean xWin;
    private boolean oWin;

    // 0 is plain, 1 is X, 2 is O
    private int turn;

    public Table(){
        //new table of all 0
        table = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 4; i++) {
            //create a new row
            ArrayList<Integer> oneRow = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++)
                oneRow.add(0);
            //add to map
            table.add(oneRow);
        }

        tie = false;
        xWin = false;
        oWin = false;
        turn = 1;
    }

    public int getElem (int row, int col){
        return table.get(row).get(col);
    }

    public boolean isTie(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (table.get(i).get(j) == 0)
                    return false;
            }
        }
        return true;
    }

    public  boolean isxWin(){
        //check horizontal
        for (int i = 0; i < 4; i++){
            if (table.get(i).get(0)==1 && table.get(i).get(1)==1 &&
                    table.get(i).get(2)==1 && table.get(i).get(3)==1)
                return true;
        }

        //check vertical
        for (int i = 0; i < 4; i++){
            if (table.get(0).get(i)==1 && table.get(1).get(i)==1 &&
                    table.get(2).get(i)==1 && table.get(3).get(i)==1)
                return true;
        }

        //check diagonal
        if (table.get(0).get(0)==1 && table.get(1).get(1)==1 &&
                table.get(2).get(2)==1 && table.get(3).get(3)==1)
            return true;

        //check diagonal
        if (table.get(3).get(0)==1 && table.get(2).get(1)==1 &&
                table.get(1).get(2)==1 && table.get(0).get(3)==1)
            return true;

        return false;
    }

    public boolean isoWin(){
        //check horizontal
        for (int i = 0; i < 4; i++){
            if (table.get(i).get(0)==2 && table.get(i).get(1)==2 &&
                    table.get(i).get(2)==2 && table.get(i).get(3)==2)
                return true;
        }

        //check vertical
        for (int i = 0; i < 4; i++){
            if (table.get(0).get(i)==2 && table.get(1).get(i)==2 &&
                    table.get(2).get(i)==2 && table.get(3).get(i)==2)
                return true;
        }

        //check diagonal
        if (table.get(0).get(0)==2 && table.get(1).get(1)==2 &&
                table.get(2).get(2)==2 && table.get(3).get(3)==2)
            return true;

        //check diagonal
        if (table.get(3).get(0)==2 && table.get(2).get(1)==2 &&
                table.get(1).get(2)==2 && table.get(0).get(3)==2)
            return true;

        return false;
    }

    public void makeMove (int row, int col){
        if (turn == 1){
            table.get(row).set(col, 1);
            turn = 2;
        }
        else if (turn == 2){
            table.get(row).set(col, 2);
            turn = 1;
        }
    }

    public void display(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++)
                System.out.print(table.get(i).get(j) + " ");
            System.out.println();
        }
        System.out.println();
        if (this.isTie())
            System.out.println("Tie");
        else if (this.isxWin())
            System.out.println("X wins");
        else if (this.isoWin())
            System.out.println("O wins");
        System.out.println();
    }
}
