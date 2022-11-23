package com.maxmesh.maxtask6.data

import com.maxmesh.maxtask6.domain.ContactEntity
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import kotlin.random.Random

class FakeUserStorage {

    lateinit var avatarUrl: String
    lateinit var firstName: String
    lateinit var surname: String
    lateinit var phoneNumber: String
    lateinit var contact: ContactEntity
    private val config = fakerConfig { locale = "ru" }
    private val faker = Faker(config)

     fun getUsers(): MutableList<ContactEntity> {
        val data: MutableList<ContactEntity> = mutableListOf()
        for (i in 0..179) {
            avatarUrl = "https://picsum.photos/id/${Random.nextInt(537)}/300"
            firstName = faker.name.maleFirstName()
            surname = faker.name.maleLastName()
            phoneNumber = "+" + faker.phoneNumber.countryCode() + faker.phoneNumber.phoneNumber()
            contact = ContactEntity(i, avatarUrl, firstName, surname, phoneNumber)
            data.add(contact)
        }
         return data
    }
}