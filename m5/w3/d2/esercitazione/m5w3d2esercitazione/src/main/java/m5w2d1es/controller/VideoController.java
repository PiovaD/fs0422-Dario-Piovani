package m5w2d1es.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m5w2d1es.models.CategoryType;
import m5w2d1es.models.Video;
import m5w2d1es.services.VideoService;


@RestController
@RequestMapping("/api/catalog")
public class VideoController {

	@Autowired
	VideoService vs;
	
	@GetMapping("")
	public ResponseEntity<Iterable<Video>> getCatalog(){
		return new ResponseEntity<>(vs.searchAllVideos(), HttpStatus.OK);
	}
	
	@GetMapping("/films")
	public ResponseEntity<Iterable<Video>> getFilms(){
		return new ResponseEntity<>(vs.findFilms(vs.searchAllVideos()), HttpStatus.OK);
	}
	
	@GetMapping("/series")
	public ResponseEntity<Iterable<Video>> getSeries(){
		return new ResponseEntity<>(vs.findSeries(vs.searchAllVideos()), HttpStatus.OK);
	}
	
	@GetMapping("/films/title/{title}")
	public ResponseEntity<Iterable<Video>> getFilmsByTitle(@PathVariable String title){
		return new ResponseEntity<>(
				vs.findByTitle(vs.findFilms(vs.searchAllVideos()), title), HttpStatus.OK);
	}
	
	@GetMapping("/films/category/{cat}")
	public ResponseEntity<Iterable<Video>> getFilmsByCategoria(@PathVariable CategoryType cat){
		return new ResponseEntity<>(
				vs.findByCategory(vs.findFilms(vs.searchAllVideos()), cat), HttpStatus.OK);
	}
	
	@GetMapping("/title-category/{cat}/{title}")
	public ResponseEntity<Iterable<Video>> getFilmsByTitleAndCategoria(@PathVariable String title, @PathVariable CategoryType cat){
		return new ResponseEntity<>(
				vs.findByTitleAndCategory(vs.searchAllVideos(), title, cat), HttpStatus.OK);
	}
}