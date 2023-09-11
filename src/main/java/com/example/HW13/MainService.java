package com.example.HW13;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MainService {
    private final NoteService noteService;

    @PostConstruct
    public void init(){
        noteService.addNote(new Note(0, "Title1", "Content1"));
        Note note1 = noteService.addNote(new Note(1, "Title3", "Content3"));
        Note note = noteService.addNote(new Note(2, "Title4", "Content4"));
        System.out.println(noteService.listAll());
        Note noteFromDb = noteService.getById(note.getId());
        System.out.println(noteFromDb);
//        noteFromDb.setTitle("Title2");
//        noteFromDb.setContent("Content2");
//        noteService.update(noteFromDb);
//        noteService.deleteById(note1.getId());
        System.out.println(noteService.listAll());

    }

    @PreDestroy
    public void destroy(){
        System.out.println("finish");
    }

}
