# rampcreator
A Colour Ramp creator for maps and games

A Java implementation of this Javascript code
http://jsfiddle.net/vksn3yLL/

The goal is to take some color samples and create a gradient for "colorize" elevations, biomes and many other things.

The values in example will create a ramp like this:

![Example](/example.jpeg)

Then you can take any color from the middle samples passing a value between 0 .. 1 to getColorAt() being 0 the first color in sample and 1 the last color in sample. Any value will calculate the correspondent color in gradient ( 0.8 = #B0DCB5 ).

https://codereview.stackexchange.com/questions/261447/colour-ramp-for-maps


Usage:

```
    public static void main(String[] args) {
        ColorGradientGenerator cg = new ColorGradientGenerator();
        
        try {
            cg.addToGradient(0,   128, 64, 0, 255);
            cg.addToGradient(50,  58, 168, 69, 255);
            cg.addToGradient(100, 255, 255, 255, 255);
            
            cg.getColorAt(0.0);
            cg.getColorAt(0.5);
            cg.getColorAt(0.8);
            cg.getColorAt(1.0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```    
