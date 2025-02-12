import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  // Loads an image file  
  public ImageFilter(String fileName) {
    super(fileName);
  }

  // Converts the image to grayscale  
  public void grayscale() {
    Pixel[][] pixels = getImagePixels();

    // Loop through every pixel  
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {

        Pixel currentPixel = pixels[i][j];

        // Find the average of red, green, and blue values  
        int avg = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;

        // Set all color channels to the same average value  
        currentPixel.setRed(avg);
        currentPixel.setGreen(avg);
        currentPixel.setBlue(avg);
      }
    }
  }

  // Applies a "weighted random" color effect  
  public void weightedRandom() {
    Pixel[][] pixels = getImagePixels();

    // Loop through every pixel  
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {

        Pixel currentPixel = pixels[i][j];

        // Check which color is strongest  
        if (currentPixel.getRed() > currentPixel.getBlue() && currentPixel.getRed() > currentPixel.getGreen()) {
          // Keep red at full strength, randomize the others  
          currentPixel.setRed(255);
          currentPixel.setGreen((int)(Math.random() * 255));
          currentPixel.setBlue((int)(Math.random() * 255));
        } 
        else if (currentPixel.getBlue() > currentPixel.getRed() && currentPixel.getBlue() > currentPixel.getGreen()) {
          // Keep blue at full strength, randomize the others  
          currentPixel.setBlue(255);
          currentPixel.setGreen((int)(Math.random() * 255));
          currentPixel.setRed((int)(Math.random() * 255));
        } 
        else if (currentPixel.getGreen() > currentPixel.getBlue() && currentPixel.getGreen() > currentPixel.getRed()) {
          // Keep green at full strength, randomize the others  
          currentPixel.setGreen(255);
          currentPixel.setRed((int)(Math.random() * 255));
          currentPixel.setBlue((int)(Math.random() * 255));
        }
      }
    }
  }

  // Changes pixel colors based on brightness  
  public void colorize() {
    Pixel[][] pixels = getImagePixels();

    // Loop through every pixel  
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {

        Pixel currentPixel = pixels[i][j];

        // Find the average brightness  
        int avg = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;

        // Change color based on brightness level  
        if (avg < 85) {
          // Dark pixels become red  
          currentPixel.setRed(255);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0);
        } else if (avg < 170) {
          // Medium brightness pixels become green  
          currentPixel.setRed(0);
          currentPixel.setGreen(255);
          currentPixel.setBlue(0);
        } else {
          // Bright pixels become blue  
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
          currentPixel.setBlue(255);
        }
      }
    }
  }

  // Applies a pixelation effect  
  public void pixelate() {
    int gridSize = 8; // Size of each block  
    Pixel[][] pixels = getImagePixels();
    
    // Loop through pixels in steps of gridSize  
    for (int i = 0; i < pixels.length; i += gridSize) {
      for (int j = 0; j < pixels[0].length; j += gridSize) {

        double totalRed = 0;
        double totalGreen = 0;
        double totalBlue = 0;

        // Get the average color in the block  
        for (int k = 0; k < gridSize; k++) {
          for (int l = 0; l < gridSize; l++) {
            Pixel currentPixel = pixels[i + k][j + l];
            totalRed += currentPixel.getRed();
            totalGreen += currentPixel.getGreen();
            totalBlue += currentPixel.getBlue();
          }
        }

        // Calculate average color for the block  
        int avgRed = (int) (totalRed / (gridSize * gridSize));
        int avgGreen = (int) (totalGreen / (gridSize * gridSize));
        int avgBlue = (int) (totalBlue / (gridSize * gridSize));

        // Apply the average color to the block  
        for (int k = 0; k < gridSize; k++) {
          for (int l = 0; l < gridSize; l++) {
            Pixel currentPixel = pixels[i + k][j + l];
            currentPixel.setRed(avgRed);
            currentPixel.setGreen(avgGreen);
            currentPixel.setBlue(avgBlue);
          }
        }
      }
    }
  }
}