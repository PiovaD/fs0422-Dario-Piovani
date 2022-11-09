package m5w2d1es.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import m5w2d1es.Repositories.VideoRepository;
import m5w2d1es.exceptions.VideoNotFoundException;
import m5w2d1es.models.CategoryType;
import m5w2d1es.models.Film;
import m5w2d1es.models.TvSerie;
import m5w2d1es.models.Video;

@Service
public class VideoService {

	@Autowired
	VideoRepository vr;
	
	public Iterable<Video> searchAllVideos() {
		return vr.findAll();
	}
	
	public Page<Video> searchAllVideosPageable(Pageable p) {
		return vr.findAll(p);
	}

	public Video save(Video Video) {
		return vr.save(Video);
	}

	public Video findById(long id) throws VideoNotFoundException {
		Video found = vr.findById(id).get();
		if(found != null) {
			return found;
		}else {
			throw new VideoNotFoundException();
		}
	}

	public Video update(Long id, Video updatedVid) throws VideoNotFoundException {
		Optional<Video> vidOpt = vr.findById(id);

		if (vidOpt.isPresent()) {
			Video vid = vidOpt.get();
			vid.setCategory(updatedVid.getCategory());
			vid.setTitle(updatedVid.getTitle());
			// --- UNDER DEVELOPMENT ---
			vr.save(vid);
			return vid;
		} else {
			throw new VideoNotFoundException();
		}

	}
	
	public void delete(long id) {
		vr.deleteById(id);
	}
	
	
	public Iterable<Video> findFilms(Iterable<Video> videoPool) {

		List<Video> result = new ArrayList<>();

		videoPool.forEach(v -> {
			if (v instanceof Film) {
				result.add(v);
			}
		});

		return result;
	}
	
	public Iterable<Video> findSeries(Iterable<Video> videoPool) {

		List<Video> result = new ArrayList<>();

		videoPool.forEach(v -> {
			if (v instanceof TvSerie) {
				result.add(v);
			}
		});

		return result;
	}
	
	public Iterable<Video> findByCategory(Iterable<Video> videoPool, CategoryType cat){
		
		List<Video> result = new ArrayList<>();
		
		videoPool.forEach(v -> {
			if(v.getCategory().equals(cat)) {
				result.add(v);
			}
		});
		
		return result;
	}
	
	public Iterable<Video> findByTitle(Iterable<Video> videoPool, String title){
		
		List<Video> result = new ArrayList<>();
		
		videoPool.forEach(v -> {
			if((v.getTitle().toLowerCase()).contains(title.toLowerCase())) {
				result.add(v);
			}
		});
		
		return result;
	}
	
	public Iterable<Video> findByTitleAndCategory(Iterable<Video> videoPool, String title, CategoryType cat){
		
		Iterable<Video> matchByTitle = findByTitle(videoPool, title);
		List<Video> result = new ArrayList<>();
		
		matchByTitle.forEach(v -> {
			if(v.getCategory().equals(cat)) {
				result.add(v);
			}
		});
		
		return result;
	}
	
}

