package org.sc.models;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8210551665835499908L;
	//Atributos da classe
	private int registry = 0;
	private String name = null;
	private String warName  = null;	
	private int RG = 0;
	private int battalion = -1;
	private int patent = 0;
	private String status  = null;
	
	public User(int registry, String name, String warName, int rG, int battalion, int patent, String status) throws Exception {
		setName(name);
		setWarName(warName);
		setRegistry(registry);
		setBattalion(battalion);
		setPatent(patent);
		setRG(rG);
		setStatus(status);		
	}
        

	/**
	 * @return the registry
	 * @throws Exception 
	 */
	public int getRegistry() throws Exception {
		if (this.registry == 0) {
			throw new Exception("No Registry!");
		}
		return registry;
	}

	/**
	 * @param registry the registry to set
	 * @throws Exception 
	 */
	public void setRegistry(int registry) throws Exception {
		if (registry == 0) {
			throw new Exception("Data Invalid!");
		}
		this.registry = registry;
	}

	/**
	 * @return the name
	 * @throws Exception 
	 */
	public String getName() throws Exception {
		if (this.name == null) {
			throw new Exception("No Name!");
		}
		return name;
	}

	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setName(String name) throws Exception {
		if (name == null) {
			throw new Exception("Data invalid!");			
		}
		this.name = name;
	}

	/**
	 * @return the warName
	 * @throws Exception 
	 */
	public String getWarName() throws Exception {
		if (this.warName == null) {
			throw new Exception("No War Name!");			
		}
		return warName;
	}

	/**
	 * @param warName the warName to set
	 * @throws Exception 
	 */
	public void setWarName(String warName) throws Exception {
		if (warName == null) {
			throw new Exception("Data invalid!");			
		}
		this.warName = warName;
	}

	/**
	 * @return the rG
	 * @throws Exception 
	 */
	public int getRG() throws Exception {
		if (this.RG == 0) {
			throw new Exception("No RG!");			
		}
		return RG;
	}

	/**
	 * @param rG the rG to set
	 * @throws Exception 
	 */
	public void setRG(int rG) throws Exception {
		if (rG == 0) {
			throw new Exception("Data invalid!");			
		}
		this.RG = rG;
	}

	/**
	 * @return the battalion
	 * @throws Exception 
	 */
	public int getBattalion() throws Exception {
		if (this.battalion == -1) {
			throw new Exception("No Battalion!");			
		}
		return battalion;
	}

	/**
	 * @param battalion the battalion to set
	 * @throws Exception 
	 */
	public void setBattalion(int battalion) throws Exception {
		if (battalion == -1) {
			throw new Exception("Data invalid!");			
		}
		this.battalion = battalion;
	}

	/**
	 * @return the patent
	 * @throws Exception 
	 */
	public int getPatent() throws Exception {
		if (this.patent == 0) {
			throw new Exception("No Patent!");			
		}
		return patent;
	}

	/**
	 * @param patent the patent to set
	 * @throws Exception 
	 */
	public void setPatent(int patent) throws Exception {
		if (patent == 0) {
			throw new Exception("Data invalid!");			
		}
		this.patent = patent;
	}

	/**
	 * @return the status
	 * @throws Exception 
	 */
	public String getStatus() throws Exception {
		if (this.status == null) {
			throw new Exception("No Status!");			
		}
		return this.status;
	}

	/**
	 * @param status the status to set
	 * @throws Exception 
	 */
	public void setStatus(String status) throws Exception {
		if (status == null) {
			throw new Exception("Data invalid!");			
		}
		this.status = status;
	}
	
	
	

}
