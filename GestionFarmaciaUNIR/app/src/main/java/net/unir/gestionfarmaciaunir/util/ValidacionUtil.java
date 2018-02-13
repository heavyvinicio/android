package net.unir.gestionfarmaciaunir.util;

import android.widget.EditText;

/**
 * Clase utilitaria para gestionar las validaciones en los campos de texto.
 * Created by pocho on 11/02/18.
 */

public final class ValidacionUtil {
    private static final String REQUIRED_MSG = "Campo Requerido";

    /**
     * Metodo utilitario para validr si es valido una caja de texto.
     * @param editText  {@link EditText}
     * @param errMsg Mensaje de error
     * @param required campo requerido
     * @return true si es valido la caja de texto
     */
    public static boolean esValido(EditText editText, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        if ( required && !tieneTexto(editText) ) return false;
        return true;
    }

    /**
     * Metodo para validar si tiene o no texto la caja de texto.
     * @param editText {@link EditText}
     * @return true si tiene texto.
     */
    public static boolean tieneTexto(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }
}
