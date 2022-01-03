package br.com.alura.ceep.controllers

import br.com.alura.ceep.dto.NoteBody
import br.com.alura.ceep.dto.NoteResponse
import br.com.alura.ceep.services.NoteService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notas")
class NotesController(
    private val service: NoteService
) {

    @GetMapping
    fun getAll(): ResponseEntity<Iterable<NoteResponse>> {
        val response = service.getAll().map {
            NoteResponse(it)
        }
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun save(@RequestBody body: NoteBody): ResponseEntity<NoteResponse> {
        val note = body.note
        val response = NoteResponse(service.save(note))
        return ResponseEntity.ok(response)
    }

    @PutMapping("{id}")
    fun update(
        @RequestBody body: NoteBody,
        @PathVariable("id") id: UUID
    ): ResponseEntity<NoteResponse> {
        val note = body.createWithId(id)
        val response = NoteResponse(service.save(note))
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        return try {
            service.delete(id)
            ResponseEntity.ok().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

}