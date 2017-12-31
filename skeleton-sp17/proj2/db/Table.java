package db;

import java.util.List;
import java.util.ArrayList;


public class Table {
    List<Row> rows;
//    List<Col> cols;
    int numRows;
    int numCols;
    String tableName;
    String[] colNames;
    String[] colTypes;


    public Table(String name, String[] cNames, String[] cType){
        tableName=name;
        colNames=cNames;
        rows=new ArrayList<Row>();
        numRows=rows.size();
        numCols=cNames.length;
        colTypes=cType;


    }

    public void addRow(String[] elements){
        try{
            Row oneRow=new Row(this,elements);
            rows.add(oneRow);
            numRows++;
        }
        catch (NumberFormatException e){
            System.out.println("Input doesn't match the table specified.");
            return;
        }
    }



    public static String getTable(Table t){
        String values="";
        for(int i=0; i<t.colNames.length; i++){
            values+=t.colNames[i]+" "+t.colTypes[i]+",";
        }
        values=values.substring(0,values.length()-1);
        values+=System.lineSeparator();

        for(Row row:t.rows){
            for (int i=0; i<t.numCols; i++) {
                values += row.get(i).toString()+",";
            }
            values=values.substring(0,values.length()-1);
            values+=System.lineSeparator();
        }
        return values;
    }



    public static void main(String[] args) {
        String[] cNames={"X","Y"};
        String[] cTypes={"int", "int"};

        Table T1=new Table("T1",cNames, cTypes);
        String[] row1={"2","h"};
        try{
            T1.addRow(row1);
        }
        catch (NumberFormatException e){
            System.out.println("Input doesn't match the table specified.");
            return;
        }

        String[] row2={"8","3"};
        try{
            T1.addRow(row2);
        }
        catch (NumberFormatException e){
            System.out.println("Input doesn't match the table specified.");
            return;
        }

        String[] row3={"13","7"};
        try{
            T1.addRow(row3);
        }
        catch (NumberFormatException e){
            System.out.println("Input doesn't match the table specified.");
            return;
        }

        System.out.println(getTable(T1));
    }
}
