package Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Auxiliar implements Serializable {

    public static boolean validacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesionDisponible = request.getSession();
        if (sesionDisponible == null) {
            return false;
        }

        return true;
    }

    public static String checkId(String txt) {

        Pattern patron = Pattern.compile("-");
        Matcher encaja = patron.matcher(txt);
        String r = encaja.replaceAll("0");

        return r;
    }

    public static String eliminarEspacios(String txt) {

        Pattern patron = Pattern.compile(" ");
        Matcher encaja = patron.matcher(txt);
        String r = encaja.replaceAll("");

        System.out.println(r + "-----");

        return r;
    }

    public static String validarDato(String d) {
        if (d == null || d.equals("")) {
            return "NA";
        } else {
            return d;
        }
    }

}
