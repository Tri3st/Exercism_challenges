public class Strike extends Frame {
  private int extra1;
  private int extra2;
  
  public Strike(int first, int second){
    super(first, second);
  }
  
  public void setExtras(int extra1, int extra2){
    this.extra1 = extra1;
    this.extra2 = extra2;
  }
  
  public int getScore(){
    return super.getScore() + this.extra1 + this.extra2;
  }
  
  @Override
  public String toString(){
    String t="";
    t += "+---+---+\n";
    t += String.format("| %s |   |%d%n","X", this.getScore());
    t+= "+---+---+\n";
    return t;
  }
}
