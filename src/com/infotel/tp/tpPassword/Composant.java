package com.infotel.tp.tpPassword;
import java.util.*;

/**
 * 
 */
public abstract class Composant {
	
	protected int index = 0;
	protected String word = "";
	
    public abstract String getWord();

	/**
     * @return
     */
    public abstract int getIndex();

}