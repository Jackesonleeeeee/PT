import java.util.ArrayList;
class Player{
  private double money;
  boolean haveJob=false;
  boolean canApplyJob=true;
  int nHouse=0;
  private ArrayList<Asset> asset;
  int roundIndex=0;
  
  public void Player(){
    money=0;
    asset=new ArrayList<Asset>();
    haveJob=false;
    canApplyJob=true;
    nHouse=0;
    roundIndex=0;
  }

  public void Player(double money_in){
    money=money_in;
    asset=new ArrayList<Asset>();
  }
  
  public void spend(double in){
    money-=in;
  }

  public void earn(double in){
    money+=in;
  }

  public double getMoney(){
    return money;
  }

  public int getNumofAsset(){
    return asset.size();
  }

  public Asset getAsset(int in){
    return asset.get(in);
  }
  public Asset getAsset(String in){
    for(int x=0;x<asset.size();x++)
      if(asset.get(x).getName().equals(in))
        return asset.get(x);
    return null;
  }

  public void setAsset(Asset in){
    asset.add(in);
  }

  public void soldAsset(String in){
    for(int x=0;x<asset.size();x++){
      if(asset.get(x).getName().equals(in))
      {
        asset.remove(x);
        break;
      }
    }
  }
}