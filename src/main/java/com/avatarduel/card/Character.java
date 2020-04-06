import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character extends Card{
    private int attack;
    private int defense;
    private boolean atkposition;
    private BufferedImage image;
    
    public BufferedImage getImage(){
        return image;
    }

    public Character(String name,String description,String element, int attack, int defense) throws IOException{
        super(name,description,element);
        this.attack = attack;
        this.defense = defense;
        this.atkposition = false;
        try {
            this.image = ImageIO.read(new File("src/main/resources/com/avatarduel/card/image/character/"+this.getName()+"/.png"));
        } catch(Exception e){
            System.out.println(this.getName());
            System.out.println(this.getName()+ " card not found");
        }
    }

    public int getAttack(){
        return this.attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getDefense(){
        return this.defense;
    }

    public void setDefense(){
        this.defense = defense;
    }

    public boolean isAttackPos(){
        return this.atkposition;
    }

    public void setPosition(boolean atkposition){
        this.atkposition = atkposition;
    }

}