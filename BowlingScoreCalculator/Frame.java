public class Frame {
  protected int first;
  protected int second;
  private int points;
  
  public Frame(int first, int second){
    this.first = first;
    this.second = second;
  }
  
  public int getFirst(){
    return this.first;
  }
  
  public int getSecond(){
    return this.second;
  }
  
  public int getScore(){
    return this.first + this.second;
  }
  
  public void setExtra1(int t){
    return;
  }
  
  public void setExtras(int t1, int t2){
    return;
  }
  
  @Override
  public String toString(){
    String t="";
    t += "+---+---+\n";
    t += String.format("| %d | %d |%d%n",this.first, this.second, this.getScore());
    t+= "+---+---+\n";
    return t;
  }
}
