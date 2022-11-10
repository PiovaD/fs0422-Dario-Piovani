package m5w3d4.es3;

public abstract class Carabiniere {

	private Carabiniere superiore;
	
	private int stipendio;

	public Carabiniere getSuperiore() {
		return superiore;
	}

	public void setSuperiore(Carabiniere superiore) {
		this.superiore = superiore;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	
	
	//public abstract void testStipendio(int s)
	
	public void testStipendio(int s){
		
		if(this.getStipendio()>=s) {
			System.out.println(this.getClass().getSimpleName());
		}
		
		if(getSuperiore()!= null)
		getSuperiore().testStipendio(s);
		
	}
	
	
}
