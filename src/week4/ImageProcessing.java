package week4;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/*
 * assume inverting image requires taking pixels in width and height into an array and flip, then place into a return val
 * 
 * 
 */

public class ImageProcessing extends GraphicsProgram 
{
	
	/*INSTANCE VARIABLES*/
	// private static final int HORIZONTAL = 1;
	
	/*
	public void run() 
	{
		
		// File input = new File("C:\\Users\\Dave\\Desktop\\prettybrit.jpg");											// change file path here to flip image
		// File output = new File("C:\\Users\\Dave\\Desktop\\prettybritflipped.jpg");									// change file path here to store new flipped image
		// flipImageHorizontal(input, output, HORIZONTAL);
		
		flipHorizontal(image);
	}
	
	private void flipImageHorizontal(File imageToFlip, File newFlippedImage, int directionOfFlip) 
	{
		try
		{
			BufferedImage image = ImageIO.read(imageToFlip);
			int width = image.getWidth();
			int height = image.getHeight();
			BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			for(int y = 0; y < height; y++)
			{
				for(int x = 0; x < width; x++)
				{
					newImage.setRGB((width - 1) - x, y, image.getRGB(x, y));
				}
			}
			
			ImageIO.write(newImage, "jpg", newFlippedImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	*/
	
	private GImage flipHorizontal(GImage img) 
	{
		int[][] arr = img.getPixelArray();						// get 2D array of pixel values from the stored img
		int width = arr[0].length;								// store '2nd' arr as width
		int height = arr.length;								// store parent arr as height
		for (int i = 0; i < height; i++) 						// iterate over height array, 1 index at time (column)
		{														
			for (int j = 0; j < width / 2; j++) 				// iterate over each column as defined my parent for loop. Divide width by 2 since it will be the same past halfway point of image
			{
				int p2 = width - j - 1;							// store width of image, minus j and minus 1. This gives us the last index value in the row (since index begins at 0)
				int temp = arr[i][j];							// init a temp array to push values to, and since height is remaining he same and not getting swapped
				arr[i][j] = arr[i][p2];							// store new values p2 and i(which hasn't been change to a diff value) and store into temp arr
				arr[i][p2] = temp;								// store new array into temp. this overwrites the horizontal position so that next iteration will grab the new 'length' value at end of row
			}
		}
		return new GImage(arr);									// returns the new array after swap and iterations are finished
	}


}
