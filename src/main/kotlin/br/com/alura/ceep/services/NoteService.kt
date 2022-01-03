package br.com.alura.ceep.services

import br.com.alura.ceep.models.Note
import br.com.alura.ceep.repositories.NoteRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteService(
    private val repository: NoteRepository
) {

    fun getAll(): Iterable<Note> {
        return repository.findAll()
    }

    fun save(note: Note): Note = repository.save(note)

    fun delete(id: UUID) {
        repository.deleteById(id)
    }

}