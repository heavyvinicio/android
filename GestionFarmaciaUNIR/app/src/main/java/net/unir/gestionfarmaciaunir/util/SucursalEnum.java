package net.unir.gestionfarmaciaunir.util;

/**
 * Enumeracion para mantener los datos de ls sucursal.
 *
 * @author Fernando Ochoa
 */
public enum SucursalEnum {
    PRINCIPAL("Principal", "Calle de la Rosa n. 28"), SECUNDARIA("Secundaria", "Calle Alcazabilla n. 3");
    private final String sucursal;
    private final String direccion;

    /**
     * COntructor de la clase.
     *
     * @param sucursal
     *            sucursal
     * @param direccion
     *            direccion
     */
    private SucursalEnum(String sucursal, String direccion) {
        this.sucursal = sucursal;
        this.direccion = direccion;
    }

    /**
     * @return the sucursal
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

}
