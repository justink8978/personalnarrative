import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    /*  
     Title text for the animation  
     First row: Main title words  
     Second row: Subtitle words  
    */
    String[][] titleArray = {
      {"Lebron's", "Career"},
      {"Team", "History"}
    };

    /*  
     Images used in the animation  
     First row: Team logos (Cavs, Heat, Cavs again, Lakers)  
     Second row: Lebron's career moments  
    */
    ImageFilter[][] imagesArray = {
      { new ImageFilter("cavs_logo.jpg"), new ImageFilter("heat_logo.png"), new ImageFilter("cavs2_logo.png"), new ImageFilter("lakers_logo.jpeg") },
      { new ImageFilter("lebron1.jpg"), new ImageFilter("lebron2.jpeg"), new ImageFilter("lebron3.jpg"), new ImageFilter("lebron4.jpeg") }
    };

    /*  
     Image labels and filters  
     First row: Names for each Lebron image  
     Second row: Filters applied to each image  
    */
    String[][] array = {
      {"Lebron 1", "Lebron 2","Lebron 3","Lebron 4"},
      {"Colorize", "Grayscale","Pixelate","Weighted Random"}
    };

    // Create the scene using text, images, and labels  
    MyStory scene = new MyStory(titleArray, imagesArray, array);
    
    // Draw the scene  
    scene.drawScene();
    
    // Play the scene in the Theater  
    Theater.playScenes(scene);
  }
}