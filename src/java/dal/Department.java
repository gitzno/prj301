
package dal;

/**
 *
 * @author Chold
 */
public class Department {
    private int DepartmentID;
    private String DepartmentName;
    private String DepartmentType;

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getDepartmentType() {
        return DepartmentType;
    }

    public void setDepartmentType(String DepartmentType) {
        this.DepartmentType = DepartmentType;
    }

    public Department(int DepartmentID, String DepartmentName, String DepartmentType) {
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.DepartmentType = DepartmentType;
    }

    public Department() {
    }
}
