package tcc.usjt.felix113;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    EditText editNome;
    EditText editSobreNome;
    EditText editEmail;
    EditText editTelefone;
    EditText editSenha;
    EditText editConfirmaSenha;
    Button btnCadastrar;
    RadioButton rdCadCliente;
    RadioButton rdCadProfssional;
    CompoundButton radioGroup1;
    BancoDados db = new BancoDados(this);
    Activity context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        context = this;
        editNome = (EditText) findViewById(R.id.editCadNome);
        editSobreNome = (EditText) findViewById(R.id.editCadSobrenome);
        editEmail = (EditText) findViewById(R.id.editCadEmail);
        editTelefone = (EditText) findViewById(R.id.editCadTelefone);
        editSenha = (EditText) findViewById(R.id.editCadSenha);
        editConfirmaSenha = (EditText) findViewById(R.id.editCadConfirmeSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadCdastar);
        rdCadCliente = (RadioButton) findViewById(R.id.rdCadCliente);
        rdCadProfssional = (RadioButton) findViewById(R.id.rdCadProfissional);

//        btnCadastrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(rdCadCliente.isChecked()) {
//                    Intent abrirTelaPrincipalCliente = new Intent(TelaCadastro.this, TelaCliente.class);
//                    startActivity(abrirTelaPrincipalCliente);
//                }if(rdCadProfssional.isChecked()){
//                    Intent abrirTelaPrincipalCliente = new Intent(TelaCadastro.this, TelaProfissional.class);
//                    startActivity(abrirTelaPrincipalCliente);
//                }
//            }
//
//        });

    }

    public void cadastrar(View view) {
        String nome = editNome.getText().toString();
        String sobrenome = editSobreNome.getText().toString();
        String email = editEmail.getText().toString();
        String telefone = editTelefone.getText().toString();
        String senha = editSenha.getText().toString();
        String confirmaSenha = editConfirmaSenha.getText().toString();

        if (nome.isEmpty()) {
            editNome.setError("Este campo é obrigatorio");

        } else {
            db.addCliente(new Cliente(nome, sobrenome, email, telefone, senha, confirmaSenha));
            Toast.makeText(context, "Salvo Com sucesso", Toast.LENGTH_LONG).show();
            limpaCampos();

        }
    }

    void limpaCampos() {
        editNome.setText("");
        editSobreNome.setText("");
        editEmail.setText("");
        editTelefone.setText("");
        editSenha.setText("");
        editConfirmaSenha.setText("");
        editNome.requestFocus();

    }
//
 //   spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
   //     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
   //         if (position == 0)
  //              spinner2.setEnabled(false);
    //        else
      //          spinner2.setEnabled(true);
       // }


   // public void onNothingSelected(AdapterView<?> parent) {

  //  }
//});



}
