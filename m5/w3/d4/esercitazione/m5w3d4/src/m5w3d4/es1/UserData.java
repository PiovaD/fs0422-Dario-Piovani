package m5w3d4.es1;

public class UserData implements DataSource{
	private String nomeCompleto;
	private int eta;

	public void getData(DataSource ds) {
		nomeCompleto = ds. getNomeCompleto (); 
		 eta = ds.getEta(); 
	}

	@Override
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	@Override
	public int getEta() {
		return eta;
	}


}
