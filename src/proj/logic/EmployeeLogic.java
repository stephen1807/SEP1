package proj.logic;

import proj.obj.Employee;
import proj.service.EmployeeService;

/**
 * Created by Stephen on 2015/05/22.
 * Ver 1.0
 */
public class EmployeeLogic {

    public Employee employeeLogin(String username, String password){

        EmployeeService es = EmployeeService.getInstance();

        Employee temp = es.getEmployee(username);

        if (temp.getUserpass().equals(password)) {
            return temp;
        } else {
            return null;
        }
    }
}
