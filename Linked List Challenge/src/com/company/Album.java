package com.company;
import java.util.*;
public class Album {

    private ArrayList<Song> songs = new ArrayList<Song>();
    private String name;
    private String artist;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        //initialize arraylist
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        //add song to arraylist if song does not exists.
        if(findSong(title) == null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }
    //Check if song already exists in the list
    private Song findSong(String title){

        //the loop will check each index to see if the contents of each index in the arrary list match the contents of the string parem
        //for each
        for(Song findSong : this.songs){

        if(findSong.getTitle().equals(title)){
                return findSong;
            }
        }
        return null; //if null value is found then the song does not exists in the arraylist
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playlist){
        int index = trackNumber -1;
        if((index >= 0) && (index <=this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track number " + trackNumber);
        return false;
    }

    public boolean addToPlaylst(String title, List<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
