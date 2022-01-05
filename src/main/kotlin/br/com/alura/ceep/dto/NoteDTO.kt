package br.com.alura.ceep.dto

import br.com.alura.ceep.models.Note
import java.util.*

class NoteResponse(note: Note) {
    val id = note.id
    val titulo = note.title
    val descricao = note.description
    val imagem = note.image
}

class NoteBody(
    titulo: String,
    descricao: String,
    imagem: String? = null
) {
    val note: Note = Note(
        title = titulo,
        description = descricao,
        image = imagem
    )

    fun createWithId(id: UUID) = Note(
        id,
        note.title,
        note.description,
        note.image
    )
}