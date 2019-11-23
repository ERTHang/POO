package exceptions;

public class InformacaoNaoEncontradaException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -6469844397266910189L;

    public InformacaoNaoEncontradaException() {
    }

    public InformacaoNaoEncontradaException(String message) {
        super(message);
    }
    
}