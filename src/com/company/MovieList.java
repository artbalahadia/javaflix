package com.company;

import java.util.ArrayList;

public class MovieList {

    private ArrayList<String> movieList = new ArrayList<String>();

    boolean onPlay;
    String nowPlaying;

    public void addMoveItem(String item){
        movieList.add(item);
        System.out.println("Thank you! " + item + " has been added to the movie list.");
    }

    public void printMovieList() {
        if(movieList.size() > 1){
            System.out.println("You have " + movieList.size() + " movies in your list");
        } else {
            System.out.println("You have " + movieList.size() + " movie in your list");
        }

        for(int i=0; i< movieList.size(); i++) {
            System.out.println((i+1) + ". " + movieList.get(i));
        }


    }

    public void modifyMovieList(int position, String newItem){
        printMovieList();
        movieList.set(position, newItem);
        System.out.println("List item " + (position + 1) + " has been modified.");
    }

    public void removeMovieItem(int position){
        printMovieList();
        String removeItem = movieList.get(position);
        System.out.println("Movie: " + removeItem + " is deleted from the list.");
        movieList.remove(position);
    }

    public String findItem(String searchItem){
        int position = movieList.indexOf(searchItem);
        if(position > 0){
            return movieList.get(position);
        }
        return null;
    }

    public void playMovieItem(int position){
        printMovieList();

        nowPlaying = movieList.get(position);
        System.out.println(nowPlaying + " will now start to play..");
        onPlay = true;
    }

    public void printQueue(){
        if(onPlay){
            System.out.println(nowPlaying + " is currently playing..");
            int count = movieList.size();
            System.out.println("Current movies on queue: ");
            for(int i = 0; i < count; i++){
                if(i == movieList.indexOf(nowPlaying)) {
                    continue;
                }
                System.out.println((i + 1) + ". " + movieList.get(i));
            }
        }
    }

}
