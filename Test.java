public class Test extends Model{
  public static void main(String[] args) {

    String basePath = "./data/";


    Model model = new Model();
    Model.DataManager loadData = model.new DataManager(basePath);
    
  }
}