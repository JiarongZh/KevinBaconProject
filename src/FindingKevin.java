import java.util.ArrayList;

public class FindingKevin {
    ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");


    public ArrayList<String> commonActors(ArrayList<SimpleMovie> movie1, ArrayList<SimpleMovie> movie2){
        ArrayList<String> common = new ArrayList<String>();
        for(SimpleMovie movie : movie1){
            for(SimpleMovie other : movie2){
                for(int i = 0; i<movie.getActors().size(); i++){
                    String current = movie.getActors().get(i);
                    for(int j = 0; j<other.getActors().size(); j++){
                        String temp = other.getActors().get(j);
                        if(current.equals(temp) && !(common.contains(current))){
                            common.add(current);
                        }
                    }
                }
            }
        }
        return common;
    }

    public ArrayList<String> singular(){
        ArrayList<String> one = new ArrayList<String>();
        ArrayList<SimpleMovie> kevin = getKevin();
        for(SimpleMovie movie: kevin){
           for(String cast : movie.getActors()){
               if(!(one.contains(cast))){
                   one.add(cast);
               }
           }
        }
        return one;
    }



    public String findMovie(String name1, String name2){
        for(SimpleMovie movie : career(name1)){
            if(movie.getActors().contains(name1)&& movie.getActors().contains(name2)){
                return movie.getTitle();
            }
        }
        return " ";
    }

    public boolean directKevin(String name){
        ArrayList<SimpleMovie> movieList = new ArrayList<SimpleMovie>();
        for (SimpleMovie movie : movies) {
            if (movie.getActors().contains(name)) {
                movieList.add(movie);
            }
        }
        if (movieList.size() == 0) {
            System.out.println("No results found. Did you type the name properly? ");
            return false;
        }
        for (SimpleMovie movie : movieList) {
            if (movie.getActors().contains("Kevin Bacon")) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<SimpleMovie> career(String name){
        ArrayList<SimpleMovie> career = new ArrayList<SimpleMovie>();
        for(SimpleMovie movie : movies){
            if(movie.getActors().contains(name)){
                career.add(movie);
            }
        }
        return career;
    }

    public ArrayList<String> coworkers(String name){
        ArrayList<String> coworkers = new ArrayList<String>();
        for(SimpleMovie movie : career(name)){
            for(String cast : movie.getActors()){
                if(!coworkers.contains(cast)){
                    coworkers.add(cast);
                }
            }
        }
        return coworkers;
    }
    public ArrayList<SimpleMovie> getKevin(){
        ArrayList<SimpleMovie> career = new ArrayList<SimpleMovie>();
        for(SimpleMovie movie : movies){
            if(movie.getActors().contains("Kevin Bacon")){
                career.add(movie);
            }
        }
        return career;
    }
}
