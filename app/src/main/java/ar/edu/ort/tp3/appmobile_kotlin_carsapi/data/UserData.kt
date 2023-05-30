package ar.edu.ort.tp3.appmobile_kotlin_carsapi.data

import java.io.Serializable
import kotlin.random.Random

class UserData : Serializable {
    private val idUser: Int
    private val namLastNam: String
    private val email: String
    private val password: String


    constructor(idUser: Int, namLastNam: String, email: String, password: String) {
        this.idUser = idUser
        this.namLastNam = namLastNam
        this.email = email
        this.password = password
    }

    companion object {
        fun getUser(): List<UserData> {
            val users = mutableListOf<UserData>()
            val user1 = UserData(1, "Delmer Rodriguez", "admin@respirar.com", "12345678")
            val user2 = UserData(2, "Debora Landa", "registrado@respirar.com", "12345678")
            val user3 = UserData(3, "Mariano Busca", "mariano@respirar.com", "12345678")
            val user4 = UserData(4, "Bruno Bruno", "bruno@respirar.com", "12345678")
            users.add(user1)
            users.add(user2)
            users.add(user3)
            users.add(user4)
            return users
        }
    }

    fun getEmail(): String {
        return this.email
    }

    fun getPassword(): String {
        return this.password
    }


}