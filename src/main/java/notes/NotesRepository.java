package notes;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<Note, String> {

    public Note findByTitle(String title);
//    public List<Note> findByLastName(String lastName);

}
