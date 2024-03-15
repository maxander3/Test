package com.example.test.domain.model

import com.example.test.ui.model.UserDataVO


data class UserData(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

internal fun UserData.toUserDataVO() = UserDataVO(
    id = this.id,
    name = this.name,
    userName = this.username,
    email = this.email,
    address = this.address.toVo(),
    phone = this.phone,
    website = this.website,
    company = this.company.toVo()
)

internal fun Address.toVo() = "$street, $suite, $city, $zipcode ${geo.toVo()}"
internal fun Geo.toVo() = "($lat, $lng)"
internal fun Company.toVo() = "$name($bs) - '$catchPhrase'"