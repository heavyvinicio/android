package net.unir.gestionfarmaciaunir.modelo;

import net.unir.gestionfarmaciaunir.util.SucursalEnum;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Formulario para generar un pedido.
 * </p>
 *
 * @author Fernando Ochoa
 */
public class PedidoDTO implements Serializable {

    private static final long serialVersionUID = 8138724950356049216L;

    private String distribuidor;
    private String cantidad;
    private String tipoMedicamento;
    private String nombreMedicamento;
    private List<SucursalEnum> sucursales;

    /**
     * Contructor de la clase
     */
    public PedidoDTO() {
        super();
    }

    /**
     * Contructor de la clase
     *
     * @param distribuidor
     *            distribuidor
     * @param cantidad
     *            cantidad
     * @param tipoMedicamento
     *            tipoMedicamento
     * @param nombreMedicamento
     *            nombreMedicamento
     * @param sucursales
     *            sucursales
     */
    public PedidoDTO(String distribuidor, String cantidad, String tipoMedicamento, String nombreMedicamento,
                     List<SucursalEnum> sucursales) {
        this.distribuidor = distribuidor;
        this.cantidad = cantidad;
        this.tipoMedicamento = tipoMedicamento;
        this.nombreMedicamento = nombreMedicamento;

        this.sucursales = sucursales;
    }

    /**
     * Metodo para obtener la direccion de la sucursal
     *
     * @return direccion
     */
    public String getDireccion() {
        final String direccion = "Para la farmacia situada en %s";
        if (sucursales.size() > 1) {
            return String.format(direccion + " y para la situada en %s", sucursales.get(0).getDireccion(),
                    sucursales.get(1).getDireccion());
        } else {
            return String.format(direccion, sucursales.get(0).getDireccion());
        }

    }

    /**
     * @return the distribuidor
     */
    public String getDistribuidor() {
        return distribuidor;
    }

    /**
     * @param distribuidor
     *            the distribuidor to set
     */
    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad
     *            the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the tipoMedicamento
     */
    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    /**
     * @param tipoMedicamento
     *            the tipoMedicamento to set
     */
    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    /**
     * @return the nombreMedicamento
     */
    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    /**
     * @param nombreMedicamento
     *            the nombreMedicamento to set
     */
    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    /**
     * @return the sucursales
     */
    public List<SucursalEnum> getSucursales() {
        return sucursales;
    }

    /**
     * @param sucursales
     *            the sucursales to set
     */
    public void setSucursales(List<SucursalEnum> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public String toString() {
        return String.format("%s unidades del %s %s", getCantidad(), getTipoMedicamento(), getNombreMedicamento());
    }

}
