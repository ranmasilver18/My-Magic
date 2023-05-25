package MODEL;

public class CartaModel {
	private int ID;
	private String CODE;
	private String NAME;
	private String CATEGORY;
	private String VALOR;
	private String QNT;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getCODE() {
		return CODE;
	}
	public void setCODE(String cODE) {
		this.CODE = cODE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		this.NAME = nAME;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		this.CATEGORY = cATEGORY;
	}
	public String getVALOR() {
		return VALOR;
	}
	public void setVALOR(String vALOR) {
		this.VALOR = vALOR;
	}
	public String getQNT() {
		return QNT;
	}
	public void setQNT(String qNT) {
		this.QNT = qNT;
	}
	
	@Override
	public String toString() {
		return "CartaModel [ID=" + ID + ", CODE=" + CODE + ", NAME=" + NAME + ", CATEGORY=" + CATEGORY + ", VALOR="
				+ VALOR + ", QNT=" + QNT + "]";
	}
	
	public CartaModel() {
		super();
	}
	
}
