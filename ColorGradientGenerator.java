package br.com.cmabreu.color;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorGradientGenerator {
	private List<ColorItem> gradient;
	
	public ColorGradientGenerator() {
		this.gradient = new ArrayList<ColorItem>();
	}
	
	public void addToGradient( int index, int red, int green, int blue, int alpha ) throws Exception {
		if( index > 100 ) throw new Exception("Index must be <= 100");
		if( index < 0 )   throw new Exception("Index must be >= 0");
		Color color = new Color(red,green,blue,alpha);
		gradient.add( new ColorItem( index, color ) );
	}

	
	public void removeFromGradient( int index ) {
		gradient.remove(index);
	}
	
	private ColorItem getItemZero() throws Exception {
		for ( ColorItem colorItem : gradient  ) {
			if( colorItem.getIndex() == 0 ) return colorItem;
		}
		throw new Exception("Cannot find lower bound color");
	}
	
	
	public Color getColorAt( double value ) throws Exception {
		ColorItem firstColor = null, secondColor = null;
		double firstColorX, secondColorX;
		value = value * 100;
		int iVal = (int)value;
		
		firstColor = getItemZero();
		for ( ColorItem colorItem : gradient  ) {
		    if( iVal <= colorItem.getIndex() ) {
		    	secondColor = colorItem;
		    	break;
		    } else {
		    	firstColor = colorItem;
		    }
		}
		if( secondColor == null ) throw new Exception("Cannot find upper bound color");
		
		firstColorX =  firstColor.getIndex();
		secondColorX = secondColor.getIndex() - firstColorX;
		
		double sliderX = (double)iVal - (double)firstColorX;
		
		double ratio = 0.0;
		if( secondColor.getIndex() > 0) {
			ratio = sliderX / (double)secondColorX;
		}  
		// System.out.println("Sx: " + sliderX + "   Fc: " + firstColor.getIndex() + "  Sc: " + secondColor.getIndex() + "  Ratio: " + ratio );		
        return pickHex( firstColor.getColor(), secondColor.getColor(), ratio);
	}

	
	private Color pickHex( Color firstColor, Color secondColor, double weight ) {
		double w  = weight * 2 - 1;
		double w1 = ( w / 1+1 ) / 2;
		double w2 = 1 - w1;
		
		long red   = Math.round( secondColor.getRed()   * w1 + firstColor.getRed()   * w2 );
		long green = Math.round( secondColor.getGreen() * w1 + firstColor.getGreen() * w2 );
		long blue  = Math.round( secondColor.getBlue()  * w1 + firstColor.getBlue()  * w2 );
		
		//String hex = String. format("#%02X%02X%02X", red, green, blue);
		//System.out.println( red + "," + green + "," + blue + " ||  " + hex );
		
		return new Color( (int)red, (int)green, (int)blue );
	}
	
	
}
