package org.wcci.apimastery;



import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;

import java.util.Collection;
import java.util.Properties;

@RestController
public class ArtistController {
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;

    public ArtistController(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @GetMapping("/artists")
    public Collection<Artist> retrieveArtists() {
        return(Collection<Artist>) artistRepository.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist retrieveSingleArtist(@PathVariable Long id) {
        return artistRepository.findById(id).get();
    }
    @PatchMapping("/artists/{id}/albums")
    public Artist updateArtistProducts(@PathVariable Long id, @RequestBody String requestBodyAlbum) {
        Artist artistToPatch = artistRepository.findById(id).get();
        Album albumToAdd = new Album(requestBodyAlbum, artistToPatch);
        albumRepository.save(albumToAdd);
        return artistRepository.save(artistToPatch);
    }
    @PostMapping("/artists")
    public Artist createArtist(@RequestBody Artist artistToAdd) {
        return artistRepository.save(artistToAdd);
    }

}
