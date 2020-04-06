public class Card {
    private String name;
    private String description;
    private String element;

    public Card(String name, String description, String element){
        this.name = name;
        this.description = description;
        this.element = element;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.description;
    }

    public String getElement(){
        return this.element;
    }
    
}
