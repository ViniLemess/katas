package com.vinilemess.corporatehotels.service

import com.vinilemess.corporatehotels.exception.ExistentEmployeeException
import com.vinilemess.corporatehotels.model.Company
import com.vinilemess.corporatehotels.model.Employee

class CompanyService(
    private val employeeRepository: HashMap<Long, Employee>,
    private val companyRepository: HashMap<Long, Company>) {

    fun createEmployee(companyId: Long, employeeId: Long) {
        val employee = findEmployee(companyId)
        if (employee != null) {
            throw ExistentEmployeeException("Employee with id $employeeId already exists")
        }
        createCompany(companyId)
        employeeRepository.put(employeeId, Employee(employeeId, companyId))
    }

    fun deleteEmployee(employeeId: Long) {
        employeeRepository.remove(employeeId)
    }

    private fun createCompany(companyId: Long) {
        val company = findCompany(companyId)
        if (company == null) {
            companyRepository.put(companyId, Company(companyId))
        }
    }

    private fun findCompany(companyId: Long): Company? {
        return companyRepository.get(companyId)
    }

    private fun findEmployee(employeeId: Long): Employee? {
        return employeeRepository.get(employeeId)
    }
}