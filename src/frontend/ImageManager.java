package frontend;

import backend.element.*;
import backend.cell.*;

import backend.element.HorizontalStrippedCandy;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageManager {

	private Map<String, Image> images;

	public ImageManager() {
		
		WrappedCandy wc = new WrappedCandy();
		VerticalStrippedCandy vc = new VerticalStrippedCandy();
		HorizontalStrippedCandy hc = new HorizontalStrippedCandy();
		
		images = new HashMap<String, Image>();

		try {
			images.put(new Nothing().getKey(), ImageIO.read(new File("resources/images/nothing.png")));
			images.put(new Bomb().getKey(), ImageIO.read(new File("resources/images/bomb.png")));
			images.put(new Wall().getKey(), ImageIO.read(new File("resources/images/wall.png")));
			images.put(new JellyCell().getKey(), ImageIO.read(new File("resources/images/jelly.png")));
			images.put(new BlankElement().getKey(), ImageIO.read(new File("resources/images/arrowLogo.png")));
            images.put(new Blank().getKey(), ImageIO.read(new File("resources/images/nothing.png")));

            for (FoodType ft: FoodType.values()){
                images.put(new Food(ft).getFullKey(), ImageIO.read(new File("resources/images/" + ft.toString().toLowerCase() + "Food.png")));
            }

			for (CandyColor cc: CandyColor.values()) {
				images.put(new Candy(cc).getFullKey(), ImageIO.read(new File("resources/images/" + cc.toString().toLowerCase() + "Candy.png")));
			}
			
			for (CandyColor cc: CandyColor.values()) {
				wc.setColor(cc);
				images.put(wc.getFullKey(), ImageIO.read(new File("resources/images/" + cc.toString().toLowerCase() + "Wrapped.png")));
			}
			
			for (CandyColor cc: CandyColor.values()) {
				vc.setColor(cc);
				images.put(vc.getFullKey(), ImageIO.read(new File("resources/images/" + cc.toString().toLowerCase() + "VStripped.png")));
			}

			for (CandyColor cc: CandyColor.values()) {
				hc.setColor(cc);
				images.put(hc.getFullKey(), ImageIO.read(new File("resources/images/" + cc.toString().toLowerCase() + "HStripped.png")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage(Element e) {
		return images.get(e.getFullKey());
	}

    public Image getImage(Cell cell){
        return images.get(cell.getKey());
    }
}
