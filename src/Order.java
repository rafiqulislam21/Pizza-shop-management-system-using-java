
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;

public class Order{

    public int pPrize;
    public int totalAmount;
    public double vat;
    public String pName;
    public String pSize;
   public double orderNUm;
    public double bill = 0;

    
    public Order() {

    }
    
    public Order(String pName, String pSize, int pPrize, int totalAmount,String order) {
        this.pPrize = pPrize;
        this.totalAmount = totalAmount;
        this.pSize = pSize;
        this.pName = pName;
        this.orderNUm=Double.parseDouble(order)+1;

    }

    public double getVat() {
        
        return (this.getBill()*2)/100 ;
    }

    public double getBill() {

        bill = this.pPrize * this.totalAmount;

        return bill;
    }
    
    

    public void file() {
        File f = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            
             fw=   new FileWriter("src/OrderDetails.txt",true);


           
            bw = new BufferedWriter(fw);
            bw.newLine();

            bw.write(this.orderNUm+"| "+this.pName + "| " + this.pSize + "| " + this.totalAmount+
                        "| "+(this.getBill()+this.getVat())+"|   "+zdt);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
            }
        }
    }
    ZonedDateTime zdt = ZonedDateTime.now();
   

    public String finalBill() {
        
      String s;
      s= "\n--------------------------------Bill---------------------------------"
                           +"\nOrder Number:  " +this.orderNUm
                            +"\npizza name :  " + this.pName
                            +"\npizza Size :  " + this.pSize
                            +"\npizza amount :  " + this.totalAmount
                            +"\nPizza price =  " + this.getBill()
                            +"\nVAT 2% =  " + this.getVat()
                            +"\nTotal Bill(included 2% vat) =  "+ (this.getBill()+this.getVat())
                            +"\nTime :  "
                            +this.zdt
                            +"\n---------------------------Thank you----------------------------";
      
    
      return s;
    }
    
}
