public class ProgramacaoPorContratoExample {

    public void emprestarLivro(int usuarioId, int livroId, int maxDias) {
        assert usuarioId > 0 : "Usuário deve ser informado";
        assert livroId > 0 : "Livro deve ser informado";
        assert maxDias > 0 : "Quantidade máxima de dias deve ser positiva";

        System.out.println("Exemplo de programação por contrato executado com sucesso.");
    }
}