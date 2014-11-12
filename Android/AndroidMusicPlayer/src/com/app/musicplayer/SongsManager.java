package com.app.musicplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

import android.os.Environment;

public class SongsManager {
	
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	public final String PATH = Environment.getExternalStorageDirectory().toString() + "/Download";
	public final String PATH_MUSIC = Environment.getExternalStorageDirectory().toString() + "/Music";
	public SongsManager(){	}
	
	/**
	 * Get list of songs.
	 * */
	public ArrayList<HashMap<String, String>> getPlayList(){
		addSongToList(PATH, this.songsList);
		addSongToList(PATH_MUSIC, this.songsList);
		return songsList;
	}
	public void addSongToList(String path,ArrayList<HashMap<String, String>> songsList){
		File home_music=new File(path);
		if (home_music.listFiles(new FileExtensionFilter()).length!=0) {
			for (File file : home_music.listFiles(new FileExtensionFilter())) {
				HashMap<String, String> song = new HashMap<String, String>();
				song.put("songTitle", file.getName().substring(0, (file.getName().length() - 4)));
				song.put("songPath", file.getPath());
				songsList.add(song);
			}
		}
	}
	/**
	 * Filer file (mp3,mp4,..)
	 * */
	class FileExtensionFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}
