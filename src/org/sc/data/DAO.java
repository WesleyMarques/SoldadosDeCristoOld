/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sc.data;

import java.util.List;
import org.sc.codes.User;

/**
 *
 * @author Wesley
 */
public interface DAO {
    /**
     * 
     * @return
     * @throws Exception
     */
	public boolean open() throws Exception;
	
    /**
     * 
     * @return
     * @throws Exception 
     */
    public List<User> loadUsers() throws Exception;
    
    /**
     * 
     * @param file
     * @return
     * @throws Exception 
     */
    public List<Object> readData(String file) throws Exception;
    
    /**
     * 
     * @param file
     * @return
     * @throws Exception 
     */
    public boolean saveData(String file) throws Exception;
    
    
    
    
    
}
