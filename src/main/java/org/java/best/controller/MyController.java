package org.java.best.controller;

import java.util.Arrays;
import java.util.List;

import org.java.best.pojo.Movie;
import org.java.best.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {

	@GetMapping("/")
	public String getHome() {
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		List<Movie>movies =getMovies();
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		List<Song>songs =getSongs();
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}  ")
	public String getMovie(Model model,@PathVariable("id")int id) {
		Movie movie =getMovieById(id);
		if(movie!=null)
			model.addAttribute("movie",movie);
		return "movie";
	}
	
	private Movie getMovieById(int id) {
		Movie resM=null;
		for(Movie m : getMovies())
			if(m.getId()==id)
				resM=m;
		return resM;
	}
	
//	@GetMapping("/movies")
//	public String getMovies(Model model) {
//		
//		String mts = "";
//		Iterator<Movie> it = getBestMovie().iterator();
//		while(it.hasNext()) {
//			
//			mts += it.next().getTitle();
//			
//			if (it.hasNext())
//				mts += ", ";
//		}
//		
//		model.addAttribute("titles", mts);
//		
//		return "titles";
//	}
//	
//	@GetMapping("/songs")
//	public String getSongs(Model model) {
//		
//		String sts = "";
//		Iterator<Song> it = getBestSong().iterator();
//		while(it.hasNext()) {
//			
//			sts += it.next().getTitle();
//			
//			if (it.hasNext()) 
//				sts += ", ";
//		}
//		model.addAttribute("titles", sts);
//		
//		return "titles";
//	}
//	
//	@GetMapping("/movies/{id}")
//	public String getMovie(Model model, @PathVariable("id") int id) {
//
//		String resT = null;
//		for (Movie m : getBestMovie()) 
//			if (m.getId() == id) 
//				resT = m.getTitle();
//		
//		if (resT != null)
//			model.addAttribute("titles", resT);
//		else 
//			model.addAttribute("titles", "no movie found");
//		
//		
//		return "titles";
//	}
	
//	@GetMapping("/songs/{id}")
//	public String getSong(Model model, @PathVariable("id") int id) {
//		
//		Song resS = null;
//		for (Song s : getBestSong())
//			if (s.getId() == id)
//				resS = s;
//		
//		if (resS != null)
//			model.addAttribute("titles", resS.getTitle());
//		
//		return "titles";
//	}
	
	private List<Movie> getMovies() {
		
		return Arrays.asList(new Movie[] {
				new Movie(1, "movie 1"),
				new Movie(2, "movie 2"),
				new Movie(3, "movie 3"),
				new Movie(4, "movie 4"),
				new Movie(5, "mio titolo 5")
		});
	}
	private List<Song> getSongs() {
		
		return Arrays.asList(new Song[] {
				new Song(1, "song 1"),
				new Song(2, "song 2"),
				new Song(3, "song 3"),
				new Song(4, "song 4"),
				new Song(5, "song 5")
		});
	}
}