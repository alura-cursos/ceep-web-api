package br.com.alura.ceep.repositories

import br.com.alura.ceep.models.Note
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NoteRepository : CrudRepository<Note, UUID>