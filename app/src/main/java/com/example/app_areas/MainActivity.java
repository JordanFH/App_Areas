package com.example.app_areas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_areas.Modelo.Circulo;
import com.example.app_areas.Modelo.Cuadrado;
import com.example.app_areas.Modelo.FiguraG;
import com.example.app_areas.Modelo.Rectangulo;
import com.example.app_areas.Modelo.Triangulo;

public class MainActivity extends AppCompatActivity {

    RadioButton rdCirculo, rdCuadrado, rdRectangulo, rdTriangulo;

    EditText txtAlto, txtAncho, txtArea;

    RadioGroup rg_1, rg_2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("App Áreas versión 1.1");

        rdCirculo = findViewById(R.id.rdCirculo);
        rdCuadrado = findViewById(R.id.rdCuadrado);
        rdRectangulo = findViewById(R.id.rdRectangulo);
        rdTriangulo = findViewById(R.id.rdTriangulo);

        txtAlto = findViewById(R.id.txtAlto);
        txtAncho = findViewById(R.id.txtAncho);
        txtArea = findViewById(R.id.txtArea);

        rg_1 = findViewById(R.id.rg_1);
        rg_2 = findViewById(R.id.rg_2);
    }

    public void onClickCalcular(View btn) {

        try {
            if (!txtAlto.getText().toString().isEmpty() && !txtAncho.getText().toString().isEmpty()) {
                FiguraG figura;
                double alto = Double.parseDouble(txtAlto.getText().toString());
                double ancho = Double.parseDouble(txtAncho.getText().toString());
                double area = 0;

                if (rdCirculo.isChecked()) {
                    figura = new Circulo(alto, ancho);
                    area = ((Circulo) figura).calcularArea();
                }
                if (rdCuadrado.isChecked()) {
                    figura = new Cuadrado(alto, ancho);
                    area = ((Cuadrado) figura).calcularArea();
                }
                if (rdRectangulo.isChecked()) {
                    figura = new Rectangulo(alto, ancho);
                    area = ((Rectangulo) figura).calcularArea();
                }
                if (rdTriangulo.isChecked()) {
                    figura = new Triangulo(alto, ancho);
                    area = ((Triangulo) figura).calcularArea();
                }

                if (area > 0) {
                    txtArea.setText(area + "");
                } else {
                    txtArea.setText("Área no existe :(");
                    txtAlto.requestFocus();
                }
            } else {
                if (txtAlto.getText().toString().isEmpty() && txtAncho.getText().toString().isEmpty()) {
                    txtAlto.requestFocus();
                } else if (!txtAlto.getText().toString().isEmpty() && txtAncho.getText().toString().isEmpty()) {
                    txtAncho.requestFocus();
                } else {
                    txtAlto.requestFocus();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickRadioButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rdCirculo:
            case R.id.rdCuadrado:
                if (checked)
                    rg_2.clearCheck();
                break;
            case R.id.rdRectangulo:
            case R.id.rdTriangulo:
                if (checked)
                    rg_1.clearCheck();
                break;
        }
    }

}