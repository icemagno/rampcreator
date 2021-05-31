# rampcreator
A Colour Ramp creator for maps and games

A Java implementation of this Javascript code
http://jsfiddle.net/vksn3yLL/

The goal is to take some color samples and create a gradient for "colorize" elevations, biomes and many other things.

The values in example will create a ramp like this:
![Example](/example.jpeg)

Then you can take any color from the middle samples passing a value between 0 .. 1 to getColorAt() being 0 the first color in sample and 1 the last color in sample. Any value will calculate the correspondent color in gradient ( 0.8 = #B0DCB5 ).
