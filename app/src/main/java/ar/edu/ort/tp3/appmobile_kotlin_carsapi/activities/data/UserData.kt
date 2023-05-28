package ar.edu.ort.tp3.appmobile_kotlin_carsapi.activities.data

import java.io.Serializable

class UserData : Serializable {
    private val idUser: Int
    private val namLastNam: String
    private val email: String
    private val password: String
    private val rol: Rol

    constructor(idUser: Int, namLastNam: String, email: String, password: String, rol: Rol) {
        this.idUser = idUser
        this.namLastNam = namLastNam
        this.email = email
        this.password = password
        this.rol = rol
    }

    companion object {
        fun getUser(): List<UserData> {
            val users = mutableListOf<UserData>()
            val user1 = UserData(1, "Delmer Rodriguez", "admin@respirar.com", "12345678", Rol.ADMIN)
            val user2 = UserData(2, "Debora Landa", "registrado@respirar.com", "12345678", Rol.REGISTRADO)
            val user3 = UserData(3, "Mariano Busca", "mariano@respirar.com", "12345678", Rol.REGISTRADO)
            val user4 = UserData(4, "Bruno Bruno", "bruno@respirar.com", "12345678", Rol.VISITANTE)
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

    fun getRol(): Rol {
        return this.rol
    }
}
