public class Control extends Model {
  public static void main(String[] args) {
    
    Model m1 = new Model();
    Model.UserAccountManagement inner = m1.new UserAccountManagement();
    String x ;
    String y;
    inner.registerUser ( x,y);

  }



}
