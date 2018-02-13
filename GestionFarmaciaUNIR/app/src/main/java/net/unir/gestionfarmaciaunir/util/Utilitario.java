package net.unir.gestionfarmaciaunir.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Clase utilitaria para gestionar los mensajes.
 * Created by pocho on 10/02/18.
 */

public final class Utilitario {
    /**
     * Constructor de la clase.
     */
    private Utilitario(){
        super();
    }

    /**
     * Metodo para enviar un mensaje usando {@link Toast}.
     * @param context {@link Context}
     * @param mensaje mensaje a imprimir
     */
    public static void mostrarMensaje(Context context, final String mensaje){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, mensaje, duration);
        toast.show();
    }
}
