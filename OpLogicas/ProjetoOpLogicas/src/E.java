
public class E{
	private boolean resultado;
	
	public void And(boolean[] ArrayBooleanos) {
		for(boolean bool:ArrayBooleanos) {
			if (!bool){
				setResultado(false);
				return;
			}
		}
		setResultado(true);
	}
	
	public void And(int[] ArrayBooleanos) {
		for(int Num:ArrayBooleanos) {
			if (Num == 0){
				setResultado(false);
				return;
			}
		}
		setResultado(true);
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
