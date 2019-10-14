package exceptions;

public class InformacaoNaoEncontradaException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InformacaoNaoEncontradaException() {

    }
    public InformacaoNaoEncontradaException(String mensagem){
        super(mensagem);
    }

}