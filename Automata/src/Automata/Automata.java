/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automata;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ang3l
 */
public class Automata {
    
    public String cadena;
    public String[]array;
    public String[] columnas = {"Estado","Entradas","Estado"};
    public DefaultTableModel header = new DefaultTableModel(null,columnas);
    public int cont;
    public String puntoyComa = ";";
    
    public void validar(JTable tabla,String cadena){
        this.cadena = cadena;
        array = cadena.split(" ");
        if(array.length == 1){
            String [] filas = {"q0","for","  q1"};
            header.addRow(filas);
        }else{
            for(int i=0; i<array.length; i++ ){
                if(array[i].equalsIgnoreCase("for")){
                    cont = i+1;
                    String [] filas = {"q0"," for ","  q1"};
                    header.addRow(filas);
                    estado2(array);
                }
            }
            tabla.setModel(header);
        }
    }
    public void estado2(String[]valor){
        System.out.print(cont);
        String[] cadena = valor;
        if(cadena[cont].equalsIgnoreCase("(")){
            String [] filas = {"q1 ","( ","  q2"};
            header.addRow(filas);
            cont++;
            estado3(cadena);
        }else{
            String [] filas = {"q1 "," Invalido","  q1 --->estado actual"};
            header.addRow(filas);
        }
    }
    
    public void estado3(String[]valor){
        String []estado3= valor;
        for(int i = cont; i<estado3.length; i++){
            if(estado3[i].equalsIgnoreCase("int")){
                String [] filas = {"q2 "," int ","  q3"};
                cont++;
                header.addRow(filas);
                estado5(estado3);
                break;
            }else if(estado3[i].equals(puntoyComa)){
                String [] filas = {"q2"," ; ","  q4"};
                cont++;
                header.addRow(filas);
                estado19(array);
                break;
            }else{
                String [] filas = {"q2","Invalido","  q2 --->estado actual"};
                header.addRow(filas);
            }
        }
        
    }
    
