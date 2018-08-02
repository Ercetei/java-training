package com.infotel.tp.tp11.utils;

public class TpUtils {
	public String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
}
