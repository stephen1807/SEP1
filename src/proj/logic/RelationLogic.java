package proj.logic;

import proj.obj.Employee;
import proj.obj.Relation;
import proj.service.EmployeeService;
import proj.service.RelationService;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stephen on 2015/05/28.
 */
public class RelationLogic {

    RelationService rs = RelationService.getInstance();

    public List<Employee> getAllSubordinates(int employeeID) {

        Set<Integer> content = new LinkedHashSet<>();

        getSubordinates(employeeID, content);

        List<Employee> result = new ArrayList<>();

        EmployeeService es = EmployeeService.getInstance();

        for (int i : content) {
            result.add(es.getEmployee(i));
        }

        return result;
    }

    private void getSubordinates(int employeeID, Set<Integer> content) {

        //Get all subordinates
        List<Relation> list = rs.getRelation(employeeID);

        //If no more subordinates, add id
        if (list.isEmpty()) {
            content.add(employeeID);
            return;
        } else {
            content.add(list.get(0).getSuperiorid());
            for (Relation r : list) {
                getSubordinates(r.getSuperiorid(), content);
            }
        }

    }
}
