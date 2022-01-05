package br.com.alura.ceep.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Note(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(columnDefinition = "TEXT")
    val title: String = "",
    @Column(columnDefinition = "TEXT")
    val description: String = "",
    val image: String? = null
)