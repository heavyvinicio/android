package net.unir.gestionfarmaciaunir.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.unir.gestionfarmaciaunir.R;
import net.unir.gestionfarmaciaunir.modelo.PedidoDTO;
import net.unir.gestionfarmaciaunir.modelo.Persona;
import net.unir.gestionfarmaciaunir.util.Utilitario;

public class VistaDetallePedido extends AppCompatActivity {
    private PedidoDTO pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_detalle_pedido);
        Intent intent=getIntent();
        pedido= (PedidoDTO) intent.getSerializableExtra("pedidoDto");
        TextView texto=findViewById(R.id.lblNombrePedido);
        texto.setText(String.format("Pedido al distribuidor %s", pedido.getDistribuidor()));
        EditText txtPedido=(EditText) findViewById(R.id.txtPedido);
        EditText txtDireccion=(EditText) findViewById(R.id.txtDireccion);
        txtPedido.setText(pedido.toString());
        txtDireccion.setText(pedido.getDireccion());
    }

    /**
     * Metodo para enviar el pedido
     * @param vista {@link View}
     */
    public void enviarPedido(View vista){
        if(pedido==null){
            Utilitario.mostrarMensaje(getApplicationContext(),"No hay pedidos disponibles a enviar.");
        }
        else{
            Utilitario.mostrarMensaje(getApplicationContext(),"Se ha enviado el pedido");
        }
    }
}
