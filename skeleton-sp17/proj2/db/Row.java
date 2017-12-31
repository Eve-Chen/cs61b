package db;

import java.util.LinkedList;

public class Row extends LinkedList {


    public Row(Table t, String[] elements){
        super();

        for (int i=0; i<elements.length; i++){
            switch (t.colTypes[i]){
                case "int": try{
                    int intCell=Integer.parseInt(elements[i]);
                    this.addLast(intCell);
                }
                catch (NumberFormatException e){
                    System.out.println(t.colNames[i]+"should be an integer");
                    return;
                }

                case "string": String stringCell=elements[i];
                    this.addLast(stringCell);

                case "float": try{
                    float floatCell=Float.parseFloat(elements[i]);
                    this.addLast(floatCell);
                }
                catch (NumberFormatException e){
                    System.out.println(t.colNames[i]+"should be a float");
                    return;
                }
            }
        }
    }

}


