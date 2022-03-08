package co.edu.cue.webapp.consultas.exceptions.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date formatearFecha(String fecha){
        Date fechaDate=null;
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaDate= dateFormat.parse(fecha);
        } catch (Exception e){
            e.printStackTrace();
        }
        return fechaDate;
    }
}
