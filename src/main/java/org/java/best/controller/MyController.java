package org.java.best.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.java.best.pojo.Movie;
import org.java.best.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("name", "Mindu");

		return "index";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		String mts="";
		Iterator<Movie>it=getBestMovie().iterator();
		while(it.hasNext()) {
			mts += it.next().getTitle();
			if(it.hasNext())
				mts += ", ";
		}
		model.addAttribute("movieTitles",mts);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		String sts="";
		Iterator<Song>it=getBestSong().iterator();
		while(it.hasNext()) {
			sts += it.next().getTitle();
			if(it.hasNext())
				sts += ", ";
		}
		model.addAttribute("songTitles",sts);
		return "songs";
	}
	
	@GetMapping("/movies")
	public String getMovie(Model model,@PathVariable("id")int id) {
		Movie resM = null;
		for (Movie m : getBestMovie())
			if(m.getId()==id)
				resM=m;
	
		if(resM !=null)
			model.addAttribute("movies",resM.getTitle());
		return "movies";
		
	}
	
	
	@GetMapping("/songs")
	public String getSong(Model model,@PathVariable("id")int id) {
		Song resS = null;
		for (Song s : getBestSong())
			if(s.getId()==id)
				resS=s;
	
		if(resS !=null)
			model.addAttribute("songs",resS.getTitle());
		return "songs";
		
	}
	
	
	private List<Movie> getBestMovie(){
		return Arrays.asList(new Movie[] {
				new Movie(1,"movie 1"),
				new Movie(2,"movie 2"),
				new Movie(3,"movie 3"),
				new Movie(4,"movie 4"),
		});
	}
	
	
	private List<Song> getBestSong(){
		return Arrays.asList(new Song[] {
				new Song(1,"Song 1"),
				new Song(2,"Song 2"),
				new Song(3,"Song 3"),
				new Song(4,"Song 4"),
		});
	}

}