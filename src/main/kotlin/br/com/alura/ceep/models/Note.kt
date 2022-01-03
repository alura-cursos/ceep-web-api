package br.com.alura.ceep.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Note(
    @Id
    val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val description: String = "",
    val image: String? = null
)