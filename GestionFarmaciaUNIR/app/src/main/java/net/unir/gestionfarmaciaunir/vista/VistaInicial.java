package net.unir.gestionfarmaciaunir.vista;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.unir.gestionfarmaciaunir.R;
import net.unir.gestionfarmaciaunir.modelo.PedidoDTO;
import net.unir.gestionfarmaciaunir.modelo.Persona;
import net.unir.gestionfarmaciaunir.util.SucursalEnum;
import net.unir.gestionfarmaciaunir.util.Utilitario;
import net.unir.gestionfarmaciaunir.util.ValidacionUtil;

import java.util.ArrayList;
import java.util.List;

public class VistaInicial extends AppCompatActivity {

    private EditText txtNombreMedicamento;
    private EditText txtCantidad;
    private Spinner cmbTipoMedicamento;
    private CheckBox chkSecundaria;
    private CheckBox chkPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_inicial);
        RadioButton rbCofarma=(RadioButton) findViewById( R.id.rbCofarma);
        rbCofarma.setChecked(true);
        registrarControles();
    }


    /**
     * Metodo pra limpiar la vista.
     * @param vista {@link View}
     */
    public void limpiarDatos(View vista){
        RadioButton rbCofarma=(RadioButton) findViewById( R.id.rbCofarma);
        rbCofarma.setChecked(true);
        chkPrincipal.setChecked(false);
        chkSecundaria.setChecked(false);
        txtNombreMedicamento.setText(null);
        txtCantidad.setText(null);

        cmbTipoMedicamento.setSelection(0);
    }

    /**
     * Metodo para enviar el pedido a la sigueinte actividad.
     * @param vista {@link View}
     */
    public void enviarPedido(View vista){
        if(!validarFormulario()) {
            return;

        }
        PedidoDTO pedidoDTO = new PedidoDTO(getDistribuidorSeleccionado(), txtCantidad.getText().toString(),
                cmbTipoMedicamento.getSelectedItem().toString(), txtNombreMedicamento.getText().toString(),
                getSucursalesSeleccionadas());
        Intent intent = new Intent(this, VistaDetallePedido.class);
        intent.putExtra("pedidoDto",pedidoDTO);
        startActivity(intent);

    }
    /**
     * Metodo para obtener las sucursales seleccionadas
     *
     * @return {@link List} de {@link SucursalEnum}
     */
    private List<SucursalEnum> getSucursalesSeleccionadas() {
        List<SucursalEnum> lista = new ArrayList<>();
        if (chkPrincipal.isChecked()) {
            lista.add(SucursalEnum.PRINCIPAL);
        }
        if (chkSecundaria.isChecked()) {
            lista.add(SucursalEnum.SECUNDARIA);
        }
        return lista;
    }

    /**
     * Metodo para validar los campos obligatorios en la vista.
     * @return True si es valido
     */
    private boolean validarFormulario() {
        boolean cumple=true;
        boolean mosntrarMensajeGeneral=true;
        if(!ValidacionUtil.tieneTexto(txtNombreMedicamento)){
            cumple=false;
        };
        if(!ValidacionUtil.tieneTexto(txtCantidad)){
            cumple=false;
        };
        if(cmbTipoMedicamento.getSelectedItem()==null|| cmbTipoMedicamento.getSelectedItem().equals("Seleccione")){
            setSpinnerError(cmbTipoMedicamento,"Campo Obligatorio");
            cumple=false;

        }
        if(getSucursalesSeleccionadas().isEmpty()){

            cumple=false;
            mosntrarMensajeGeneral=false;
            Utilitario.mostrarMensaje(getApplicationContext(),"Seleccione una sucursal para continuar.");
        }
        if(!cumple){
            if(mosntrarMensajeGeneral) {
                Utilitario.mostrarMensaje(getApplicationContext(), "Error, ingrese todos los campos obligatorios.");
            }
        }
        return cumple;
    }

    /**
     * Metodo para registrar los componentes en la vista.
     */
    private void registrarControles(){
        txtNombreMedicamento=(EditText) findViewById(R.id.txtNombreMedicamento);
        txtNombreMedicamento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ValidacionUtil.tieneTexto(txtNombreMedicamento);
            }
        });
        txtCantidad=(EditText) findViewById(R.id.txtCantidad);
        txtCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ValidacionUtil.tieneTexto(txtCantidad);
            }
        });
        cmbTipoMedicamento=(Spinner) findViewById(R.id.cmbTipoMedicamento);
        chkSecundaria=(CheckBox) findViewById(R.id.chkSecundaria);
        chkPrincipal=(CheckBox) findViewById(R.id.chkPrincipal);

    }

    /**
     * Metodo para controlar la presentación de errores en un spinner
     * @param spinner {@link Spinner}
     * @param error mensaje de error
     */
    private void setSpinnerError(Spinner spinner, String error){
        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            spinner.requestFocus();
            TextView  selectedTextView = (TextView) selectedView;
            selectedTextView.setError(error); // any name of the error will do
            selectedTextView.setTextColor(Color.RED);


        }
    }

    /**
     * Metodo para obtener el nombre del distribuidor seleccionado.
     * @return
     */
    public String getDistribuidorSeleccionado(){
        RadioGroup rbGroup=(RadioGroup) findViewById( R.id.rbGroup);
        return ((RadioButton) findViewById(rbGroup.getCheckedRadioButtonId())).getText().toString();
    }

}
