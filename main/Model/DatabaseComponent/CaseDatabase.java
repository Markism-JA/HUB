package main.Model.DatabaseComponent;

import java.util.List;

import main.Model.CSVUtil;
import main.Model.Components.Case;

public class CaseDatabase extends CSVUtil{
  private String name, formFactor;
 

  public CaseDatabase(String name, String formFactor) {
      this.name = name;
      this.formFactor = formFactor;
      
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }


  public String getFormFactor() { return formFactor; }
  public void setFormFactor(String formFactor) { this.formFactor = formFactor; }



  @Override
  public String toString() {
      return "Case{" + "name='" + name + '\'' + ", formFactor='" + formFactor  +'}';
      }

  public static List<CaseDatabase> readCaseFromCSV(String fileName) {
      return readFromCSV(fileName, data -> new CaseDatabase(data[0], data[1] ));
      }

  public String toCSVString() {
      return String.join(",", name, formFactor);
  }

  public static void writeCaseToCSV(String fileName, List<CaseDatabase> cases) {
    writeToCSV(fileName, cases, CaseDatabase::toCSVString);
  }
  public static void main(String[] args) {
        List<CaseDatabase> cases = readCaseFromCSV("main/Resources/data/CaseDataBase.csv");

        for (CaseDatabase caseItem : cases) {
            System.out.println(caseItem);
        }
  }
  
}
