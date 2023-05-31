package ar.edu.ort.tp3.appmobile_kotlin_carsapi.data

import java.io.Serializable

class UserData : Serializable {
    private val idUser: Int
    private val namLastNam: String
    private val email: String
    private val password: String
    private val urlImage: String


    constructor(idUser: Int, namLastNam: String, email: String, password: String,urlImage: String) {
        this.idUser = idUser
        this.namLastNam = namLastNam
        this.email = email
        this.password = password
        this.urlImage= urlImage
    }

    fun getEmail(): String {
        return this.email
    }

    fun getNamLastNam(): String {
        return this.namLastNam
    }

    fun getPassword(): String {
        return this.password
    }
    fun getUrlImage(): String {
        return this.urlImage
    }

    companion object {
        fun getUser(): List<UserData> {
            val users = mutableListOf<UserData>()
            val user1 = UserData(1, "Delmer", "delmer@ort.com", "12345678","https://i.ibb.co/kGw7TVB/1661810986388.jpg")
            val user2 = UserData(2, "Debora", "debora@ort.com", "12345678","https://i.ibb.co/qy1wsgW/debora.jpg")
            val user3 = UserData(3, "mariano", "mariano@ort.com", "12345678","www.image.com")
            val user4 = UserData(4, "eugenio", "eugenio@ort.com", "12345678","www.image.com")
            users.add(user1)
            users.add(user2)
            users.add(user3)
            users.add(user4)
            return users
        }
    }
}