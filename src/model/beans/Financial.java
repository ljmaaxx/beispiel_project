package model.beans;

public class Financial {
    private double extraExpenses;
    private double importExpenses;
    private double employeeExpenses;
    private double resourcesExpenses;
    private double salesGains;
    private double exportGains;


    public Financial() {}

    public double getExtraExpenses() {
        return extraExpenses;
    }

    public void setExtraExpenses(double extraExpenses) {
        this.extraExpenses = extraExpenses;
    }

    public double getImportExpenses() {
        return importExpenses;
    }

    public void setImportExpenses(double importExpenses) {
        this.importExpenses = importExpenses;
    }

    public double getEmployeeExpenses() {
        return employeeExpenses;
    }

    public void setEmployeeExpenses(double employeeExpenses) {
        this.employeeExpenses = employeeExpenses;
    }

    public double getResourcesExpenses() {
        return resourcesExpenses;
    }

    public void setResourcesExpenses(double resourcesExpenses) {
        this.resourcesExpenses = resourcesExpenses;
    }

    public double getSalesGains() {
        return salesGains;
    }

    public void setSalesGains(double salesGains) {
        this.salesGains = salesGains;
    }

    public double getExportGains() {
        return exportGains;
    }

    public void setExportGains(double exportGains) {
        this.exportGains = exportGains;
    }

    public void generateReport() {}

}
