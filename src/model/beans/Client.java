package model.beans;

public class Client {
    private String name;
    private String idCode;
    private Sale financialSituation;

    public Client(String name, String idCode) {
        this.name = name;
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Sale getFinancialSituation() {
        return financialSituation;
    }
}
