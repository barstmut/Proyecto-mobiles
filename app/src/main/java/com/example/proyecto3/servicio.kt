package com.example.proyecto3

class servicio
{
    var categoria:String?=null
    var nombre:String?=null
    var imagen:Int?=null
    var url:String?=null
    var phone:String?=null
    //lat, long

    constructor(categoria:String,nombre:String, imagen:Int,url:String,phone:String)
    {

        this.categoria = categoria
        this.nombre = nombre
        this.imagen = imagen
        this.url = url
        this.phone = phone
    }
}