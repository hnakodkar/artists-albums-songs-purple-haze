package org.wcci.apimastery;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Artist;

public interface ArtistRepository extends CrudRepository <Artist, Long>{


}
