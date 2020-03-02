public class Asset{
  private double Price;
  private double Income;
  private double Lost;
  private boolean canBeSold;
  private String name;

  public void Asset(){
    Price=0;
    Income=0;
    Lost=0;
    name="";
    canBeSold=false;
  }

  public void Asset(String name, double Price, double Income, boolean canBeSold){
    this.name=name;
    this.Price=Price;
    this.Income=Income;
    this.canBeSold=canBeSold;
  }

  public void setPrice(double in){
    Price=in;
  }
  public double getPrice(){
    return Price;
  }

  public void setIncome(double in){
     Income=in;
  }

  public double Income(){
    return Income;
  }

  public void setLost(double in){
    Lost=in;
  }
  
  public double getLost(){
    return Lost;
  }

  public boolean getCanBeSold(){
    return canBeSold;
  }

  public String getName(){
    return name;
  }

}