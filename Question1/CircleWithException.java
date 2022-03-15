package Question1;
import java.util.Scanner;

public class CircleWithException{
    
    private float radius = 0;
    private static boolean radiusState = false;
    private static boolean run = false;

    public void setRadius(float radius) throws IllegalArgumentException{
        if (radius <= 0){
            throw new IllegalArgumentException("\n++++++++++++++++++++++++++++++++++++\n|ERROR| Radius cannot be negative!\n++++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("Radius set to: " + radius);
            this.radius = radius;
            radiusState = true;
        }
    }

    public float getRadius(){
        return this.radius;
    }

    public float getArea() throws Exception{
        float area = (float) (Math.PI*Math.pow(getRadius(),2));
        if(area > 1000){
            throw new Exception("\n++++++++++++++++++++++++++++++++++++\n|ERROR| Area is bigger than 1000. Pick a smaller radius.\n++++++++++++++++++++++++++++++++++++");
        }else{
            run = true;
            return area;
        }
    }

    public float getDiameter(){
        return 2*this.radius;
    }

    public static void main (String[] args){
        
        Scanner userInput = new Scanner(System.in);
        CircleWithException Circle = new CircleWithException();
        
        while(!run){
            while(!radiusState){
                try{
                    System.out.print("\nEnter a positive radius: ");
                    float value = userInput.nextInt();
                    Circle.setRadius(value);
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }

            radiusState = false;
            try{
                float value = Circle.getArea();
                System.out.println("\n======================");
                System.out.println("The area is: " + value);
                System.out.println("======================\n");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        userInput.close();
    }
}