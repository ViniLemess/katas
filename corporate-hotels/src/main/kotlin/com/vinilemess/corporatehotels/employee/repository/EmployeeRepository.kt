package com.vinilemess.corporatehotels.employee.repository

import com.vinilemess.corporatehotels.employee.model.Employee
import com.vinilemess.corporatehotels.exception.NotFoundException

class EmployeeRepository {

    private val employeeMap: HashMap<Long, Employee> = HashMap()

    fun upsert(employee: Employee) {
        employeeMap[employee.companyId] = employee
    }

    fun findEmployeeBy(employeeId: Long, companyId: Long): Employee? {
        val employee = employeeMap[employeeId]
        if ((employee == null) || (employee.companyId != companyId)) {
            return null
        }
        return employee;
    }

    fun findEmployeeBy(employeeId: Long): Employee {
        return employeeMap.getOrElse(employeeId) {
            throw NotFoundException("Employee with id $employeeId not found.")
        }
    }

    fun removeEmployee(id: Long) {
        employeeMap.remove(id)
    }
}
