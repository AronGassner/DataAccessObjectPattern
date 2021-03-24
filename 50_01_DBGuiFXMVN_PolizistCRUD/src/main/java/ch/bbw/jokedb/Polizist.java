package ch.bbw.jokedb;
/**
 * Entität Polizist
 * @author Peter Rutschmann
 * @date 03.07.2020
 */
public class Polizist {
	int polizistID;
	String name;
	String vorname;
	int gruppeIDFS;
	int partnerPolizistIDFS;
	
	public Polizist(int polizistID, String name, String vorname, int gruppeIDFS, int partnerPolizistIDFS) {
		super();
		this.polizistID = polizistID;
		this.name = name;
		this.vorname = vorname;
		this.gruppeIDFS = gruppeIDFS;
		this.partnerPolizistIDFS = partnerPolizistIDFS;
	}

	@Override
	public String toString() {
		return "Polizist [polizistID=" + polizistID + ", name=" + name + ", vorname=" + vorname
				+ ", gruppeIDFS=" + gruppeIDFS + ", partnerPolizistIDFS=" + partnerPolizistIDFS + "]";
	}
}
