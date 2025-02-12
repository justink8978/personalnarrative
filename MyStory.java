import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Stores title text for the animation  
  private String[][] titleArray;

  // Stores images of team logos and Lebron  
  private ImageFilter[][] imagesArray;

  // Stores labels for images and their filters  
  private String[][] array;

  // Constructor to set up the scene  
  public MyStory(String[][] titleArray, ImageFilter[][] imagesArray, String[][] array) {
    this.titleArray = titleArray;
    this.imagesArray = imagesArray;
    this.array = array;
  }

  // Runs all scenes in order  
  public void drawScene() {
    drawFirstScene();
    drawSecondScene();
    applyFilters();
  }

  // Displays the title screen with text  
  public void drawFirstScene() {
    clear("white");

    // Display each text element one by one with pauses  
    drawText(titleArray[0][0], 50, 100);
    pause(0.5);
    drawText(titleArray[0][1], 250, 100);
    pause(0.5);
    drawText(titleArray[1][0], 50, 300);
    pause(0.5);
    drawText(titleArray[1][1], 250, 300);

    pause(1.0);
  }

  // Displays team logos with sounds  
  public void drawSecondScene() {
    clear("white");
    
    // Show each team logo and play a note  
    drawImage(imagesArray[0][0], 0, 0, 200);
    playNote(65,2);
    pause(0.5);
    drawImage(imagesArray[0][1], 200, 0, 200);
    playNote(70,2);
    pause(0.5);
    drawImage(imagesArray[0][2], 0, 200, 200);
    playNote(75,2);
    pause(0.5);
    drawImage(imagesArray[0][3], 200, 200, 200);
    playNote(80,2);
    pause(1.0);
  }

  // Randomly applies filters to images  
  public void applyFilters() {
    
    // Array to track which images have been used  
    int[] ints = {0,1,2,3};

    // Loop to process each image  
    for (int i = 0; i < 4; i++) {
      
      int selected = -1;

      // Pick a random index from 0 to 3  
      int random_num = (int) (Math.random() * 4);

      // If the randomly picked index is still available, use it  
      if (ints[random_num] != -1) {
        selected = ints[random_num]; 
        ints[random_num] = -1; // Mark it as used  
      } else {
        // If it's already used, find the next available one  
        for (int j = 0; j < ints.length; j++) {
          if (ints[j] != -1) {
            selected = ints[j]; 
            break; // Stop looking once found  
          }
        }
        ints[selected] = -1; // Mark this one as used too  
      }

      // Show and apply a filter to the selected image  
      if (array[0][selected].equals("Lebron 1")) {
        drawImage(imagesArray[1][0], 0, 0, 200);
        pause(0.5);
        selectFilter(0);
        drawImage(imagesArray[1][0], 0, 0, 200);
      }
      if (array[0][selected].equals("Lebron 2")) {
        drawImage(imagesArray[1][1], 200, 0, 200);
        pause(0.5);
        selectFilter(1);
        drawImage(imagesArray[1][1], 200, 0, 200); 
      }
      if (array[0][selected].equals("Lebron 3")) {
        drawImage(imagesArray[1][2], 0, 200, 200);
        pause(0.5);
        selectFilter(2);
        drawImage(imagesArray[1][2], 0, 200, 200);
      }
      if (array[0][selected].equals("Lebron 4")) {
        drawImage(imagesArray[1][3], 200, 200, 200);
        pause(0.5);
        selectFilter(3);
        drawImage(imagesArray[1][3], 200, 200, 200);
      }
    }
  }

  // Applies the correct filter to an image based on its index  
  public void selectFilter(int index) {
    if (array[1][index].equals("Colorize")) {
      imagesArray[1][index].colorize();
    }
    if (array[1][index].equals("Grayscale")) {
      imagesArray[1][index].grayscale();
    }
    if (array[1][index].equals("Pixelate")) {
      imagesArray[1][index].pixelate();
    }
    if (array[1][index].equals("Weighted Random")) {
      imagesArray[1][index].weightedRandom();
    }
  }
}