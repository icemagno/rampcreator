
public class Main{
	
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
	
}