
public class PizzaInfo {
    private String pName;
    private String size;
    private int prize;
    
    public PizzaInfo(String pName,String size, int prize){
        this.pName = pName;
        this.size = size;
        this.prize = prize;
    }
    
    
    public String getPname(){
        return pName;
    }
    public String getSize(){
        return size;
    }
    public int getPrize(){
        return prize;
    }
}
