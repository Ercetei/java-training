package com.infotel.tp.tpPassword;

import java.util.*;

/**
 * 
 */
public class SentenceComposite extends Composant {

    /**
     * Default constructor
     */
    public SentenceComposite() {
    }

    /**
     * 
     */
    private List<Word> children = new ArrayList<Word>();

    /**
     * @return
     */
    public void SentenceComposite() {
    }

    /**
     * @param word 
     * @return
     */
    public void add(Word word) {
    	this.children.add(word);
    }

    /**
     * @param word 
     * @return
     */
    public void remove(Word word) {
    	this.children.remove(word);
    }

    /**
     * @return
     */
    public Iterator getChildren() {
        return children.iterator();
    }

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return this.index;
	}

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return this.word;
	}



}