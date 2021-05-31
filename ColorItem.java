package br.com.cmabreu.color;

import java.awt.Color;

public class ColorItem {
	private int index;
	private Color color;

	public ColorItem( int index, Color color ) {
		this.color = color;
		this.index = index;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getIndex() {
		return index;
	}
	
}
