package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private int contador;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = 0;
        textoResultado =(TextView)findViewById(R.id.textoContador);
    }

    public void incrementar(View view) {

        contador = contador + 1;
        textoResultado.setText(""+contador);
        //mostrarTexto();
    }

    public void decrementar(View view) {

        contador = contador - 1;
        if (contador<0){

            CheckBox negativo =(CheckBox)findViewById(R.id.negativo);
            if (!negativo.isChecked()){
                contador=0;
            }

        }
        textoResultado.setText(""+contador);
        //mostrarTexto();
    }

    public void resetear(View view) {


        EditText numero_resetear =(EditText)findViewById(R.id.Numero);
        try{
            contador=Integer.parseInt(numero_resetear.getText().toString());
        }catch (Exception e){
            contador=0;
        }

        numero_resetear.setText("");
        textoResultado.setText(""+contador);
        InputMethodManager miTeclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        miTeclado.hideSoftInputFromWindow(numero_resetear.getWindowToken(),0);
    // mostrarTexto();
    }

   /*public void mostrarTexto() {
        TextView textoContador = (TextView)findViewById(R.id.textoContador);
        textoContador.setText("" + contador);
    }*/



}
