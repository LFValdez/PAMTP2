package py.edu.columbia.pamtp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private static Spinner spnCategoria;
    private static EditText etUsuario;
    private static EditText etContrasena;
    private static Button btCancelar;
    private static Button btAceptar;
    private static ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarios = new ArrayList<>();

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etConstrasena);
        btCancelar = findViewById(R.id.btCancelar);
        btAceptar = findViewById(R.id.btAceptar);

        spnCategoria = findViewById(R.id.spnCategoria);
        String [] categoria = {"Docente","Estudiante"};
        spnCategoria.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, categoria));

        btCancelar.setOnClickListener(this);
        btAceptar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == btCancelar.getId()){

            Intent intent = getIntent();
            setResult(RESULT_CANCELED, intent);
            finish();
        } else {

            Usuario usuario = new Usuario();

            usuario.setCategoria(spnCategoria.getSelectedItem().toString());
            usuario.setUsuario(etUsuario.getText().toString());
            usuario.setContrasena(etContrasena.getText().toString());

            usuarios.add(usuario);

            Intent intent = getIntent();
            intent.putExtra("Usuario", usuario);
            setResult(RESULT_OK, intent);
            finish();

        }
    }
}