    public void estado5(String[]valor){
        array = valor;
        if(array[cont].equalsIgnoreCase("i")){
            String []filas = {"q3"," i ","  q5"};
            header.addRow(filas);
            cont++;
            estado6(array);
        }else{
            String [] filas = {"q3","Invalido","  q3 --->estado actual"};
            header.addRow(filas);
        }
    }
    public void estado6(String[]valor){
        array = valor;
        if(array[cont].equals("=")){
            String []filas = {"q5 "," = ","  q6"};
            cont++;
            header.addRow(filas);
            estado8(array);
        }
    }
    public void estado8(String []valor){
        String []cero;
        String num;
        array = valor;
        String dato;
        dato = array[cont];
        cero = dato.split("");
        int co = 0;
        
        for(int i=0; i<11; i++){
            num = String.valueOf(i);
            for(int j = 0; j<cero.length; j++){
                if(cero[j].equals(num)){
                    String []filas = {"q6 ",num,"  q7"};
                    header.addRow(filas);
                    co++;
                }
            }
            if(cero[co].equals(puntoyComa)){
                String []filas = {"q8 "," ; ","  q9"};
                header.addRow(filas);
                cont++;
                estado9(array);
                break;
            }
        } 
    }
    public void estado9(String []valor){
        String []cero;
        String num;
        array = valor;
        String dato;
        dato = array[cont];
        cero = dato.split("");
        int co = 0;
         
        for(int j = 0; j<cero.length; j++){
            if(cero[j].equals("i")){
                String []filas = {"q9 "," i ","  q10"};
                header.addRow(filas);
                co++;
            }
        }
        if(cero[co].equals("<")){
            String []filas = {"q10 "," < ","  q11"};
            header.addRow(filas);
            cont++;
            estado13(array);
        }else{
            if(cero[co].equals(">")){
                String []filas = {"q10 "," < ","  q12"};
                header.addRow(filas);
                co++;
            }if(cero[co].equals("=")){
                String []filas = {"q12 "," = ","  q25"};
                header.addRow(filas);
                cont++;
                estado25(array);
            }
        }
    }
    public void estado25(String[]valor){
        array = valor;
        String num="";
        String va = array[cont];
        String[] va2;
        va2=va.split("");
        int co = 0;
        for(int i=0; i<10; i++){
            num = String.valueOf(i);
            for(int j=0; j<va2.length; j++){
                if(va2[j].equals(num)){
                    String []filas = {"q25 ",va2[j],"  q13"};
                    header.addRow(filas);
                    co++;   
                }
            } 
        }
        if(va2[co].equals(num)){
            String []filas = {"q13",va2[co],"  q13"};
            header.addRow(filas);
            co++;
        }
        if(va2[co].equals(puntoyComa)){
            String []filas = {"q13 "," ; ","  q14"};
            header.addRow(filas);
            cont++;
            estado152(array);    
        }
    
    }
    public void estado13(String[]valor){
        array = valor;
        String num;
        String va = array[cont];
        String[] va2;
        va2=va.split("");
        int co = 0;
        int conta=0;
        for(int i=0; i<10; i++){
            num = String.valueOf(i);
            for(int j=0; j<va2.length; j++){
                if(va2[j].equals(num)){
                    String []filas = {"q11 ",va2[j],"  q13"};
                    header.addRow(filas);
                    co++;
                    break;
                }
            } 
            conta++;
        }
        num= String.valueOf(conta);
        if(va2[co].equals(num)){
            String []filas = {"q13",va2[co],"  q13"};
            header.addRow(filas);
            co++;
        }
        if(va2[co].equals(puntoyComa)){
            String []filas = {"q13 "," ; ","  q14"};
            header.addRow(filas);
            cont++;
            estado15(array);    
        }
    }
    public void estado152(String[]valor){
        array = valor;
        String[] va2;
        String va ="";
        va = array[cont];
        va2 = va.split("");
        String menos= "-";
        
        int co=0;
        
        for(int i =0; i<va2.length; i++){
            if(va2[i].equals("i")){
                String []filas = {"q14 "," i ","  q15"};
                header.addRow(filas);
                co++;
            }
        }
        if(va2[co].equals(menos)){
            String []filas = {"q15 "," - ","  q18"};
            header.addRow(filas);
            co++;
        }
        if(va2[co].equals(menos)){
            String []filas = {"q18 "," - ","  q19"};
            header.addRow(filas);
            cont++;
            estado20(array);
        }
    }
    public void estado15(String[]valor){
        array = valor;
        String[] va2;
        String va ="";
        va = array[cont];
        va2 = va.split("");
        String mas= "+";
        
        int co=0;
        
        for(int i =0; i<va2.length; i++){
            if(va2[i].equals("i")){
                String []filas = {"q14 "," i ","  q15"};
                header.addRow(filas);
                co++;
            }
        }
        if(va2[co].equals(mas)){
            String []filas = {"q15 "," + ","  q16"};
            header.addRow(filas);
            co++;
        }
        if(va2[co].equals(mas)){
            String []filas = {"q16 "," + ","  q17"};
            header.addRow(filas);
            cont++;
            estado20(array);
        }
    }
    public void estado19(String[]valor){
        array = valor;
        String va;
        va=array[cont];
        String[] va2;
        va2 = va.split("");
        for(int i = 0; i<va2.length; i++){
            if(va2[i].equals(puntoyComa)){
                String []filas = {"q4 "," ; ","  q19"};
                header.addRow(filas);
                cont++;
                estado20(array);
            }else{
                estado7(array);
            }
        }
    }
    public void estado7(String[]valor){
        char x;
        String a;
        int c = 0;
        array = valor;
        String va;
        va=array[cont];
        String[] va2;
        va2 = va.split("");
        int di=0;
        for(int i= 0; i<va2.length; i++){
            for(x='A'; x<='Z'; x++){
                a = Character.toString(x);
                if(va2[i].equalsIgnoreCase(a)){
                    if(c>0){
                        String []filas = {"q7 ",va2[c],"  q7"};
                        header.addRow(filas);
                        c++;
                    }else{
                        String []filas = {"q4 ",va2[c],"  q7"};
                        header.addRow(filas);
                        c++;
                    }
                } 
            } 
            if(va2[i].equals("!")){
                String []filas = {"q7 ",va2[c],"  q26"};
                header.addRow(filas);
                c++;
            }
            di=i+1;
            if(va2[di].equals("=")){
                String []filas = {"q26 ",va2[c],"  q27"};
                header.addRow(filas);
                cont++;
                negativo(array);
            }
        }        
    }
   public void negativo(String[]valor){
        array = valor;
        String va = array[cont];
        String[]va2;
        va2= va.split("");
        String op;
        for(int j = 0; j<va2.length; j++){
            if(va2[j].equals("-")){
                String []filas = {"q27 ",va2[j],"  q28"};
                header.addRow(filas);
                for(int i= 0; i<10; i++){
                    op = String.valueOf(i);
                    if(va2[1].equals(op)){
                        estado27(array);
                        break;
                    }
                }
            }
            else{
                for(int i= 0; i<10; i++){
                    op = String.valueOf(i);
                    if(va2[j].equals(op)){
                        estado27(array);
                        break;
                    }
                }
            }
        }  
    }
   public void estado27(String[]valor){
        array = valor;
        String va = array[cont];
        String[]va2;
        va2= va.split("");
        String op;
        int conta =0;
        int co=0;
        for(int j = 0; j<va2.length; j++){
            for(int i= 0; i<10; i++){
                op = String.valueOf(i);
                if(va2[j].equals(op)){
                    String []filas = {"q27 ",va2[j],"  q13"};
                    header.addRow(filas);
                    co++;
                    break;
                }
                conta++;
            }
            
        }  
        op= String.valueOf(conta);
        if(va2[co].equals(op)){
            String []filas = {"q13 ",va2[co],"  q13"};
            header.addRow(filas);
        }else{
        if(va2[co].equals(puntoyComa)){
            String []filas = {"q13 ",va2[co],"  q14"};
            header.addRow(filas);
            cont++;
            estado201(array);
            
        }}
    }
   public void estado201(String[]valor){
       array = valor;
       String va = array[cont];
       String []va2;
       va2 = va.split("");
        int co=0;
        for(int i =0; i<va2.length; i++){
            if(va2[i].equals(")")){
                String []filas = {"q14 "," ) ","  q20"};
                header.addRow(filas);
                co++;
            }
        }
        if(va2[co].equals("{")){
            String []filas = {"q20 "," { ","  q21"};
            header.addRow(filas);
            cont++;
            estado21(array);
        }
   }
    public void estado20(String[]valor){
        array = valor;
        String va = array[cont];
        String []va2;
        va2 = va.split("");
        
        int co=0;
        for(int i =0; i<va2.length; i++){
            if(va2[i].equals(")")){
                String []filas = {"q17 "," ) ","  q20"};
                header.addRow(filas);
                co++;
            }
        }
        if(va2[co].equals("{")){
            String []filas = {"q20 "," { ","  q21"};
            header.addRow(filas);
            cont++;
            estado21(array);
        }
    }
    public void estado21(String[]valor){
        array = valor;
        String va;
        va = array[cont];
        String[]va2;
        String pc="";
        va2 = va.split("");
        String instruciones="";
        for(int i = 0; i<va2.length; i++){
            if(va2[i].equals(puntoyComa)){
                pc = va2[i];
                break;
            }else{
                instruciones=instruciones+va2[i];
            }
        }
        if(instruciones.equals("instrucciones")){
            String []filas = {"q21 "," instrucciones ","  q22"};
            header.addRow(filas);
        }if(pc.equals(puntoyComa)){
            String []filas = {"q22"," ; ","  q23"};
            header.addRow(filas);
            cont++;
            estadoFinal(array);
        }
    }
    public void estadoFinal(String[]valor){
        array = valor;
        if(array[cont].equals("}")){
            String []filas = {"q23"," } ","  q24 ------> estado de aceptacion"};
            header.addRow(filas);
        }
    }
}
