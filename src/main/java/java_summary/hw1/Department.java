package java_summary.hw1;

public class Department {
    private String name;
    private int employeeCount;
    private Company company;

    public Department(String name, int employeeCount, Company company) {
        this.name = name;
        this.employeeCount = employeeCount;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
