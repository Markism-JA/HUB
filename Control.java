import java.util.*;
public class Control extends Model {
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    // Get the user's decision
    System.out.println("Enter your choice (High, Mid, Low): ");
    String userDecision = scanner.nextLine();

    // Get the component type (CPU or GPU)
    System.out.println("Enter the component type (CPU or GPU): ");
    String componentType = scanner.nextLine();

    Model m1 = new Model();
    Model.PriceComparison inner = m1.new PriceComparison(userDecision);

    if (componentType.equalsIgnoreCase("CPU")) {  
        // Read CPUs from CSV
        List<Component.CPU> cpus = Component.CPU.CSVReader.readCPUsFromCSV("cpus.csv");
        // Perform price comparison for CPUs
        inner.comparePricesCPU(cpus);
    } else if (componentType.equalsIgnoreCase("GPU")) {
        // Read GPUs from CSV
        List<Component.GPU> gpus = Component.GPU.CSVReader.readGPUsFromCSV("gpus.csv");
        // Perform price comparison for GPUs
       inner.comparePricesGPU(gpus);
    } else {
        System.out.println("Invalid component type entered.");
    }

    scanner.close();



}
}