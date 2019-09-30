
public class OU{
	private boolean resultado;
	
	public void OR(boolean[] ArrayBooleanos) {
		for(boolean bool:ArrayBooleanos) {
			if(bool) {
				setResultado(true);
				return;
			}
		}
		setResultado(false);
	}
	
	public void OR(int[] ArrayBooleanos) {
		for(int num:ArrayBooleanos) {
			if(num == 1) {
				setResultado(true);
				return;
			}
		}
		setResultado(false);
	}
	
	public boolean bool() {
		return resultado;
	}

	public int num() {
		return (resultado) ? 1 : 0;
	}
	
	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
}
