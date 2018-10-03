package py.edu.columbia.pamtp2;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static Button btIniciar;
    private static Button btRegistrar;
    private static  ArrayList<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios = new ArrayList<>();
        //Log.i("ON CREATE", MainActivity.class.getName());
        btIniciar = findViewById(R.id.btIniciar);
        btRegistrar = findViewById(R.id.btRegistrar);

        btRegistrar.setOnClickListener(this);
        btIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == btRegistrar.getId()){
            registrarse ();
        } else {

            iniciarSesion ();
        }
    }

    private void iniciarSesion() {
        Intent intent = new Intent(this, InicioSesion.class);
        intent.putExtra("listaUsuario", usuarios);
        startActivity(intent);
    }

    private void registrarse() {

        Intent intent = new Intent(this, Registro.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_CANCELED){
                Toast toast = Toast.makeText(this,"Registro Cancelado",Toast.LENGTH_SHORT);
                toast.show();

            } else if (resultCode == RESULT_OK){

                Usuario usuario = (Usuario) data.getExtras().getSerializable("Usuario");

                if (usuario.getCategoria().equals(Usuario.Categoria.Docente) ){

                    Toast toast = Toast.makeText(this,"Registro del Docente exitoso",Toast.LENGTH_SHORT);
                    toast.show();

                } else {

                    Toast toast = Toast.makeText(this,"Registro del Estudiante exitoso",Toast.LENGTH_SHORT);
                    toast.show();

                }

                usuarios.add(usuario);

            }
        }
    }
}
