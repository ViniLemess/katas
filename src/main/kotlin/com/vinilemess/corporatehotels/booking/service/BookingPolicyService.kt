package com.vinilemess.corporatehotels.booking.service

import com.vinilemess.corporatehotels.company.repository.CompanyRepository
import com.vinilemess.corporatehotels.company.service.CompanyService
import com.vinilemess.corporatehotels.employee.repository.EmployeeRepository
import com.vinilemess.corporatehotels.hotel.model.RoomType

class BookingPolicyService {
    private val companyService = CompanyService(EmployeeRepository(), CompanyRepository())
    private val companyPolicies: MutableMap<Long, List<RoomType>> = HashMap()
    private val employeePolicies: MutableMap<Long, List<RoomType>> = HashMap()

    fun setCompanyPolicy(companyId: Long, roomTypes: List<RoomType>) {
        companyPolicies[companyId] = roomTypes
    }

    fun setEmployeePolicy(employeeId: Long, roomTypes: List<RoomType>) {
        employeePolicies[employeeId] = roomTypes
    }

    fun isBookingAllowed(employeeId: Long, roomType: RoomType): Boolean {
        val employeePolicies = employeePolicies[employeeId]
        if (employeePolicies != null) {
            return employeePolicies.contains(roomType)
        }
        val companyId = companyService.findCompanyIdBy(employeeId)
        val companyPolicies = companyPolicies[companyId]
        if (companyPolicies != null) {
            return companyPolicies.contains(roomType)
        }
        return true;
    }
}