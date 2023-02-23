package com.vinilemess.corporatehotels.service

import com.vinilemess.corporatehotels.model.RoomType

class ReservationPolicyService {

    fun setCompanyPolicy(companyId: Long, roomTypes: List<RoomType>) {

    }

    fun setEmployeePolicy(employeeId: Long, roomTypes: List<RoomType>) {

    }

    fun canBook(employeeId: Long, roomType: RoomType): Boolean {
        return false;
    }
}