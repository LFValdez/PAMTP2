package py.edu.columbia.pamtp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import clases.Usuario;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    private static EditText etUsuario;
    private static EditText etContrasena;

    private static Button btIniciar;

    private ArrayList <Usuario> usuarios;

    private static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        usuarios = new ArrayList<>();

        this.etUsuario = findViewById(R.id.etUsuario);
        this.etContrasena = findViewById(R.id.etConstrasena);

        this.btIniciar = findViewById(R.id.btIniciar);

        btIniciar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == btIniciar.getId()){

            Boolean flag = Boolean.FALSE;

            String user = etUsuario.getText().toString();
            String pass = etContrasena.getText().toString();

            intent = getIntent();
            usuarios = (ArrayList<Usuario>) intent.getSerializableExtra("listaUsuario");

            for (Usuario u : usuarios){

                if (u.getUsuario().equals(user) && u.getContrasena().equals(pass)){

                    flag = Boolean.TRUE;
                    break;
                }
            }

            if (flag.equals(Boolean.TRUE)){

                Toast toast = Toast.makeText(this,"Inicio de sesión exitoso.",Toast.LENGTH_SHORT);
                toast.show();

            } else {

                Toast toast = Toast.makeText(this,"Usuario y/o contraseña incorrectos.\n"
                        +"Vuelva a intentarlo.",Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}
