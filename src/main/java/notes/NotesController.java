package notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NotesController {
    @Autowired
    private NotesRepository repository;

    private static final String title_template = "Title: %s";
    private static final String content_template = "Content: %s";

    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    public void putNote(@RequestParam(value = "title", defaultValue = "Empty") String title,
                        @RequestParam(value = "content", defaultValue = "Empty") String content) {
//        System.out.println("In the PUT with: title:"+title+" content:"+content);

        // SAVE a note to the DB
        repository.save(new Note(title, content));
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public List<Note> getNote(@RequestParam(value = "title", defaultValue = "Empty") String title,
                              @RequestParam(value = "content", defaultValue = "Empty") String content) {
//        System.out.println("In the GET with: title:"+title+" content:"+content);
        // GET either one note if title is supplied, or else all notes
        List<Note> retNote = new ArrayList();

//        for(Note note : repository.findAll()) {
//            System.out.println(note);
//        }

        if (title.equals("Empty")) {
            System.out.println("GET call with empty title, returning all titles");
            retNote = repository.findAll();
        } else {
            System.out.println("GET call with title, returning found title");
            retNote.add(repository.findByTitle(title));
        }

        return retNote;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.DELETE)
    public void getNote(@RequestParam(value = "title", defaultValue = "Empty") String title) {
        System.out.println("Delete called with title=" + title);
        if (title.equals("Empty")) {
            System.out.println("DELETE call with empty title, doing nothing");
        } else {
            System.out.println("DELETE call with title=" + title + ", deleting first item with that title");
            System.out.println("This is the note found: " + repository.findByTitle(title));
            repository.delete(repository.findByTitle(title));
        }
    }
}
