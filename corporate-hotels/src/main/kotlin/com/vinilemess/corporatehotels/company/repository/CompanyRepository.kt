package com.vinilemess.corporatehotels.company.repository

import com.vinilemess.corporatehotels.company.model.Company

class CompanyRepository {

    private val companyMap: HashMap<Long, Company> = HashMap()

    fun upsert(company: Company): Company {
        companyMap[company.companyId] = company
        return company
    }

    fun findCompanyBy(id: Long): Company? {
        return companyMap.get(id)
    }
}