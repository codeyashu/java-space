package io.rsi.codespace.jxpath.util;

import io.rsi.codespace.jxpath.model.Company;
import io.rsi.codespace.jxpath.model.Department;
import io.rsi.codespace.jxpath.model.Employee;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JXPathCompanyRelContextTester {
    public static void main(String[] args) {
        Company company = new Company("Acme Inc.");
        List<Department> departments = new ArrayList<>();
        departments.add(new Department("Sales"));
        departments.add(new Department("Accounting"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Johnny", "Sales rep", 45));
        employees.add(new Employee("Sarah", "Sales rep", 33));
        employees.add(new Employee("Magda", "Office assistant", 27));
        departments.get(0).setEmployees(employees);

        employees = new ArrayList<>();
        employees.add(new Employee("Steve", "Head Controller", 51));
        employees.add(new Employee("Peter", "Assistant Controller", 31));
        employees.add(new Employee("Susan", "Office assistant", 27));
        departments.get(1).setEmployees(employees);

        company.setDepartmentList(departments);

        JXPathContext context = JXPathContext.newContext(company);


        for (Iterator iter = context.iteratePointers("/departmentList[name='Sales']/employees[age>30]"); iter.hasNext(); ) {
            Pointer empPtr = (Pointer) iter.next();
            JXPathContext relativeContext = context.getRelativeContext(empPtr);

            //Current Employee
            Employee emp = (Employee) relativeContext.getValue(".");
            System.out.println(emp);
            System.out.println("----------------------------");
            //Employee name
            String name = (String) relativeContext.getValue("./name");
            System.out.println(name);
            System.out.println("----------------------------");
            //Name of the Department this Employee belongs to (a parent object)
            String deptName = (String) relativeContext.getValue("../name");
            System.out.println(deptName);
            System.out.println("----------------------------");
            //Name of the Company this Employee belongs to (a 'grandparent' object)
            String compName = (String) relativeContext.getValue("../../name");
            System.out.println(compName);
            System.out.println("----------------------------");
            //Alle coworkers of this Employee (sibling objects)
            for (Iterator empIter = relativeContext.iterate("../employees"); empIter.hasNext(); ) {
                Employee colleague = (Employee) empIter.next();
                System.out.println(colleague);
            }
        }


    }
}
