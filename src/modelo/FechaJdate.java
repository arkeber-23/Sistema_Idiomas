/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FechaJdate {
 public java.util.Date optenerFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date f = null;

        try {
            f = formato.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
        }
        return f;
    }
 
  
}
