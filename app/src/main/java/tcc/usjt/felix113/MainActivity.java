package tcc.usjt.felix113;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // importando nossos itens criados:
    EditText editCodigo, editNome, editSobreNome,editEmail, editTelefone,editSenha, editConfirmaSenha;
    //Button btnLimpar,btnExcluir;
    Button btnCadCadastrar;
    BancoDados db = new BancoDados(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        editNome = (EditText) findViewById(R.id.editCadNome);
        editSobreNome = (EditText) findViewById(R.id.editCadSobrenome);
        editEmail = (EditText) findViewById(R.id.editCadEmail);
        editTelefone = (EditText) findViewById(R.id.editCadTelefone);
        editSenha = (EditText) findViewById(R.id.editCadSenha);
        editConfirmaSenha = (EditText) findViewById(R.id.editCadConfirmeSenha);

        //btnLimpar = (Button)findViewById(R.id.btnLimpar);
        btnCadCadastrar = (Button) findViewById(R.id.btnCadCdastar);
        //btnExcluir = (Button)findViewById(R.id.btnExcluir);


        /*TESTE DO CRUD*/

        // Insert ok - fica na base do celular.
        //teste NSA
        //db.addCliente(new Cliente("George", "Dias", "teste@teste.com.br", "(11)123456789", "Senha123", "Senha123"));
        //Toast.makeText(MainActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();

        btnCadCadastrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String codigo = editCodigo.getText().toString();
                String nome = editNome.getText().toString();
                String sobrenome = editSobreNome.getText().toString();
                String email = editEmail.getText().toString();
                String telefone = editTelefone.getText().toString();
                String senha = editSenha.getText().toString();
                String confirmaSenha = editConfirmaSenha.getText().toString();

                if (nome.isEmpty()) {
                    editNome.setError("Este campo é obrigatorio");

                } else if (codigo.isEmpty()) {
                    //insert
                    db.addCliente(new Cliente(nome, sobrenome, email, telefone, senha, confirmaSenha));
                    Toast.makeText(MainActivity.this, "Salvo Com sucesso", Toast.LENGTH_LONG).show();
                    limpaCampos();

                } else {
                    Toast.makeText(MainActivity.this, "Erro", Toast.LENGTH_LONG).show();
                }
            }


            void limpaCampos() {
                editCodigo.setText("");
                editNome.setText("");
                editSobreNome.setText("");
                editEmail.setText("");
                editTelefone.setText("");
                editSenha.setText("");
                editConfirmaSenha.setText("");
                editNome.requestFocus();

            }

        /*Apagar cliente ok
        Cliente cliente = new Cliente();

        cliente.setCodigo(3); // apagando o cliente 3
        db.apagarCliente(cliente);
        */

            //Toast.makeText(MainActivity.this, "Apagado com sucesso",Toast.LENGTH_LONG).show();


        });

    }
}
