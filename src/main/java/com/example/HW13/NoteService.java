package com.example.HW13;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class NoteService {
    private List<Note> noteList = new ArrayList<>();

    public long createId() {
        return new Random().nextLong();
    }

    public Note addNote(Note note) {
        note.setId(createId());
        noteList.add(note);
        return note;
    }


    public List<Note> listAll() {
        return noteList;
    }

    public Note getById(long id) {
        return
                noteList.stream().filter(n -> n.getId() == id)
                        .findAny().orElseThrow(() -> new IllegalArgumentException("Write right Id"));
    }

    public void update(Note note) {
        noteList.stream()
                .filter(n -> n.getId() == note.getId())
                .findFirst()
                .ifPresentOrElse(value ->
                {
                    noteList.set(noteList.indexOf(value), note);
                }, () -> { throw new NoSuchElementException();});
    }

    public void deleteById(long id) {
        Note note = getById(id);
        if (note != null) {
            noteList.remove(note);
        } else
            throw new IllegalArgumentException("Write right Id");
    }
}
