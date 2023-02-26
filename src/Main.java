import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        FindingKevin test = new FindingKevin();
        String name = "";
        String result = "";
        int count = 0;
        while(!(name.equals("q"))){
            count = 0;
            result = "";
            System.out.print("Enter an actor or (q) to quit: ");
            name = scan.nextLine();
            result += name + " -> "; // Does not work for actors with a bacon number of 4 because it will take too long
            if(!test.directKevin(name)){
                boolean found = false;
                for(String actor : test.commonActors(test.career(name),test.getKevin())){
                    if(test.singular().contains(actor)){
                        found = true;
                        count = 2;
                        result+= test.findMovie(name,actor) + " " + actor + " -> " + test.findMovie(actor,"Kevin Bacon") + " -> Kevin Bacon";
                        break;
                    }
                }
                if(!found){
                    for(String actor : test.coworkers(name)) {
                        for (String cast : test.coworkers(actor)) {
                            if (test.singular().contains(cast)) {
                                result += test.findMovie(name, actor) + " " + actor + " -> " + test.findMovie(actor,cast) + " " + cast + " -> " + test.findMovie(cast,"Kevin Bacon") + " -> Kevin Bacon";
                                count = 3;
                                break;
                            }
                        }
                        if(count == 3){
                            break;
                        }
                    }
                }
            }else{
                result += test.findMovie(name,"Kevin Bacon") + " -> Kevin Bacon";
                count =1;
            }

            System.out.println(result + "\nBacon number of " + count);
        }

    }
}