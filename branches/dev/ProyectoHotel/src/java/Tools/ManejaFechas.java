/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author desarrollo
 */
public class ManejaFechas {

    private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día

    public static Date convertirString(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = sdf.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return fechaDate;
    }

    public static long diferencia(Date fechaInicio, Date fechaFin){
        return (fechaFin.getTime() - fechaInicio.getTime())/MILLSECS_PER_DAY;
    }

    public static long difencia(Date fechaInicio){
        Date hoy = new Date();
        return (hoy.getTime() - fechaInicio.getTime())/MILLSECS_PER_DAY;
    }

    public static String convertirDate(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = sdf.format(fecha);
        return fechaString;
    }

    public static Date getHour(String hora)
    {
        String[] comp = hora.split(":");
        Date fechaDate = new Date(1900, 1, 1, Integer.parseInt(comp[0]), Integer.parseInt(comp[1]));
        
        return fechaDate;
    }
}
