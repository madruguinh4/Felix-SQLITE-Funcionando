package tcc.usjt.felix113;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE ="bd_clientes";

    //
    private static final String TABELA_CLIENTE ="tb_clientes";

    // campos do banco:
    private static final String COLUNA_CODIGO="codigo";
    private static final String COLUNA_NOME  ="nome";
    private static final String COLUNA_SOBRENOME =" sobrenome";
    private static final String COLUNA_EMAIL ="email";
    private static final String COLUNA_TELEFONE ="telefone";
    private static final String COLUNA_SENHA ="senha";
    private static final String COLUNA_CONFIRMASENHA ="confirmaSenha";


    public BancoDados (Context context)
    {
        super (context,BANCO_CLIENTE,null,VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase db)
    {
        //executa apenas a primeira vez
        String QUERY_COLUNA = "Create table "+ TABELA_CLIENTE + "("
                +COLUNA_CODIGO + " INTEGER PRIMARY KEY," + COLUNA_NOME+" TEXT ,"
                +COLUNA_SOBRENOME+" TEXT ,"
                +COLUNA_EMAIL+" TEXT ,"
                +COLUNA_TELEFONE+" TEXT ,"
                +COLUNA_SENHA+" TEXT ,"
                +COLUNA_CONFIRMASENHA+" TEXT0)";


        //Executar query acima
        db.execSQL(QUERY_COLUNA);
    }

    /*Crud abaixo*/
    void addCliente(Cliente cliente){

        //referenciar o banco de dados:
        //write serve para escrever os dados
        SQLiteDatabase db = this.getWritableDatabase();

        // Responsavel por captar os dados que serão enviados ao banco:
        ContentValues values = new ContentValues();

        //pega os dados passados na classe cliente.
        values.put(COLUNA_NOME,cliente.getNome());
        values.put(COLUNA_SOBRENOME,cliente.getSobreNome());
        values.put(COLUNA_EMAIL,cliente.getEmail());
        values.put(COLUNA_TELEFONE,cliente.getTelefone());
        values.put(COLUNA_SENHA,cliente.getSenha());
        values.put(COLUNA_CONFIRMASENHA,cliente.getConfirmaSenha());

        try{
            db.insert(TABELA_CLIENTE,null,values);}
        catch (Exception e){
            e.printStackTrace();
        }
        Log.i("BANCO","DADOS");
        db.close();

    }
    void apagarCliente(Cliente cliente){
        //escrever no banco
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_CLIENTE, COLUNA_CODIGO + " = ? ", new String[]{ String.valueOf(cliente.getCodigo())});

        //fechar o banco de dados:
        db.close();
    }

    @Override
    /**Atualizar o banco, instanciando um novo,Exemplo:
     -Tem uma tabela com 4 campos e agora quer adicionar mais um, entao
     ele copia os dados da tabela, apaga e cria uma nova*/
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
