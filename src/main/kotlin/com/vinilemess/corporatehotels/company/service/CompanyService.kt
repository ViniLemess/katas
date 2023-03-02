package com.vinilemess.corporatehotels.company.service

import com.vinilemess.corporatehotels.exception.ExistentEmployeeException
import com.vinilemess.corporatehotels.company.model.Company
import com.vinilemess.corporatehotels.employee.model.Employee
import com.vinilemess.corporatehotels.company.repository.CompanyRepository
import com.vinilemess.corporatehotels.employee.repository.EmployeeRepository
import com.vinilemess.corporatehotels.exception.NotFoundException

class CompanyService(private val employeeRepository: EmployeeRepository,
                     private val companyRepository: CompanyRepository
) {

    fun createEmployee(companyId: Long, employeeId: Long) {
        val company = findCompany(companyId)
        val employee = employeeRepository.findEmployeeBy(employeeId, company.companyId)
        if (employee != null) throw ExistentEmployeeException("Employee with id $employeeId already exists")
        employeeRepository.upsert(Employee(employeeId, companyId))
    }

    fun deleteEmployee(employeeId: Long) {
        employeeRepository.removeEmployee(employeeId)
    }

    fun findCompanyIdBy(employeeId: Long): Long {
        return employeeRepository.findEmployeeBy(employeeId) ?:
        throw NotFoundException("Employee with id $employeeId not found.")

    }

    private fun findCompany(companyId: Long): Company {
        return companyRepository.findCompanyBy(id = companyId) ?: companyRepository.upsert(Company(companyId))
    }
}