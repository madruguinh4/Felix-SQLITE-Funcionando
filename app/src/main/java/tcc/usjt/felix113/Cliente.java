package tcc.usjt.felix113;


public class Cliente {
    int    codigo;
    String nome;
    String sobreNome;
    String email;
    String telefone;
    String senha;
    String confirmaSenha;


    //Construtor vazio para instanciar em algum momemento em outra classe.
    public Cliente(){

    }

    // para realizar update no banco, se cria mesma variavel com nomes diferentes (_).
    //UPDATE
    public Cliente (int _codigo, String _nome, String _sobreNome,String _email, String _telefone, String _senha, String _confirmaSenha)
    {
        //Referenciando as varias do construtor e passando os valores que receberam futuramente.
        this.codigo = _codigo;
        this.nome = _nome;
        this.sobreNome = _sobreNome;
        this.email = _email;
        this.telefone = _telefone;
        this.senha = _senha;
        this.confirmaSenha = _confirmaSenha;

    }

    // Insert
    public Cliente( String _nome, String _sobreNome,String _email, String _telefone, String _senha, String _confirmaSenha )
    {
        //Referenciando as varias do construtor e passando os valores que receberam futuramente:
        this.nome = _nome;
        this.sobreNome = _sobreNome;
        this.email = _email;
        this.telefone = _telefone;
        this.senha = _senha;
        this.confirmaSenha = _confirmaSenha;
    }

    //=========================================================================
    // para obter e definir dados:


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
